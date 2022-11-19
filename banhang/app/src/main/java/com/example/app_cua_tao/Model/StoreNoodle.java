package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreNoodle implements Serializable {


        @SerializedName("idCHNoodles")
        @Expose
        private String idCHNoodles;
        @SerializedName("TenCHNoodles")
        @Expose
        private String tenCHNoodles;
        @SerializedName("HinhAnhCHNoodles")
        @Expose
        private String hinhAnhCHNoodles;
        @SerializedName("MoTaCHNoodles")
        @Expose
        private String moTaCHNoodles;
        @SerializedName("DanhGiaCHNoodles")
        @Expose
        private String danhGiaCHNoodles;
        @SerializedName("SoKMCHNoodles")
        @Expose
        private String soKMCHNoodles;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHNoodles() {
            return idCHNoodles;
        }

        public void setIdCHNoodles(String idCHNoodles) {
            this.idCHNoodles = idCHNoodles;
        }

        public String getTenCHNoodles() {
            return tenCHNoodles;
        }

        public void setTenCHNoodles(String tenCHNoodles) {
            this.tenCHNoodles = tenCHNoodles;
        }

        public String getHinhAnhCHNoodles() {
            return hinhAnhCHNoodles;
        }

        public void setHinhAnhCHNoodles(String hinhAnhCHNoodles) {
            this.hinhAnhCHNoodles = hinhAnhCHNoodles;
        }

        public String getMoTaCHNoodles() {
            return moTaCHNoodles;
        }

        public void setMoTaCHNoodles(String moTaCHNoodles) {
            this.moTaCHNoodles = moTaCHNoodles;
        }

        public String getDanhGiaCHNoodles() {
            return danhGiaCHNoodles;
        }

        public void setDanhGiaCHNoodles(String danhGiaCHNoodles) {
            this.danhGiaCHNoodles = danhGiaCHNoodles;
        }

        public String getSoKMCHNoodles() {
            return soKMCHNoodles;
        }

        public void setSoKMCHNoodles(String soKMCHNoodles) {
            this.soKMCHNoodles = soKMCHNoodles;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }