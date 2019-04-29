package com.yongchul.suitdagenealogy.model;

/**
 * Created by shinyongchul on 16. 4. 19..
 */
public class ShuitdaDTO {
    private int name;
    private boolean state;

    public ShuitdaDTO(int name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public int getName() {
        return name;
    }

    public boolean isState() {
        return state;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
