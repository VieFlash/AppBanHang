package com.example.app_cua_tao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cua_tao.Helper.ManagementCart;
import com.example.app_cua_tao.Model.ThucPham;
import com.example.app_cua_tao.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class ChiTiet_ThucPham_Activity extends AppCompatActivity {

    private TextView txtTenThucPham, txtGiaTriThucPham, txtSoLuong, txtGiaTriThucPhamTangDan;
    private ImageButton btnMinus, btnPlus, btnClose;
    private ImageView imgHinhAnhThucPham;
    private ThucPham thucPham;
    private RelativeLayout btnAddToCart;
    private int soluong = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thuc_pham);
        managementCart = new ManagementCart(this);
        DataIntent();
        AnhXa();
        buttonF();
        if(thucPham != null && !thucPham.getTenThucPham().equals("")){
            setValuesInView(thucPham.getTenThucPham(), thucPham.getGiaThucPham(), thucPham.getHinhAnhThucPham(), soluong);
            GetDataChiTiet();
        }
    }



    private void buttonF() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong+=1;
                if (soluong > 0){
                    btnMinus.setVisibility(View.VISIBLE);
                }
                if (soluong == 15){
                    btnPlus.setVisibility(View.INVISIBLE);
                }
                txtSoLuong.setText(String.valueOf(soluong));
                txtGiaTriThucPhamTangDan.setText(numberCurrencyFormat(String.valueOf(soluong * Integer.parseInt(thucPham.getGiaThucPham()))) + "đ");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soluong-=1;
                if (soluong == 0){
                    btnMinus.setVisibility(View.INVISIBLE);
                }
                btnPlus.setVisibility(View.VISIBLE);
                txtSoLuong.setText(String.valueOf(soluong));
                txtGiaTriThucPhamTangDan.setText(numberCurrencyFormat(String.valueOf(soluong * Integer.parseInt(thucPham.getGiaThucPham()))) + "đ");

            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thucPham.setNumberInCart(soluong);
                managementCart.insertFood(thucPham);
                finish();
            }
        });
    }

    private void GetDataChiTiet() {
    }

    private void setValuesInView(String ten, String gia, String hinhanh, int soluong) {
        txtTenThucPham.setText(ten);
        txtGiaTriThucPham.setText(numberCurrencyFormat(gia) + "đ");
        Picasso.with(this).load(hinhanh).into(imgHinhAnhThucPham);
        txtGiaTriThucPhamTangDan.setText(numberCurrencyFormat(String.valueOf(soluong * Integer.parseInt(gia))) + "đ");
        txtSoLuong.setText(String.valueOf(soluong));
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("thucpham")){
                thucPham = (ThucPham) intent.getSerializableExtra("thucpham");
            }
        }
    }


    private void AnhXa() {
        txtTenThucPham = findViewById(R.id.txtTenChiTietItem);
        txtGiaTriThucPham = findViewById(R.id.txtGiaTriChiTietItem);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        txtGiaTriThucPhamTangDan = findViewById(R.id.txtGiaTriItemTangDan);
        btnClose = findViewById(R.id.btnClose);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        imgHinhAnhThucPham = findViewById(R.id.imgHinhAnhItemChiTiet);
        btnAddToCart = findViewById(R.id.btnAddToCart);
    }
    private static String numberCurrencyFormat(String number){
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(Integer.parseInt(number));
    }
}