package com.example.SDPTask;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eyalbira.loadingdots.LoadingDots;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class commonTask extends AppCompatActivity implements taskAdapter.OnTaskListener
         {

    //ui
    public RecyclerView CTRecyclerView;

    //var

    public ArrayList<task> mTasks = new ArrayList<>();
    public taskAdapter mTaskAdapter;

    String datasetcount;
    String deleteTaskNo;
    ArrayList<String> keyArray = new ArrayList<>();

    //path variables
    String OptionSelected = " ";
    String AreaSelected = " ";
    String SectionSelected = " ";


    //database variables
    FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference commontaskdata = database.getReference(OptionSelected).child(AreaSelected).child(SectionSelected);
     DatabaseReference commontaskdataset = database.getReference("commanTaskDataSet");
    // Current User
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    String email = Objects.requireNonNull(currentFirebaseUser).getEmail();
    String checkerUid = currentFirebaseUser.getUid();
    DatabaseReference operator = database.getReference("Operator");
    String checkerName ;
    //flags and sharedpreferences
    boolean AdminFlag = true;
    boolean deleteFlag = false;
    String tempFlag;
    SharedPreferences sharedpreferences;

    //Date
    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.comman_task);

        //path variable
        Intent intent = getIntent();
         OptionSelected = intent.getStringExtra("OptionSelected");
         AreaSelected = intent.getStringExtra("AreaSelected");
         SectionSelected = intent.getStringExtra("SectionSelected");



        // Shared preferences for deletion
        sharedpreferences = getSharedPreferences("deletion", Context.MODE_PRIVATE);
        deleteFlag= sharedpreferences.getBoolean("delflag", false);
        tempFlag = sharedpreferences.getString("value","");



        Log.i("path", "onCreate: " + OptionSelected + AreaSelected + SectionSelected);

        if(TextUtils.isEmpty(OptionSelected) || TextUtils.isEmpty(AreaSelected) ||TextUtils.isEmpty(SectionSelected))
        {
            OptionSelected = sharedpreferences.getString("Option","1 ");
            AreaSelected = sharedpreferences.getString("Area","2 ");
            SectionSelected = sharedpreferences.getString("Section","3 ");
            Log.i("path2", "onCreate: " + OptionSelected + AreaSelected + SectionSelected);
        }
        Log.i("path2", "onCreate: " + OptionSelected + AreaSelected + SectionSelected);
        commontaskdata = database.getReference(OptionSelected).child(AreaSelected).child(SectionSelected);

        Button submitCT = findViewById(R.id.submitCT);
        Button addNewTask = findViewById(R.id.addTask);
        Button check = findViewById(R.id.check);
        Button submit = findViewById(R.id.submitCT);
        Button verify = findViewById(R.id.verify);
        Button details = findViewById((R.id.details));
        final EditText getShift = (EditText)findViewById(R.id.shift);
        if(!email.contains("admin"))
        {
            AdminFlag = false;
            addNewTask.setVisibility(View.INVISIBLE);



        }




        //ProgressBar
        final LoadingDots progressBar = findViewById(R.id.progressbar);

        //RecyclerView
        CTRecyclerView = findViewById(R.id.recyclerView);
        CTRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        CTRecyclerView.setLayoutManager(linearLayoutManager);
        // Attach the ItemTouchHelper
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(CTRecyclerView);

        mTaskAdapter = new taskAdapter(mTasks, this);
        CTRecyclerView.setAdapter(mTaskAdapter);

        //Get the checker name
        operator.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                checkerName = snapshot.child(checkerUid).child("fullName").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //retrieves the tasks to be displayed

        retrieveTasks(new MyCallback() {     //REASON:  https://stackoverflow.com/questions/47847694/how-to-return-datasnapshot-value-as-a-result-of-a-method
            @Override
            public void onCallback(ArrayList<String> value) {

                keyArray= (ArrayList<String>)value.clone();
                progressBar.setVisibility(View.GONE);
                Log.i("keyretrieved", String.valueOf(keyArray));
            }
        });

        // this to make sure if the task is deleted with taskname then the next added task should be with the same name
        Intent getDelTask = getIntent();
        tempFlag = getDelTask.getStringExtra("deleteTaskNo");
        Log.i("tempFlag", "onCreate: " + tempFlag);



        submitCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shift = getShift.getText().toString();

                if(shift.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter the Shift", Toast.LENGTH_LONG).show();
                }
                else
                {

                    DatabaseReference commontaskdataset = database.getReference("CheckAndVerify").child(shift.toUpperCase()+date).child(AreaSelected).child(SectionSelected);

                    for (int i = 0; i<mTaskAdapter.mTasks.size() ; i++)
                    {
                        String taskPar = keyArray.get(i);
                        Log.i(String.valueOf(i), "the remarks are: " + mTaskAdapter.mTasks.get(i).getRemarks());
                        String remarkGiven = mTaskAdapter.mTasks.get(i).getRemarks();
                        commontaskdataset.child(taskPar).child("remarks").setValue(remarkGiven);
                        Log.i(String.valueOf(i), "the selected are: " + mTaskAdapter.mTasks.get(i).isTaskDone());
                        boolean temptask = mTaskAdapter.mTasks.get(i).isTaskDone();
                        String taskDone;
                        if(temptask)
                        {
                             taskDone = "Checked";
                        }
                        else
                        {
                             taskDone = "Not\nChecked";
                        }
                        commontaskdataset.child(taskPar).child("taskDone").setValue(taskDone);
                        String taskName = mTaskAdapter.mTasks.get(i).getTaskName();
                        commontaskdataset.child(taskPar).child("name").setValue(taskName);
                    }
                    commontaskdataset.child("DoneBy").child("DName").setValue(checkerName);

                    Toast t1 =    Toast.makeText(getApplicationContext(), "Task Report Submitted Successfully.", Toast.LENGTH_LONG);
                    t1.show();
                    finish();
                }

            }
        });

        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddTask.class);
                intent.putStringArrayListExtra("keysArray",keyArray);
                if(!TextUtils.isEmpty(tempFlag) && deleteFlag)
                {
                    intent.putExtra("taskcount", tempFlag);
                    deleteFlag = false;
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.clear();
                    editor.putBoolean("delflag", deleteFlag);
                    editor.putString("value",deleteTaskNo);
                    editor.putString("Option",OptionSelected);
                    editor.putString("Area",AreaSelected);
                    editor.putString("Section",SectionSelected);
                    editor.apply();
                }
                else
                {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    intent.putExtra("taskcount", datasetcount);
                    editor.putString("Option",OptionSelected);
                    editor.putString("Area",AreaSelected);
                    editor.putString("Section",SectionSelected);
                    editor.apply();

                }

                intent.putExtra("OptionSelected" , OptionSelected);
                intent.putExtra("AreaSelected" , AreaSelected);
                intent.putExtra("SectionSelected" , SectionSelected);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }



    /*private void insertFakeTasks(){
        for(int i = 0; i < 10; i++){
            task tasks = new task();
            tasks.setTaskName("title #" + i);
            tasks.setRemarks("content #: " + i);
            mTasks.add(tasks);
            Log.i("fake tasks", "insertFakeTasks: " +i);
        }
        mTaskAdapter.notifyDataSetChanged();
        Log.i("the tasks are 2", "onCreateViewHolder: " + mTasks.get(1).getRemarks());
    }*/


    //retrive the checkboxes and empty editTexts
    private  void retrieveTasks(final MyCallback myCallback){
        keyArray.clear();
        commontaskdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                 datasetcount = String.valueOf(snapshot.getChildrenCount());
                // retrieved the tasks that are to be shown
                Log.i("taskName", "onDataChange: "+ snapshot);
                ArrayList<String> tempList = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren())
                {
                    tempList.add(ds.getKey());
                    task temp = new task();
                    String taskName = ds.child("name").getValue(String.class);
                    temp.setTaskName(taskName);
                    mTasks.add(temp);
                }
                mTaskAdapter.notifyDataSetChanged();
                myCallback.onCallback(tempList);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



         }

    private  void deleteTask(task delTask){
        Query deleteQuery = commontaskdata.orderByChild("name").equalTo(delTask.getTaskName());
        deleteQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren())
                {
                    String area= ds.getRef().getKey();

                    Log.i("area", "onSwiped: " + area);
                    String count = area.substring(Math.max(area.length() - 2, 0));
                    Log.i("count", "onSwiped: " + count);
                    int intcount = Integer.parseInt(count);
                    Log.i("intcount", "onSwiped: " + intcount);
                    if(intcount < 10){
                        deleteTaskNo = "0" + intcount;
                    }
                    else
                    {
                        deleteTaskNo = String.valueOf(intcount);
                    }

                    Log.i("tempDelTask", "onSwiped:1" + deleteTaskNo);
                    // this line removes the data from the database
                    ds.getRef().removeValue();
                }

                Intent intent = new Intent(getApplicationContext() , commonTask.class);
                Log.i("tempDelTask", "onSwiped: " + deleteTaskNo);
                intent.putExtra("deleteTaskNo",deleteTaskNo);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                deleteFlag = true;
                editor.putBoolean("delflag", deleteFlag);
                editor.putString("value",deleteTaskNo);
                editor.apply();
                startActivity(intent);
                finish();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @Override
    public void onTaskClick(int position) {

    }


    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if(AdminFlag){
                deleteTask(mTasks.get(viewHolder.getAdapterPosition()));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "You do not have Admin Access", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext() , commonTask.class);
                startActivity(intent);
                finish();
            }

        }
    };

    public interface MyCallback {
        void onCallback(ArrayList<String> value);
    }
}
