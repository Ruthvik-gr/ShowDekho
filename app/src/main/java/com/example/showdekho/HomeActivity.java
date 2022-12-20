package com.example.showdekho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageButton plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        plus = findViewById(R.id.org);

        plus.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Organizer.class);
            startActivity(intent);
        });


    }
}