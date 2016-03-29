package com.ia.sharephotos.presentation.view.activities;

import android.os.Bundle;

import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseActivity;
import com.ia.sharephotos.presentation.view.fragments.home.DetailPhotoFragment;

/**
 * Created by ysantana on 28/03/2016.
 */
public class DetailPhotoActivity extends BaseActivity {

    public static final String EXTRA_PHOTO = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null && getIntent().hasExtra(EXTRA_PHOTO)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new DetailPhotoFragment().newInstance(getIntent().getIntExtra(EXTRA_PHOTO, 0)))
                    .commit();
        }
    }
}