package com.example.appamst4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video_view extends AppCompatActivity {

    private VideoView video;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        Button btnAtras = findViewById(R.id.btnAtras);
        video = findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_clip));

        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        mc.setAnchorView(video);

        video.start();

    }

    public void onClick(View vw) {
        if(vw.getId() == R.id.btnAtras){
            Log.d("mensaje","video");
        }
    }

    public void retroceder(View view) {
        Intent intent = new Intent(this, formulario_registro.class);
        startActivity(intent);
    }
}