package com.yongchul.suitdagenealogy.modules.common;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.yongchul.suitdagenealogy.model.MessageDTO;


public class CustomHandler extends Handler {

    public static final int ALERT_WINDOW_CODE = 1;
    public static final int MAIN_GETPHOTO = 2;
    public static final int MAIN_PAGER_CODE = 3;
    public static final int INTRO = 4;
    public static final int TOKEN_CODE = 5;
    public static final int PHOTO_CODE = 6;
    public static final int SETTING_GET_CODE = 7;
    public static final int MAIN_NOTICE = 8;
    public static final int LOGIN_CODE = 9;



    private Context c;

    public CustomHandler(Context c) {
        this.c = c;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what) {

            case ALERT_WINDOW_CODE :
                MessageDTO mDTO = (MessageDTO)msg.obj;
                this.baseAlertMessage(mDTO.getSubject(),mDTO.getContent());
                break;

            case TOKEN_CODE:
                ((IntroActivity)this.c).moveMain();
                break;

        }
    }

    //기본알럿창
    private void baseAlertMessage (String subject , String content) {
        new MaterialDialog.Builder(this.c).title(subject)
                .content(content)
                .positiveText("OK").negativeText("cancel").theme(Theme.LIGHT).show();

    }

}
