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
import com.example.app_cua_tao.Model.StoreRice;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreRice_Adapter extends RecyclerView.Adapter<Items_StoreRice_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreRice> storeRiceArrayList;


    public Items_StoreRice_Adapter(Context context, ArrayList<StoreRice> storeRiceArrayList) {
        this.context = context;
        this.storeRiceArrayList = storeRiceArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storerice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreRice storeRice = storeRiceArrayList.get(position);
        holder.txtTenStoreRice.setText(storeRice.getTenCHRice());
        holder.txtMoTaStoreRice.setText(storeRice.getMoTaCHRice());
        holder.txtKilometStoreRice.setText(storeRice.getSoKMCHRice() + "km");
        Picasso.with(context).load(storeRice.getHinhAnhCHRice()).into(holder.imgHinhStoreRice);
    }


    @Override
    public int getItemCount() {
        return storeRiceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreRice;
        TextView txtTenStoreRice, txtMoTaStoreRice, txtKilometStoreRice, txtDanhGiaStoreRice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreRice = itemView.findViewById(R.id.imageviewStoreRice);
            txtTenStoreRice = itemView.findViewById(R.id.txtTenStoreRice);
            txtMoTaStoreRice = itemView.findViewById(R.id.txtMoTaStoreRice);
            txtKilometStoreRice = itemView.findViewById(R.id.txtKilometStoreRice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("rice", storeRiceArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
