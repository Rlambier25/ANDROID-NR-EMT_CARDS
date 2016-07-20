package com.example.guest.nr_studyapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 7/8/16.
 */
@Parcel
public class FlashCard {
    private String mTerm;
    private String mDefinition;
    private String mRank;

    public FlashCard() {
    }

    public FlashCard(String Term, String Definition, String Rank) {
        this.mTerm = Term;
        this.mDefinition = Definition;
        this.mRank = Rank;
    }

    public String getTerm() {
        return mTerm;
    }

    public String getDefinition() {
        return mDefinition;
    }

    public String getRank() {
        return mRank;
    }
}




