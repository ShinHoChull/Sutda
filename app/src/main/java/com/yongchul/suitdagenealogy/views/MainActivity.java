package com.yongchul.suitdagenealogy.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.databinding.ActivityMainBinding;
import com.yongchul.suitdagenealogy.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        this.binding.setMain(this);
        this.mvm = new MainViewModel(binding,this,this);

    }

}
