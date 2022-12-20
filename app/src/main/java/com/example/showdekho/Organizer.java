package com.example.showdekho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Organizer extends AppCompatActivity {

    EditText ipmovn, iptime, iploc, ipprice, iplang, ipgenre;
    Button submit;
    DbOrg db;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer);
        ipmovn = findViewById(R.id.ipmovnam);
        iptime = findViewById(R.id.iptime);
        iploc = findViewById(R.id.iploc);
        ipprice = findViewById(R.id.ipprice);
        iplang = findViewById(R.id.iplang);
        ipgenre = findViewById(R.id.ipgenre);
        submit = findViewById(R.id.btnsubmit);

        db = new DbOrg(this);
        submit.setOnClickListener(v -> {
            String moviename = ipmovn.getText().toString();
            String time = iptime.getText().toString();
            String location = iploc.getText().toString();
            String price = ipprice.getText().toString();
            String language = iplang.getText().toString();
            String genre = ipgenre.getText().toString();
            if (moviename.equals("") || time.equals("") || location.equals("") || price.equals("") || language.equals("") || genre.equals("")) {
                Toast.makeText(Organizer.this, "FILL ALL THE FIELDS", Toast.LENGTH_SHORT).show();
            } else {
                boolean checkmovname = db.checkmoviename(moviename);
                if (!checkmovname) {
                    boolean regmovie = db.insertmovie(moviename, time, location, price, language, genre);
                    if (regmovie) {
                        Toast.makeText(Organizer.this, "Your Show Added Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Organizer.this, "Unable to list your show", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Organizer.this, "Movie name already exists", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}