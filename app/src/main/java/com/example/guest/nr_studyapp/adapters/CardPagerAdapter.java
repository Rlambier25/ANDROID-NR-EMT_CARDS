package com.example.guest.nr_studyapp.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.nr_studyapp.models.FlashCard;
import com.example.guest.nr_studyapp.ui.CardFlipFragment;


import java.util.ArrayList;

/**
 * Created by Guest on 7/19/16.
 */
public class CardPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<FlashCard> mFlashCards;

    public CardPagerAdapter(FragmentManager fm, ArrayList<FlashCard> flashCards) {
        super(fm);
        mFlashCards = flashCards;
    }

    @Override
    public Fragment getItem(int position) {
        return CardFlipFragment.newInstance(mFlashCards.get(position));
    }

    @Override
    public int getCount() {
        return mFlashCards.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFlashCards.get(position).getTerm();
    }
}
