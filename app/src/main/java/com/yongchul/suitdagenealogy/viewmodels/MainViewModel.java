package com.yongchul.suitdagenealogy.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.databinding.ActivityMainBinding;
import com.yongchul.suitdagenealogy.views.DescriptionFragment;
import com.yongchul.suitdagenealogy.views.QuizFragment;
import com.yongchul.suitdagenealogy.views.SutdaChoiceFragment;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class MainViewModel implements TabLayout.OnTabSelectedListener {

    private Context c;
    private Activity a;
    private ActivityMainBinding binding;

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fm;
    private Fragment fr = null;
    private InterstitialAd mInterstitialAd;


    public MainViewModel( ActivityMainBinding binding, Context c, Activity a ) {
        this.c = c;
        this.a = a;
        this.binding = binding;
        this.init();
    }

    private void listenerRegister() {
        this.binding.tabLayout.addOnTabSelectedListener(this);
    }

    private void init() {
        this.fm = ((FragmentActivity)this.c).getSupportFragmentManager();
        this.listenerRegister();
        this.changeFragment(0);

    }

    private void changeFragment ( int pos) {

        if (fr != null) {
            fm.beginTransaction().remove(fr).commit();
        }

        if ( pos == 0 ) {
            fr = new SutdaChoiceFragment();
        } else if ( pos == 1 ) {
            fr = new DescriptionFragment();
        } else if ( pos == 2 ) {
            //fr = new QuizFragment();
        } else {
            fr = new SutdaChoiceFragment();
        }

        this.fragmentTransaction = fm.beginTransaction();
        this.fragmentTransaction.add(R.id.FragmentBor, fr);
        this.fragmentTransaction.commit();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        this.changeFragment(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
