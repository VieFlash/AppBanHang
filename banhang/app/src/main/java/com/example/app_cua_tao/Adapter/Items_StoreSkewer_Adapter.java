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
import com.example.app_cua_tao.Model.StoreSkewer;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreSkewer_Adapter extends RecyclerView.Adapter<Items_StoreSkewer_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreSkewer> storeSkewerArrayList;


    public Items_StoreSkewer_Adapter(Context context, ArrayList<StoreSkewer> storeSkewerArrayList) {
        this.context = context;
        this.storeSkewerArrayList = storeSkewerArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storeskewer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreSkewer storeSkewer = storeSkewerArrayList.get(position);
        holder.txtTenStoreSkewer.setText(storeSkewer.getTenCHSkewer());
        holder.txtMoTaStoreSkewer.setText(storeSkewer.getMoTaCHSkewer());
        holder.txtKilometStoreSkewer.setText(storeSkewer.getSoKMCHSkewer() + "km");
        Picasso.with(context).load(storeSkewer.getHinhAnhCHSkewer()).into(holder.imgHinhStoreSkewer);
    }


    @Override
    public int getItemCount() {
        return storeSkewerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreSkewer;
        TextView txtTenStoreSkewer, txtMoTaStoreSkewer, txtKilometStoreSkewer, txtDanhGiaStoreSkewer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreSkewer = itemView.findViewById(R.id.imageviewStoreSkewer);
            txtTenStoreSkewer = itemView.findViewById(R.id.txtTenStoreSkewer);
            txtMoTaStoreSkewer = itemView.findViewById(R.id.txtMoTaStoreSkewer);
            txtKilometStoreSkewer = itemView.findViewById(R.id.txtKilometStoreSkewer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("skewer", storeSkewerArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
