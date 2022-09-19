package com.example.fontaines5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Objects;

public class MainMenuActivity extends AppCompatActivity {
private VideoView video_view = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        video_view = (VideoView) findViewById(R.id.video_view);
        video_view.setMediaController(new MediaController(this)); //added media controller
        Uri video = Uri.parse("android.resource://" +getPackageName()+ "/"+ R.raw.logo_into_f5);
        video_view.setVideoURI(video);
        video_view.setZOrderOnTop(true); //don't merge video with other widgets

        //Add a listener to the button to take you to the MLB page(*method attach)
        Button btnmlb=(Button) findViewById(R.id.btnmlb);
        btnmlb.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) { goMLB();}
                                 }
        );

        //Add a listener to the button to take you to the NBA page(*method attach)
        Button btnnba=(Button) findViewById(R.id.btnnba);
        btnnba.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) { goNBA();}
                                  }
        );

        //Add a listener to the button to take you to the NFL page(*method attach)
        Button btnnfl=(Button) findViewById(R.id.btnnfl);
        btnnfl.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) { goNFL();}
                                  }
        );
    }

    protected void onResume() { //Play
        super.onResume();
        video_view.start();
    }
    protected void onPause() { //Pause
        video_view.stopPlayback();
        super.onPause();
    }

    private void goNFL() {
        Intent intent = new Intent(MainMenuActivity.this, NFLActivity.class);
        this.startActivity(intent);
    }

    private void goNBA() {
        Intent intent = new Intent(MainMenuActivity.this, NBAActivity.class);
        this.startActivity(intent);
    }

    private void goMLB() {
        Intent intent = new Intent(MainMenuActivity.this, MLBActivity.class);
        this.startActivity(intent);
    }




}