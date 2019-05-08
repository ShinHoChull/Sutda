package com.yongchul.suitdagenealogy.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.databinding.ActivityMainBinding;
import com.yongchul.suitdagenealogy.databinding.SutdachoiceFragmentBinding;
import com.yongchul.suitdagenealogy.model.ShuitdaDTO;
import com.yongchul.suitdagenealogy.modules.adapters.CustomGridViewAdapter;
import com.yongchul.suitdagenealogy.modules.common.Globar;
import com.yongchul.suitdagenealogy.modules.common.Shuitda;

import java.util.ArrayList;

public class ChoiceViewModel implements AdapterView.OnItemClickListener {

    private SutdachoiceFragmentBinding biding;
    private Context c;
    private Globar g;

    private int adCount = 0;
    private ArrayList<ShuitdaDTO> slist;
    private int card1,card2,r_img;
    private Shuitda shuitda;
    private String scoreName;


    public ChoiceViewModel(SutdachoiceFragmentBinding biding, Context c) {
        this.biding = biding;
        this.c = c;
        this.init();
    }

    private void listenerRegister() {
        this.biding.sutdaGrid.setOnItemClickListener(this);
    }

    private void init() {
        this.slist = new ArrayList<>();
        this.shuitda = new Shuitda();
        this.listenerRegister();
        adapterReset();
    }

    private void adapterReset () {
        LayoutInflater inflater = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CustomGridViewAdapter cga = new CustomGridViewAdapter(this.c, inflater);
        this.biding.sutdaGrid.setAdapter(cga);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setVisibility(View.INVISIBLE);

        if (position % 2 == 0) {
            this.setList(new ShuitdaDTO((int)view.getTag(),true));
        } else {
            this.setList(new ShuitdaDTO((int)view.getTag(),false));
        }
    }

    private void setList(ShuitdaDTO sd) {
        this.adCount++;
        this.slist.add(sd);
        Log.e("adCount", "" + this.adCount);
        if (this.slist.size() >= 2) {
            LayoutInflater inflater = (LayoutInflater)this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.card_result , this.biding.sutdaFrame , false);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c,"hello!",Toast.LENGTH_SHORT).show();
                }
            });
            ImageView img1 = v.findViewById(R.id.subV_img1);
            ImageView img2 = v.findViewById(R.id.subV_img2);
            TextView tv = v.findViewById(R.id.resultText);

            tv.setText(this.getScoreName());
            img1.setImageResource(this.setting(this.slist.get(0).getName(),this.slist.get(0).isState()));
            img2.setImageResource(this.setting(this.slist.get(1).getName(),this.slist.get(1).isState()));

            this.biding.sutdaFrame.addView(v);
            this.slist = new ArrayList<>();
            this.adapterReset();
        }
    }

    public int setting(int card , boolean state){

        if(card == 1 && state == true){
            this.r_img = R.drawable.one;
        }else if(card == 1 && state == false){
            this.r_img = R.drawable.one_;
        }else if(card == 2 && state == true){
            this.r_img = R.drawable.two;
        }else if(card == 2 && state == false){
            this.r_img = R.drawable.two_;
        }else if(card == 3 && state == true){
            this.r_img = R.drawable.three;
        }else if(card == 3 && state == false){
            this.r_img = R.drawable.three_;
        }else if(card == 4 && state == true){
            this.r_img = R.drawable.four;
        }else if(card == 4 && state == false){
            this.r_img = R.drawable.four_;
        }else if(card == 5 && state == true){
            this.r_img = R.drawable.five;
        }else if(card == 5 && state == false){
            this.r_img = R.drawable.five_;
        }else if(card == 6 && state == true){
            this.r_img = R.drawable.six;
        }else if(card == 6 && state == false){
            this.r_img = R.drawable.six_;
        }else if(card == 7 && state == true){
            this.r_img = R.drawable.seven;
        }else if(card == 7 && state == false){
            this.r_img = R.drawable.seven_;
        }else if(card == 8 && state == true){
            this.r_img = R.drawable.eight;
        }else if(card == 8 && state == false){
            this.r_img = R.drawable.eight_;
        }else if(card == 9 && state == true){
            this.r_img = R.drawable.nine;
        }else if(card == 9 && state == false){
            this.r_img = R.drawable.nine_;
        }else if(card == 10 && state == true){
            this.r_img = R.drawable.ten;
        }else if(card == 10 && state == false){
            this.r_img = R.drawable.ten_;
        }
        return this.r_img;
    }

    private String getScoreName(){
        this.scoreName = "";

        switch (this.slist.get(0).getName()){

            case 1:
                this.scoreName = shuitda.mix1(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 2:
                this.scoreName = shuitda.mix2(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 3:
                scoreName = shuitda.mix3(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 4:
                scoreName = shuitda.mix4(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 5:
                scoreName = shuitda.mix5(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 6:
                scoreName = shuitda.mix6(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 7:
                scoreName = shuitda.mix7(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 8:
                scoreName = shuitda.mix8(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 9:
                scoreName = shuitda.mix9(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;
            case 10:
                scoreName = shuitda.mix10(slist.get(0).isState(),slist.get(1).getName(),slist.get(1).isState());
                break;

        }

        return scoreName;
    }
}
