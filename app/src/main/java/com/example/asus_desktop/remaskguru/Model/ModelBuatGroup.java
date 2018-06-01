package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Asus-Desktop on 5/27/2018.
 */

public class ModelBuatGroup {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ArrayList<Result> results;

    public String getStatus() {
        return status;
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}
