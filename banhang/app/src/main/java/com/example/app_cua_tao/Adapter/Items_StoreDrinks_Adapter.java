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
import com.example.app_cua_tao.Model.StoreDrink;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreDrinks_Adapter extends RecyclerView.Adapter<Items_StoreDrinks_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreDrink> storeDrinkArrayList;

    public Items_StoreDrinks_Adapter(Context context, ArrayList<StoreDrink> storeDrinkArrayList) {
        this.context = context;
        this.storeDrinkArrayList = storeDrinkArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storedrink, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Items_StoreDrinks_Adapter.ViewHolder holder, int position) {
        StoreDrink storeDrink = storeDrinkArrayList.get(position);
        holder.txtTenStoreDrinks.setText(storeDrink.getTenCHDrinks());
        holder.txtMoTaStoreDrinks.setText(storeDrink.getMoTaCHDrinks());
        holder.txtKilometStoreDrinks.setText(storeDrink.getSoKMCHDrinks() + "km");
        Picasso.with(context).load(storeDrink.getHinhAnhDrinks()).into(holder.imgHinhStoreDrinks);

    }

    @Override
    public int getItemCount() {
        return storeDrinkArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreDrinks;
        TextView txtTenStoreDrinks, txtMoTaStoreDrinks, txtKilometStoreDrinks, txtDanhGiaStoreDrinks;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreDrinks = itemView.findViewById(R.id.imageviewStoreDrinks);
            txtTenStoreDrinks = itemView.findViewById(R.id.txtTenStoreDrinks);
            txtMoTaStoreDrinks = itemView.findViewById(R.id.txtMoTaStoreDrinks);
            txtKilometStoreDrinks = itemView.findViewById(R.id.txtKilometStoreDrinks);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("drink", storeDrinkArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
