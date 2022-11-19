package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreSkewer implements Serializable {


        @SerializedName("idCHSkewer")
        @Expose
        private String idCHSkewer;
        @SerializedName("TenCHSkewer")
        @Expose
        private String tenCHSkewer;
        @SerializedName("HinhAnhCHSkewer")
        @Expose
        private String hinhAnhCHSkewer;
        @SerializedName("MoTaCHSkewer")
        @Expose
        private String moTaCHSkewer;
        @SerializedName("DanhGiaCHSkewer")
        @Expose
        private String danhGiaCHSkewer;
        @SerializedName("SoKMCHSkewer")
        @Expose
        private String soKMCHSkewer;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHSkewer() {
            return idCHSkewer;
        }

        public void setIdCHSkewer(String idCHSkewer) {
            this.idCHSkewer = idCHSkewer;
        }

        public String getTenCHSkewer() {
            return tenCHSkewer;
        }

        public void setTenCHSkewer(String tenCHSkewer) {
            this.tenCHSkewer = tenCHSkewer;
        }

        public String getHinhAnhCHSkewer() {
            return hinhAnhCHSkewer;
        }

        public void setHinhAnhCHSkewer(String hinhAnhCHSkewer) {
            this.hinhAnhCHSkewer = hinhAnhCHSkewer;
        }

        public String getMoTaCHSkewer() {
            return moTaCHSkewer;
        }

        public void setMoTaCHSkewer(String moTaCHSkewer) {
            this.moTaCHSkewer = moTaCHSkewer;
        }

        public String getDanhGiaCHSkewer() {
            return danhGiaCHSkewer;
        }

        public void setDanhGiaCHSkewer(String danhGiaCHSkewer) {
            this.danhGiaCHSkewer = danhGiaCHSkewer;
        }

        public String getSoKMCHSkewer() {
            return soKMCHSkewer;
        }

        public void setSoKMCHSkewer(String soKMCHSkewer) {
            this.soKMCHSkewer = soKMCHSkewer;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }