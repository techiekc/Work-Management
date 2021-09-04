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
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class Login extends AppCompatActivity {

    EditText em,pd;
    TextView engl;
    Locale myLocale;
    String currentlanguage="en",currentLang;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(getApplicationContext(), Splash.class));
            finish();
        }


        currentlanguage=getIntent().getStringExtra(currentLang);

        em=(EditText)findViewById(R.id.e1);
        pd=(EditText)findViewById(R.id.p1);

        engl=(TextView)findViewById(R.id.eng);


        engl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });



        firebaseAuth=FirebaseAuth.getInstance();

    }

    public void goToSignup(View view) {

        startActivity(new Intent(getApplicationContext(),Signup.class));

    }

    public void login(View view) {

        String email, password;
        email=em.getText().toString().trim();
        password=pd.getText().toString().trim();

        if(email.isEmpty())
        {
            em.setError(getString(R.string.email_req));
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            em.setError(getString(R.string.val_email));
            return;
        }
        if(password.isEmpty())
        {
            pd.setError(getString(R.string.pass_req));
            return;
        }




        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent in=new Intent(getApplicationContext(),Splash.class);
                            Toast.makeText(Login.this,  "Logged in Successfully",
                                    Toast.LENGTH_LONG).show();
                            startActivity(in);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d(null, "Error"+ task.getException());
                            Toast.makeText(Login.this,  getString(R.string.reg_fail),
                                    Toast.LENGTH_LONG).show();
                        }
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
            Intent refresh=new Intent(this, Login.class);
            refresh.putExtra(currentLang,localeName);
            startActivity(refresh);
        }else{
            Toast.makeText(Login.this,"Language already selected",Toast.LENGTH_LONG).show();
        }
    }
}
