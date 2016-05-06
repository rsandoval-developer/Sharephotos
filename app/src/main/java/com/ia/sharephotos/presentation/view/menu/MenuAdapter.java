package com.ia.sharephotos.presentation.view.menu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ia.sharephotos.R;
import com.ia.sharephotos.presentation.view.activities.MyAlbumActivity;

import java.util.List;

/**
 * Created by ysantana on 28/03/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.itemViewHolder> {

    private Context mcContext;
    private List<MenuModel> mList;
    private MenuListener mListener;

    public MenuAdapter(Context context,List<MenuModel> list, MenuListener listener) {
        mcContext = context;
        mList = list;
        mListener = listener;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, final int position) {
        MenuModel item = mList.get(position);
        holder.mIcon.setImageResource(item.getIcon());
        holder.mName.setText(item.getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.closeDrawers();

                switch (position) {
                    case 0:
                        if (!(mcContext instanceof MyAlbumActivity)) {
                            Intent intent = new Intent(mcContext, MyAlbumActivity.class);
                            mcContext.startActivity(intent);
                        }
                        break;
                    case 1:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView mIcon;
        public TextView mName;

        public itemViewHolder(View v) {
            super(v);
            mView = v;
            mIcon = (ImageView) v.findViewById(R.id.icon);
            mName = (TextView) v.findViewById(R.id.name);
        }
    }
}