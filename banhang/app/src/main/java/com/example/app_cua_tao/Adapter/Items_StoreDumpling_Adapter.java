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
import com.example.app_cua_tao.Model.StoreDumpling;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreDumpling_Adapter extends RecyclerView.Adapter<Items_StoreDumpling_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreDumpling> storeDumplingArrayList;

    public Items_StoreDumpling_Adapter(Context context, ArrayList<StoreDumpling> storeDumplingArrayList) {
        this.context = context;
        this.storeDumplingArrayList = storeDumplingArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storedumpling, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreDumpling storeDumpling = storeDumplingArrayList.get(position);
        holder.txtTenStoreDumpling.setText(storeDumpling.getTenCHDumpling());
        holder.txtMoTaStoreDumpling.setText(storeDumpling.getMoTaCHDumpling());
        holder.txtKilometStoreDumpling.setText(storeDumpling.getSoKMCHDumpling() + "km");
        Picasso.with(context).load(storeDumpling.getHinhAnhCHDumpling()).into(holder.imgHinhStoreDumpling);
    }


    @Override
    public int getItemCount() {
        return storeDumplingArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreDumpling;
        TextView txtTenStoreDumpling, txtMoTaStoreDumpling, txtKilometStoreDumpling, txtDanhGiaStoreDumpling;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHinhStoreDumpling = itemView.findViewById(R.id.imageviewStoreDumpling);
            txtTenStoreDumpling = itemView.findViewById(R.id.txtTenStoreDumpling);
            txtMoTaStoreDumpling = itemView.findViewById(R.id.txtMoTaStoreDumpling);
            txtKilometStoreDumpling = itemView.findViewById(R.id.txtKilometStoreDumpling);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("dumpling", storeDumplingArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
