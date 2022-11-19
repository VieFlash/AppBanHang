package com.example.app_cua_tao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.ChangeNumberItemsListener;
import com.example.app_cua_tao.Helper.ManagementCart;
import com.example.app_cua_tao.Model.ThucPham;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {
    ArrayList<ThucPham> thucPhamArrayList;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;


    public GioHangAdapter(ArrayList<ThucPham> thucPhamArrayList, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.thucPhamArrayList = thucPhamArrayList;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_gio_hang, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThucPham thucPham = thucPhamArrayList.get(position);
        holder.txtTenThucPham.setText(thucPham.getTenThucPham());
        holder.txtFeeEachItem.setText(numberCurrencyFormat(thucPham.getGiaThucPham()) + "đ");
        holder.txtSoLuong.setText(String.valueOf(thucPhamArrayList.get(position).getNumberInCart()));
        holder.txtTotaEachlItem.setText(numberCurrencyFormat(String.valueOf((thucPhamArrayList.get(position).getNumberInCart()) * Integer.parseInt(thucPham.getGiaThucPham()))) + "đ");

        Picasso.with(holder.itemView.getContext()).load(thucPham.getHinhAnhThucPham()).into(holder.imgHinhAnh);

        holder.btnPlus.setOnClickListener(view -> managementCart.plusNumberFood(thucPhamArrayList, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.btnMinus.setOnClickListener(view -> managementCart.minusNumberFood(thucPhamArrayList, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }


    @Override
    public int getItemCount() {
        return thucPhamArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenThucPham, txtFeeEachItem, txtTotaEachlItem;
        ImageButton btnMinus, btnPlus;
        TextView txtSoLuong;
        ImageView imgHinhAnh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenThucPham = itemView.findViewById(R.id.txttitle);
            txtFeeEachItem = itemView.findViewById(R.id.feeEachItem);
            txtTotaEachlItem = itemView.findViewById(R.id.totalEachItem);
            btnMinus = itemView.findViewById(R.id.btnMinusCart);
            btnPlus = itemView.findViewById(R.id.btnPlusCart);
            imgHinhAnh = itemView.findViewById(R.id.pic);
            txtSoLuong = itemView.findViewById(R.id.txtSoLuong);
        }
    }

    private static String numberCurrencyFormat(String number){
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(Integer.parseInt(number));
    }
}
