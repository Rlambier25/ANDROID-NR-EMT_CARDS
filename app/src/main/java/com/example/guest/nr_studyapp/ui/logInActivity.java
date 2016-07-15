package com.example.guest.nr_studyapp.ui;




import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.nr_studyapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = LoginActivity.class.getSimpleName();
    @Bind(R.id.logInUserName) EditText mlogInUserName;
    @Bind(R.id.logInButton) Button mlogInButton;
    @Bind(R.id.signUpButton) Button mSignUpButton;
    @Bind(R.id.passwordLogIn) EditText mpassWordLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        ButterKnife.bind(this);

        mlogInButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mlogInButton) {
            String user = mlogInUserName.getText().toString();
            String password = mpassWordLogIn.getText().toString();
//            Log.d(TAG, user); left these for future use.
//            Log.d(TAG, password);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "check console", Toast.LENGTH_LONG).show();
        }
        if(v == mSignUpButton) {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
//            intent.putExtra("user", user);
            startActivity(intent);
            finish();
        }
    }

}
