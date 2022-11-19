package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreHotPot implements Serializable {

        @SerializedName("idCHHotPot")
        @Expose
        private String idCHHotPot;
        @SerializedName("TenCHHotPot")
        @Expose
        private String tenCHHotPot;
        @SerializedName("HinhAnhCHHotPot")
        @Expose
        private String hinhAnhCHHotPot;
        @SerializedName("MoTaCHHotPot")
        @Expose
        private String moTaCHHotPot;
        @SerializedName("DanhGiaCHHotPot")
        @Expose
        private String danhGiaCHHotPot;
        @SerializedName("SoKMCHHotPot")
        @Expose
        private String soKMCHHotPot;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHHotPot() {
            return idCHHotPot;
        }

        public void setIdCHHotPot(String idCHHotPot) {
            this.idCHHotPot = idCHHotPot;
        }

        public String getTenCHHotPot() {
            return tenCHHotPot;
        }

        public void setTenCHHotPot(String tenCHHotPot) {
            this.tenCHHotPot = tenCHHotPot;
        }

        public String getHinhAnhCHHotPot() {
            return hinhAnhCHHotPot;
        }

        public void setHinhAnhCHHotPot(String hinhAnhCHHotPot) {
            this.hinhAnhCHHotPot = hinhAnhCHHotPot;
        }

        public String getMoTaCHHotPot() {
            return moTaCHHotPot;
        }

        public void setMoTaCHHotPot(String moTaCHHotPot) {
            this.moTaCHHotPot = moTaCHHotPot;
        }

        public String getDanhGiaCHHotPot() {
            return danhGiaCHHotPot;
        }

        public void setDanhGiaCHHotPot(String danhGiaCHHotPot) {
            this.danhGiaCHHotPot = danhGiaCHHotPot;
        }

        public String getSoKMCHHotPot() {
            return soKMCHHotPot;
        }

        public void setSoKMCHHotPot(String soKMCHHotPot) {
            this.soKMCHHotPot = soKMCHHotPot;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }