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

import com.example.app_cua_tao.Adapter.Items_StoreHotPot_Adapter;
import com.example.app_cua_tao.Model.StoreHotPot;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreHotPot extends Fragment {

    View view;
    RecyclerView recyclerViewStoreHotPot;
    Items_StoreHotPot_Adapter items_storeHotPot_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storehotpot, container, false);
        recyclerViewStoreHotPot = view.findViewById(R.id.recyclerviewStoreHotPot);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreHotPot>> callback = dataservice.GetDataStoreHotPot();
        callback.enqueue(new Callback<List<StoreHotPot>>() {
            @Override
            public void onResponse(Call<List<StoreHotPot>> call, Response<List<StoreHotPot>> response) {
                ArrayList<StoreHotPot> storeHotPotArrayList = (ArrayList<StoreHotPot>) response.body();
                items_storeHotPot_adapter = new Items_StoreHotPot_Adapter(getActivity(), storeHotPotArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreHotPot.setLayoutManager(linearLayoutManager);
                recyclerViewStoreHotPot.setAdapter(items_storeHotPot_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreHotPot>> call, Throwable t) {

            }
        });
    }
}
