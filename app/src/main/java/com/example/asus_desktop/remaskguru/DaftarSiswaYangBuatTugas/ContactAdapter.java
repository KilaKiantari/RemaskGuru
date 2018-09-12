package com.example.asus_desktop.remaskguru.DaftarSiswaYangBuatTugas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus_desktop.remaskguru.Model.Result;
import com.example.asus_desktop.remaskguru.R;

import java.util.ArrayList;

/**
 * Created by Asus-Desktop on 6/29/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MahasiswaViewHolder> {
private String namagroup;
private String id_tugas;

public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_daftar_siswa, parent, false);
        return new MahasiswaViewHolder(view);
        }


private ArrayList<Result> result;
private Context mContext;


public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
    private TextView txtNama, txtNamaTugas, txtStatus;
    private ImageView img_tgl;
    private CardView card_view_sensor;

    public MahasiswaViewHolder(View itemView) {
        super(itemView);
        txtNama = (TextView) itemView.findViewById(R.id.tv_nama_lengkap);
        txtNamaTugas = (TextView) itemView.findViewById(R.id.tv_nama_tugas);
        txtStatus = (TextView) itemView.findViewById(R.id.status);
        img_tgl = (ImageView) itemView.findViewById(R.id.img_tgl);
        card_view_sensor = (CardView) itemView.findViewById(R.id.card_view_sensor);

    }
}

    public ContactAdapter(Context mContext,ArrayList<Result> results) {
        this.mContext = mContext;
        this.result = results;

    }


    public void onBindViewHolder(final ContactAdapter.MahasiswaViewHolder holder, final int position) {
        holder.txtNama.setText(result.get(position).getNamalengkap());
        holder.txtStatus.setText(result.get(position).getStatusTugas());
        holder.txtNamaTugas.setText(result.get(position).getNamaTugas());
        holder.card_view_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(mContext, "KLIK", Toast.LENGTH_SHORT).show();
                id_tugas = result.get(position).getIdTugas();
                Intent intent = new Intent(mContext, Grafik.class);
                intent.putExtra("id_tugas",id_tugas);
                mContext.startActivity(intent);
            }
        });

        switch (result.get(position).getStatusTugas()) {
            case "s":
                holder.txtStatus.setText("Sudah");
                holder.img_tgl.setBackgroundResource(R.drawable.checked);
                break;
            case "b":
                holder.txtStatus.setText("Belum");
                holder.img_tgl.setBackgroundResource(R.drawable.error);
                break;

        }
    }


    @Override
    public int getItemCount() {

        return result.size();
    }

}