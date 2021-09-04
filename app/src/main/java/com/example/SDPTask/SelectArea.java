package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;



public class SelectArea extends AppCompatActivity {

    // Intent Strings
    String OptionSelected = "";

    TextView GoDown , premixing, mixing , forming , packing, rroom, flavourroom;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_select_area);

        GoDown = findViewById(R.id.GoDown);

        premixing = findViewById(R.id.admin);
        mixing = findViewById(R.id.mixing);
        forming = findViewById(R.id.forming);

        packing = findViewById(R.id.packing);
        rroom = findViewById(R.id.rroom);
        flavourroom = findViewById(R.id.flavroom);

        Intent intent = getIntent();
        OptionSelected = intent.getStringExtra("selectOption");

        GoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "GoDown");
                startActivity(intent);

            }
        });



        premixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "admin");
                startActivity(intent);

            }
        });

        mixing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "Marketing");
                startActivity(intent);

            }
        });


        forming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "Finance");
                startActivity(intent);

            }
        });



        packing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "packing");
                startActivity(intent);

            }
        });

        rroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "rroom");
                startActivity(intent);

            }
        });


        flavourroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectSection.class);
                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("selectArea" , "Projects");
                startActivity(intent);

            }
        });





        if(OptionSelected.equals("Create"))
         {

         }
         else
         {

         }

    }
}
