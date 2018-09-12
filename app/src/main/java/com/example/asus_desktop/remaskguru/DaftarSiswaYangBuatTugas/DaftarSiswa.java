package com.example.asus_desktop.remaskguru.DaftarSiswaYangBuatTugas;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelBuatGroup;
import com.example.asus_desktop.remaskguru.Model.Result;
import com.example.asus_desktop.remaskguru.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 6/29/2018.
 */

public class DaftarSiswa extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private ModelBuatGroup modelBuatGroup;
    String[] status;
    TypedArray profile_pics;
    String[] statues;
    String[] contactType;
    ArrayList<Result> result;
    ListView mylistview;
    String namagroup;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_siswa);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DaftarSiswa.this.setTitle("Daftar Group");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        //  setListViewData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarSiswa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        Intent grup = getIntent();
        namagroup = grup.getStringExtra("namagroup");


        ApiClient.services_get_nama_siswa.getNamaSiswa(namagroup).enqueue(new Callback<ModelBuatGroup>() {
            @Override
            public void onResponse(Call<ModelBuatGroup> call, Response<ModelBuatGroup> response) {
                Log.e("Response Guru", "Code : " + response.code());
                if (response.isSuccessful()) {
                    modelBuatGroup = response.body();
                    adapter = new ContactAdapter(DaftarSiswa.this, modelBuatGroup.getResults());
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);


                    //  mylistview.setOnItemClickListener(DaftarSiswa.this);
                } else {
                    Toast.makeText(DaftarSiswa.this, "KESALAHAN BIASA", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ModelBuatGroup> call, Throwable t) {
                Toast.makeText(DaftarSiswa.this, "" + t, Toast.LENGTH_SHORT).show();
            }
        });




    }


}
