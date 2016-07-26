package com.example.guest.nr_studyapp.ui;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.guest.nr_studyapp.R;
import com.example.guest.nr_studyapp.adapters.CardListAdapter;
import com.example.guest.nr_studyapp.models.FlashCard;
import com.example.guest.nr_studyapp.services.FlashCardService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SavedCardActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private CardListAdapter mAdapter;
    public static final String TAG = FlashCardListActivity.class.getSimpleName();
    public ArrayList<FlashCard> mCards = new ArrayList<>();
    private DatabaseReference mCardReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_card);
        ButterKnife.bind(this);
        getTerms();
    }

    private void getTerms() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();


        mCardReference = FirebaseDatabase.getInstance().getReference("cards");
        Query queryRef = mCardReference.child(uid);
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                Log.d(TAG, "onChildAdded: " + snapshot.getValue(FlashCard.class).getTerm());
                mCards.add(snapshot.getValue(FlashCard.class));
                setAdapter();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                mCards.remove(dataSnapshot.getValue(FlashCard.class));
                setAdapter();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }

    void setAdapter() {
        SavedCardActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String[] cardCategories = new String[mCards.size()];
                for (int i = 0; i < cardCategories.length; i++) {
                    cardCategories[i] = mCards.get(i).getTerm();
                }
                mAdapter = new CardListAdapter(getApplicationContext(), mCards);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SavedCardActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
            }

//                            ArrayAdapter adapter = new ArrayAdapter(FlashCardActivity.this,
//                                    android.R.layout.simple_expandable_list_item_1, cardCategories);
//                            mFlashCards.setAdapter(adapter);
//                       }
            //                    }
        });
    }
}

