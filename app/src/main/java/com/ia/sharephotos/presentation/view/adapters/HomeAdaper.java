package com.ia.sharephotos.presentation.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.PhotoModel;
import com.ia.sharephotos.presentation.view.activities.DetailPhotoActivity;

import java.util.List;

/**
 * Created by ysantana on 28/03/2016.
 */
public class HomeAdaper extends RecyclerView.Adapter<HomeAdaper.itemViewHolder> {

    private Context mContext;
    private List<PhotoModel> mLlist;

    public HomeAdaper(Context context, List<PhotoModel> list) {
        mContext = context;
        mLlist = list;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        final PhotoModel item = mLlist.get(position);
        holder.mPhoto.setImageResource(item.getPhoto());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailPhotoActivity.class)
                        .putExtra(DetailPhotoActivity.EXTRA_PHOTO, item.getPhoto());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLlist.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ImageView mPhoto;

        public itemViewHolder(View v) {
            super(v);
            mView = v;
            mPhoto = (ImageView) v.findViewById(R.id.photo);
        }
    }
}