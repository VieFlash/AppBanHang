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

import com.example.app_cua_tao.Adapter.Items_StoreCream_Adapter;
import com.example.app_cua_tao.Model.StoreCream;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreCream extends Fragment {

    View view;
    RecyclerView recyclerViewStoreCream;
    Items_StoreCream_Adapter items_storeCream_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storecream, container, false);
        recyclerViewStoreCream = view.findViewById(R.id.recyclerviewStoreCream);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreCream>> callback = dataservice.GetDataStoreCream();
        callback.enqueue(new Callback<List<StoreCream>>() {
            @Override
            public void onResponse(Call<List<StoreCream>> call, Response<List<StoreCream>> response) {
                ArrayList<StoreCream> storeCreamArrayList = (ArrayList<StoreCream>) response.body();
                items_storeCream_adapter = new Items_StoreCream_Adapter(getActivity(), storeCreamArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreCream.setLayoutManager(linearLayoutManager);
                recyclerViewStoreCream.setAdapter(items_storeCream_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreCream>> call, Throwable t) {

            }
        });
    }
}
