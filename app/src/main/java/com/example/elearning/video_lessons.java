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

public class video_lessons extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_video_lessons);
        setUpViews();

        ListView listView = findViewById(R.id.videolessons);

        // Create a list of items
        List<String> lessonItems = new ArrayList<>();
        lessonItems.add("AND Gate");
        lessonItems.add("OR Gate");
        lessonItems.add("NOT Gate");
        lessonItems.add("NOR Gate");
        lessonItems.add("NAND Gate");
        lessonItems.add("XOR Gate");

        // Create an ArrayAdapter and set it to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessonItems);
        listView.setAdapter(adapter);

        // Set an item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = lessonItems.get(position);
                if ("AND Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent1 = new Intent(video_lessons.this, activity_and_gate.class);
                    startActivity(intent1);
                }
                if ("OR Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent2 = new Intent(video_lessons.this, activity_or_gate.class);
                    startActivity(intent2);
                }
                if ("NOT Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent3 = new Intent(video_lessons.this, activity_or_gate.class);
                    startActivity(intent3);
                }
                if ("NAND Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent4 = new Intent(video_lessons.this, activity_nand_gate.class);
                    startActivity(intent4);
                }
                if ("NOR Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent5 = new Intent(video_lessons.this, activity_nor_gate.class);
                    startActivity(intent5);
                }
                if ("XOR Gate".equals(selectedItem)) {
                    // Open the activity_and_gate activity
                    Intent intent6 = new Intent(video_lessons.this, activity_xor_gate.class);
                    startActivity(intent6);
                }
                // You can add more cases for other items if needed
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
