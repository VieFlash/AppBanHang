package com.example.app_cua_tao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Adapter.GioHangAdapter;
import com.example.app_cua_tao.ChangeNumberItemsListener;
import com.example.app_cua_tao.Helper.ManagementCart;
import com.example.app_cua_tao.Model.ThucPham;
import com.example.app_cua_tao.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.NumberFormat;
import java.util.Locale;

public class DonHang_Activity extends AppCompatActivity {

    ThucPham thucPham;
    TextView txtTotalFee, txtDelivery, txtTotal, txtEmpty;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ScrollView scrollView;
    private ManagementCart managementCart;
    LinearLayout comboan1;
    ConstraintLayout comboan2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_donhang);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menu_donhang:
                        return true;
                }
                return false;
            }
        });

        managementCart = new ManagementCart(this);
        DataIntent();
        AnhXa();
        initList();
        calculateCard();
        comboan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new GioHangAdapter(managementCart.getListCast(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerView.setAdapter(adapter);

        if(managementCart.getListCast().isEmpty()) {
            txtEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            comboan1.setVisibility(View.GONE);
            comboan2.setVisibility(View.GONE);
        } else {
            txtEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            comboan1.setVisibility(View.VISIBLE);
            comboan2.setVisibility(View.VISIBLE);
        }
    }
    private void AnhXa() {
        txtTotalFee = findViewById(R.id.txtToTalFee);
        txtDelivery = findViewById(R.id.txtDelivery);
        txtTotal = findViewById(R.id.txtToTal);
        recyclerView = findViewById(R.id.viewGioHang);
        txtEmpty = findViewById(R.id.txtEmpty);
        scrollView = findViewById(R.id.scrollview);
        comboan1 = findViewById(R.id.comboan1);
        comboan2 = findViewById(R.id.comboan2);
    }

    private void calculateCard() {
        int delivery = 30000;
        long total = Math.round((managementCart.getTotalFee() + delivery) * 100) / 100;
        long itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;
        txtTotalFee.setText(numberCurrencyFormat1(String.valueOf(itemTotal)) + "đ");
        txtDelivery.setText(numberCurrencyFormat1(String.valueOf(delivery)) + "đ");
        txtTotal.setText(numberCurrencyFormat1(String.valueOf(total)) + "đ");
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("donhang")){
                thucPham = (ThucPham) intent.getSerializableExtra("donhang");
            }
        }
    }


    private static String numberCurrencyFormat1(String number){
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(Integer.parseInt(number));
    }
}