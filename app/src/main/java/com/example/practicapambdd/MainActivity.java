package com.example.practicapambdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enlazarDatos (){
        Toast.makeText(this, "hola git", Toast.LENGTH_SHORT).show();

    }
}