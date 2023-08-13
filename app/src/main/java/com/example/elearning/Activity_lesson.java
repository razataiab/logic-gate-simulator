package com.example.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.List;

public class Activity_lesson extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        setUpViews();

        ListView listView = findViewById(R.id.lessonsListView);

        // Create a list of items
        List<String> lessonItems = new ArrayList<>();
        lessonItems.add("Video Lessons");
        lessonItems.add("Notes");

        // Create an ArrayAdapter and set it to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessonItems);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedLesson = lessonItems.get(position);
                if (selectedLesson.equals("Video Lessons")) {
                    // Open contents_video_lessons activity
                    Intent intent = new Intent(Activity_lesson.this, video_lessons.class);
                    startActivity(intent);
                } else if (selectedLesson.equals("Notes")) {
                    // Handle opening notes or other content
                }
            }
        });
    }

    private void setUpViews() {
        setUpDrawerLayout();
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
