package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ShiftAndDate extends AppCompatActivity {

    EditText shift ;
    DatePicker date;
    Button submit;
    String shiftDate;
    //path variables
    String OptionSelected = " ";
    String AreaSelected = " ";
    String SectionSelected = " ";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_shift_date);


        shift = (EditText)findViewById(R.id.enterShift);
        date = (DatePicker) findViewById(R.id.date);
        submit = (Button) findViewById(R.id.shiftDate);

        Intent intent1 = getIntent();
        OptionSelected = intent1.getStringExtra("OptionSelected");
        AreaSelected = intent1.getStringExtra("AreaSelected");
        SectionSelected = intent1.getStringExtra("SectionSelected");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getShift = shift.getText().toString();
                if(getShift.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Shift.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String month = "" ;
                    String day = "" ;
                    if(date.getDayOfMonth() < 10){

                        day = "0" + date.getDayOfMonth();
                    }
                    else{
                        day = String.valueOf(date.getDayOfMonth());
                    }
                    if((date.getMonth() + 1) < 10){

                        month  = "0" + (date.getMonth() + 1) ;
                    }
                    else
                    {
                        month = String.valueOf((date.getMonth() + 1));
                    }
                    shiftDate = getShift.toUpperCase()+ day+"-"+ month+"-"+date.getYear();
                    Intent intent = new Intent(getApplicationContext(), displayCommonTask.class);
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , SectionSelected);
                    intent.putExtra("DateSelected",shiftDate);
                    startActivity(intent);
                }

            }
        });

    }
}
