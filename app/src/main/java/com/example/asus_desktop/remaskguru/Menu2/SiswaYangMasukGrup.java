package com.example.asus_desktop.remaskguru.Menu2;

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
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelSiswaMasuk;
import com.example.asus_desktop.remaskguru.Model.Result;
import com.example.asus_desktop.remaskguru.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 7/12/2018.
 */

public class SiswaYangMasukGrup extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SiswaYangMasukAdapter adapter;
    private ModelSiswaMasuk modelSiswaMasuk;
    String[] status;
    TypedArray profile_pics;
    String[] statues;
    String[] contactType;
    ArrayList<Result> result;
    String namagroup;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_siswa);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SiswaYangMasukGrup.this.setTitle("Daftar Siswa");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        //  setListViewData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SiswaYangMasukGrup.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        Intent grup = getIntent();
        namagroup = grup.getStringExtra("namagroup");


        ApiClient.services_get_siswa_masuk.getSiswaMasuk(namagroup).enqueue(new Callback<ModelSiswaMasuk>() {
            @Override
            public void onResponse(Call<ModelSiswaMasuk> call, Response<ModelSiswaMasuk> response) {
                Log.e("Response Guru", "Code : " + response.code());
                if (response.isSuccessful()) {
                    modelSiswaMasuk = response.body();
                    adapter = new SiswaYangMasukAdapter(SiswaYangMasukGrup.this, modelSiswaMasuk.getResults());
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);


                    //  mylistview.setOnItemClickListener(DaftarSiswa.this);
                } else {
                    Toast.makeText(SiswaYangMasukGrup.this, "KESALAHAN BIASA", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ModelSiswaMasuk> call, Throwable t) {
                Toast.makeText(SiswaYangMasukGrup.this, "" + t, Toast.LENGTH_SHORT).show();
            }
        });




    }


}
