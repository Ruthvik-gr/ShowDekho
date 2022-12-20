package com.example.showdekho;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> MovieName, ShowTime, Location, Amount, Language, Genre;
    DbHelper db;
    DbOrg dbOrg;
    MyAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        db = new DbHelper(this);
        MovieName = new ArrayList<>();
        ShowTime = new ArrayList<>();
        Location = new ArrayList<>();
        Amount = new ArrayList<>();
        Language = new ArrayList<>();
        Genre = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, MovieName, ShowTime, Location, Amount, Language, Genre);
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = dbOrg.getdata();
        if (cursor.getColumnCount() == 0) {
            Toast.makeText(this, "NO ENTRY EXIST", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                MovieName.add(cursor.getString(0));
                ShowTime.add(cursor.getString(1));
                Location.add(cursor.getString(2));
                Amount.add(cursor.getString(3));
                Language.add(cursor.getString(4));
                Genre.add(cursor.getString(5));
            }
        }
    }
}