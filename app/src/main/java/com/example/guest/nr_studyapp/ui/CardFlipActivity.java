package com.example.guest.nr_studyapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.nr_studyapp.R;

public class CardFlipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);
    }

    /**
     * A fragment representing the front of the card.
     */
    public class CardFrontFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_front, container, false);
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public class CardBackFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }
}


// Different version but this could help for hwat I am trying to do
//     https://www.youtube.com/watch?v=4WGnB-hXUFk

//another flip animation explained
//    http://www.thedroidsonroids.com/blog/android/android-flipa-card-animation-exlpained/


//Android.Developer card flip explained

//https://stuff.mit.edu/afs/sipb/project/android/docs/training/animation/cardflip.html