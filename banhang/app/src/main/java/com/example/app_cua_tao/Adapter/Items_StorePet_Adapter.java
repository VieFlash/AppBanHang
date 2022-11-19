package com.example.app_cua_tao.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Activity.DanhSach_ThucPham_Activity;
import com.example.app_cua_tao.Model.StorePet;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StorePet_Adapter extends RecyclerView.Adapter<Items_StorePet_Adapter.ViewHolder> {
    Context context;
    ArrayList<StorePet> storePetArrayList;


    public Items_StorePet_Adapter(Context context, ArrayList<StorePet> storePetArrayList) {
        this.context = context;
        this.storePetArrayList = storePetArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storepet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StorePet storePet = storePetArrayList.get(position);
        holder.txtTenStorePet.setText(storePet.getTenCHPet());
        holder.txtMoTaStorePet.setText(storePet.getMoTaCHPet());
        holder.txtKilometStorePet.setText(storePet.getSoKMCHPet() + "km");
        Picasso.with(context).load(storePet.getHinhAnhCHPet()).into(holder.imgHinhStorePet);
    }


    @Override
    public int getItemCount() {
        return storePetArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStorePet;
        TextView txtTenStorePet, txtMoTaStorePet, txtKilometStorePet, txtDanhGiaStorePet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStorePet = itemView.findViewById(R.id.imageviewStorePet);
            txtTenStorePet = itemView.findViewById(R.id.txtTenStorePet);
            txtMoTaStorePet = itemView.findViewById(R.id.txtMoTaStorePet);
            txtKilometStorePet = itemView.findViewById(R.id.txtKilometStorePet);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("pet", storePetArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
