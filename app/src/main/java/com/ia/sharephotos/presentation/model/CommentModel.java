package com.ia.sharephotos.presentation.model;

/**
 * Created by ysantana on 28/03/2016.
 */
public class CommentModel {
    private String name;
    private int image;
    private String comment;
    private String post_time;

    public CommentModel(String name, int image, String comment, String post_time) {
        this.name = name;
        this.image = image;
        this.comment = comment;
        this.post_time = post_time;
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

    public String getPost_time() {
        return post_time;
    }
}