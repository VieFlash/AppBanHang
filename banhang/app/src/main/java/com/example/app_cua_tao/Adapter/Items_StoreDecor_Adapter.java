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
import com.example.app_cua_tao.Model.StoreDecor;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreDecor_Adapter extends RecyclerView.Adapter<Items_StoreDecor_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreDecor> storeDecorArrayList;

    public Items_StoreDecor_Adapter(Context context, ArrayList<StoreDecor> storeDecorArrayList) {
        this.context = context;
        this.storeDecorArrayList = storeDecorArrayList;
    }

    @NonNull
    @Override
    public Items_StoreDecor_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storedecor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Items_StoreDecor_Adapter.ViewHolder holder, int position) {
        StoreDecor storeDecor = storeDecorArrayList.get(position);
        holder.txtTenStoreDecor.setText(storeDecor.getTenCHDecor());
        holder.txtMoTaStoreDecor.setText(storeDecor.getMoTaCHDecor());
        holder.txtKilometStoreDecor.setText(storeDecor.getSoKMCHDecor() + "km");
        Picasso.with(context).load(storeDecor.getHinhAnhCHDecor()).into(holder.imgHinhStoreDecor);

    }

    @Override
    public int getItemCount() {
        return storeDecorArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView imgHinhStoreDecor;
        TextView txtTenStoreDecor, txtMoTaStoreDecor, txtKilometStoreDecor, txtDanhGiaStoreDecor;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imgHinhStoreDecor = itemView.findViewById(R.id.imageviewStoreDecor);
            txtTenStoreDecor = itemView.findViewById(R.id.txtTenStoreDecor);
            txtMoTaStoreDecor = itemView.findViewById(R.id.txtMoTaStoreDecor);
            txtKilometStoreDecor = itemView.findViewById(R.id.txtKilometStoreDecor);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("decor", storeDecorArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
