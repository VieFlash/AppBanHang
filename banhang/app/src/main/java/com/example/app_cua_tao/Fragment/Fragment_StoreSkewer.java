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

import com.example.app_cua_tao.Adapter.Items_StoreSkewer_Adapter;
import com.example.app_cua_tao.Model.StoreSkewer;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreSkewer extends Fragment {

    View view;
    RecyclerView recyclerViewStoreSkewer;
    Items_StoreSkewer_Adapter items_storeSkewer_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storeskewer, container, false);
        recyclerViewStoreSkewer = view.findViewById(R.id.recyclerviewStoreSkewer);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreSkewer>> callback = dataservice.GetDataStoreSkewer();
        callback.enqueue(new Callback<List<StoreSkewer>>() {
            @Override
            public void onResponse(Call<List<StoreSkewer>> call, Response<List<StoreSkewer>> response) {
                ArrayList<StoreSkewer> storeSkewerArrayList = (ArrayList<StoreSkewer>) response.body();
                items_storeSkewer_adapter = new Items_StoreSkewer_Adapter(getActivity(), storeSkewerArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreSkewer.setLayoutManager(linearLayoutManager);
                recyclerViewStoreSkewer.setAdapter(items_storeSkewer_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreSkewer>> call, Throwable t) {

            }
        });
    }
}
