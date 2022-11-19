package com.example.app_cua_tao.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ThucPham implements Serializable {

@SerializedName("idThucPham")
@Expose
private String idThucPham;
@SerializedName("TenThucPham")
@Expose
private String tenThucPham;
@SerializedName("HinhAnhThucPham")
@Expose
private String hinhAnhThucPham;
@SerializedName("GiaThucPham")
@Expose
private String giaThucPham;
private int numberInCart;

public int getNumberInCart() {
        return numberInCart;
    }
public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

public String getIdThucPham() {
return idThucPham;
}

public void setIdThucPham(String idThucPham) {
this.idThucPham = idThucPham;
}

public String getTenThucPham() {
return tenThucPham;
}

public void setTenThucPham(String tenThucPham) {
this.tenThucPham = tenThucPham;
}

public String getHinhAnhThucPham() {
return hinhAnhThucPham;
}

public void setHinhAnhThucPham(String hinhAnhThucPham) {
this.hinhAnhThucPham = hinhAnhThucPham;
}

public String getGiaThucPham() {
return giaThucPham;
}

public void setGiaThucPham(String giaThucPham) {
this.giaThucPham = giaThucPham;
}

}