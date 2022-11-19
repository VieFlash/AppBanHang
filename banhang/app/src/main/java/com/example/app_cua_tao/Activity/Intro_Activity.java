package com.example.app_cua_tao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cua_tao.R;

public class Intro_Activity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView img1;
    RelativeLayout img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        img1 = findViewById(R.id.imgrandom);
        img2 = findViewById(R.id.aaaarela);

        img1.setAnimation(topAnim);
        img2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}