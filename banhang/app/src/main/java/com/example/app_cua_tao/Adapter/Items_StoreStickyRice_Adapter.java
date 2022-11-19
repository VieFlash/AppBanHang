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
import com.example.app_cua_tao.Model.StoreStickyRice;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreStickyRice_Adapter extends RecyclerView.Adapter<Items_StoreStickyRice_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreStickyRice> storeStickyRiceArrayList;


    public Items_StoreStickyRice_Adapter(Context context, ArrayList<StoreStickyRice> storeStickyRiceArrayList) {
        this.context = context;
        this.storeStickyRiceArrayList = storeStickyRiceArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storestickyrice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreStickyRice storeStickyRice = storeStickyRiceArrayList.get(position);
        holder.txtTenStoreStickyRice.setText(storeStickyRice.getTenCHStickyRice());
        holder.txtMoTaStoreStickyRice.setText(storeStickyRice.getMoTaCHStickyRice());
        holder.txtKilometStoreStickyRice.setText(storeStickyRice.getSoKMCHStickyRice() + "km");
        Picasso.with(context).load(storeStickyRice.getHinhAnhCHStickyRice()).into(holder.imgHinhStoreStickyRice);
    }


    @Override
    public int getItemCount() {
        return storeStickyRiceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreStickyRice;
        TextView txtTenStoreStickyRice, txtMoTaStoreStickyRice, txtKilometStoreStickyRice, txtDanhGiaStoreStickyRice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreStickyRice = itemView.findViewById(R.id.imageviewStoreStickyRice);
            txtTenStoreStickyRice = itemView.findViewById(R.id.txtTenStoreStickyRice);
            txtMoTaStoreStickyRice = itemView.findViewById(R.id.txtMoTaStoreStickyRice);
            txtKilometStoreStickyRice = itemView.findViewById(R.id.txtKilometStoreStickyRice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("stickyrice", storeStickyRiceArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
