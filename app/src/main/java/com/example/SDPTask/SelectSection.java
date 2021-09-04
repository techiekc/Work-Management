package com.example.SDPTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SelectSection extends AppCompatActivity {


    String AreaSelected;
    String OptionSelected;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        OptionSelected = intent.getStringExtra("OptionSelected");
        AreaSelected = intent.getStringExtra("selectArea");

        if(AreaSelected.equals("GoDown"))
        {
            setContentView(R.layout.godown);
            TextView stores = findViewById(R.id.Raw);
            TextView delivery = findViewById(R.id.delivery);
            TextView notes1 = findViewById(R.id.notes1);


            stores.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                         intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Raw");
                    startActivity(intent);

                }
            });

            delivery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "delivery");
                    startActivity(intent);

                }
            });

            notes1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes1");
                    startActivity(intent);

                }
            });



        }
        if(AreaSelected.equals("axtel"))
        {
            setContentView(R.layout.administration);
            TextView materialHandeling = findViewById(R.id.Documentation);
            TextView notes2 = findViewById(R.id.notes2);


            materialHandeling.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Documentation");
                    startActivity(intent);

                }
            });

            notes2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes2");
                    startActivity(intent);

                }
            });


        }
        if(AreaSelected.equals("admin"))
        {
            setContentView(R.layout.documentation);
            TextView areaPremix = findViewById(R.id.areaPremix);
            TextView DMGpp = findViewById(R.id.DMGpp);
            TextView invertSyrup = findViewById(R.id.invertSyrup);
            //TextView sugarSolution = findViewById(R.id.sugarSolution);
            //TextView biscuitGrinding = findViewById(R.id.biscuitGrinding);
            //TextView sieving = findViewById(R.id.sieving);
            //TextView DFCFpp = findViewById(R.id.DFCFpp);
            TextView notes3 = findViewById(R.id.notes3);



            areaPremix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Client Comp");
                    startActivity(intent);

                }
            });

            DMGpp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Future clients");
                    startActivity(intent);

                }
            });

            invertSyrup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Staff req");
                    startActivity(intent);

                }
            });

            /*sugarSolution.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "sugarSolution");
                    startActivity(intent);

                }
            });*/

            /*biscuitGrinding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "biscuitGrinding");
                    startActivity(intent);

                }
            });*/

            /*sieving.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "sieving");
                    startActivity(intent);

                }
            });

            DFCFpp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "DFCFpp");
                    startActivity(intent);

                }
            });*/

            notes3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes3");
                    startActivity(intent);

                }
            });

        }
        if(AreaSelected.equals("Marketing"))
        {
            setContentView(R.layout.marketing);
            TextView areaMix = findViewById(R.id.Branding);
            TextView IMarketing = findViewById(R.id.IMarketing);
            //TextView marie = findViewById(R.id.marie);
            //TextView bounce = findViewById(R.id.bounce);
            //TextView cookie = findViewById(R.id.cookie);
            TextView notes4 = findViewById(R.id.notes4);


            areaMix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Branding");
                    startActivity(intent);

                }
            });

            IMarketing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "IMarketing");
                    startActivity(intent);

                }
            });

           /* marie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "marie");
                    startActivity(intent);

                }
            });*/


            /*bounce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "bounce");
                    startActivity(intent);

                }
            });*/

            /*cookie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "cookie");
                    startActivity(intent);

                }
            });*/

            notes4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes4");
                    startActivity(intent);

                }
            });


        }
        if(AreaSelected.equals("Finance"))
        {
            setContentView(R.layout.finance);
            TextView areaForm = findViewById(R.id.Investments);
            TextView funding = findViewById(R.id.funding);
            TextView plan = findViewById(R.id.plan);
            //TextView bounceForm = findViewById(R.id.bounceForm);
            //TextView cookieForm = findViewById(R.id.cookieForm);
            //TextView notes5 = findViewById(R.id.notes5);


            areaForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "areaForm");
                    startActivity(intent);

                }
            });

            funding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "funding");
                    startActivity(intent);

                }
            });

            plan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "plan");
                    startActivity(intent);

                }
            });

            /*bounceForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "bounceForm");
                    startActivity(intent);

                }
            });*/

            /*cookieForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "cookieForm");
                    startActivity(intent);

                }
            });*/

            /*notes5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes5");
                    startActivity(intent);

                }
            });*/


        }
        if(AreaSelected.equals("oven"))
        {
            setContentView(R.layout.packing);
            TextView labelling = findViewById(R.id.labelling);
            TextView maintenance = findViewById(R.id.maintenance);
            //TextView marieOven = findViewById(R.id.marieOven);
            //TextView bounceFormOven = findViewById(R.id.bounceFormOven);
            //TextView cookieFormOven = findViewById(R.id.cookieFormOven);
            TextView notes6 = findViewById(R.id.notes6);



            labelling.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "labelling");
                    startActivity(intent);

                }
            });

            maintenance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "maintenance");
                    startActivity(intent);

                }
            });

            /*marieOven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "marieOven");
                    startActivity(intent);

                }
            });*/

            /*bounceFormOven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "bounceFormOven");
                    startActivity(intent);

                }
            });*/


            /*cookieFormOven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "cookieFormOven");
                    startActivity(intent);

                }
            });*/


            notes6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes6");
                    startActivity(intent);

                }
            });
        }
        if(AreaSelected.equals("packing"))
        {
            setContentView(R.layout.resource);
            TextView Stationary = findViewById(R.id.Stationary);
            TextView audit = findViewById(R.id.audit);
            //TextView mariePack = findViewById(R.id.mariePack);
            //TextView bouncePack = findViewById(R.id.bouncePack);
            //TextView cookiePack = findViewById(R.id.cookiePack);
            TextView notes7 = findViewById(R.id.notes7);


            Stationary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Stationary");
                    startActivity(intent);

                }
            });

            audit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "audit");
                    startActivity(intent);

                }
            });

            /*mariePack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "mariePack");
                    startActivity(intent);

                }
            });*/



            /*bouncePack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "bouncePack");
                    startActivity(intent);

                }
            });*/

            /*cookiePack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "cookiePack");
                    startActivity(intent);

                }
            });*/

            notes7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes7");
                    startActivity(intent);

                }
            });


        }
        if(AreaSelected.equals("rroom"))
        {
            setContentView(R.layout.resource);
            TextView Stationary = findViewById(R.id.Stationary);
            TextView audit = findViewById(R.id.audit);


            Stationary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Stationary");
                    startActivity(intent);

                }
            });

            audit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes8");
                    startActivity(intent);

                }
            });
        }
        if(AreaSelected.equals("Projects"))
        {
            setContentView(R.layout.projects);
            TextView fAndcPrep = findViewById(R.id.Batch1);
            TextView notes9 = findViewById(R.id.notes9);


            fAndcPrep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "Batch1");
                    startActivity(intent);

                }
            });

            notes9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    if(OptionSelected.equals("Create"))
                    {
                        intent = new Intent(getApplicationContext(), commonTask.class);
                    }
                    else if(OptionSelected.equals("CheckAndVerify"))
                    {
                        intent = new Intent(getApplicationContext(), ShiftAndDate.class);
                    }
                    intent.putExtra("OptionSelected" , OptionSelected);
                    intent.putExtra("AreaSelected" , AreaSelected);
                    intent.putExtra("SectionSelected" , "notes9");
                    startActivity(intent);

                }
            });
        }

    }
}
