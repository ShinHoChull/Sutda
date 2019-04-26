package com.yongchul.suitdagenealogy.model;

import java.io.Serializable;

public class MainGetPhotoDTO implements Serializable {

    private int sid;
    private String url;
    private String deviceid;

    public MainGetPhotoDTO(int sid, String url, String deviceid) {
        this.sid = sid;
        this.url = url;
        this.deviceid = deviceid;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getSid() {
        return sid;
    }

    public String getUrl() {
        return url;
    }

    public String getDeviceid() {
        return deviceid;
    }
}
