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
import com.example.app_cua_tao.Model.StoreMedicine;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Items_StoreMedicine_Adapter extends RecyclerView.Adapter<Items_StoreMedicine_Adapter.ViewHolder> {
    Context context;
    ArrayList<StoreMedicine> storeMedicineArrayList;


    public Items_StoreMedicine_Adapter(Context context, ArrayList<StoreMedicine> storeMedicineArrayList) {
        this.context = context;
        this.storeMedicineArrayList = storeMedicineArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_storemedicine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreMedicine storeMedicine = storeMedicineArrayList.get(position);
        holder.txtTenStoreMedicine.setText(storeMedicine.getTenCHMedicine());
        holder.txtMoTaStoreMedicine.setText(storeMedicine.getMoTaCHMedicine());
        holder.txtKilometStoreMedicine.setText(storeMedicine.getSoKMCHMedicine() + "km");
        Picasso.with(context).load(storeMedicine.getHinhAnhCHMedicine()).into(holder.imgHinhStoreMedicine);
    }


    @Override
    public int getItemCount() {
        return storeMedicineArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhStoreMedicine;
        TextView txtTenStoreMedicine, txtMoTaStoreMedicine, txtKilometStoreMedicine, txtDanhGiaStoreMedicine;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhStoreMedicine = itemView.findViewById(R.id.imageviewStoreMedicine);
            txtTenStoreMedicine = itemView.findViewById(R.id.txtTenStoreMedicine);
            txtMoTaStoreMedicine = itemView.findViewById(R.id.txtMoTaStoreMedicine);
            txtKilometStoreMedicine = itemView.findViewById(R.id.txtKilometStoreMedicine);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSach_ThucPham_Activity.class);
                    intent.putExtra("medicine", storeMedicineArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
