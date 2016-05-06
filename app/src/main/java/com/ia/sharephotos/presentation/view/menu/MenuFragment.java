package com.ia.sharephotos.presentation.view.menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.BaseFragment;
import java.util.ArrayList;

/**
 * Created by ysantana on 28/03/2016.
 */
public class MenuFragment extends BaseFragment {

    private ArrayList<MenuModel> mItemsList = new ArrayList<>();
    private RecyclerView mRecycler;
    private MenuAdapter mAdapter;
    private MenuListener menuListener;

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        mRecycler = (RecyclerView) v.findViewById(R.id.recycler_menu);

        mItemsList.add(new MenuModel(getString(R.string.mi_album), R.drawable.ic_album));
        mItemsList.add(new MenuModel(getString(R.string.tabla_posiciones), R.drawable.ic_ratings_photos));

        mAdapter = new MenuAdapter(getActivity(), mItemsList, menuListener);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecycler.setAdapter(mAdapter);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            menuListener = (MenuListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }
}