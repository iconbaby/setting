package com.example.viewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        LinearLayout linearlayout = findViewById(R.id.layout_main);
        Button button = (Button) layoutInflater.inflate(R.layout.layout_button, null);
        linearlayout.addView(button);
    }
}
