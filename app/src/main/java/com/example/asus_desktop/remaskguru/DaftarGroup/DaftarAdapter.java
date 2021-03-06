package com.example.asus_desktop.remaskguru.DaftarGroup;

/**
 * Created by Asus-Desktop on 5/26/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.DaftarSiswaYangBuatTugas.DaftarSiswa;
import com.example.asus_desktop.remaskguru.Model.Result;
import com.example.asus_desktop.remaskguru.R;

import java.util.ArrayList;



public class DaftarAdapter extends RecyclerView.Adapter<DaftarAdapter.MahasiswaViewHolder> {
    private String namagroup;
    private String id_tugas;

    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_daftar, parent, false);
        return new MahasiswaViewHolder(view);
    }


    private ArrayList<Result> result;
    private Context mContext;


    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaGroup, txtMatpel, txtKeterangan, txtKategori;
        public ImageView overflow;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNamaGroup = (TextView) itemView.findViewById(R.id.txt_nama_group);
            txtMatpel = (TextView) itemView.findViewById(R.id.txt_matpel);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);

        }
    }

    public DaftarAdapter(Context mContext,ArrayList<Result> results) {
        this.mContext = mContext;
        this.result = results;

    }


    public void onBindViewHolder(final MahasiswaViewHolder holder, final int position) {
        holder.txtNamaGroup.setText(result.get(position).getNamagroup());
        holder.txtMatpel.setText(result.get(position).getNamaMatpel());

        holder.overflow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                namagroup = result.get(position).getNamagroup();
                id_tugas = result.get(position).getIdTugas();
                showPopupMenu(holder.overflow);

            }
        });
    }

    private void showPopupMenu(View view) {

        //inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_daftar_group, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();

    }

    //Click listener for popup menu item

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override

        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_lihat_join:
                    Intent intent = new Intent(mContext, DaftarSiswa.class);
                    intent.putExtra("namagroup", namagroup);
                    intent.putExtra("id_tugas",id_tugas);
                    Toast.makeText(mContext, ""+namagroup, Toast.LENGTH_SHORT).show();
                    mContext.startActivity(intent);

                   // Toast.makeText(mContext, "Edit", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_edit:
                    Toast.makeText(mContext, "Edit", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_delete:
                    Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }return false;

        }
    }
    @Override
    public int getItemCount() {

        return result.size();
    }

}