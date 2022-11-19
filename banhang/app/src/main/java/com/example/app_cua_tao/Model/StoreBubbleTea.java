package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreBubbleTea implements Serializable {

    @SerializedName("idCHBubbleTea")
    @Expose
    private String idCHBubbleTea;
    @SerializedName("TenCHBubbleTea")
    @Expose
    private String tenCHBubbleTea;
    @SerializedName("HinhAnhCHBubbleTea")
    @Expose
    private String hinhAnhCHBubbleTea;
    @SerializedName("MoTaCHBubbleTea")
    @Expose
    private String moTaCHBubbleTea;
    @SerializedName("DanhGiaCHBubbleTea")
    @Expose
    private String danhGiaCHBubbleTea;
    @SerializedName("SoKMCHBubbleTea")
    @Expose
    private String soKMCHBubbleTea;
    @SerializedName("SoNgayMo")
    @Expose
    private String soNgayMo;

    public String getIdCHBubbleTea() {
        return idCHBubbleTea;
    }

    public void setIdCHBubbleTea(String idCHBubbleTea) {
        this.idCHBubbleTea = idCHBubbleTea;
    }

    public String getTenCHBubbleTea() {
        return tenCHBubbleTea;
    }

    public void setTenCHBubbleTea(String tenCHBubbleTea) {
        this.tenCHBubbleTea = tenCHBubbleTea;
    }

    public String getHinhAnhCHBubbleTea() {
        return hinhAnhCHBubbleTea;
    }

    public void setHinhAnhCHBubbleTea(String hinhAnhCHBubbleTea) {
        this.hinhAnhCHBubbleTea = hinhAnhCHBubbleTea;
    }

    public String getMoTaCHBubbleTea() {
        return moTaCHBubbleTea;
    }

    public void setMoTaCHBubbleTea(String moTaCHBubbleTea) {
        this.moTaCHBubbleTea = moTaCHBubbleTea;
    }

    public String getDanhGiaCHBubbleTea() {
        return danhGiaCHBubbleTea;
    }

    public void setDanhGiaCHBubbleTea(String danhGiaCHBubbleTea) {
        this.danhGiaCHBubbleTea = danhGiaCHBubbleTea;
    }

    public String getSoKMCHBubbleTea() {
        return soKMCHBubbleTea;
    }

    public void setSoKMCHBubbleTea(String soKMCHBubbleTea) {
        this.soKMCHBubbleTea = soKMCHBubbleTea;
    }

    public String getSoNgayMo() {
        return soNgayMo;
    }

    public void setSoNgayMo(String soNgayMo) {
        this.soNgayMo = soNgayMo;
    }

}