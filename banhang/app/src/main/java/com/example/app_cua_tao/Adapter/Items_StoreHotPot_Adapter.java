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
import com.example.app_cua_tao.Model.StoreHotPot;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreHotPot_Adapter extends RecyclerView.Adapter<Items_StoreHotPot_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreHotPot> storeHotPotArrayList;


    public Items_StoreHotPot_Adapter(Context context, ArrayList<StoreHotPot> storeHotPotArrayList) {
        this.context = context;
        this.storeHotPotArrayList = storeHotPotArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storehotpot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreHotPot storeHotPot = storeHotPotArrayList.get(position);
        holder.txtTenStoreHotPot.setText(storeHotPot.getTenCHHotPot());
        holder.txtMoTaStoreHotPot.setText(storeHotPot.getMoTaCHHotPot());
        holder.txtKilometStoreHotPot.setText(storeHotPot.getSoKMCHHotPot() + "km");
        Picasso.with(context).load(storeHotPot.getHinhAnhCHHotPot()).into(holder.imgHinhStoreHotPot);
    }

    @Override
    public int getItemCount() {
        return storeHotPotArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreHotPot;
        TextView txtTenStoreHotPot, txtMoTaStoreHotPot, txtKilometStoreHotPot, txtDanhGiaStoreHotPot;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreHotPot = itemView.findViewById(R.id.imageviewStoreHotpot);
            txtTenStoreHotPot = itemView.findViewById(R.id.txtTenStoreHotpot);
            txtMoTaStoreHotPot = itemView.findViewById(R.id.txtMoTaStoreHotpot);
            txtKilometStoreHotPot = itemView.findViewById(R.id.txtKilometStoreHotpot);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("hotpot", storeHotPotArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
