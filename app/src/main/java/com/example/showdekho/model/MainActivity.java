package com.example.showdekho.model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.showdekho.R;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnsignup, btnsignin;
    DbHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignin = findViewById(R.id.btnsignin);


        myDB = new DbHelper(this);
        btnsignup.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if (user.equals("") || pass.equals("") || repass.equals("")) {
                Toast.makeText(MainActivity.this, "FILL ALL THE FIELDS", Toast.LENGTH_SHORT).show();
            } else {
                if (pass.equals(repass)) {
                    boolean usercheckresult = myDB.checkusername(user);
                    if (!usercheckresult) {
                        boolean regresult = myDB.insertData(user, pass);
                        if (regresult) {
                            Toast.makeText(MainActivity.this, "Registration succesfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "USER EXIST/LOGIN/CHANGE USER NAME", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "PASSWORD DOESNT MATCH", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsignin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }
}