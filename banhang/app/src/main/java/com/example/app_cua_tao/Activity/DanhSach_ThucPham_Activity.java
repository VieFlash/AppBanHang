package com.example.app_cua_tao.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Adapter.DanhSach_ThucPham_Adapter;
import com.example.app_cua_tao.Model.QuangCao;
import com.example.app_cua_tao.Model.StoreBubbleTea;
import com.example.app_cua_tao.Model.StoreCream;
import com.example.app_cua_tao.Model.StoreDecor;
import com.example.app_cua_tao.Model.StoreDrink;
import com.example.app_cua_tao.Model.StoreDumpling;
import com.example.app_cua_tao.Model.StoreHotPot;
import com.example.app_cua_tao.Model.StoreMedicine;
import com.example.app_cua_tao.Model.StoreNoodle;
import com.example.app_cua_tao.Model.StorePet;
import com.example.app_cua_tao.Model.StoreRice;
import com.example.app_cua_tao.Model.StoreSkewer;
import com.example.app_cua_tao.Model.StoreStickyRice;
import com.example.app_cua_tao.Model.ThucPham;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSach_ThucPham_Activity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerViewDanhSachBubbleTea;
    Toolbar toolbar;
    ImageButton btnBack;
    ArrayList<ThucPham> mangThucPham;
    TextView txtTenStore, txtKilomet, txtTime, txtStar;
    ImageView imgHinhAnhItemcc;
    DanhSach_ThucPham_Adapter danhSachThucPham_adapter;
    Context context;
    QuangCao quangCao;
    StoreBubbleTea storeBubbleTea;
    StoreCream storeCream;
    StoreDecor storeDecor;
    StoreDrink storeDrink;
    StoreDumpling storeDumpling;
    StoreHotPot storeHotPot;
    StoreMedicine storeMedicine;
    StoreNoodle storeNoodle;
    StorePet storePet;
    StoreRice storeRice;
    StoreSkewer storeSkewer;
    StoreStickyRice storeStickyRice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_thucpham);
        DataIntent();
        anhxa();
        init();
        if(quangCao != null && !quangCao.getTenCHBubbleTea().equals("")){
            setValuesInView(quangCao.getTenCHBubbleTea(), quangCao.getSoKMCHBubbleTea(),
                    quangCao.getSoNgayMo(), quangCao.getDanhGiaCHBubbleTea(), quangCao.getHinhAnhCHBubbleTea());
            GetDataQuangCao(quangCao.getIdQuangCao());
        }
        if(storeBubbleTea != null && !storeBubbleTea.getTenCHBubbleTea().equals("")){
            setValuesInView(storeBubbleTea.getTenCHBubbleTea(), storeBubbleTea.getSoKMCHBubbleTea(),
                    storeBubbleTea.getSoNgayMo(), storeBubbleTea.getDanhGiaCHBubbleTea(), storeBubbleTea.getHinhAnhCHBubbleTea());
            GetDataCuaHangBubbleTea(storeBubbleTea.getIdCHBubbleTea());
        }
        if(storeCream != null && !storeCream.getTenCHCream().equals("")){
            setValuesInView(storeCream.getTenCHCream(), storeCream.getSoKMCHCream(),
                    storeCream.getSoNgayMo(), storeCream.getDanhGiaCHCream(), storeCream.getHinhAnhCHCream());
            GetDataCuaHangCream(storeCream.getIdCHCream());
        }
        if(storeDecor != null && !storeDecor.getTenCHDecor().equals("")){
            setValuesInView(storeDecor.getTenCHDecor(), storeDecor.getSoKMCHDecor(),
                    storeDecor.getSoNgayMo(), storeDecor.getDanhGiaCHDecor(), storeDecor.getHinhAnhCHDecor());
            GetDataCuaHangDecor(storeDecor.getIdCHDecor());
        }
        if(storeDrink != null && !storeDrink.getTenCHDrinks().equals("")){
            setValuesInView(storeDrink.getTenCHDrinks(), storeDrink.getSoKMCHDrinks(),
                    storeDrink.getSoNgayMo(), storeDrink.getDanhGiaCHDrinks(), storeDrink.getHinhAnhDrinks());
            GetDataCuaHangDrink(storeDrink.getIdCHDrinks());
        }
        if(storeDumpling != null && !storeDumpling.getTenCHDumpling().equals("")){
            setValuesInView(storeDumpling.getTenCHDumpling(), storeDumpling.getSoKMCHDumpling(),
                    storeDumpling.getSoNgayMo(), storeDumpling.getDanhGiaCHDumpling(), storeDumpling.getHinhAnhCHDumpling());
            GetDataCuaHangDumpling(storeDumpling.getIdCHDumpling());
        }
        if(storeHotPot != null && !storeHotPot.getTenCHHotPot().equals("")){
            setValuesInView(storeHotPot.getTenCHHotPot(), storeHotPot.getSoKMCHHotPot(),
                    storeHotPot.getSoNgayMo(), storeHotPot.getDanhGiaCHHotPot(), storeHotPot.getHinhAnhCHHotPot());
            GetDataCuaHangHotPot(storeHotPot.getIdCHHotPot());
        }
        if(storeMedicine != null && !storeMedicine.getTenCHMedicine().equals("")){
            setValuesInView(storeMedicine.getTenCHMedicine(), storeMedicine.getSoKMCHMedicine(),
                    storeMedicine.getSoNgayMo(), storeMedicine.getDanhGiaCHMedicine(), storeMedicine.getHinhAnhCHMedicine());
            GetDataCuaHangMedicine(storeMedicine.getIdCHMedicine());
        }
        if(storeNoodle != null && !storeNoodle.getTenCHNoodles().equals("")){
            setValuesInView(storeNoodle.getTenCHNoodles(), storeNoodle.getSoKMCHNoodles(),
                    storeNoodle.getSoNgayMo(), storeNoodle.getDanhGiaCHNoodles(), storeNoodle.getHinhAnhCHNoodles());
            GetDataCuaHangNoodle(storeNoodle.getIdCHNoodles());
        }
        if(storePet != null && !storePet.getTenCHPet().equals("")){
            setValuesInView(storePet.getTenCHPet(), storePet.getSoKMCHPet(),
                    storePet.getSoNgayMo(), storePet.getDanhGiaCHPet(), storePet.getHinhAnhCHPet());
            GetDataCuaHangPet(storePet.getIdCHPet());
        }
        if(storeRice != null && !storeRice.getTenCHRice().equals("")){
            setValuesInView(storeRice.getTenCHRice(), storeRice.getSoKMCHRice(),
                    storeRice.getSoNgayMo(), storeRice.getDanhGiaCHRice(), storeRice.getHinhAnhCHRice());
            GetDataCuaHangRice(storeRice.getIdCHRice());
        }
        if(storeSkewer != null && !storeSkewer.getTenCHSkewer().equals("")){
            setValuesInView(storeSkewer.getTenCHSkewer(), storeSkewer.getSoKMCHSkewer(),
                    storeSkewer.getSoNgayMo(), storeSkewer.getDanhGiaCHSkewer(), storeSkewer.getHinhAnhCHSkewer());
            GetDataCuaHangSkewer(storeSkewer.getIdCHSkewer());
        }
        if(storeStickyRice != null && !storeStickyRice.getTenCHStickyRice().equals("")){
            setValuesInView(storeStickyRice.getTenCHStickyRice(), storeStickyRice.getSoKMCHStickyRice(),
                    storeStickyRice.getSoNgayMo(), storeStickyRice.getDanhGiaCHStickyRice(), storeStickyRice.getHinhAnhCHStickyRice());
            GetDataCuaHangStickyRice(storeStickyRice.getIdCHStickyRice());
        }
    }

    private void GetDataCuaHangStickyRice(String idchstickyrice) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangStickyRice(idchstickyrice);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangSkewer(String idchskewer) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangSkewer(idchskewer);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangRice(String idchrice) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangRice(idchrice);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangPet(String idchpet) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangPet(idchpet);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangNoodle(String idchnoodles) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangNoodles(idchnoodles);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangMedicine(String idchmedicine) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangMedicine(idchmedicine);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangHotPot(String idchhotpot) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangHotPot(idchhotpot);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangDumpling(String idchdumpling) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangDumpling(idchdumpling);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }
            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangDrink(String idchdrink) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangDrink(idchdrink);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangDecor(String idchdecor) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangDecor(idchdecor);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangCream(String idchcream) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangCream(idchcream);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataCuaHangBubbleTea(String idchbubbletea) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetDanhSachThucPhamTheoCuaHangBubbleTea(idchbubbletea);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void GetDataQuangCao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<ThucPham>> callback = dataservice.GetCuaHangTheoQuangCao(idquangcao);
        callback.enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                mangThucPham = (ArrayList<ThucPham>) response.body();
                danhSachThucPham_adapter = new DanhSach_ThucPham_Adapter(DanhSach_ThucPham_Activity.this, mangThucPham);
                recyclerViewDanhSachBubbleTea.setLayoutManager(new LinearLayoutManager(DanhSach_ThucPham_Activity.this));
                recyclerViewDanhSachBubbleTea.setAdapter(danhSachThucPham_adapter);
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {

            }
        });
    }

    private void setValuesInView(String ten,String kilomet, String time, String star, String hinhanh) {
        txtTenStore.setText(ten);
        txtKilomet.setText(kilomet + " km");
        txtTime.setText(time + " days");
        txtStar.setText(star);
        try {
            URL url = new URL(hinhanh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void init(){
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void anhxa(){
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbarhh);
        recyclerViewDanhSachBubbleTea = findViewById(R.id.recyclerviewDanhSachBubbleTea);
        txtTenStore = findViewById(R.id.txtTenStoreBubbleTea);
        txtKilomet = findViewById(R.id.txtKilomet);
        txtTime = findViewById(R.id.txtTime);
        txtStar =findViewById(R.id.txtStar);
        imgHinhAnhItemcc = findViewById(R.id.imgHinhAnhItemcc);
    }
    private void DataIntent(){
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
            }
            if(intent.hasExtra("bubbletea")){
                storeBubbleTea = (StoreBubbleTea) intent.getSerializableExtra("bubbletea");
            }
            if(intent.hasExtra("cream")){
                storeCream = (StoreCream) intent.getSerializableExtra("cream");
            }
            if (intent.hasExtra("decor")){
                storeDecor = (StoreDecor) intent.getSerializableExtra("decor");
            }
            if(intent.hasExtra("drink")){
                storeDrink = (StoreDrink) intent.getSerializableExtra("drink");
            }
            if(intent.hasExtra("dumpling")){
                storeDumpling = (StoreDumpling) intent.getSerializableExtra("dumpling");
            }
            if(intent.hasExtra("hotpot")){
                storeHotPot = (StoreHotPot) intent.getSerializableExtra("hotpot");
            }
            if(intent.hasExtra("medicine")){
                storeMedicine = (StoreMedicine) intent.getSerializableExtra("medicine");
            }
            if(intent.hasExtra("noodles")){
                storeNoodle = (StoreNoodle) intent.getSerializableExtra("noodles");
            }
            if(intent.hasExtra("pet")){
                storePet = (StorePet) intent.getSerializableExtra("pet");
            }
            if(intent.hasExtra("rice")){
                storeRice = (StoreRice) intent.getSerializableExtra("rice");
            }
            if(intent.hasExtra("skewer")){
                storeSkewer = (StoreSkewer) intent.getSerializableExtra("skewer");
            }
            if(intent.hasExtra("stickyrice")){
                storeStickyRice = (StoreStickyRice) intent.getSerializableExtra("stickyrice");
            }

        }
    }
}