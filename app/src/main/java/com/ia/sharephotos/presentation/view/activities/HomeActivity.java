package com.ia.sharephotos.presentation.view.activities;

import android.os.Bundle;

import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseActivity;
import com.ia.sharephotos.presentation.view.fragments.home.HomeFragment;

/**
 * Created by ysantana on 28/03/2016.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new HomeFragment().newInstance())
                    .commit();
        }
    }
}