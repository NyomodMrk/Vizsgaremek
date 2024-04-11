package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edittext_login_username;
    private EditText edittext_login_password;
    private Button button_login_login;
    private Button button_login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        button_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registerpage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void init(){
        edittext_login_password =findViewById(R.id.edittext_login_password);
        edittext_login_username =findViewById(R.id.edittext_login_username);
        button_login_login =findViewById(R.id.button_login_login);
        button_login_register =findViewById(R.id.button_login_register);
    }
}