package com.ia.sharephotos.presentation.model;

/**
 * Created by ysantana on 28/03/2016.
 */
public class PhotoModel {

    private int photo;
    private String comentario;

    public PhotoModel(int photo, String comentario) {
        this.photo = photo;
        this.comentario = comentario;
    }

    public int getPhoto() {
        return photo;
    }

    public String getComentario() {
        return comentario;
    }
}