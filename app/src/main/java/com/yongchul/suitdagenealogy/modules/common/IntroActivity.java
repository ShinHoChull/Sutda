package com.yongchul.suitdagenealogy.modules.common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.model.MessageDTO;
import com.yongchul.suitdagenealogy.views.MainActivity;


public class IntroActivity extends AppCompatActivity {

    private Handler handler;
    private int time = 2000;
    private Globar g;
    //handler
    private CustomHandler customHandler;
    private ImageView intro;
    private Custom_SharedPreferences csp;

    public void init() {
        this.handler = new Handler();
        this.g = new Globar(this);
        this.customHandler = new CustomHandler(this);
        this.csp = new Custom_SharedPreferences(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        this.intro = findViewById(R.id.intro_img);
        this.init();

        if (NetworkState.isNetworkStat(getApplicationContext()) == false) {
            Toast.makeText(getApplicationContext(), "인터넷을 실행시켜주세요", Toast.LENGTH_SHORT).show();
            this.finish();
            return;
        }

        this.moveMain();
    }



    public void moveMain() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }
}
