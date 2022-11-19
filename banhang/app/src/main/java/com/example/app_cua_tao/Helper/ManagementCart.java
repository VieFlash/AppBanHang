package com.example.app_cua_tao.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.app_cua_tao.ChangeNumberItemsListener;
import com.example.app_cua_tao.Model.ThucPham;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;
    ArrayList<ThucPham> thucPhamArrayList;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(ThucPham item){
        ArrayList<ThucPham> listFood = getListCast();
        boolean exitAlready = false;
        int n = 0;
        for(int i = 0; i < listFood.size(); i++) {
            if(listFood.get(i).getTenThucPham().equals(item.getTenThucPham())){
                exitAlready = true;
                n = i;
                break;
            }
        }

        if(exitAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }

        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ThucPham> getListCast() {
        return tinyDB.getListObject("CartList");
    }

    public void setListCast(ArrayList<ThucPham> thucPhamArrayList) {
        this.thucPhamArrayList = thucPhamArrayList;
    }

    public void minusNumberFood(ArrayList<ThucPham> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if(listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public void plusNumberFood(ArrayList<ThucPham> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ThucPham> listfood2 = getListCast();
        double fee = 0;
        for(int i = 0; i < listfood2.size(); i++) {
            fee += Integer.parseInt(listfood2.get(i).getGiaThucPham()) * listfood2.get(i).getNumberInCart();
        }

        return fee;
    }
}
