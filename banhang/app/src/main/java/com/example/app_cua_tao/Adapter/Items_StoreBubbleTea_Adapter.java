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
import com.example.app_cua_tao.Model.StoreBubbleTea;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreBubbleTea_Adapter extends RecyclerView.Adapter<Items_StoreBubbleTea_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreBubbleTea> storeBubbleTeaArrayList;

    public Items_StoreBubbleTea_Adapter(Context context, ArrayList<StoreBubbleTea> storeBubbleTeaArrayList) {
        this.context = context;
        this.storeBubbleTeaArrayList = storeBubbleTeaArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storebubbletea, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreBubbleTea storeBubbleTea = storeBubbleTeaArrayList.get(position);
        holder.txtTenChuDeStoreBubbleTea.setText(storeBubbleTea.getTenCHBubbleTea());
        holder.txtMoTaStoreBubbleTea.setText(storeBubbleTea.getMoTaCHBubbleTea());
        holder.txtKilometStoreBubbleTea.setText(storeBubbleTea.getSoKMCHBubbleTea() + "km");
        Picasso.with(context).load(storeBubbleTea.getHinhAnhCHBubbleTea()).into(holder.imgHinhStoreBubbleTea);
    }

    @Override
    public int getItemCount() {
        return storeBubbleTeaArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinhStoreBubbleTea;
        TextView txtTenChuDeStoreBubbleTea, txtMoTaStoreBubbleTea, txtKilometStoreBubbleTea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreBubbleTea = itemView.findViewById(R.id.imageviewStoreBubbleTea);
            txtTenChuDeStoreBubbleTea = itemView.findViewById(R.id.txtTenChuDeStoreBubbleTea);
            txtMoTaStoreBubbleTea = itemView.findViewById(R.id.txtMoTaStoreBubbleTea);
            txtKilometStoreBubbleTea = itemView.findViewById(R.id.txtKilometStoreBubbleTea);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("bubbletea", storeBubbleTeaArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
