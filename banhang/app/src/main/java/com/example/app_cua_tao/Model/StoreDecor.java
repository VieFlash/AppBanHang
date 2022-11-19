package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class StoreDecor implements Serializable {

        @SerializedName("idCHDecor")
        @Expose
        private String idCHDecor;
        @SerializedName("TenCHDecor")
        @Expose
        private String tenCHDecor;
        @SerializedName("HinhAnhCHDecor")
        @Expose
        private String hinhAnhCHDecor;
        @SerializedName("MoTaCHDecor")
        @Expose
        private String moTaCHDecor;
        @SerializedName("DanhGiaCHDecor")
        @Expose
        private String danhGiaCHDecor;
        @SerializedName("SoKMCHDecor")
        @Expose
        private String soKMCHDecor;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHDecor() {
            return idCHDecor;
        }

        public void setIdCHDecor(String idCHDecor) {
            this.idCHDecor = idCHDecor;
        }

        public String getTenCHDecor() {
            return tenCHDecor;
        }

        public void setTenCHDecor(String tenCHDecor) {
            this.tenCHDecor = tenCHDecor;
        }

        public String getHinhAnhCHDecor() {
            return hinhAnhCHDecor;
        }

        public void setHinhAnhCHDecor(String hinhAnhCHDecor) {
            this.hinhAnhCHDecor = hinhAnhCHDecor;
        }

        public String getMoTaCHDecor() {
            return moTaCHDecor;
        }

        public void setMoTaCHDecor(String moTaCHDecor) {
            this.moTaCHDecor = moTaCHDecor;
        }

        public String getDanhGiaCHDecor() {
            return danhGiaCHDecor;
        }

        public void setDanhGiaCHDecor(String danhGiaCHDecor) {
            this.danhGiaCHDecor = danhGiaCHDecor;
        }

        public String getSoKMCHDecor() {
            return soKMCHDecor;
        }

        public void setSoKMCHDecor(String soKMCHDecor) {
            this.soKMCHDecor = soKMCHDecor;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }