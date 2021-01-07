package com.example.mobileactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsignin = (Button) findViewById(R.id.btnsignin);
        btnsignin.setOnClickListener(this);

        Button btnregister = (Button) findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);

        Button btnforgot = (Button) findViewById(R.id.btnforgot);
        btnforgot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsignin:
                Intent screen2 = new Intent(this, MainActivity2.class);
                startActivity(screen2);
                break;
            case R.id.btnregister:
                Toast.makeText(this, "Not Yet Available", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnforgot:
                Toast.makeText(this, "Not Yet Available", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}