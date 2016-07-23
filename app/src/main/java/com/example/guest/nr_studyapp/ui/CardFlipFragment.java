package com.example.guest.nr_studyapp.ui;




import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.nr_studyapp.Constants;
import com.example.guest.nr_studyapp.R;
import com.example.guest.nr_studyapp.adapters.FlipViewAdapter;
import com.example.guest.nr_studyapp.models.FlashCard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CardFlipFragment extends Fragment implements View.OnClickListener {
    private Boolean mShowingBack = false;
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    private FlashCard mFlashCard;
//    @Bind(R.id.saveCard) Button mSaveButton;

    public static CardFlipFragment newInstance(FlashCard flashCard) {
        CardFlipFragment cardFlipFragment = new CardFlipFragment();
        Bundle args = new Bundle();
        args.putParcelable("flashCard", Parcels.wrap(flashCard));
        cardFlipFragment.setArguments(args);
        return cardFlipFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFlashCard = Parcels.unwrap(getArguments().getParcelable("flashCard"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_card_flip, container, false);
        ButterKnife.bind(this, view);

        List<String> items = new ArrayList();
        items.add(mFlashCard.getTerm());
        items.add(mFlashCard.getDefinition());
        FlipViewAdapter adapter = new FlipViewAdapter(items, R.layout.flash_card_flipview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);

//        mSaveButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
//        if(v == mSaveButton) {
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            String uid = user.getUid();
//            DatabaseReference cardRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(Constants.FIREBASE_CHILD_CARDS)
//                    .child(uid);
//
//            DatabaseReference pushRef = cardRef.push();
//            String pushId = pushRef.getKey();
//            mFlashCard.setPushId(pushId);
//            pushRef.setValue(mFlashCard);
//
//            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
//        }
    }
}


