package com.yongchul.suitdagenealogy.modules.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.modules.common.Globar;

public class CustomTabLayout extends TabLayout {

    private int x,y,w,h;

    private View view;
    private Context c;
    private Globar g;


    public CustomTabLayout(@NonNull Context context) {
        super(context);
    }
    public CustomTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context,attrs);
    }

    public void init(Context c , AttributeSet a) {
        this.g = new Globar(c);
        this.c = c;

        TypedArray t = c.obtainStyledAttributes(a, R.styleable.CustomTabLayout);

        this.w = g.w(t.getInt(R.styleable.CustomTabLayout_w,0));//t.getInt(R.styleable.CustomImgView_w,0) * width / 720;
        this.h = g.h(t.getInt(R.styleable.CustomTabLayout_h,0));//t.getInt(R.styleable.CustomImgView_h,0) * height / 1280;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        if(this.w > 0) {
            widthMeasureSpec = this.w;
            getLayoutParams().width = this.w;
        }

        if(this.h > 0) {
            heightMeasureSpec = this.h;
            getLayoutParams().height = this.h;
        }
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }



}
