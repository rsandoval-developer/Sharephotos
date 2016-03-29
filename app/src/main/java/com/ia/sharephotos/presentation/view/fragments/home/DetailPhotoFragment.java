package com.ia.sharephotos.presentation.view.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.CommentModel;
import com.ia.sharephotos.presentation.view.BaseFragment;
import com.ia.sharephotos.presentation.view.adapters.CommentsAdapter;
import org.fluttercode.datafactory.impl.DataFactory;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;

/**
 * Created by ysantana on 28/03/2016.
 */
public class DetailPhotoFragment extends BaseFragment {

    private static String ARG_PHOTO = "photo";
    private CommentsAdapter mAdapter;
    private int photo;

    public static DetailPhotoFragment newInstance(int photo) {
        DetailPhotoFragment fragment = new DetailPhotoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PHOTO, photo);
        fragment.setArguments(args);
        return fragment;
    }

    @Bind(R.id.photo)
    ImageView mPhoto;

    @Bind(R.id.comments)
    RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_photo, container, false);
        if (getArguments() != null) {
            photo = getArguments().getInt(ARG_PHOTO);
        }
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPhoto.setImageResource(photo);

        mAdapter = new CommentsAdapter(getActivity(), getData());
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(mAdapter);
    }

    private List<CommentModel> getData() {
        List<CommentModel> mCommentsList = new ArrayList<>();
        DataFactory mFactory = new DataFactory();

        for (int i = 1; i <= 15; i++) {
            String name = mFactory.getFirstName() + " " + mFactory.getLastName();
            int imagen = (i % 2 == 0) ? R.drawable.user1 : R.drawable.user2;
            String comment = mFactory.getRandomText(50);
            mCommentsList.add(new CommentModel(name, imagen, comment));
        }
        return mCommentsList;
    }
}