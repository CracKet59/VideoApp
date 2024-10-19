package com.example.videoapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoapp.VideoItem;

import java.util.List;

// Adapter to bind video data to RecyclerView for swiping through videos
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoItem> videoItems; // List of video items

    // Constructor for the adapter, accepts a list of VideoItem objects
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    // Inflate the view for each video item when needed
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        TextView textVideoTitle1, textVideoDescription1, textVideoID1;
        VideoView videoView;
        ProgressBar progressBar;

        // Constructor to initialize views in the item layout
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textViewDescription);
            textVideoID1 = itemView.findViewById(R.id.textVideoID);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        // Set video data (title, description, ID, and URL) for the video
        void setVideoData(VideoItem videoItem) {
            textVideoTitle1.setText(videoItem.videoTitle); // Set title
            textVideoDescription1.setText(videoItem.videoDescription); // Set description
            textVideoID1.setText(videoItem.videoID); // Set ID
            videoView.setVideoPath(videoItem.videoURL); // Set video URL


            videoView.setOnPreparedListener(mp -> {
                progressBar.setVisibility(View.GONE);
                mp.start();
                float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                float scale = videoRatio / screenRatio;
                if (scale >= 1f) {
                    videoView.setScaleX(scale);
                } else {
                    videoView.setScaleY(1f / scale);
                }
            });

            // Loop the video after completion
            videoView.setOnCompletionListener(mp -> mp.start());
        }
    }
}
