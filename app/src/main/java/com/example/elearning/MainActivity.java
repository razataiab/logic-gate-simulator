package com.example.elearning;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        setUpDrawerLayout();

        // Find the Lessons card view
        MaterialCardView lessonsCard = findViewById(R.id.lessonsCard);
        // Find the Sandbox card view
        MaterialCardView sandboxCard = findViewById(R.id.sandboxCard);

        // Set an OnClickListener for the Lessons card
        lessonsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the LessonsActivity
                Intent intent = new Intent(MainActivity.this, Activity_lesson.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for the Sandbox card
        sandboxCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the activity_sandbox
                Intent intent = new Intent(MainActivity.this, activity_sandbox.class);
                startActivity(intent);
            }
        });
    }

    private void setUpDrawerLayout() {
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);

        DrawerLayout mainDrawer = findViewById(R.id.mainDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mainDrawer, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
