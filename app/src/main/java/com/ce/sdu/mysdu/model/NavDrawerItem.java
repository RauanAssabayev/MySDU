package com.ce.sdu.mysdu.model;

/**
 * Created by Rauan on 07/02/17.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    public NavDrawerItem() {}
    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }
    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
