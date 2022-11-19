package com.example.app_cua_tao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Model.QuanhDayCoGi;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuanhDayCoGiAdapter extends RecyclerView.Adapter<QuanhDayCoGiAdapter.ViewHolder>{
    Context context;
    ArrayList<QuanhDayCoGi> quanhDayCoGiArrayList;

    public QuanhDayCoGiAdapter(Context context, ArrayList<QuanhDayCoGi> quanhDayCoGiArrayList) {
        this.context = context;
        this.quanhDayCoGiArrayList = quanhDayCoGiArrayList;
    }

    @NonNull
    @Override
    public QuanhDayCoGiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_quanhdaycogi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuanhDayCoGiAdapter.ViewHolder holder, int position) {
        QuanhDayCoGi quanhDayCoGi = quanhDayCoGiArrayList.get(position);
        holder.txtTenHinhQuanhDayCoGi.setText(quanhDayCoGi.getTenCHBubbleTea());
        holder.txtMoTaHinhQuanhDayCoGi.setText(quanhDayCoGi.getMoTaCHBubbleTea());
        Picasso.with(context).load(quanhDayCoGi.getHinhAnhCHBubbleTea()).into(holder.imgHinhQuanhDayCoGi);
    }

    @Override
    public int getItemCount() {
        return quanhDayCoGiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhQuanhDayCoGi;
        TextView txtTenHinhQuanhDayCoGi, txtMoTaHinhQuanhDayCoGi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhQuanhDayCoGi = itemView.findViewById(R.id.imageviewQuanhDayCoGi);
            txtTenHinhQuanhDayCoGi = itemView.findViewById(R.id.txtTenQuanhDayCoGi);
            txtMoTaHinhQuanhDayCoGi = itemView.findViewById(R.id.txtMoTaQuanhDayCoGi);
        }
    }
}
