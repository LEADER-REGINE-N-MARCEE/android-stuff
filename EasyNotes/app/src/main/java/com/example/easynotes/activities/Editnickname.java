package com.example.easynotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easynotes.R;

public class Editnickname extends AppCompatActivity {

    private EditText editednickname;
    private Button add, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnickname);

        add = findViewById(R.id.add_button);
        cancel = findViewById(R.id.cancel_button);
        editednickname = findViewById(R.id.edited_nickname);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nickname1 = editednickname.getText().toString();

                if(editednickname.getText().toString().trim().isEmpty()){
                    Toast.makeText(Editnickname.this, "Nickname can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Editnickname.this, Homescreen.class);
                intent.putExtra ("keyname",nickname1);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Editnickname.this, Settings.class);
                startActivity(intent);
            }
        });

    }
}