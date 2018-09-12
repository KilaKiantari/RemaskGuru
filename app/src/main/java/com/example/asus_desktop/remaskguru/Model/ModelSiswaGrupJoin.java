package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asus-Desktop on 7/12/2018.
 */

public class ModelSiswaGrupJoin {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("jml")
    @Expose
    private Integer jml;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getJml() {
        return jml;
    }

    public void setJml(Integer jml) {
        this.jml = jml;
    }
}
