package com.example.showdekho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnsignin;

    DbHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernamelogin);
        password = findViewById(R.id.passwordlogin);
        btnsignin = findViewById(R.id.btnlogin);

        myDB = new DbHelper(this);

        btnsignin.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (user.equals("") || pass.equals("")) {
                Toast.makeText(this, "PLEASE ENTER THE CREDENTIALS", Toast.LENGTH_SHORT).show();
            } else {
                boolean result = myDB.checkusernamepass(user, pass);
                if (result) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}