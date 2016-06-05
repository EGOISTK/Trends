package com.egoistk.trends.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.egoistk.trends.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] mData;

    public RecyclerAdapter(String[] data) {
        mData = data;
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, getPosition());
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mData[position] != null) {
            String username = mData[position].split(" ")[0];
            ((TextView) holder.itemView.findViewById(R.id.tv_content_in_cardView)).setText(mData[position].substring(username.length() + 1) + "\n");
            ((TextView) holder.itemView.findViewById(R.id.tv_username_in_cardView)).setText(username);
        } else {
            ((TextView) holder.itemView.findViewById(R.id.tv_content_in_cardView)).setText(null);
            ((TextView) holder.itemView.findViewById(R.id.tv_username_in_cardView)).setText(null);
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}
