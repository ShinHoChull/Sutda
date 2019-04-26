
package com.yongchul.suitdagenealogy.modules.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.yongchul.suitdagenealogy.R;


import java.util.HashMap;
import java.util.Random;

public class Globar {

    public String mainUrl = "http://knpa.m2comm.co.kr";
    public String baseUrl = "http://knpa.m2comm.co.kr/app/2019spring/php";
    public String code = "knpa";
    public static String CONTENT_TITLE = "2019 춘계학술대회";
    public String userCodeUrl = "http://121.254.129.104/voting_0523/insert_device.asp";
    public String eventCode = "knpa";
    public String voting_ip = "121.254.129.104";
    public int voting_port = 13001;

    public static double default_W = 360;
    public static double default_H = 640;

    public int deviceW = 0;
    public int deviceH = 0;
    public int statusBar = 0;

    private Context a;
    private WindowManager wm;

    private String[] exts = {"pptx", "docx", "doc", "hwp", "xlsx"};
    private String[] imgExts = {"jpeg", "gif", "jpeg", "jpg", "png"};
    public int[] info_color = {
            Color.rgb(230, 242, 255),
            Color.rgb(255, 231, 233),
            Color.rgb(222, 240, 226),
            Color.rgb(229, 242, 255),
            Color.rgb(254, 231, 233),
            Color.rgb(222, 240, 226),
            Color.rgb(229, 242, 255),
            Color.rgb(230, 242, 255),
            Color.rgb(255, 231, 233),
            Color.rgb(222, 240, 226),
            Color.rgb(229, 242, 255),
            Color.rgb(254, 231, 233),
            Color.rgb(222, 240, 226),
            Color.rgb(229, 242, 255)
    };



    public Globar(Context c) {
        this.a = c;
        this.wh_setting(c);
    }

    public boolean extPDFSearch(String ext) {
        if (ext.contains("pdf")) {
            return true;
        }
        return false;
    }

    public boolean extSearch(String ext) {
        for (String s : exts) {
            if (ext.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean imgExtSearch(String ext) {
        for (String s : imgExts) {
            if (ext.contains(s)) {
                return true;
            }
        }
        return false;
    }


    private DisplayMetrics dM() {
        DisplayMetrics dm = new DisplayMetrics();
        this.wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    private void wh_setting(Context c) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) c.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(displayMetrics);

        int statusBarHeight = 0;

        int resId = c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            statusBarHeight = c.getResources().getDimensionPixelSize(resId);
        }

        WindowManager windowManager = (WindowManager)c.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        if ( Build.MODEL.equals("SM-G973N") ) {
            statusBarHeight = 0;
        }
        this.deviceW = size.x;
        this.deviceH = size.y - statusBarHeight;
    }

    public int x(int x) {
        return (int) (this.deviceW * (x / default_W));
    }

    public int y(int x) {
        return (int) (this.deviceH * (x / default_H));
    }

    public int w(int x) {
        return (int) (this.deviceW * (x / default_W));
    }

    public int h(int x) {
        return (int) (this.deviceH * (x / default_H));
    }

    public int dpToPixel(int dp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, a.getResources().getDisplayMetrics());
        return px;
    }

    //View get X , Y
    public Point getPointView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }

    public double setTextSize(int fontize) {
        double size_formatter = (double) fontize / this.default_W;
        double deviceW;
        if (this.deviceW > 720) {
            deviceW = (double) this.deviceW / 3;
        } else {
            deviceW = (double) this.deviceW / 2;
        }
        return (int) deviceW * size_formatter;
    }

    public void msg(String msg) {
        Toast.makeText(this.a, msg, Toast.LENGTH_SHORT).show();
    }


    public JsonElement getParser(String url) throws Exception {
        HttpConnection hc = new HttpConnection();
        String getData = hc.request(url);
        JsonParser json = new JsonParser();
        return json.parse(getData);
    }

    public String[] mainUrls = {
            "/about/greetings.php", "/program/list.php", "/abstract/index.php",
            "/program/highlights.php", "/feedback/feedback_01.php", "/about/floor.php"
            ,"/bbs/list.php","/about/booth.php",""
    };


    public String[][] linkUrl = {
            {"/about/greetings.php","/about/welcome.php"},
            {"/program/glance.php?tab=11","/program/list.php?tab=11","/program/list.php?tab=12"},
            {"/abstract/index.php?tab=1","/abstract/index.php?tab=2","/abstract/list.php"},//Faculty
            {"/program/highlights.php"},
            {"/feedback/feedback_01.php"},
            {"/about/floor.php","/about/map.php"},
            {"/bbs/list.php"},
            {"/about/booth.php"}
    };

    public HashMap<String, String> urls = new HashMap<String, String>() {
        {
            put("glance1", "/program/glance.php?tab=11");
            put("glance2", "/program/glance.php?tab=12");
            put("now", "/program/list.php?tab=999");
            put("program", "/program/list.php?tab=11");
            put("schedule", "/program/favorite.php");
            put("search", "/program/search.php");
            put("fav","/program/favorite.php");
            put("getNoti", "/noti.php");
            put("notiView","/bbs/view.php");

            put("intro", "/banner/list.php?gubun=2&code="+code);//intro
            put("session", "/session/list.php?code="+code);
            put("abstract", "/abstract/list.php?code="+code); //산하연구회 소개
            put("faculty", "/faculty/list.php?code="+code);//산하연구회 회칙
            put("notice", "/bbs/list.php?code="+code);
            put("getPhoto", "/photo.php");
            put("photo","http://knpa.m2comm.co.kr/upload/gallery/");
            put("photoUpload", "/photo_upload.php");
            put("login", "/login.php");
            put("photoDel", "/del_photo.php");


            put("photoGet", "/photo/get_photo.php");
            put("photoLike", "/photo/set_favor.php");
            put("getPush", "/get_push.php");
            put("setPush", "/set_push.php");

            put("setToken", "/token.php");
            put("detailNoti", "/bbs/view.php?code="+code);

            put("boothEvent", "/contents/booth_attend.php");
            put("myMemo", "/session/list.php?tab=-6&code="+code);
            put("MainPhotoTitleList", "/photo/index.php");//MainPhoto title 리스트

            put("researchPhoto", "/research/photo.php");
            put("notiView", "/bbs/view.php");
            put("appInfo", "/app_info.php");

        }
    };

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public String zeroPoint(String data) {
        data = data.trim();
        if (data.length() == 1) {
            data = "0" + data;
        }
        return data;
    }

    //기본알럿창
    public void baseAlertMessage(String subject, String content) {
        new MaterialDialog.Builder(this.a).title(subject)
                .content(content)
                .positiveText("OK").negativeText("Cancle").theme(Theme.LIGHT).show();
    }


}
