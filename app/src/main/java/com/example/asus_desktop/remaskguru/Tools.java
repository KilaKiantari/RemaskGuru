package com.example.asus_desktop.remaskguru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Asus-Desktop on 5/21/2018.
 */

public class Tools extends Fragment {
    public Tools(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tools, container, false);
        getActivity().setTitle("Tentang");

        return view;
    }
}
