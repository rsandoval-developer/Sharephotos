package com.ia.sharephotos.presentation.view.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.PhotoModel;
import com.ia.sharephotos.presentation.view.BaseFragment;
import com.ia.sharephotos.presentation.view.adapters.HomeAdaper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ysantana on 28/03/2016.
 */
public class HomeFragment extends BaseFragment {

    private List<PhotoModel> mPhotosList = new ArrayList<>();
    private HomeAdaper mAdapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Bind(R.id.photos)
    RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPhotosList.add(new PhotoModel(R.drawable.foto3,""));
        mPhotosList.add(new PhotoModel(R.drawable.foto1,""));
        mPhotosList.add(new PhotoModel(R.drawable.foto2,""));
        mPhotosList.add(new PhotoModel(R.drawable.foto4,""));

        mAdapter = new HomeAdaper(getActivity(), mPhotosList);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(mAdapter);
    }
}