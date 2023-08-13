package com.example.elearning;

import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.MenuItem;
import android.webkit.WebView;

public class activity_xor_gate extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String stringJavaScript = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "  <body>\n" +
            "    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->\n" +
            "    <div id=\"player\"></div>\n" +
            "    <script>\n" +
            "      // 1. Load the YouTube IFrame Player API code asynchronously.\n" +
            "      var tag = document.createElement('script');\n" +
            "      tag.src = \"https://www.youtube.com/iframe_api\";\n" +
            "      var firstScriptTag = document.getElementsByTagName('script')[0];\n" +
            "      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n" +
            "\n" +
            "      // 2. This function creates an <iframe> (and YouTube player)\n" +
            "      //    after the API code downloads.\n" +
            "      var player;\n" +
            "      function onYouTubeIframeAPIReady() {\n" +
            "        player = new YT.Player('player', {\n" +
            "          height: '195',\n" +
            "          width: '320',\n" +
            "          videoId: 'M7lc1UVf-VE',\n" + // Change this to your video ID
            "          playerVars: {\n" +
            "            'autoplay': 1,\n" + // Autoplay the video
            "            'playsinline': 1\n" +
            "          },\n" +
            "          events: {\n" +
            "            'onReady': onPlayerReady,\n" +
            "            'onStateChange': onPlayerStateChange\n" +
            "          }\n" +
            "        });\n" +
            "      }\n" +
            "\n" +
            "      // 3. The API will call this function when the video player is ready.\n" +
            "      function onPlayerReady(event) {\n" +
            "        event.target.playVideo();\n" +
            "      }\n" +
            "\n" +
            "      // 4. The API calls this function when the player's state changes.\n" +
            "      //    The function indicates that when playing a video (state=1),\n" +
            "      //    the player should play for six seconds and then stop.\n" +
            "      var done = false;\n" +
            "      function onPlayerStateChange(event) {\n" +
            "        if (event.data == YT.PlayerState.PLAYING && !done) {\n" +
            "          setTimeout(stopVideo, 10000);\n" +
            "          done = true;\n" +
            "        }\n" +
            "      }\n" +
            "      function stopVideo() {\n" +
            "        player.stopVideo();\n" +
            "      }\n" +
            "    </script>\n" +
            "  </body>\n" +
            "</html>";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xor_gate);
        setUpViews();

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        // Load and play the YouTube video
        webView.loadData(stringJavaScript, "text/html", "utf-8");
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
