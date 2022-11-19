package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreRice implements Serializable {


        @SerializedName("idCHRice")
        @Expose
        private String idCHRice;
        @SerializedName("TenCHRice")
        @Expose
        private String tenCHRice;
        @SerializedName("HinhAnhCHRice")
        @Expose
        private String hinhAnhCHRice;
        @SerializedName("MoTaCHRice")
        @Expose
        private String moTaCHRice;
        @SerializedName("DanhGiaCHRice")
        @Expose
        private String danhGiaCHRice;
        @SerializedName("SoKMCHRice")
        @Expose
        private String soKMCHRice;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHRice() {
            return idCHRice;
        }

        public void setIdCHRice(String idCHRice) {
            this.idCHRice = idCHRice;
        }

        public String getTenCHRice() {
            return tenCHRice;
        }

        public void setTenCHRice(String tenCHRice) {
            this.tenCHRice = tenCHRice;
        }

        public String getHinhAnhCHRice() {
            return hinhAnhCHRice;
        }

        public void setHinhAnhCHRice(String hinhAnhCHRice) {
            this.hinhAnhCHRice = hinhAnhCHRice;
        }

        public String getMoTaCHRice() {
            return moTaCHRice;
        }

        public void setMoTaCHRice(String moTaCHRice) {
            this.moTaCHRice = moTaCHRice;
        }

        public String getDanhGiaCHRice() {
            return danhGiaCHRice;
        }

        public void setDanhGiaCHRice(String danhGiaCHRice) {
            this.danhGiaCHRice = danhGiaCHRice;
        }

        public String getSoKMCHRice() {
            return soKMCHRice;
        }

        public void setSoKMCHRice(String soKMCHRice) {
            this.soKMCHRice = soKMCHRice;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }