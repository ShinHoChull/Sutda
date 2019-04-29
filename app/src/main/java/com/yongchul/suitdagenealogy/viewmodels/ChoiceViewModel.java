package com.yongchul.suitdagenealogy.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.databinding.ActivityMainBinding;
import com.yongchul.suitdagenealogy.databinding.SutdachoiceFragmentBinding;
import com.yongchul.suitdagenealogy.model.ShuitdaDTO;
import com.yongchul.suitdagenealogy.modules.adapters.CustomGridViewAdapter;
import com.yongchul.suitdagenealogy.modules.common.Globar;

import java.util.ArrayList;

public class ChoiceViewModel implements AdapterView.OnItemClickListener {

    private SutdachoiceFragmentBinding biding;
    private Context c;
    private Globar g;

    private int adCount = 0;
    private ArrayList<ShuitdaDTO> slist;


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
        this.listenerRegister();
        LayoutInflater inflater = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CustomGridViewAdapter cga = new CustomGridViewAdapter(this.c, inflater);
        this.biding.sutdaGrid.setAdapter(cga);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("itemClickTag", "" + view.getTag());
        if (position % 2 == 0) {
            this.setList(new ShuitdaDTO((int)view.getTag(),true));
            //Log.d("number", "");
        } else {
            this.setList(new ShuitdaDTO((int)view.getTag(),false));
            //Log.d("number", "11");
        }
    }

    private void setList(ShuitdaDTO sd) {
        this.adCount++;
        this.slist.add(sd);
        Log.e("adCount", "" + this.adCount);
        if (this.slist.size() >= 2) {
            Log.e("adCount", "" + this.slist);
            LayoutInflater inflater = (LayoutInflater)this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.card_result , this.biding.sutdaFrame , false);
            this.biding.sutdaFrame.addView(v);

//                this.intent = new Intent(getApplicationContext(),Popup.class);
//                this.intent.putExtra("scoreName",getScoreName());
//                this.intent.putExtra("card1",slist.get(0).getName());
//                this.intent.putExtra("card2",slist.get(1).getName());
//                this.intent.putExtra("card1State",slist.get(0).isState());
//                this.intent.putExtra("card2State",slist.get(1).isState());
//
//                startActivity(this.intent);

            this.slist = new ArrayList<ShuitdaDTO>();
        }
    }
}
