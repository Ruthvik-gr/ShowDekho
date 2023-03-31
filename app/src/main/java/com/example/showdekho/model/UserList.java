package com.example.showdekho.model;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showdekho.R;
import com.example.showdekho.model.DbHelper;
import com.example.showdekho.model.DbOrg;
import com.example.showdekho.model.Movie;
import com.example.showdekho.model.MyAdapter;
import com.example.showdekho.model.Organizer;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> moviesList = new ArrayList<>();
    DbHelper db;
    DbOrg dbOrg;
    MyAdapter adapter;
    ImageButton plus;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        db = new DbHelper(this);


        getData();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, moviesList);
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        plus = findViewById(R.id.org);

        plus.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Organizer.class);
            startActivity(intent);
        });
    }

    public void getData() {
        dbOrg = new DbOrg(this);
        Cursor cursor = dbOrg.getdata();
        if (cursor.getColumnCount() == 0) {
            Toast.makeText(this, "NO ENTRY EXIST", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                Movie movie = new Movie();
//                movie.setName(cursor.getColumnIndex("movieName"));
                movie.setName(cursor.getString(0));
                movie.setTime(cursor.getString(1));
                movie.setLocation(cursor.getString(2));
                movie.setPrice(cursor.getString(3));
                movie.setLanguage(cursor.getString(4));
                movie.setGenere(cursor.getString(5));
                moviesList.add(movie);

            }
        }
        cursor.close();
    }
}