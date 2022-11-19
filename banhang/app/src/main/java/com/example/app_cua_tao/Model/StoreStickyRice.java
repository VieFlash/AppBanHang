package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreStickyRice implements Serializable {


        @SerializedName("idCHStickyRice")
        @Expose
        private String idCHStickyRice;
        @SerializedName("TenCHStickyRice")
        @Expose
        private String tenCHStickyRice;
        @SerializedName("HinhAnhCHStickyRice")
        @Expose
        private String hinhAnhCHStickyRice;
        @SerializedName("MoTaCHStickyRice")
        @Expose
        private String moTaCHStickyRice;
        @SerializedName("DanhGiaCHStickyRice")
        @Expose
        private String danhGiaCHStickyRice;
        @SerializedName("SoKMCHStickyRice")
        @Expose
        private String soKMCHStickyRice;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHStickyRice() {
            return idCHStickyRice;
        }

        public void setIdCHStickyRice(String idCHStickyRice) {
            this.idCHStickyRice = idCHStickyRice;
        }

        public String getTenCHStickyRice() {
            return tenCHStickyRice;
        }

        public void setTenCHStickyRice(String tenCHStickyRice) {
            this.tenCHStickyRice = tenCHStickyRice;
        }

        public String getHinhAnhCHStickyRice() {
            return hinhAnhCHStickyRice;
        }

        public void setHinhAnhCHStickyRice(String hinhAnhCHStickyRice) {
            this.hinhAnhCHStickyRice = hinhAnhCHStickyRice;
        }

        public String getMoTaCHStickyRice() {
            return moTaCHStickyRice;
        }

        public void setMoTaCHStickyRice(String moTaCHStickyRice) {
            this.moTaCHStickyRice = moTaCHStickyRice;
        }

        public String getDanhGiaCHStickyRice() {
            return danhGiaCHStickyRice;
        }

        public void setDanhGiaCHStickyRice(String danhGiaCHStickyRice) {
            this.danhGiaCHStickyRice = danhGiaCHStickyRice;
        }

        public String getSoKMCHStickyRice() {
            return soKMCHStickyRice;
        }

        public void setSoKMCHStickyRice(String soKMCHStickyRice) {
            this.soKMCHStickyRice = soKMCHStickyRice;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }