package com.example.showdekho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicReference;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnsignin;

    DbHelper myDB;

    private static final boolean PREFS_NAME = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernamelogin);
        password = findViewById(R.id.passwordlogin);
        btnsignin = findViewById(R.id.btnlogin);
        SharedPreferences sharedPreferences;
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

                    /*SharedPreferences settings = getSharedPreferences(String.valueOf(PREFS_NAME), MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("logged", true); // set it to false when the user is logged out
                    editor.commit(); // Commit the edits!*/

                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}