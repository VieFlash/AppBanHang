package com.example.app_cua_tao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Adapter.Items_StoreDrinks_Adapter;
import com.example.app_cua_tao.Model.StoreDrink;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreDrinks extends Fragment {
    View view;
    RecyclerView recyclerViewStoreDrinks;
    Items_StoreDrinks_Adapter items_storeDrinks_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storedrinks, container, false);
        recyclerViewStoreDrinks = view.findViewById(R.id.recyclerviewStoreDrinks);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreDrink>> callback = dataservice.GetDataStoreDrinks();
        callback.enqueue(new Callback<List<StoreDrink>>() {
            @Override
            public void onResponse(Call<List<StoreDrink>> call, Response<List<StoreDrink>> response) {
                ArrayList<StoreDrink> storeDrinkArrayList = (ArrayList<StoreDrink>) response.body();
                items_storeDrinks_adapter = new Items_StoreDrinks_Adapter(getActivity(), storeDrinkArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreDrinks.setLayoutManager(linearLayoutManager);
                recyclerViewStoreDrinks.setAdapter(items_storeDrinks_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreDrink>> call, Throwable t) {

            }
        });
    }
}
