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

import com.example.app_cua_tao.Adapter.Items_StoreRice_Adapter;
import com.example.app_cua_tao.Model.StoreRice;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreRice extends Fragment {

    View view;
    RecyclerView recyclerViewStoreRice;
    Items_StoreRice_Adapter items_storeRice_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storerice, container, false);
        recyclerViewStoreRice = view.findViewById(R.id.recyclerviewStoreRice);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreRice>> callback = dataservice.GetDataStoreRice();
        callback.enqueue(new Callback<List<StoreRice>>() {
            @Override
            public void onResponse(Call<List<StoreRice>> call, Response<List<StoreRice>> response) {
                ArrayList<StoreRice> storeRiceArrayList = (ArrayList<StoreRice>) response.body();
                items_storeRice_adapter = new Items_StoreRice_Adapter(  getActivity(), storeRiceArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreRice.setLayoutManager(linearLayoutManager);
                recyclerViewStoreRice.setAdapter(items_storeRice_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreRice>> call, Throwable t) {

            }
        });
    }
}
