package com.ia.sharephotos.presentation.model;

/**
 * Created by ysantana on 28/03/2016.
 */
public class PhotoModel {

    private int photo;
    private String comentario;
    private String nameUser;

    public PhotoModel(int photo, String comentario, String nameUser) {
        this.photo = photo;
        this.comentario = comentario;
        this.nameUser = nameUser;
    }

    public int getPhoto() {
        return photo;
    }

    public String getComentario() {
        return comentario;
    }

    public String getNameUser() {
        return nameUser;
    }
}