package com.example.SDPTask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    String email = Objects.requireNonNull(currentFirebaseUser).getEmail();
    boolean AdminFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button createCheck = (Button)findViewById(R.id.submit2);
        Button submitCheck = (Button)findViewById(R.id.submit);
        Button verifyCheck = (Button)findViewById(R.id.display);
        Button logout = (Button)findViewById(R.id.logout);
        if(!email.contains("admin"))
        {
            AdminFlag = false;
            createCheck.setVisibility(View.GONE);

        }

        else
        {
            AdminFlag = true;
            submitCheck.setVisibility(View.GONE);

        }

        createCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectArea.class);
                intent.putExtra("selectOption" , "Create");
                startActivity(intent);

            }
        });

        submitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectArea.class);
                intent.putExtra("selectOption" , "Create");
                startActivity(intent);

            }
        });

        verifyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectArea.class);
                intent.putExtra("selectOption" , "CheckAndVerify");
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}