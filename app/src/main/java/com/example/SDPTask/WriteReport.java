package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteReport extends AppCompatActivity {

    EditText report;
    Button subRepo;

    //path variables
    String OptionSelected = " ";
    String AreaSelected = " ";
    String SectionSelected = " ";
    String shiftDate =  " ";
    String getReport =" ";

    //database variables
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
    DatabaseReference commontaskdata = database.getReference("commanTaskData");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_add_report);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        report = findViewById(R.id.writeRepo);
        subRepo = findViewById(R.id.subRepo);

        final Intent intent = getIntent();
        OptionSelected = intent.getStringExtra("OptionSelected");
        AreaSelected = intent.getStringExtra("AreaSelected");
        SectionSelected = intent.getStringExtra("SectionSelected");
        shiftDate = intent.getStringExtra("DateSelected");



        subRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getReport = report.getText().toString();
                Log.i("report", "onClick: ");
                commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
                commontaskdataset.child("Report").child("content").setValue(getReport);
                Toast.makeText(WriteReport.this, "Report Submitted", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
