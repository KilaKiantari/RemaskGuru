package com.example.asus_desktop.remaskguru.Menu2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelDelete;
import com.example.asus_desktop.remaskguru.Model.Result;
import com.example.asus_desktop.remaskguru.ProfilSiswa;
import com.example.asus_desktop.remaskguru.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 7/12/2018.
 */

public class SiswaYangMasukAdapter extends RecyclerView.Adapter<SiswaYangMasukAdapter.MahasiswaViewHolder> {
    private String id_grup;
    private String id_tugas;
    private String id_siswa;
    private String namasiswa;
    public Result infoData;




    public SiswaYangMasukAdapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_siswa_masuk_grup, parent, false);
        return new SiswaYangMasukAdapter.MahasiswaViewHolder(view);
    }


    private ArrayList<Result> result;
    private Context mContext;


    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNamaTugas, txtStatus;
        private ImageView img_tgl,overflow;
        private CardView card_view_sensor;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.tv_nama_lengkap);
            txtNamaTugas = (TextView) itemView.findViewById(R.id.tv_nama_tugas);
            txtStatus = (TextView) itemView.findViewById(R.id.status);
            img_tgl = (ImageView) itemView.findViewById(R.id.img_tgl);
            card_view_sensor = (CardView) itemView.findViewById(R.id.card_view_sensor);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);

        }
    }

    public SiswaYangMasukAdapter(Context mContext, ArrayList<Result> results) {
        this.mContext = mContext;
        this.result = results;

    }


    public void onBindViewHolder(final SiswaYangMasukAdapter.MahasiswaViewHolder holder, final int position) {
        holder.txtNama.setText(result.get(position).getNamalengkap());
//        holder.txtStatus.setText(result.get(position).getStatusTugas());
        holder.txtNamaTugas.setText(result.get(position).getSekolah());
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_grup = result.get(position).getIdGroup();
                namasiswa = result.get(position).getNamalengkap();
                infoData = result.get(position);
                showPopupMenu(holder.overflow);
            }
        });
        holder.card_view_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(mContext, "KLIK", Toast.LENGTH_SHORT).show();
              //  id_tugas = result.get(position).getIdTugas();
                id_siswa = result.get(position).getSiswaId();
                Intent intent = new Intent(mContext, ProfilSiswa.class);
                intent.putExtra("id_siswa",id_siswa);
                mContext.startActivity(intent);
            }
        });
    }
    private void showPopupMenu(View view) {

        //inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.activity_delete, popup.getMenu());
        popup.setOnMenuItemClickListener(new SiswaYangMasukAdapter.MyMenuItemClickListener());
        popup.show();

    }

    //Click listener for popup menu item

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override

        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_delete:
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
                    alertDialogBuilder.setTitle("Peringatan");
                    alertDialogBuilder
                            .setMessage("Apakah Anda yakin ingin mengeluarkan "+namasiswa+" dari grup?")
                            .setCancelable(false)
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    ApiClient.services_get_keluar_grup.getKeluarGroup(id_grup).enqueue(new Callback<ModelDelete>() {
                                        @Override

                                        public void onResponse(Call<ModelDelete> call, Response<ModelDelete> response) {
                                            Log.e("Response Delete " , "Code : " + response.code());
                                            if(response.isSuccessful()){
                                                Toast.makeText(mContext, namasiswa+" Berhasil dikeluarkan", Toast.LENGTH_SHORT).show();
                                                removeItem(infoData);
                                            }else {
                                                Toast.makeText(mContext, ""+response.body().getResults(), Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<ModelDelete> call, Throwable t) {
                                            Toast.makeText(mContext, ""+t, Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                            }).setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    break;
                default:}
            return false;
        }
    }

    private void removeItem(Result infoData) {

        int currPosition = result.indexOf(infoData);
        result.remove(currPosition);
        notifyItemRemoved(currPosition);
    }


    @Override
    public int getItemCount() {

        return result.size();
    }

}