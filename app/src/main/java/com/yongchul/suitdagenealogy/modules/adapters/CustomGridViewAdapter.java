package com.yongchul.suitdagenealogy.modules.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.modules.common.Globar;


public class CustomGridViewAdapter extends BaseAdapter {

    private Integer[] mainIcon = {
            R.drawable.one,
            R.drawable.one_,
            R.drawable.two,
            R.drawable.two_,
            R.drawable.three,
            R.drawable.three_,
            R.drawable.four,
            R.drawable.four_,
            R.drawable.five,
            R.drawable.five_,
            R.drawable.six,
            R.drawable.six_,
            R.drawable.seven,
            R.drawable.seven_,
            R.drawable.eight,
            R.drawable.eight_,
            R.drawable.nine,
            R.drawable.nine_,
            R.drawable.ten,
            R.drawable.ten_,
    };

    private Integer[] tags = {
            1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10
    };

    private Globar g;
    private Context c;
    private LayoutInflater inflater;


    public CustomGridViewAdapter(Context c, LayoutInflater inflater) {
        this.c = c;
        this.g = new Globar(c);
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return this.mainIcon.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if ( convertView == null ) {
            Log.d("choiceImg",""+position);
            convertView = this.inflater.inflate(R.layout.main_grid_item,parent,false);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.main_grid_img);

            ViewGroup.LayoutParams param = convertView.getLayoutParams();
            if(param == null) {
                param = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
            param.width = this.g.w(90);
            param.height = this.g.h(90);
            convertView.setTag(this.tags[position]);
            convertView.setLayoutParams(param);
            imageView.setImageResource(this.mainIcon[position]);
            convertView.setBackgroundResource(R.color.main_color_white);
        }

        return convertView;
    }
}
