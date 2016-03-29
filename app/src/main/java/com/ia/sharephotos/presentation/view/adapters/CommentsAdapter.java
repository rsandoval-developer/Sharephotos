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
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.itemViewHolder> {

    private Context mContext;
    private List<CommentModel> mList;

    public CommentsAdapter(Context context, List<CommentModel> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {
        CommentModel item = mList.get(position);
        holder.mName.setText(item.getName());
        holder.mComment.setText(item.getComment());
        holder.mImage.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mComment;
        public TextView mName;

        public itemViewHolder(View v) {
            super(v);
            mImage=(ImageView)v.findViewById(R.id.image);
            mName = (TextView) v.findViewById(R.id.name);
            mComment = (TextView) v.findViewById(R.id.comment);
        }
    }
}