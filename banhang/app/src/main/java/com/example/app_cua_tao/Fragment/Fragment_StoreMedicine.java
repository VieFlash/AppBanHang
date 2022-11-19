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

import com.example.app_cua_tao.Adapter.Items_StoreMedicine_Adapter;
import com.example.app_cua_tao.Model.StoreMedicine;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreMedicine extends Fragment {

    View view;
    RecyclerView recyclerViewStoreMedicine;
    Items_StoreMedicine_Adapter items_storeMedicine_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storemedicine, container, false);
        recyclerViewStoreMedicine = view.findViewById(R.id.recyclerviewStoreMedicine);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreMedicine>> callback = dataservice.GetDataStoreMedicine();
        callback.enqueue(new Callback<List<StoreMedicine>>() {
            @Override
            public void onResponse(Call<List<StoreMedicine>> call, Response<List<StoreMedicine>> response) {
                ArrayList<StoreMedicine> storeMedicineArrayList = (ArrayList<StoreMedicine>) response.body();
                items_storeMedicine_adapter = new Items_StoreMedicine_Adapter(getActivity(), storeMedicineArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreMedicine.setLayoutManager(linearLayoutManager);
                recyclerViewStoreMedicine.setAdapter(items_storeMedicine_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreMedicine>> call, Throwable t) {

            }
        });
    }
}
