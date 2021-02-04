package com.example.easynotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.easynotes.R;

public class Welcome extends AppCompatActivity {

    private EditText nickname;
    private ImageButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        nickname = findViewById(R.id.text_nickname);
        add = findViewById(R.id.button_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nickname1 = nickname.getText().toString();

                if(nickname.getText().toString().trim().isEmpty()){
                    Toast.makeText(Welcome.this, "Nickname can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Welcome.this, Homescreen.class);
                intent.putExtra ("keyname",nickname1);
                startActivity(intent);
            }
        });

    }
}