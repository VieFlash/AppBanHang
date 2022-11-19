package com.example.app_cua_tao.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuanhDayCoGi {

@SerializedName("idCHBubbleTea")
@Expose
private String idCHBubbleTea;
@SerializedName("TenCHBubbleTea")
@Expose
private String tenCHBubbleTea;
@SerializedName("HinhAnhCHBubbleTea")
@Expose
private String hinhAnhCHBubbleTea;
@SerializedName("MoTaCHBubbleTea")
@Expose
private String moTaCHBubbleTea;

public String getIdCHBubbleTea() {
return idCHBubbleTea;
}

public void setIdCHBubbleTea(String idCHBubbleTea) {
this.idCHBubbleTea = idCHBubbleTea;
}

public String getTenCHBubbleTea() {
return tenCHBubbleTea;
}

public void setTenCHBubbleTea(String tenCHBubbleTea) {
this.tenCHBubbleTea = tenCHBubbleTea;
}

public String getHinhAnhCHBubbleTea() {
return hinhAnhCHBubbleTea;
}

public void setHinhAnhCHBubbleTea(String hinhAnhCHBubbleTea) {
this.hinhAnhCHBubbleTea = hinhAnhCHBubbleTea;
}

public String getMoTaCHBubbleTea() {
return moTaCHBubbleTea;
}

public void setMoTaCHBubbleTea(String moTaCHBubbleTea) {
this.moTaCHBubbleTea = moTaCHBubbleTea;
}

}