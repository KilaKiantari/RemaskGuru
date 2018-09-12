package com.example.asus_desktop.remaskguru;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelGuruProfile;
import com.example.asus_desktop.remaskguru.Model.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Asus-Desktop on 5/21/2018.
 */

public class Profil extends Fragment {

    public Profil(){}
    RelativeLayout view;
    private ModelGuruProfile modelGuruProfile;
    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnLogin ;
    private TextView NamaSiswa,Status,Sekolah,Email,tanggal;
  //  private UserProfilSiswa modelUserProfile;
    private String guru_id;
    private TextView Tentang;
    private TextView Logout;
    SessionManager session;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_profile, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Remask", MODE_PRIVATE);
        guru_id = sharedPreferences.getString("guru_id","");


        NamaSiswa = (TextView) view.findViewById(R.id.tvNamaLengkap);
        Status = (TextView) view.findViewById(R.id.tvStatus);
        Sekolah = (TextView) view.findViewById(R.id.tvSekolah);
        Email = (TextView) view.findViewById(R.id.tvEmail);
        Tentang = (TextView) view.findViewById(R.id.tvtentang);
        Logout = (TextView) view.findViewById(R.id.tvLogout);
        tanggal = (TextView) view.findViewById(R.id.tvTgl);

        Tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Tools();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session = new SessionManager(getActivity());
                session.logoutUser();
                onStop();
            }
        });



        getActivity().setTitle("Profil Saya");

        ApiClient.services_get_profile_guru.getProfile(guru_id).enqueue(new Callback<ModelGuruProfile>() {
            @Override
            public void onResponse(Call<ModelGuruProfile> call, Response<ModelGuruProfile> response) {
                modelGuruProfile = response.body();
                NamaSiswa.setText(modelGuruProfile.getNamaGuru());
                Status.setText(modelGuruProfile.getLevel());
                Sekolah.setText(modelGuruProfile.getSekolah());
                Email.setText(modelGuruProfile.getEmail());
                tanggal.setText(modelGuruProfile.getTglLahir());

                switch (modelGuruProfile.getLevel()) {
                    case "1":
                        Status.setText("Siswa");
                        break;
                    case "2":
                        Status.setText("Guru");
                        break;
                    case "3":
                        Status.setText("Orangtua");
                        break;
                }
            }
            public void onFailure(Call<ModelGuruProfile> call, Throwable t) {

            }


        });


        return view;
    }
}