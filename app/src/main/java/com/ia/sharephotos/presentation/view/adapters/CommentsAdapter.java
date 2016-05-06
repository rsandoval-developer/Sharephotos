package com.ia.sharephotos.presentation.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.model.CommentModel;
import java.util.List;

/**
 * Created by ysantana on 28/03/2016.
 */
public class CommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<CommentModel> mList;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    public CommentsAdapter(Context context, List<CommentModel> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_header, parent, false);
            return new HeaderViewHolder(v);
        } else {
            if (viewType == TYPE_ITEM) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
                return new ItemViewHolder(v);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof HeaderViewHolder) {
                HeaderViewHolder headerViewHolder=(HeaderViewHolder)holder;

            } else {
            if (holder instanceof ItemViewHolder) {
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                CommentModel item = mList.get(position - 1);

                itemViewHolder.mName.setText(item.getName());
                itemViewHolder.mComment.setText(item.getComment());
                itemViewHolder.mPostTime.setText(item.getPost_time());
                itemViewHolder.mImage.setImageResource(item.getImage());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View v) {
            super(v);

        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mComment;
        public TextView mName;
        public TextView mPostTime;

        public ItemViewHolder(View v) {
            super(v);
            mImage = (ImageView) v.findViewById(R.id.image);
            mName = (TextView) v.findViewById(R.id.name);
            mComment = (TextView) v.findViewById(R.id.comment);
            mPostTime = (TextView) v.findViewById(R.id.post_time);
        }
    }
}