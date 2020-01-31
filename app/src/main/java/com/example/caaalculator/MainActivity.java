package com.example.caaalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Calculator calculator = new Calculator();
    int buttonamount = 17; //Amount of buttons that simply add a symbol
    TextView calcView;
    //Button b1;
    Button[] symbols = new Button [buttonamount];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Привет", Toast.LENGTH_LONG).show();
        //Log.wtf("tag", "сообщение");
        Log.i("tag", "сообщение");
        Log.e("tag", "сообщение");
        //b1 = findViewById(R.id.b1);
        calcView = findViewById(R.id.calcText);
        //b1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        //Random r = new Random();
        String s = ((Button)v).getText().toString() + new Random().nextInt(500000);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
    public void onSymbolClick(View v){
        //Random r = new Random();
        String s = ((Button)v).getText().toString();
        //Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        calcView.setText(calculator.addSymbol(s));
    }
    public void onCalculateClick(View v){
        calcView.setText(calculator.calculate());
    }
    public void onDeleteClick(View v){
        calcView.setText(calculator.deleteSymbol());
    }
    public void onClearClick(View v){
        calcView.setText(calculator.clearString());
    }

}

