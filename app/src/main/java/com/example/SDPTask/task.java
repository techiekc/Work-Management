package com.example.SDPTask;

import android.os.Parcel;
import android.os.Parcelable;

public class task implements Parcelable {


    private String taskName ;
    private String remarks;

    public boolean isTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    public static Creator<task> getCREATOR() {
        return CREATOR;
    }

    private boolean taskDone;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    public task(){

    }

    public task(String taskName, String remarks) {
        this.taskName = taskName;
        this.remarks = remarks;
    }

    protected task(Parcel in) {
        taskName = in.readString();
        remarks = in.readString();
    }


    public static final Creator<task> CREATOR = new Creator<task>() {
        @Override
        public task createFromParcel(Parcel in) {
            return new task(in);
        }

        @Override
        public task[] newArray(int size) {
            return new task[size];
        }
    };




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(taskName);
        dest.writeString(remarks);
    }
}
