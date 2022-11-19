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

import com.example.app_cua_tao.Adapter.Items_StoreDecor_Adapter;
import com.example.app_cua_tao.Model.StoreDecor;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreDecor extends Fragment {

    View view;
    RecyclerView recyclerViewStoreDecor;
    Items_StoreDecor_Adapter items_storeDecor_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storedecor, container, false);
        recyclerViewStoreDecor = view.findViewById(R.id.recyclerviewStoreDecor);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreDecor>> callback = dataservice.GetDataStoreDecor();
        callback.enqueue(new Callback<List<StoreDecor>>() {
            @Override
            public void onResponse(Call<List<StoreDecor>> call, Response<List<StoreDecor>> response) {
                ArrayList<StoreDecor> storeDecorArrayList = (ArrayList<StoreDecor>) response.body();
                items_storeDecor_adapter = new Items_StoreDecor_Adapter(getContext(), storeDecorArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreDecor.setLayoutManager(linearLayoutManager);
                recyclerViewStoreDecor.setAdapter(items_storeDecor_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreDecor>> call, Throwable t) {

            }
        });
    }
}
