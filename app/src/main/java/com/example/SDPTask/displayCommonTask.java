package com.example.SDPTask;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eyalbira.loadingdots.LoadingDots;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class displayCommonTask extends AppCompatActivity implements displayTaskAdapter.OnDisplayTaskListener {

    // UI
    public RecyclerView displayRecyclerView;

    //var

    public ArrayList<DisplayTask> mDisplayTask = new ArrayList<>();
    public displayTaskAdapter mDisplayTaskAdapter;

    //path variables
    String OptionSelected = " ";
    String AreaSelected = " ";
    String SectionSelected = " ";
    String shiftDate =  " ";

    //database variables
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
    DatabaseReference commontaskdata = database.getReference("commanTaskData");

    // Current User
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    String email = Objects.requireNonNull(currentFirebaseUser).getEmail();
    String userUid = currentFirebaseUser.getUid();
    DatabaseReference operator = database.getReference("Operator");
    String userName ;



    //Admin check
    boolean AdminFlag = true;

    // other parameters
    Intent intent1;
    String checkerName = " ";
    String doneByName = " ";
    String verifyName = " ";
    String reportContent = " ";
    Button verify;
    Button report;
    Button details;
    Button check;
    TextView checkedAndVerified;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.display_verify_checklist);

        //path intents
        final Intent intent = getIntent();
        OptionSelected = intent.getStringExtra("OptionSelected");
        AreaSelected = intent.getStringExtra("AreaSelected");
        SectionSelected = intent.getStringExtra("SectionSelected");
        shiftDate = intent.getStringExtra("DateSelected");

        verify = findViewById(R.id.verify);
        report = findViewById(R.id.report);
        check = findViewById(R.id.check);
        details = findViewById(R.id.details);
        checkedAndVerified = findViewById(R.id.checkAndverify);
        if(!email.contains("admin"))
        {
            AdminFlag = false;
            verify.setVisibility(View.GONE);
            report.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
        }

        //ProgressBar
        final LoadingDots progressBar = findViewById(R.id.progressbarD);

        //RecyclerView
        displayRecyclerView = findViewById(R.id.recyclerViewD);
        displayRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        displayRecyclerView.setLayoutManager(linearLayoutManager);

        mDisplayTaskAdapter = new displayTaskAdapter(mDisplayTask, this);
        displayRecyclerView.setAdapter(mDisplayTaskAdapter);



        //Get the checker name
        operator.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                userName = snapshot.child(userUid).child("fullName").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        displayTasks(new displayCommonTask.MyCallback() { //REASON:  https://stackoverflow.com/questions/47847694/how-to-return-datasnapshot-value-as-a-result-of-a-method
            @Override
            public void onCallback() {
                String detail = "Done By:" + doneByName+"   " +"Checked By:"  + checkerName +"   "+ "Verified By:" + verifyName+"   ";

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent1 = new Intent(getApplicationContext(), Details.class);
                        intent1.putExtra("SandD",shiftDate);
                        intent1.putExtra("db",doneByName);
                        intent1.putExtra("cb",checkerName);
                        intent1.putExtra("vb",verifyName);
                        intent1.putExtra("content",reportContent);
                        startActivity(intent1);
                    }
                });


                if(!verifyName.equals(" "))
                {
                    Log.i("detail", "onCallback: ");
                    check.setVisibility(View.GONE);
                    verify.setVisibility(View.GONE);
                    checkedAndVerified.setVisibility(View.VISIBLE);
                }

                if(!checkerName.equals(" "))
                {
                    Log.i("detail", "onCallback: ");
                    check.setVisibility(View.GONE);
                }


                progressBar.setVisibility(View.GONE);
            }
        });


        // Alert Dialogue box for check
        final AlertDialog.Builder builderc = new AlertDialog.Builder(this);

        builderc.setTitle("Confirm Check");
        builderc.setMessage("Are you sure you want to CHECK the Checklist?");

        builderc.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
                commontaskdataset.child("CheckedBy").child("CName").setValue(userName);
                check.setVisibility(View.GONE);
                checkedAndVerified.setText("Checked");
                if(verify.getVisibility() == View.INVISIBLE)
                {
                    checkedAndVerified.setVisibility(View.VISIBLE);
                }

                Toast.makeText(displayCommonTask.this, "CHECKED", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builderc.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });
        // Alert Dialogue box for verify

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alert = builderc.create();
                alert.show();

            }
        });


        // Alert Dialogue box for verify
        final AlertDialog.Builder builderv = new AlertDialog.Builder(this);

        builderv.setTitle("Confirm Verify");
        builderv.setMessage("Are you sure you want to VERIFY the Checklist?");

        builderv.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
                commontaskdataset.child("VerifiedBy").child("VName").setValue(userName);
                verify.setVisibility(View.GONE);
                checkedAndVerified.setText("Checked and Verified");
                checkedAndVerified.setVisibility(View.VISIBLE);
                Toast.makeText(displayCommonTask.this, "VERIFIED", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builderv.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });
        // Alert Dialogue box for verify

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alert = builderv.create();
                alert.show();

            }
        });


        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(getApplicationContext(),WriteReport.class);
                intent2.putExtra("OptionSelected" , OptionSelected);
                intent2.putExtra("AreaSelected" , AreaSelected);
                intent2.putExtra("SectionSelected" , SectionSelected);
                intent2.putExtra("DateSelected" , shiftDate);
                startActivity(intent2);
            }
        });

    }

    private void displayTasks(final MyCallback myCallback) {

        Log.i("pathhere", "onCreate: " + OptionSelected + shiftDate+ AreaSelected + SectionSelected);
        commontaskdataset = database.getReference(OptionSelected).child(shiftDate).child(AreaSelected).child(SectionSelected);
        commontaskdataset.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                mDisplayTask.clear();
                mDisplayTaskAdapter.notifyDataSetChanged();
                String status = "";
                Log.i("pathhereondc", "onCreate: " + OptionSelected + shiftDate+ AreaSelected + SectionSelected);
                for(DataSnapshot ds : snapshot.getChildren())
                {

                    if(ds.getKey().equals("DoneBy")) {
                        doneByName  = ds.child("DName").getValue(String.class);
                        Log.i("doneByName", doneByName);
                    }
                    else if(ds.getKey().equals("CheckedBy"))
                    {
                        checkerName = ds.child("CName").getValue(String.class);
                        Log.i("checkByName", checkerName);
                    }
                    else if(ds.getKey().equals("VerifiedBy"))
                    {
                        verifyName  = ds.child("VName").getValue(String.class);
                        Log.i("verifyByName", "ver"+verifyName);
                    }
                    else if(ds.getKey().equals("Report"))
                    {
                        reportContent  = ds.child("content").getValue(String.class);
                        Log.i("reportContent", "ver"+reportContent);
                    }
                    else
                    {
                        DisplayTask temp = new DisplayTask();
                        String taskName = ds.child("name").getValue(String.class);
                        String remarks = ds.child("remarks").getValue(String.class);
                        String taskDone = ds.child("taskDone").getValue(String.class);

                        temp.setTaskName(taskName);
                        temp.setRemarks(remarks);
                        temp.setStatus(taskDone);

                        mDisplayTask.add(temp);
                    }
                }
                mDisplayTaskAdapter.notifyDataSetChanged();
                myCallback.onCallback();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    public void onTaskClick(int adapterPosition) {

    }

    public interface MyCallback {
        void onCallback();
    }
}
