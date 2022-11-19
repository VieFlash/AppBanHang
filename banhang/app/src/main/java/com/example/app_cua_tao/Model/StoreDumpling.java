package com.example.app_cua_tao.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreDumpling implements Serializable {


        @SerializedName("idCHDumpling")
        @Expose
        private String idCHDumpling;
        @SerializedName("TenCHDumpling")
        @Expose
        private String tenCHDumpling;
        @SerializedName("HinhAnhCHDumpling")
        @Expose
        private String hinhAnhCHDumpling;
        @SerializedName("MoTaCHDumpling")
        @Expose
        private String moTaCHDumpling;
        @SerializedName("DanhGiaCHDumpling")
        @Expose
        private String danhGiaCHDumpling;
        @SerializedName("SoKMCHDumpling")
        @Expose
        private String soKMCHDumpling;
        @SerializedName("SoNgayMo")
        @Expose
        private String soNgayMo;

        public String getIdCHDumpling() {
            return idCHDumpling;
        }

        public void setIdCHDumpling(String idCHDumpling) {
            this.idCHDumpling = idCHDumpling;
        }

        public String getTenCHDumpling() {
            return tenCHDumpling;
        }

        public void setTenCHDumpling(String tenCHDumpling) {
            this.tenCHDumpling = tenCHDumpling;
        }

        public String getHinhAnhCHDumpling() {
            return hinhAnhCHDumpling;
        }

        public void setHinhAnhCHDumpling(String hinhAnhCHDumpling) {
            this.hinhAnhCHDumpling = hinhAnhCHDumpling;
        }

        public String getMoTaCHDumpling() {
            return moTaCHDumpling;
        }

        public void setMoTaCHDumpling(String moTaCHDumpling) {
            this.moTaCHDumpling = moTaCHDumpling;
        }

        public String getDanhGiaCHDumpling() {
            return danhGiaCHDumpling;
        }

        public void setDanhGiaCHDumpling(String danhGiaCHDumpling) {
            this.danhGiaCHDumpling = danhGiaCHDumpling;
        }

        public String getSoKMCHDumpling() {
            return soKMCHDumpling;
        }

        public void setSoKMCHDumpling(String soKMCHDumpling) {
            this.soKMCHDumpling = soKMCHDumpling;
        }

        public String getSoNgayMo() {
            return soNgayMo;
        }

        public void setSoNgayMo(String soNgayMo) {
            this.soNgayMo = soNgayMo;
        }

    }