package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Details extends AppCompatActivity {
    boolean AdminFlag = true;


    TextView ShiftAndDate , DoneBy, CheckedBy, VerifiedBy , Report;
    String SandD= " ";
    String check = " ";
    String verify = " ";
    String db= " ";
    String cb= " ";
    String vb= " ";
    String reportContent =  " ";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    String email = Objects.requireNonNull(currentFirebaseUser).getEmail();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        Intent intent = getIntent();
         SandD = "Shift And Date:" + intent.getStringExtra("SandD");
         /*db = "Done By: " + intent.getStringExtra("DoneBy");*/
         db = "Done By: " + "chinmay1@gmail.com";
         cb = "Checked By: ";
         vb = "Verified By: ";

        if(email.contains("admin"))
        {
            AdminFlag = false;
            cb = "Checked By: " + email;
            vb = "Verified By: " + email;

        }

        reportContent= "Report: \n " + intent.getStringExtra("content");
        ShiftAndDate = findViewById(R.id.shiftAndDate);
        DoneBy = findViewById(R.id.doneby);
        CheckedBy = findViewById(R.id.checkedby);
        VerifiedBy = findViewById(R.id.verifiedby);
        Report = findViewById(R.id.report);


        ShiftAndDate.setText(SandD);
        DoneBy.setText(db);
        CheckedBy.setText(cb);
        VerifiedBy.setText(vb);
        Report.setText(reportContent);
    }
}
