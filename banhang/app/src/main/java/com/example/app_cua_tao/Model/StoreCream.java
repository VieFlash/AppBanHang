package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreCream implements Serializable {

        @SerializedName("idCHCream")
        @Expose
        private String idCHCream;
        @SerializedName("TenCHCream")
        @Expose
        private String tenCHCream;
        @SerializedName("HinhAnhCHCream")
        @Expose
        private String hinhAnhCHCream;
        @SerializedName("MoTaCHCream")
        @Expose
        private String moTaCHCream;
        @SerializedName("DanhGiaCHCream")
        @Expose
        private String danhGiaCHCream;
        @SerializedName("SoKMCHCream")
        @Expose
        private String soKMCHCream;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHCream() {
            return idCHCream;
        }

        public void setIdCHCream(String idCHCream) {
            this.idCHCream = idCHCream;
        }

        public String getTenCHCream() {
            return tenCHCream;
        }

        public void setTenCHCream(String tenCHCream) {
            this.tenCHCream = tenCHCream;
        }

        public String getHinhAnhCHCream() {
            return hinhAnhCHCream;
        }

        public void setHinhAnhCHCream(String hinhAnhCHCream) {
            this.hinhAnhCHCream = hinhAnhCHCream;
        }

        public String getMoTaCHCream() {
            return moTaCHCream;
        }

        public void setMoTaCHCream(String moTaCHCream) {
            this.moTaCHCream = moTaCHCream;
        }

        public String getDanhGiaCHCream() {
            return danhGiaCHCream;
        }

        public void setDanhGiaCHCream(String danhGiaCHCream) {
            this.danhGiaCHCream = danhGiaCHCream;
        }

        public String getSoKMCHCream() {
            return soKMCHCream;
        }

        public void setSoKMCHCream(String soKMCHCream) {
            this.soKMCHCream = soKMCHCream;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }