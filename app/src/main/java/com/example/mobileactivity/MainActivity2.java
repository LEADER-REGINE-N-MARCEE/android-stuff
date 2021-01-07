package com.example.mobileactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    EditText textaccountnumber;
    EditText textpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textaccountnumber = (EditText) findViewById(R.id.textaccountnumber);
        textpassword = (EditText) findViewById(R.id.textpassword);


        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (textaccountnumber.getText().toString().equals("123456") && textpassword.getText().toString().equals("password")) {
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
            Intent screen3 = new Intent(this, MainActivity3.class);
            startActivity(screen3);
        }
       else {
            Toast.makeText(this, "Incorrect Account Number and Password", Toast.LENGTH_SHORT).show();
        }
    }
}