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

import com.example.app_cua_tao.Activity.ChiTiet_ThucPham_Activity;
import com.example.app_cua_tao.Model.ThucPham;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DanhSach_ThucPham_Adapter extends RecyclerView.Adapter<DanhSach_ThucPham_Adapter.ViewHolder>{

    Context context;
    ArrayList<ThucPham> thucPhamArrayList;

    public DanhSach_ThucPham_Adapter(Context context, ArrayList<ThucPham> thucPhamArrayList) {
        this.context = context;
        this.thucPhamArrayList = thucPhamArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachthucpham, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThucPham thucPham = thucPhamArrayList.get(position);
        holder.txtTenThucPham.setText(thucPham.getTenThucPham());
        holder.txtGiaTri.setText(numberCurrencyFormat(thucPham.getGiaThucPham()) + "đ");
        Picasso.with(context).load(thucPham.getHinhAnhThucPham()).into(holder.imgHinhAnhThucPham);
    }

    @Override
    public int getItemCount() {
        return thucPhamArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenThucPham, txtGiaTri;
        ImageView imgHinhAnhThucPham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenThucPham = itemView.findViewById(R.id.txtTenItem);
            txtGiaTri = itemView.findViewById(R.id.txtGiaTriItem);
            imgHinhAnhThucPham = itemView.findViewById(R.id.imgHinhAnhItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChiTiet_ThucPham_Activity.class);
                    intent.putExtra("thucpham", thucPhamArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }


    private static String numberCurrencyFormat(String number){
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(Integer.parseInt(number));
    }


}
