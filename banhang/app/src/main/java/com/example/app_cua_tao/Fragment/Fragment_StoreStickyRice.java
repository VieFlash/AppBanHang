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

import com.example.app_cua_tao.Adapter.Items_StoreStickyRice_Adapter;
import com.example.app_cua_tao.Model.StoreStickyRice;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_StoreStickyRice extends Fragment {

    View view;
    RecyclerView recyclerViewStoreStickyRice;
    Items_StoreStickyRice_Adapter items_storeStickyRice_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_items_storestickyrice, container, false);
        recyclerViewStoreStickyRice = view.findViewById(R.id.recyclerviewStoreStickyRice);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<StoreStickyRice>> callback = dataservice.GetDataStoreStickyRice();
        callback.enqueue(new Callback<List<StoreStickyRice>>() {
            @Override
            public void onResponse(Call<List<StoreStickyRice>> call, Response<List<StoreStickyRice>> response) {
                ArrayList<StoreStickyRice> storeStickyRiceArrayList = (ArrayList<StoreStickyRice>) response.body();
                items_storeStickyRice_adapter = new Items_StoreStickyRice_Adapter(getActivity(), storeStickyRiceArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewStoreStickyRice.setLayoutManager(linearLayoutManager);
                recyclerViewStoreStickyRice.setAdapter(items_storeStickyRice_adapter);
            }

            @Override
            public void onFailure(Call<List<StoreStickyRice>> call, Throwable t) {

            }
        });
    }
}
