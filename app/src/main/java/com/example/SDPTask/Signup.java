package com.example.SDPTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Signup extends AppCompatActivity{

    EditText full_name, user_name, eMail, passWd, conPasswd;
    TextView engl,tamil;
    Locale myLocale;
    String currentlanguage="en",currentLang;

    FirebaseAuth firebaseAuth;

    DatabaseReference data_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        currentlanguage=getIntent().getStringExtra(currentLang);


        full_name= (EditText) findViewById(R.id.fn);
        user_name=(EditText)findViewById(R.id.un);
        eMail=(EditText)findViewById(R.id.email);
        passWd=(EditText)findViewById(R.id.pass);
        conPasswd=(EditText)findViewById(R.id.con_pass);


        engl=(TextView)findViewById(R.id.eng);


        engl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });



        firebaseAuth = FirebaseAuth.getInstance();

        data_base= FirebaseDatabase.getInstance().getReference("Operator");

    }


    public void goToLogin(View view) {

        startActivity(new Intent(getApplicationContext(),Login.class));

    }

    public void signUp(View view) {

        final String fullName, userName, email, passwd, con_passwd;
        fullName=full_name.getText().toString().trim();
        userName=user_name.getText().toString().trim();
        email=eMail.getText().toString().trim();
        passwd=passWd.getText().toString().trim();
        con_passwd=conPasswd.getText().toString().trim();

        if(fullName.isEmpty())
        {
            full_name.setError(getString(R.string.fn_req));
            return;
        }
        if(userName.isEmpty())
        {
            user_name.setError(getString(R.string.un_req));
            return;
        }
        if(email.isEmpty())
        {
            eMail.setError(getString(R.string.email_req));
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            eMail.setError(getString(R.string.val_email));
            return;
        }
        if(passwd.isEmpty())
        {
            passWd.setError(getString(R.string.pass_req));
            return;
        }
        if(passwd.length()<6)
        {
            passWd.setError(getString(R.string.pass_len_req));
            return;
        }
        if(con_passwd.isEmpty())
        {
            conPasswd.setError(getString(R.string.cpass_req));
            return;
        }
        if(!con_passwd.equals(passwd))
        {
            conPasswd.setError(getString(R.string.pass_equal_req));
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, passwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Operator info = new Operator(
                                    fullName, userName, email
                            );

                            FirebaseDatabase.getInstance().getReference("Operator")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Toast.makeText(getApplicationContext(),getString(R.string.reg_succ),Toast.LENGTH_LONG);
                                    startActivity(new Intent(getApplicationContext(),Splash.class));

                                }
                            });


                        } else {

                            Log.i("null","Error: "+ task.getException());
                            Toast.makeText(getApplicationContext(), "This account already exists",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }


    public void setLocale(String localeName){
        if(!localeName.equals(currentlanguage)){
            myLocale=new Locale(localeName);
            Resources res=getResources();
            DisplayMetrics dm= res.getDisplayMetrics();
            Configuration conf =  res.getConfiguration();
            conf.locale=myLocale;
            res.updateConfiguration(conf,dm);
            Intent refresh=new Intent(this, Signup.class);
            refresh.putExtra(currentLang,localeName);
            startActivity(refresh);
        }else{
            Toast.makeText(Signup.this,"Language already selected",Toast.LENGTH_LONG).show();
        }
    }

}
