package com.example.SDPTask;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class displayTaskAdapter extends RecyclerView.Adapter<displayTaskAdapter.ViewHolder>  {

    public ArrayList<DisplayTask> mTaskDisplay = new ArrayList<>();
    public OnDisplayTaskListener mOnDisplayTaskListener;


    public displayTaskAdapter(ArrayList<DisplayTask> DisplayTask, OnDisplayTaskListener onDisplayTaskListener) {

        this.mTaskDisplay = DisplayTask;
        this.mOnDisplayTaskListener = onDisplayTaskListener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.displaytaskitem, parent, false);

        return new displayTaskAdapter.ViewHolder(view, mOnDisplayTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull displayTaskAdapter.ViewHolder holder, int position) {

        holder.task.setText(mTaskDisplay.get(position).getTaskName());
        holder.remark.setText(mTaskDisplay.get(position).getRemarks());
        holder.status.setText(mTaskDisplay.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return mTaskDisplay.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView task;
        TextView remark;
        TextView status;
        displayTaskAdapter.OnDisplayTaskListener mOnDisplayTaskListener;

        public ViewHolder(View itemView, displayTaskAdapter.OnDisplayTaskListener onDisplayTaskListener) {
            super(itemView);
            Log.i("ViewHolder", "ViewHolder: reaching here");
            task = itemView.findViewById(R.id.taskDisplay);
            remark = itemView.findViewById(R.id.remarkDisplay);
            status = itemView.findViewById(R.id.status);
            //EditText change event handled here
            //checkbox click event handling
            mOnDisplayTaskListener = onDisplayTaskListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("Check reached here", "onClick: " + getAdapterPosition());
            mOnDisplayTaskListener.onTaskClick(getAdapterPosition());
        }
    }


    public interface OnDisplayTaskListener {
         void onTaskClick(int adapterPosition);
    }
}
