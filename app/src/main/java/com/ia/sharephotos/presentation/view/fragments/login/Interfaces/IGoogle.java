package com.ia.sharephotos.presentation.view.fragments.login.Interfaces;

import android.content.Intent;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ysantana on 30/03/2016.
 */
public interface IGoogle {
    void onInitAOuth(SignInButton signInButton, GoogleSignInOptions gso, GoogleApiClient googleApiClient);

    void onStartAOuth();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSignInAOth();

    void onSignOutAOth();

    void onRevokeAccess();
}