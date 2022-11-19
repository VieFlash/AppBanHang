package com.example.app_cua_tao.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_cua_tao.Adapter.ChuDeAdapter;
import com.example.app_cua_tao.Model.ChuDe;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDeTrongNgay extends Fragment {
    View view;
    RecyclerView recyclerViewChuDe;
    ChuDeAdapter chuDeAdapter;
    ImageButton imgChuDeTrongNgay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chudetrongngay, container, false);
        recyclerViewChuDe = view.findViewById(R.id.recyclerviewChuDe);
        imgChuDeTrongNgay = view.findViewById(R.id.btnXemThemChuDe);
        GetData();
        return view;

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback = dataservice.GetDataChuDeTrongNgay();
        callback.enqueue(new Callback<List<ChuDe>>() {

            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> chuDeArrayList = (ArrayList<ChuDe>) response.body();
                chuDeAdapter = new ChuDeAdapter(getActivity(), chuDeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewChuDe.setLayoutManager(linearLayoutManager);
                recyclerViewChuDe.setAdapter(chuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });

}
}
