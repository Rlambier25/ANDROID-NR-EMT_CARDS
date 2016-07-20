package com.example.guest.nr_studyapp.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import com.example.guest.nr_studyapp.R;
import com.example.guest.nr_studyapp.adapters.CardListAdapter;
import com.example.guest.nr_studyapp.adapters.CardPagerAdapter;
import com.example.guest.nr_studyapp.models.FlashCard;
import com.example.guest.nr_studyapp.services.FlashCardService;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;



public class FlashCardActivity extends AppCompatActivity {

    private CardListAdapter mAdapter;
    public static final String TAG = FlashCardActivity.class.getSimpleName();
    public ArrayList<FlashCard> mCards = new ArrayList<>();
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private CardPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, flashcards);
//        mFlashCards.setAdapter(adapter);
            ButterKnife.bind(this);
            getTerms();


//        mFlashCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String flashcard = ((TextView) view).getText().toString();
//                Toast.makeText(FlashCardActivity.this, flashcard, Toast.LENGTH_LONG).show();
//            }
//        });
        }

    private void getTerms() {
        final FlashCardService flashCardService = new FlashCardService();
        flashCardService.findFlashCard(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)  {
                mCards = flashCardService.processResults(response);

                FlashCardActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapterViewPager = new CardPagerAdapter(getSupportFragmentManager(), mCards);
                        mViewPager.setAdapter(adapterViewPager);
                        mViewPager.setCurrentItem(1);
//                        String[] cardCategories = new String[mCards.size()];
//                        for (int i = 0; i < cardCategories.length; i++) {
//                            cardCategories[i] = mCards.get(i).getTerm();
//                        }
//                            mAdapter = new CardListAdapter(getApplicationContext(), mCards);
//                            mRecyclerView.setAdapter(mAdapter);
//                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FlashCardActivity.this);
//                            mRecyclerView.setLayoutManager(layoutManager);
//                            mRecyclerView.setHasFixedSize(true);
                        }
//                            ArrayAdapter adapter = new ArrayAdapter(FlashCardActivity.this,
//                                    android.R.layout.simple_expandable_list_item_1, cardCategories);
//                            mFlashCards.setAdapter(adapter);
//                       }
 //                    }
               });
       }
       });
    }
}
