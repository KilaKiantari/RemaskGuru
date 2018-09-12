package com.example.asus_desktop.remaskguru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus_desktop.remaskguru.DaftarGroup.Daftar_Group;

/**
 * Created by Asus-Desktop on 6/21/2018.
 */

public class Root extends Fragment {

    public Root() {
    }
    private static final String TAG = Root.class.getSimpleName();

    private CardView cardView1,cardView2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        cardView1 = (CardView) view.findViewById(R.id.daftarcardId);
        cardView2 = (CardView) view.findViewById(R.id.siswacardId);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new Daftar_Group();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new JoinSiswaGrup();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });




        return view;


    }

}
