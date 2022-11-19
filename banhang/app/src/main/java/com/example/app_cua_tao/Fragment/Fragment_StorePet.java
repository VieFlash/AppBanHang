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

import com.example.app_cua_tao.Adapter.Items_StorePet_Adapter;
import com.example.app_cua_tao.Model.StorePet;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StorePet extends Fragment {

    View view;
    RecyclerView recyclerViewStorePet;
    Items_StorePet_Adapter items_storePet_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storepet, container, false);
        recyclerViewStorePet = view.findViewById(R.id.recyclerviewStorePet);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StorePet>> callback = dataservice.GetDataStorePet();
        callback.enqueue(new Callback<List<StorePet>>() {
            @Override
            public void onResponse(Call<List<StorePet>> call, Response<List<StorePet>> response) {
                ArrayList<StorePet> storePetArrayList = (ArrayList<StorePet>) response.body();
                items_storePet_adapter = new Items_StorePet_Adapter(getActivity(), storePetArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStorePet.setLayoutManager(linearLayoutManager);
                recyclerViewStorePet.setAdapter(items_storePet_adapter);
            }

            @Override
            public void onFailure(Call<List<StorePet>> call, Throwable t) {

            }
        });
    }
}
