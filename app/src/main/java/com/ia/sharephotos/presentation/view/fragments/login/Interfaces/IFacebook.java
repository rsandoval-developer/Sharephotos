package com.ia.sharephotos.presentation.view.fragments.login.Interfaces;

import android.content.Intent;
import com.facebook.login.widget.LoginButton;

/**
 * Created by ysantana on 30/03/2016.
 */
public interface IFacebook {

    void onInitFacebook(LoginButton loginButton);

    void onResumeFacebook();

    void onPauseFacebook();

    void onDestroyFacebook();

    void onActivityResult(int requestCode, int resultCode, Intent data);
}