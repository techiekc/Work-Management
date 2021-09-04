package com.example.SDPTask;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class taskAdapter extends RecyclerView.Adapter<taskAdapter.ViewHolder> {


    public ArrayList<task> mTasks = new ArrayList<>();
    public OnTaskListener mOnTaskListener;



    public taskAdapter(ArrayList<task> mTasks, OnTaskListener onTaskListener) {

        this.mTasks = mTasks;
        this.mOnTaskListener = onTaskListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskitem, parent, false);

        return new ViewHolder(view, mOnTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull taskAdapter.ViewHolder holder, int position) {


            holder.task.setText(mTasks.get(position).getTaskName());
            holder.remark.setText(mTasks.get(position).getRemarks());

        //After that display progressbar at the below


    }
    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CheckBox task;
        EditText remark;
        OnTaskListener mOnTaskListener;

        public ViewHolder(View itemView, OnTaskListener onTaskListener) {
            super(itemView);
            Log.i("ViewHolder", "ViewHolder: reaaching here");
            task = itemView.findViewById(R.id.taskCheckbox);
            remark = itemView.findViewById(R.id.taskRemark);
            //EditText change event handled here
            remark.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    // here the changed value of the EditText is stored in the array
                    mTasks.get(getAdapterPosition()).setRemarks(remark.getText().toString());

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            //checkbox click event handling
            task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        mTasks.get(getAdapterPosition()).setTaskDone(isChecked);

                }
            });


            mOnTaskListener = onTaskListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("Check reached here", "onClick: " + getAdapterPosition());
            mOnTaskListener.onTaskClick(getAdapterPosition());
        }
    }

    public interface OnTaskListener{
        void onTaskClick(int position);
    }


}
