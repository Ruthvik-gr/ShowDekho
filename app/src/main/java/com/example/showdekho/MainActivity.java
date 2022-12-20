package com.example.showdekho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnsignup, btnsignin;
    DbHelper myDB;
//    SharedPreferences sharedPreferences;
//
//    private static final String shared_pref_name = "mypref";
//    private static final String key_name = "name";
//    private static final String key_pass = "pass";
//    private static final String key_repass = "repass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignin = findViewById(R.id.btnsignin);

//        sharedPreferences = getSharedPreferences(shared_pref_name, MODE_PRIVATE);
//        String name = sharedPreferences.getString(key_name, null);
//        if (name != null) {
//            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//            startActivity(intent);
//        }

        myDB = new DbHelper(this);
        btnsignup.setOnClickListener(v -> {
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString(key_name, username.getText().toString());
//            editor.putString(key_pass, password.getText().toString());
//            editor.putString(key_repass, repassword.getText().toString());
//            editor.apply();
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