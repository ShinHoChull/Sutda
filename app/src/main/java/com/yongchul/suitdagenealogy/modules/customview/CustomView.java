package com.yongchul.suitdagenealogy.modules.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.modules.common.Globar;

public class CustomView extends LinearLayout {

    private int x,y,w,h;

    private WindowManager wm;

    public int deviceW = 0;
    public int deviceH = 0;
    private Context a;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context,attrs);
    }

    private void initView(Context c , AttributeSet a) {
        this.a = c;
        wm = (WindowManager) c.getSystemService(c.WINDOW_SERVICE);
        this.deviceW = this.getDeviceW();
        this.deviceH = this.getDeviceH();


        TypedArray t = c.obtainStyledAttributes(a, R.styleable.CustomView);

        this.w = this.w(t.getInt(R.styleable.CustomView_w,0));
        this.h = this.h(t.getInt(R.styleable.CustomView_h,0));
        boolean isSchedule = (boolean)t.getBoolean(R.styleable.CustomView_isSchedule,false);
        if ( isSchedule == true ) {
            this.h = this.w(t.getInt(R.styleable.CustomView_w,0));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        if(this.w>0)
            widthMeasureSpec=w;
        if(this.h>0)
            heightMeasureSpec=h;
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    private DisplayMetrics dM() {
        DisplayMetrics dm = new DisplayMetrics();
        this.wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    private int getDeviceW() {
        return this.dM().widthPixels;
    }

    private int getDeviceH() {
        return this.dM().heightPixels - this.getStatusBarHeight();
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = this.a.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = this.a.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public int w(int x) {
        return (int) (this.deviceW * (x / Globar.default_W));
    }

    public int h(int x) {
        return (int) (this.deviceH * (x / Globar.default_H));
    }
}
