package com.ia.sharephotos.presentation.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.PhotoModel;
import com.ia.sharephotos.presentation.view.Utils;
import com.ia.sharephotos.presentation.view.activities.DetailPhotoActivity;
import java.util.List;

/**
 * Created by ysantana on 30/03/2016.
 */
public class MyAlbumAdapter extends RecyclerView.Adapter<MyAlbumAdapter.itemViewHolder> {

    private Context mContext;
    private List<PhotoModel> mList;
    private int lastPosition = -1;

    public MyAlbumAdapter(Context context, List<PhotoModel> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_album_item, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        final PhotoModel item = mList.get(position);

        Utils.setAnimation(mContext, holder.mPhotosContainer, lastPosition, position);

        Glide.with(mContext)
                .load(item.getPhoto())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.mPhoto);

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
        return mList.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        private final View mView;
        public LinearLayout mPhotosContainer;
        public ImageView mPhoto;

        public itemViewHolder(View v) {
            super(v);
            mView = v;
            mPhotosContainer = (LinearLayout) v.findViewById(R.id.photo_container);
            mPhoto = (ImageView) v.findViewById(R.id.photo);

        }
    }
}