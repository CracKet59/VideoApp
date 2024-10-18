package com.example.videoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        list<VideoItem> videoItems = new ArrayList<>();
        videoItem videoCelebration = new VideoItem();
        videoCelebration.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-8941b.appspot.com/o/League%20of%20Legends%20Homepage.mp4?alt=media&token=bc6ece1e-bb43-4eba-9521-8f899efcba08";
        videoCelebration.videoTitle = "League of legend";
        videoCelebration.videoDescription ="Game Introduction";
        videoItemsList.add(videoCelebration);

        videoViewPager.setAdapter(new videoAdapter(videoItemList));
    }
}