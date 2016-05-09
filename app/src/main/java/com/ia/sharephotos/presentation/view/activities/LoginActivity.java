package com.ia.sharephotos.presentation.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseActivity;
import com.ia.sharephotos.presentation.view.fragments.home.HomeFragment;
import com.ia.sharephotos.presentation.view.fragments.login.LoginFragment;

/**
 * Created by ysantana on 28/03/2016.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new LoginFragment().newInstance())
                    .commit();
        }
    }
}