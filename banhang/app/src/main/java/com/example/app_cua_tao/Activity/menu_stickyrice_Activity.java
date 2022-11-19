package com.example.app_cua_tao.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.app_cua_tao.R;

public class menu_stickyrice_Activity extends AppCompatActivity {
    Toolbar toolbarStickyRice;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_stickyrice);
        init();
    }

    private void init(){
        toolbarStickyRice = findViewById(R.id.toolbarStickyRice);
        btnBack = findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}