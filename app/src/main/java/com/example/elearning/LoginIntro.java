package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginIntro extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        getStartedButton = findViewById(R.id.getStartedButton);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    // User is already logged in, navigate to MainActivity
                    startActivity(new Intent(LoginIntro.this, MainActivity.class));
                    finish();
                } else {
                    // User is not logged in, navigate to LoginActivity
                    startActivity(new Intent(LoginIntro.this, LoginActivity.class));
                }
            }
        });
    }
}
