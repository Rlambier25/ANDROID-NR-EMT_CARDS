package com.example.guest.nr_studyapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.logInButton) Button mLogInButton;
    @Bind(R.id. appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.flashCardButton) Button mFlashCardButton;
    @Bind(R.id.userMain) TextView mUserTextView;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface captureFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");
        mAppNameTextView.setTypeface(captureFont);

        mUserTextView = (TextView) findViewById(R.id.userMain);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        mUserTextView.setText(user);

        mAboutButton.setOnClickListener(this);
        mLogInButton.setOnClickListener(this);
        mFlashCardButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAboutButton) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if(v == mLogInButton) {
            Intent goToLogin = new Intent(MainActivity.this, logInActivity.class);
            startActivity(goToLogin);
        }
        if(v == mFlashCardButton) {
            Intent goToFlashCards = new Intent(MainActivity.this, FlashCardActivity.class);
            startActivity(goToFlashCards);
        }
    }
}
