package com.ia.sharephotos.presentation.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.widget.LoginButton;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.Aplicacion;
import com.ia.sharephotos.presentation.view.fragments.login.Facebook;
import com.ia.sharephotos.presentation.view.fragments.login.Interfaces.IFacebookView;

/**
 * Created by ysantana on 29/03/2016.
 */
public class LoginActivity extends AppCompatActivity implements IFacebookView {

    private LoginButton loginButton;
    private Facebook facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebook = new Facebook(this, this);
        setContentView(R.layout.activity_login);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        facebook.onInitFacebook(loginButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        facebook.onResumeFacebook();
    }

    @Override
    protected void onPause() {
        super.onPause();
        facebook.onPauseFacebook();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        facebook.onDestroyFacebook();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = data;
        facebook.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onErrorLoginFacebook(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetProfileFacebook(Profile profile) {
        boolean enableButtons = AccessToken.getCurrentAccessToken() != null;
        if (enableButtons && profile != null) {

            //TODO: GUARDAR EN LA APLICACION EL PERFIL DE USUARIO
            ((Aplicacion) getApplication()).setProfileFacebook(profile);

            //TODO: DIRECCIONAR A HOME
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}