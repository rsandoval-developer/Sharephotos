package com.ia.sharephotos.presentation.view.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseFragment;

/**
 * Created by ysantana on 31/03/2016.
 */
public class CommentsFragment extends BaseFragment {

    public static CommentsFragment newInstance() {
        return new CommentsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_comments, container, false);
        return v;
    }
}
