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

import com.example.app_cua_tao.Adapter.TheLoaiAdapter;
import com.example.app_cua_tao.Model.TheLoai;
import com.example.app_cua_tao.R;
import com.example.app_cua_tao.Service.APIService;
import com.example.app_cua_tao.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TheLoaiTrongNgay extends Fragment {
    View view;
    RecyclerView recyclerViewChuDe;
    TheLoaiAdapter theLoaiAdapter;
    ImageButton imgTheLoaiTrongNgay;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloaitrongngay, container, false);
        recyclerViewChuDe = view.findViewById(R.id.recyclerviewTheLoai);
        imgTheLoaiTrongNgay = view.findViewById(R.id.btnXemThemTheLoai);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> callback = dataservice.GetDataTheLoaiTrongNgay();
        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> theLoaiArrayList = (ArrayList<TheLoai>) response.body();
                theLoaiAdapter = new TheLoaiAdapter(getActivity(), theLoaiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewChuDe.setLayoutManager(linearLayoutManager);
                recyclerViewChuDe.setAdapter(theLoaiAdapter);
                }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }

        });

    }
}
