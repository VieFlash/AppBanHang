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

import com.example.app_cua_tao.Adapter.Items_StoreNoodles_Adapter;
import com.example.app_cua_tao.Model.StoreNoodle;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreNoodles extends Fragment {

    View view;
    RecyclerView recyclerViewStoreNoodles;
    Items_StoreNoodles_Adapter items_storeNoodles_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storenoodles, container, false);
        recyclerViewStoreNoodles = view.findViewById(R.id.recyclerviewStoreNoodles);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreNoodle>> callback = dataservice.GetDataStoreNoodles();
        callback.enqueue(new Callback<List<StoreNoodle>>() {
            @Override
            public void onResponse(Call<List<StoreNoodle>> call, Response<List<StoreNoodle>> response) {
                ArrayList<StoreNoodle> storeNoodleArrayList = (ArrayList<StoreNoodle>) response.body();
                items_storeNoodles_adapter = new Items_StoreNoodles_Adapter(getActivity(), storeNoodleArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreNoodles.setLayoutManager(linearLayoutManager);
                recyclerViewStoreNoodles.setAdapter(items_storeNoodles_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreNoodle>> call, Throwable t) {

            }
        });
    }
}
