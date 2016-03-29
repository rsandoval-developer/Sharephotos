package com.ia.sharephotos.presentation.model;

/**
 * Created by ysantana on 28/03/2016.
 */
public class CommentModel {
    private String name;
    private int image;
    private String comment;

    public CommentModel(String name, int image, String comment) {
        this.name = name;
        this.image = image;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getComment() {
        return comment;
    }
}