package com.ia.sharephotos.presentation.view.activities;

import android.os.Bundle;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseActivity;
import com.ia.sharephotos.presentation.view.fragments.home.CommentsFragment;

/**
 * Created by ysantana on 31/03/2016.
 */
public class CommentsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new CommentsFragment().newInstance())
                    .commit();
        }
    }
}