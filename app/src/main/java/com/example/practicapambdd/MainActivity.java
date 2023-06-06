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
        Toast.makeText(this, "segundo commit", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "tercer commit", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "cuarto  commit , a diana le gusta los chocolates :V", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "quinto commit , a diana le gusta la torta de chocolate", Toast.LENGTH_SHORT).show();
    }
}