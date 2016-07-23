package com.example.guest.nr_studyapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.guest.nr_studyapp.Constants;
import com.example.guest.nr_studyapp.R;
import com.example.guest.nr_studyapp.models.FlashCard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flipview.FlipView;


/**
 * Created by Guest on 7/19/16.
 */
public class FlipViewAdapter extends RecyclerView.Adapter<FlipViewAdapter.FlipViewHolder> implements View.OnClickListener{

    private static final String TAG = FlipViewAdapter.class.getSimpleName();
    private List<String> mItems = new ArrayList<>();
    private static int mLayout;

    public FlipViewAdapter(List<String> items, int layout) {

        mItems = items;
        mLayout = layout;
    }

    public String getItem(int position) {

        return mItems.get(position);
    }

    @Override
    public FlipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(mLayout, parent, false);
        Log.d(TAG, "onCreateViewHolder");
        return new FlipViewHolder(view);
    }

    @Override
    public int getItemCount() {

        return 1;
    }

    @Override
    public void onBindViewHolder(FlipViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " +mLayout);
        Log.d(TAG, "Binding position "+position);
        Log.d(TAG, "onBindViewHolder: " + getItem(position));
        holder.mFlipView.setFrontText(getItem(0));
        holder.mFlipView.setRearText(getItem(1));
        if(mLayout == 2130968609){
            holder.mSave.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference cardRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_CARDS)
                    .child(uid);

            FlashCard flashCard = new FlashCard(getItem(0), getItem(1));

            DatabaseReference pushRef = cardRef.push();
            String pushId = pushRef.getKey();
            flashCard.setPushId(pushId);
            pushRef.setValue(flashCard);

//            Toast.makeText(, "Saved", Toast.LENGTH_SHORT).show();
    }

    /**
     * Provide a reference to the views for each data item.
     * Complex data items may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    static final class FlipViewHolder extends RecyclerView.ViewHolder {

        FlipView mFlipView;
        Button mSave;

        public FlipViewHolder(View view) {
            super(view);
            this.mFlipView = (FlipView) view.findViewById(R.id.flip_view);

            if(mLayout == 2130968609){
                this.mSave = (Button) mFlipView.findViewById(R.id.saveCard);
            }

        }
    }
}
