package com.example.guest.nr_studyapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 7/8/16.
 */
@Parcel
public class FlashCard {
    private String term;
    private String definition;
    private String mRank;

    private String pushId;

    public FlashCard() {}

    public FlashCard(String Term, String Definition, String Rank) {
        this.term = Term;
        this.definition = Definition;
        this.mRank = Rank;
    }

    public FlashCard(String Term, String Definition) {
        this.term = Term;
        this.definition = Definition;
    }

    public String getTerm() {

        return term;
    }

    public String getDefinition() {

        return definition;
    }

    public String getRank() {

        return mRank;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}




