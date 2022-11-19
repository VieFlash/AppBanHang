package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreDrink implements Serializable {


        @SerializedName("idCHDrinks")
        @Expose
        private String idCHDrinks;
        @SerializedName("TenCHDrinks")
        @Expose
        private String tenCHDrinks;
        @SerializedName("HinhAnhDrinks")
        @Expose
        private String hinhAnhDrinks;
        @SerializedName("MoTaCHDrinks")
        @Expose
        private String moTaCHDrinks;
        @SerializedName("DanhGiaCHDrinks")
        @Expose
        private String danhGiaCHDrinks;
        @SerializedName("SoKMCHDrinks")
        @Expose
        private String soKMCHDrinks;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHDrinks() {
            return idCHDrinks;
        }

        public void setIdCHDrinks(String idCHDrinks) {
            this.idCHDrinks = idCHDrinks;
        }

        public String getTenCHDrinks() {
            return tenCHDrinks;
        }

        public void setTenCHDrinks(String tenCHDrinks) {
            this.tenCHDrinks = tenCHDrinks;
        }

        public String getHinhAnhDrinks() {
            return hinhAnhDrinks;
        }

        public void setHinhAnhDrinks(String hinhAnhDrinks) {
            this.hinhAnhDrinks = hinhAnhDrinks;
        }

        public String getMoTaCHDrinks() {
            return moTaCHDrinks;
        }

        public void setMoTaCHDrinks(String moTaCHDrinks) {
            this.moTaCHDrinks = moTaCHDrinks;
        }

        public String getDanhGiaCHDrinks() {
            return danhGiaCHDrinks;
        }

        public void setDanhGiaCHDrinks(String danhGiaCHDrinks) {
            this.danhGiaCHDrinks = danhGiaCHDrinks;
        }

        public String getSoKMCHDrinks() {
            return soKMCHDrinks;
        }

        public void setSoKMCHDrinks(String soKMCHDrinks) {
            this.soKMCHDrinks = soKMCHDrinks;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }