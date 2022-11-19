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

import com.example.app_cua_tao.Adapter.QuanhDayCoGiAdapter;
import com.example.app_cua_tao.Model.QuanhDayCoGi;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_QuanhDayCoGi extends Fragment {

    View view;
    RecyclerView recyclerViewQuanhDayCoGi;
    QuanhDayCoGiAdapter quanhDayCoGiAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quanhdaycogi, container, false);
        recyclerViewQuanhDayCoGi = view.findViewById(R.id.recyclerviewQuanhDayCoGi);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<QuanhDayCoGi>> callback = dataservice.GetDataQuanhDayCoGi();
        callback.enqueue(new Callback<List<QuanhDayCoGi>>() {
            @Override
            public void onResponse(Call<List<QuanhDayCoGi>> call, Response<List<QuanhDayCoGi>> response) {
                ArrayList<QuanhDayCoGi> quanhDayCoGiArrayList = (ArrayList<QuanhDayCoGi>) response.body();
                quanhDayCoGiAdapter = new QuanhDayCoGiAdapter(getActivity(), quanhDayCoGiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewQuanhDayCoGi.setLayoutManager(linearLayoutManager);
                recyclerViewQuanhDayCoGi.setAdapter(quanhDayCoGiAdapter);
            }

            @Override
            public void onFailure(Call<List<QuanhDayCoGi>> call, Throwable t) {

            }
        });
    }
}
