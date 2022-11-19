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
import com.example.app_cua_tao.Model.StoreNoodle;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreNoodles_Adapter extends RecyclerView.Adapter<Items_StoreNoodles_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreNoodle> storeNoodleArrayList;


    public Items_StoreNoodles_Adapter(Context context, ArrayList<StoreNoodle> storeNoodleArrayList) {
        this.context = context;
        this.storeNoodleArrayList = storeNoodleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storenoodles, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreNoodle storeNoodle = storeNoodleArrayList.get(position);
        holder.txtTenStoreNoodles.setText(storeNoodle.getTenCHNoodles());
        holder.txtMoTaStoreNoodles.setText(storeNoodle.getMoTaCHNoodles());
        holder.txtKilometStoreNoodles.setText(storeNoodle.getSoKMCHNoodles() + "km");
        Picasso.with(context).load(storeNoodle.getHinhAnhCHNoodles()).into(holder.imgHinhStoreNoodles);
    }


    @Override
    public int getItemCount() {
        return storeNoodleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreNoodles;
        TextView txtTenStoreNoodles, txtMoTaStoreNoodles, txtKilometStoreNoodles, txtDanhGiaStoreNoodles;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreNoodles = itemView.findViewById(R.id.imageviewStoreNoodles);
            txtTenStoreNoodles = itemView.findViewById(R.id.txtTenStoreNoodles);
            txtMoTaStoreNoodles = itemView.findViewById(R.id.txtMoTaStoreNoodles);
            txtKilometStoreNoodles = itemView.findViewById(R.id.txtKilometStoreNoodles);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("noodles", storeNoodleArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
