package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreMedicine implements Serializable {

        @SerializedName("idCHMedicine")
        @Expose
        private String idCHMedicine;
        @SerializedName("TenCHMedicine")
        @Expose
        private String tenCHMedicine;
        @SerializedName("HinhAnhCHMedicine")
        @Expose
        private String hinhAnhCHMedicine;
        @SerializedName("MoTaCHMedicine")
        @Expose
        private String moTaCHMedicine;
        @SerializedName("DanhGiaCHMedicine")
        @Expose
        private String danhGiaCHMedicine;
        @SerializedName("SoKMCHMedicine")
        @Expose
        private String soKMCHMedicine;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHMedicine() {
            return idCHMedicine;
        }

        public void setIdCHMedicine(String idCHMedicine) {
            this.idCHMedicine = idCHMedicine;
        }

        public String getTenCHMedicine() {
            return tenCHMedicine;
        }

        public void setTenCHMedicine(String tenCHMedicine) {
            this.tenCHMedicine = tenCHMedicine;
        }

        public String getHinhAnhCHMedicine() {
            return hinhAnhCHMedicine;
        }

        public void setHinhAnhCHMedicine(String hinhAnhCHMedicine) {
            this.hinhAnhCHMedicine = hinhAnhCHMedicine;
        }

        public String getMoTaCHMedicine() {
            return moTaCHMedicine;
        }

        public void setMoTaCHMedicine(String moTaCHMedicine) {
            this.moTaCHMedicine = moTaCHMedicine;
        }

        public String getDanhGiaCHMedicine() {
            return danhGiaCHMedicine;
        }

        public void setDanhGiaCHMedicine(String danhGiaCHMedicine) {
            this.danhGiaCHMedicine = danhGiaCHMedicine;
        }

        public String getSoKMCHMedicine() {
            return soKMCHMedicine;
        }

        public void setSoKMCHMedicine(String soKMCHMedicine) {
            this.soKMCHMedicine = soKMCHMedicine;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }