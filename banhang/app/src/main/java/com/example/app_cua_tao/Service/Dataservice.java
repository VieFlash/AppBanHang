package com.example.app_cua_tao.Service;

import com.example.app_cua_tao.Model.ChuDe;
import com.example.app_cua_tao.Model.QuangCao;
import com.example.app_cua_tao.Model.QuanhDayCoGi;
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
import com.example.app_cua_tao.Model.TheLoai;
import com.example.app_cua_tao.Model.ThucPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("foodbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("chudetrongngay.php")
    Call<List<ChuDe>> GetDataChuDeTrongNgay();

    @GET("theloaitrongngay.php")
    Call<List<TheLoai>> GetDataTheLoaiTrongNgay();

    @GET("quanhdaycogi.php")
    Call<List<QuanhDayCoGi>> GetDataQuanhDayCoGi();

    @GET("cuahangbubbletea.php")
    Call<List<StoreBubbleTea>> GetDataStoreBubbleTea();

    @GET("cuahangcream.php")
    Call<List<StoreCream>> GetDataStoreCream();

    @GET("cuahangdecor.php")
    Call<List<StoreDecor>> GetDataStoreDecor();

    @GET("cuahangdrinks.php")
    Call<List<StoreDrink>> GetDataStoreDrinks();

    @GET("cuahangdumpling.php")
    Call<List<StoreDumpling>> GetDataStoreDumpling();

    @GET("cuahanghotpot.php")
    Call<List<StoreHotPot>> GetDataStoreHotPot();

    @GET("cuahangmedicine.php")
    Call<List<StoreMedicine>> GetDataStoreMedicine();

    @GET("cuahangnoodles.php")
    Call<List<StoreNoodle>> GetDataStoreNoodles();

    @GET("cuahangpet.php")
    Call<List<StorePet>> GetDataStorePet();

    @GET("cuahangrice.php")
    Call<List<StoreRice>> GetDataStoreRice();

    @GET("cuahangskewer.php")
    Call<List<StoreSkewer>> GetDataStoreSkewer();

    @GET("cuahangstickyrice.php")
    Call<List<StoreStickyRice>> GetDataStoreStickyRice();

    @GET("thucpham.php")
    Call<List<ThucPham>> GetDataThucPham();

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetCuaHangTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangBubbleTea(@Field("idchbubbletea") String idchbubbletea);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangCream(@Field("idchcream") String idchcream);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangDecor(@Field("idchdecor") String idchdecor);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangDrink(@Field("idchdrink") String idchdrink);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangDumpling(@Field("idchdumpling") String idchdumpling);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangHotPot(@Field("idchhotpot") String idchhotpot);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangMedicine(@Field("idchmedicine") String idchmedicine);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangNoodles(@Field("idchnoodles") String idchnoodles);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangPet(@Field("idchpet") String idchpet);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangRice(@Field("idchrice") String idchrice);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangSkewer(@Field("idchskewer") String idchskewer);

    @FormUrlEncoded
    @POST("thucpham.php")
    Call<List<ThucPham>> GetDanhSachThucPhamTheoCuaHangStickyRice(@Field("idchstickyrice") String idchstickyrice);




}
