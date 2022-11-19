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

import com.example.app_cua_tao.Adapter.Items_StoreDumpling_Adapter;
import com.example.app_cua_tao.Model.StoreDumpling;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreDumpling extends Fragment {

    View view;
    RecyclerView recyclerViewStoreDumpling;
    Items_StoreDumpling_Adapter items_storeDumpling_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_items_storedumpling, container, false);
            recyclerViewStoreDumpling = view.findViewById(R.id.recyclerviewStoreDumpling);
            GetData();
            return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreDumpling>> callback = dataservice.GetDataStoreDumpling();
        callback.enqueue(new Callback<List<StoreDumpling>>() {
            @Override
            public void onResponse(Call<List<StoreDumpling>> call, Response<List<StoreDumpling>> response) {
                ArrayList<StoreDumpling> storeDumplingArrayList = (ArrayList<StoreDumpling>) response.body();
                items_storeDumpling_adapter = new Items_StoreDumpling_Adapter(getActivity(), storeDumplingArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreDumpling.setLayoutManager(linearLayoutManager);
                recyclerViewStoreDumpling.setAdapter(items_storeDumpling_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreDumpling>> call, Throwable t) {

            }
        });
    }
}
