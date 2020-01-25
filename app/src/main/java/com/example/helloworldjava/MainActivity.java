package com.example.helloworldjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Привет", Toast.LENGTH_LONG).show();
        //Log.wtf("tag", "сообщение");
        Log.i("tag", "сообщение");
        Log.e("tag", "сообщение");
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        //Random r = new Random();
        String s = ((Button)v).getText().toString() + new Random().nextInt(500000);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}

