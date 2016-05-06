package com.ia.sharephotos.presentation.view.fragments.login;

import android.content.Context;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IFacebook;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IFacebookView;
import java.util.Arrays;

/**
 * Created by ysantana on 05/04/2016.
 */
public class Facebook implements IFacebook {

    private Context mContext;
    private CallbackManager callbackManager;
    private LoginButton mLoginButton;
    private IFacebookView mListener;
    private ProfileTracker profileTracker;

    public Facebook(Context context, IFacebookView listener) {
        mContext = context;
        mListener = listener;
        FacebookSdk.sdkInitialize(mContext);
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    public void onInitFacebook(LoginButton loginButton) {
        mLoginButton=loginButton;
        mLoginButton.setReadPermissions(Arrays.asList("public_profile, email"));
        mLoginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        getUserData();
                    }
                    @Override
                    public void onCancel() {
                        mListener.onErrorLoginFacebook("Login cancelado.");
                    }
                    @Override
                    public void onError(FacebookException e) {
                        mListener.onErrorLoginFacebook("Error:" + e.getMessage());
                    }
                });

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                getUserData();
            }
        };
    }

    @Override
    public void onResumeFacebook() {
        AppEventsLogger.activateApp(mContext);
        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
            getUserData();
        }
    }

    @Override
    public void onPauseFacebook() {
        AppEventsLogger.deactivateApp(mContext);
    }

    @Override
    public void onDestroyFacebook() {
        profileTracker.stopTracking();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void getUserData() {
        mListener.onGetProfileFacebook(Profile.getCurrentProfile());
    }
}