package com.ia.sharephotos.presentation.view.fragments.my_album;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.PhotoModel;
import com.ia.sharephotos.presentation.view.BaseFragment;
import com.ia.sharephotos.presentation.view.adapters.MyAlbumAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;

/**
 * Created by ysantana on 30/03/2016.
 */
public class MyAlbumFragment extends BaseFragment {

    private MyAlbumAdapter mAdpter;

    public static MyAlbumFragment newInstance() {
        return new MyAlbumFragment();
    }

    @Bind(R.id.photos)
    RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_album, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdpter = new MyAlbumAdapter(getActivity(), getData());
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecycler.setAdapter(mAdpter);
    }

    private List<PhotoModel> getData() {
        List<PhotoModel> mPhotosList = new ArrayList<>();
        mPhotosList.add(new PhotoModel(R.drawable.foto3, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto1, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto2, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto4, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto5, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto7, "", ""));
        mPhotosList.add(new PhotoModel(R.drawable.foto8, "", ""));
        return mPhotosList;
    }
}