package com.ia.sharephotos.presentation.view;

import android.app.Application;
import com.facebook.Profile;

/**
 * Created by ysantana on 28/03/2016.
 */
public class Aplicacion extends Application {

    private Profile profileFacebook;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Profile getProfileFacebook() {
        return profileFacebook;
    }

    public void setProfileFacebook(Profile profileFacebook) {
        this.profileFacebook = profileFacebook;
    }
}