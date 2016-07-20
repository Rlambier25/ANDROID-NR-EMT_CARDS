package com.example.guest.nr_studyapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.nr_studyapp.R;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flipview.FlipView;


/**
 * Created by Guest on 7/19/16.
 */
public class FlipViewAdapter extends RecyclerView.Adapter<FlipViewAdapter.FlipViewHolder> {

    private static final String TAG = FlipViewAdapter.class.getSimpleName();
    private List<String> mItems = new ArrayList<>();

    public FlipViewAdapter(List<String> items) {
       mItems = items;
    }

    public String getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public FlipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flash_card_flipview, parent, false);
        Log.d(TAG, "onCreateViewHolder");
        return new FlipViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(FlipViewHolder holder, int position) {
        Log.d(TAG, "Binding position "+position);
        Log.d(TAG, "onBindViewHolder: " + getItem(position));
        holder.mFlipView.setFrontText(getItem(0));
        holder.mFlipView.setRearText(getItem(1));
    }

    /**
     * Provide a reference to the views for each data item.
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    static final class FlipViewHolder extends RecyclerView.ViewHolder {

        FlipView mFlipView;

        public FlipViewHolder(View view) {
            super(view);
            this.mFlipView = (FlipView) view.findViewById(R.id.flip_view);
        }

    }

}
