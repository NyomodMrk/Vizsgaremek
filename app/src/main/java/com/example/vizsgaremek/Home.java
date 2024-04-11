package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private TextView textview_home_username;
    private Button button_Home_Profile;
    private Button button_Home_Home;
    private Button button_Home_Search;
    private Button button_Home_Post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        button_Home_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Post.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void init(){
        textview_home_username =findViewById(R.id.textview_home_username);
        button_Home_Profile = findViewById(R.id.button_Home_Profile);
        button_Home_Home = findViewById(R.id.button_Home_home);
        button_Home_Search = findViewById(R.id.button_Home_search);
        button_Home_Post = findViewById(R.id.button_Home_Post);
    }
}