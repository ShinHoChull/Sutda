package com.yongchul.suitdagenealogy.modules.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.yongchul.suitdagenealogy.R;


public class ServiceAlertActivity extends AppCompatActivity implements View.OnClickListener {

    Globar g;
    private LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_alert);
        this.g = new Globar(this);

        l = findViewById(R.id.servcie_alert_v);
        l.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
