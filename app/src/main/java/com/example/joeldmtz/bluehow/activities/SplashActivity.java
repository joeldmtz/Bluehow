package com.example.joeldmtz.bluehow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.joeldmtz.bluehow.R;
import com.example.joeldmtz.bluehow.custom_components.GifImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    Timer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        GifImageView gifImageView = (GifImageView) findViewById(R.id.img_gif);
        gifImageView.setGifImageResource(R.drawable.gif);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setIndeterminate(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.t = new Timer();
        this.t.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.t.cancel();
    }
}
