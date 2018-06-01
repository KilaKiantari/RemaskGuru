package com.example.asus_desktop.remaskguru;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelDaftarGroup;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Asus-Desktop on 5/21/2018.
 */


public class Daftar_Group extends Fragment {

    public Daftar_Group() {
    }


    Toolbar toolbar;
    CalendarView calendarView;

    private static final String TAG = Daftar_Group.class.getSimpleName();

    private RecyclerView recyclerView;
    private DaftarAdapter adapter;
    private ModelDaftarGroup modelDaftarGroup;
    ApiClient apiClient;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private String date;
    private Calendar calendar;
    private FloatingActionButton fab;
    private ProgressDialog progressDialog;
    private Date currentTime = Calendar.getInstance().getTime();
    private String guru_id;
    //private ArrayList<Mahasiswa> mahasiswaArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_daftar_group, container, false);
        //addData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        //sharedPreferences = getActivity().getSharedPreferences("RemaskGuru", Context.MODE_PRIVATE);
//        edit = sharedPreferences.edit();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Remask", MODE_PRIVATE);
        guru_id = sharedPreferences.getString("guru_id","");
        Toast.makeText(getActivity(), ""+guru_id, Toast.LENGTH_SHORT).show();

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait....");
        progressDialog.show();


//        refreshRecycler();

        //adapter = new DaftarAdapter(getActivity(),mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getActivity().setTitle("Daftar Group");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent openCreateNote = new Intent(getActivity(), BuatGroup.class);
                startActivity(openCreateNote);
            }
        });


        ApiClient.services_get_daftar_group.getDaftar(guru_id).enqueue(new Callback<ModelDaftarGroup>() {
            @Override
            public void onResponse(Call<ModelDaftarGroup> call, Response<ModelDaftarGroup> response) {
                modelDaftarGroup = response.body();

//                adapter = new JoinGroupAdapter(this,modelGroupAll.getResults());
                adapter = new DaftarAdapter(getActivity(), modelDaftarGroup.getResults());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<ModelDaftarGroup> call, Throwable t) {

            }
        });

        return view;

    }

}
/*
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Dimas Maulana", "1414370309"));
        mahasiswaArrayList.add(new Mahasiswa("Fadly Yonk", "1214234560"));
        mahasiswaArrayList.add(new Mahasiswa("Ariyandi Nugraha", "1214230345"));
        mahasiswaArrayList.add(new Mahasiswa("Aham Siswana", "1214378098"));
    }
    */










