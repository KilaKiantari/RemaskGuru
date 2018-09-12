package com.example.asus_desktop.remaskguru;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelDaftarGroup;
import com.example.asus_desktop.remaskguru.Model.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Asus-Desktop on 7/12/2018.
 */

public class JoinSiswaGrup extends Fragment {

    private JoinSiswaGrupAdapter adapter;
    private ModelDaftarGroup modelDaftarGroup;
    String[] status;
    TypedArray profile_pics;
    String[] statues;
    String[] contactType;
    ArrayList<Result> result;
    ListView mylistview;
    String namagroup;
    String guru_id;
    RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_join_siswa_grup, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getActivity().setTitle("Daftar Group Guru");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Remask", MODE_PRIVATE);
        guru_id = sharedPreferences.getString("guru_id", "");


        //  setListViewData();


        ApiClient.services_get_daftar_group.getDaftar(guru_id).enqueue(new Callback<ModelDaftarGroup>() {
            @Override
            public void onResponse(Call<ModelDaftarGroup> call, Response<ModelDaftarGroup> response) {
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Please wait....");
                progressDialog.show();
                Log.e("Response Guru", "Code : " + response.code());

                if (response.isSuccessful()) {
                    modelDaftarGroup = response.body();
                    adapter = new JoinSiswaGrupAdapter(getActivity(), modelDaftarGroup.getResults());
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                       progressDialog.dismiss();

                } else {
                    Toast.makeText(getActivity(), "KESALAHAN BIASA", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ModelDaftarGroup> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}



