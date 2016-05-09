package com.ia.sharephotos.presentation.view.fragments.login.Interfaces;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;

/**
 * Created by ysantana on 30/03/2016.
 */
public interface IGoogleView {
    void onErrorLoginAOuth(String error);
    void onGetProfileAOuth(GoogleSignInResult result);
    void onSignInAOth();

    void onSignOutAOth();

    void onRevokeAccess();
}