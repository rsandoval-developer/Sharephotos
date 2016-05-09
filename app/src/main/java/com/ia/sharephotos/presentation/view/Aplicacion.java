package com.ia.sharephotos.presentation.view;

import android.app.Application;
import com.facebook.Profile;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by ysantana on 28/03/2016.
 */
public class Aplicacion extends Application {

    private Profile profileFacebook;
    private GoogleSignInAccount googleSignInAccount;

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

    public GoogleSignInAccount getGoogleSignInAccount() {
        return googleSignInAccount;
    }

    public void setGoogleSignInAccount(GoogleSignInAccount googleSignInAccount) {
        this.googleSignInAccount = googleSignInAccount;
    }
}