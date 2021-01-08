package com.example.mobileactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotActivity extends AppCompatActivity implements View.OnClickListener{

    EditText textaccountnumber2;
    EditText textemail;
    EditText textmpin;
    Button btncontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        textaccountnumber2 = (EditText) findViewById(R.id.textaccountnumber2);
        textemail = (EditText) findViewById(R.id.textemail);
        textmpin = (EditText) findViewById(R.id.textmpin);
        btncontinue = (Button) findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (textaccountnumber2.getText().toString().equals("123456") && textemail.getText().toString().equals("dummyemail@gmail.com") && textmpin.getText().toString().equals("1111")) {
            Toast.makeText(this, "Password reset sent, please check your email.", Toast.LENGTH_SHORT).show();
            Intent screen4 = new Intent(this, startActivity.class);
            startActivity(screen4);
            finish();
        }
        else {
            Toast.makeText(this, "There seems to be a problem. Please check your credentials and try again.", Toast.LENGTH_LONG).show();
            return;
        }

    }
}