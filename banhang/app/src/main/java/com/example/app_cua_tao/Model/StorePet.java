package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StorePet implements Serializable {


        @SerializedName("idCHPet")
        @Expose
        private String idCHPet;
        @SerializedName("TenCHPet")
        @Expose
        private String tenCHPet;
        @SerializedName("HinhAnhCHPet")
        @Expose
        private String hinhAnhCHPet;
        @SerializedName("MoTaCHPet")
        @Expose
        private String moTaCHPet;
        @SerializedName("DanhGiaCHPet")
        @Expose
        private String danhGiaCHPet;
        @SerializedName("SoKMCHPet")
        @Expose
        private String soKMCHPet;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHPet() {
            return idCHPet;
        }

        public void setIdCHPet(String idCHPet) {
            this.idCHPet = idCHPet;
        }

        public String getTenCHPet() {
            return tenCHPet;
        }

        public void setTenCHPet(String tenCHPet) {
            this.tenCHPet = tenCHPet;
        }

        public String getHinhAnhCHPet() {
            return hinhAnhCHPet;
        }

        public void setHinhAnhCHPet(String hinhAnhCHPet) {
            this.hinhAnhCHPet = hinhAnhCHPet;
        }

        public String getMoTaCHPet() {
            return moTaCHPet;
        }

        public void setMoTaCHPet(String moTaCHPet) {
            this.moTaCHPet = moTaCHPet;
        }

        public String getDanhGiaCHPet() {
            return danhGiaCHPet;
        }

        public void setDanhGiaCHPet(String danhGiaCHPet) {
            this.danhGiaCHPet = danhGiaCHPet;
        }

        public String getSoKMCHPet() {
            return soKMCHPet;
        }

        public void setSoKMCHPet(String soKMCHPet) {
            this.soKMCHPet = soKMCHPet;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }