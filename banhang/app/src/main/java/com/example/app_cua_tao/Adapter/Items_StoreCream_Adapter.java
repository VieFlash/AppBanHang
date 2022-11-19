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
import com.example.app_cua_tao.Model.StoreCream;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreCream_Adapter extends RecyclerView.Adapter<Items_StoreCream_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreCream> storeCreamArrayList;

    public Items_StoreCream_Adapter(Context context, ArrayList<StoreCream> storeCreamArrayList) {
        this.context = context;
        this.storeCreamArrayList = storeCreamArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storecream, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreCream storeCream = storeCreamArrayList.get(position);
        holder.txtTenStoreCream.setText(storeCream.getTenCHCream());
        holder.txtMoTaStoreCream.setText(storeCream.getMoTaCHCream());
        holder.txtKilometStoreCream.setText(storeCream.getSoKMCHCream() + "km");
        Picasso.with(context).load(storeCream.getHinhAnhCHCream()).into(holder.imgHinhStoreCream);

    }

    @Override
    public int getItemCount() {
        return storeCreamArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinhStoreCream;
        TextView txtTenStoreCream, txtMoTaStoreCream, txtKilometStoreCream, txtDanhGiaStoreCream;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreCream = itemView.findViewById(R.id.imageviewStoreCream);
            txtTenStoreCream = itemView.findViewById(R.id.txtTenStoreCream);
            txtMoTaStoreCream = itemView.findViewById(R.id.txtMoTaStoreCream);
            txtKilometStoreCream = itemView.findViewById(R.id.txtKilometStoreCream);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("cream", storeCreamArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }

}
