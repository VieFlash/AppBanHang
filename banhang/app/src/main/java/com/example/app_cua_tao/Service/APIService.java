package com.example.app_cua_tao.Service;

public class APIService {
    private static String base_url = "https://databaseoday.000webhostapp.com/Server/";

    public static Dataservice getService() {
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
