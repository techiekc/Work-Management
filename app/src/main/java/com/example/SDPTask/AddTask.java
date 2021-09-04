package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference commontaskdata = database.getReference("commanTaskData");

    //path variable
    String OptionSelected = " ";
    String AreaSelected = " ";
    String SectionSelected = " ";

    // var
    String finaltaskCount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        //path variables
        Intent intent = getIntent();
        OptionSelected = intent.getStringExtra("OptionSelected");
        AreaSelected = intent.getStringExtra("AreaSelected");
        SectionSelected = intent.getStringExtra("SectionSelected");

        final EditText taskName = (EditText)findViewById(R.id.newTask);
        Button addTask = (Button)findViewById(R.id.addNew);

         String temp = intent.getStringExtra("taskcount");
        ArrayList<String> keysArray= intent.getStringArrayListExtra("keysArray");

        int count = Integer.parseInt(temp) +1 ;
        if(count<10)
        {
            String check = "task"+"0"+String.valueOf(count);
        }
        else
        {
            String check = "task"+String.valueOf(count);
        }
        String check = "task"+String.valueOf(count);
        if(keysArray.contains(check))
        {
            count= count-1;
        }
        if(count<10)
        {
             finaltaskCount = "task"+"0"+String.valueOf(count);
        }
        else
        {
             finaltaskCount = "task"+String.valueOf(count);
        }
        addTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String newTask = taskName.getText().toString();
                if(!newTask.trim().equals(""))
                {
                    DatabaseReference tempcommontaskdata = database.getReference(OptionSelected+"/"+AreaSelected+"/"+SectionSelected+"/"+"task"+ finaltaskCount);
                    tempcommontaskdata.child("name").setValue(newTask);

                    Intent intent = new Intent(getApplicationContext(),commonTask.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Enter a valid task",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
