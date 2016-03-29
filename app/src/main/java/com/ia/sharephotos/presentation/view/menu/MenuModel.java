package com.ia.sharephotos.presentation.view.menu;

/**
 * Created by ysantana on 28/03/2016.
 */
public class MenuModel {

    private String title;
    private int icon;

    public MenuModel(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}