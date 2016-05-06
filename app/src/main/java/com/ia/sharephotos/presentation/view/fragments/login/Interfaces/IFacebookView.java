package com.ia.sharephotos.presentation.view.fragments.login.Interfaces;

import com.facebook.Profile;

/**
 * Created by ysantana on 30/03/2016.
 */
public interface IFacebookView {
    void onErrorLoginFacebook(String error);
    void onGetProfileFacebook(Profile profile);
}