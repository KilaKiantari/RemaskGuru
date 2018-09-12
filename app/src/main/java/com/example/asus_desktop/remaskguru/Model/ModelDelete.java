package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus-Desktop on 7/25/2018.
 */

public class ModelDelete {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private String results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

}

