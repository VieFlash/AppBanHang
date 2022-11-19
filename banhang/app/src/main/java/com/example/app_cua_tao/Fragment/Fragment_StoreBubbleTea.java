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

import com.example.app_cua_tao.Adapter.Items_StoreBubbleTea_Adapter;
import com.example.app_cua_tao.Model.StoreBubbleTea;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreBubbleTea extends Fragment {
    View view;
    RecyclerView recyclerViewStoreBubbleTea;
    Items_StoreBubbleTea_Adapter items_storeBubbleTea_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storebubbletea, container, false);
        recyclerViewStoreBubbleTea = view.findViewById(R.id.recyclerviewStoreBubbleTea);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreBubbleTea>> callback = dataservice.GetDataStoreBubbleTea();
        callback.enqueue(new Callback<List<StoreBubbleTea>>() {
            @Override
            public void onResponse(Call<List<StoreBubbleTea>> call, Response<List<StoreBubbleTea>> response) {
                ArrayList<StoreBubbleTea> storeBubbleTeaArrayList = (ArrayList<StoreBubbleTea>) response.body();
                items_storeBubbleTea_adapter = new Items_StoreBubbleTea_Adapter(getActivity(), storeBubbleTeaArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreBubbleTea.setLayoutManager(linearLayoutManager);
                recyclerViewStoreBubbleTea.setAdapter(items_storeBubbleTea_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreBubbleTea>> call, Throwable t) {

            }
        });
    }

}
