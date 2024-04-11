package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Post extends AppCompatActivity {
    private EditText edittext_post_title;
    private EditText edittext_post_content;
    private CheckBox checkbox_post;
    private Button button_post_post;
    private Button button_post_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        init();
    }

    protected void init(){
        edittext_post_title =findViewById(R.id.edittext_post_Title);
        edittext_post_content =findViewById(R.id.edittext_post_Content);
        checkbox_post =findViewById(R.id.checkbox_post);
        button_post_post =findViewById(R.id.button_post_Post);
        button_post_back =findViewById(R.id.button_post_back);
    }
}