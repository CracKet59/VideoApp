package com.example.videoapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
import com.example.videoapp.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);
        List<VideoItem> videoItemsList = new ArrayList<>();

        VideoItem videoCelebration = new VideoItem();
        videoCelebration.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-8941b.appspot.com/o/League%20of%20Legends%20Homepage.mp4?alt=media&token=bc6ece1e-bb43-4eba-9521-8f899efcba08";
        videoCelebration.videoTitle = "League of Legend";
        videoCelebration.videoDescription = "Welcome to a world of magic!!!";
        videoCelebration.videoID = "129485";
        videoItemsList.add(videoCelebration);

        VideoItem videoCelebration2 = new VideoItem();
        videoCelebration2.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-3-ca202.appspot.com/o/855282-hd_1280_720_25fps.mp4?alt=media&token=e269deb7-99ee-421b-91cd-c51bc3b06f3a";
        videoCelebration2.videoTitle = "Cat playtime";
        videoCelebration2.videoDescription = "Have a good time boy.";
        videoCelebration2.videoID = "129486";
        videoItemsList.add(videoCelebration2);

        VideoItem videoCelebration3 = new VideoItem();
        videoCelebration3.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-2-3cf79.appspot.com/o/2257257-hd_1920_1080_24fps.mp4?alt=media&token=ab89d417-a18c-47d5-9536-cd57cc310e2d";
        videoCelebration3.videoTitle = "Welcome to Seattle!!!";
        videoCelebration3.videoDescription = "Travelling around Space Needle in Seattle";
        videoCelebration3.videoID = "129487";
        videoItemsList.add(videoCelebration3);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}
