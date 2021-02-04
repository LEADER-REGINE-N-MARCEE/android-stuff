package com.example.easynotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.easynotes.R;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN = 7000;
    Animation leftanim;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftanim = AnimationUtils.loadAnimation(this, R.anim.left_to_right);

        logo = findViewById(R.id.easynotes);
        logo.setAnimation(leftanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}