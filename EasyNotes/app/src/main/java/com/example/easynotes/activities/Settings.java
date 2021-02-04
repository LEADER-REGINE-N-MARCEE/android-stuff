package com.example.easynotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easynotes.R;

public class Settings extends AppCompatActivity {

    private Button editnickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editnickname = findViewById(R.id.changenicknamebutton);

        editnickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Editnickname.class);
                startActivity(intent);
            }
        });
    }
}