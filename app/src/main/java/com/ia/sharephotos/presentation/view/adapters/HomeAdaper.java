package com.ia.sharephotos.presentation.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.PhotoModel;
import com.ia.sharephotos.presentation.view.Utils;
import com.ia.sharephotos.presentation.view.activities.CommentsActivity;
import com.ia.sharephotos.presentation.view.activities.DetailPhotoActivity;
import java.util.List;

/**
 * Created by ysantana on 28/03/2016.
 */
public class HomeAdaper extends RecyclerView.Adapter<HomeAdaper.itemViewHolder> {

    private Context mContext;
    private List<PhotoModel> mLlist;
    private int lastPosition = -1;

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

        Utils.setAnimation(mContext, holder.mPhotosContainer, lastPosition, position);

        holder.mName.setText(item.getNameUser());
        Glide.with(mContext)
                .load(item.getPhoto())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.mPhoto);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.photo:
                        Intent intent = new Intent(mContext, DetailPhotoActivity.class)
                                .putExtra(DetailPhotoActivity.EXTRA_PHOTO, item.getPhoto());
                        mContext.startActivity(intent);
                        break;
                    case R.id.comments:
                        Intent intent1 = new Intent(mContext, CommentsActivity.class);
                        mContext.startActivity(intent1);
                        break;
                }
            }
        };

        holder.mPhoto.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mLlist.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mPhotosContainer;
        public ImageView mPhoto;
        public TextView mName;

        public itemViewHolder(View v) {
            super(v);
            mPhotosContainer = (LinearLayout) v.findViewById(R.id.photo_container);
            mPhoto = (ImageView) v.findViewById(R.id.photo);
            mName = (TextView) v.findViewById(R.id.name);
        }
    }
}