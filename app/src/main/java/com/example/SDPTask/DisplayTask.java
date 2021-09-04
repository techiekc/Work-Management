package com.example.SDPTask;

import android.os.Parcel;
import android.os.Parcelable;

public class DisplayTask implements Parcelable {

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DisplayTask(String taskName, String remarks, String status) {
        this.taskName = taskName;
        this.remarks = remarks;
        this.status = status;
    }

    public DisplayTask()
    {

    }

    private String taskName;
    private String remarks;
    private String status;

    protected DisplayTask(Parcel in) {
        taskName = in.readString();
        remarks = in.readString();
        status = in.readString();
    }

    public static final Creator<DisplayTask> CREATOR = new Creator<DisplayTask>() {
        @Override
        public DisplayTask createFromParcel(Parcel in) {
            return new DisplayTask(in);
        }

        @Override
        public DisplayTask[] newArray(int size) {
            return new DisplayTask[size];
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
        dest.writeString(status);
    }
}
