package com.example.app_cua_tao.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.app_cua_tao.Activity.menu_bubbletea_Activity;
import com.example.app_cua_tao.Activity.menu_cream_Activity;
import com.example.app_cua_tao.Activity.menu_decor_Activity;
import com.example.app_cua_tao.Activity.menu_drinks_Activity;
import com.example.app_cua_tao.Activity.menu_dumpling_Activity;
import com.example.app_cua_tao.Activity.menu_hotpot_Activity;
import com.example.app_cua_tao.Activity.menu_medicine_Activity;
import com.example.app_cua_tao.Activity.menu_noodles_Activity;
import com.example.app_cua_tao.Activity.menu_pet_Activity;
import com.example.app_cua_tao.Activity.menu_rice_Activity;
import com.example.app_cua_tao.Activity.menu_skewer_Activity;
import com.example.app_cua_tao.Activity.menu_stickyrice_Activity;
import com.example.app_cua_tao.R;

public class Fragment_MenuItems extends Fragment {
    View view;
    ConstraintLayout cl1, cl2, cl3, cl4, cl5, cl6, cl7, cl8, cl9, cl10, cl11, cl12;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menuitems, container, false);
        Init();
        OnClickMenuItem();

        return view;
    }
    private void OnClickMenuItem(){
        cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_rice_Activity.class);
                startActivity(intent);
            }
        });
        cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_noodles_Activity.class);
                startActivity(intent);
            }
        });
        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_drinks_Activity.class);
                startActivity(intent);
            }
        });
        cl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_hotpot_Activity.class);
                startActivity(intent);
            }
        });
        cl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_stickyrice_Activity.class);
                startActivity(intent);
            }
        });
        cl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_bubbletea_Activity.class);
                startActivity(intent);
            }
        });
        cl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_medicine_Activity.class);
                startActivity(intent);
            }
        });
        cl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_pet_Activity.class);
                startActivity(intent);
            }
        });
        cl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_decor_Activity.class);
                startActivity(intent);
            }
        });
        cl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_dumpling_Activity.class);
                startActivity(intent);
            }
        });
        cl11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_skewer_Activity.class);
                startActivity(intent);
            }
        });
        cl12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), menu_cream_Activity.class);
                startActivity(intent);
            }
        });

    }
    private void Init() {
        cl1 = view.findViewById(R.id.item1);
        cl2 = view.findViewById(R.id.item2);
        cl3 = view.findViewById(R.id.item3);
        cl4 = view.findViewById(R.id.item4);
        cl5 = view.findViewById(R.id.item5);
        cl6 = view.findViewById(R.id.item6);
        cl7 = view.findViewById(R.id.item7);
        cl8 = view.findViewById(R.id.item8);
        cl9 = view.findViewById(R.id.item9);
        cl10 = view.findViewById(R.id.item10);
        cl11 = view.findViewById(R.id.item11);
        cl12 = view.findViewById(R.id.item12);

    }


}
