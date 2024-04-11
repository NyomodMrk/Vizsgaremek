package com.example.vizsgaremek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

public class Registerpage extends AppCompatActivity {
    private String url="http://10.0.2.2:3000/users/register";
    //javítani kell
    private EditText edittext_register_username;
    private EditText edittext_register_email;
    private EditText edittext_register_password;
    private EditText edittext_register_password_again;
    private Button  button_register_register;
    private Button  button_register_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        init();
        
        button_register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edittext_register_username.getText().toString().trim();
                String email = edittext_register_email.getText().toString().trim();
                String password = edittext_register_password.getText().toString().trim();
                String passwordAgain = edittext_register_password_again.getText().toString().trim();

                Users users = new Users(username, email, password, passwordAgain);
                Gson converter = new Gson();
                RequestTask task = new RequestTask(url,"POST", converter.toJson(users));
                task.execute();
            }
        });
        button_register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registerpage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void init(){
        edittext_register_username =findViewById(R.id.edittext_register_username);
        edittext_register_email =findViewById(R.id.edittext_register_email);
        edittext_register_password =findViewById(R.id.edittext_register_password);
        edittext_register_password_again =findViewById(R.id.edittext_register_password_again);
        button_register_register =findViewById(R.id.button_register_register);
        button_register_back =findViewById(R.id.button_register_back);
    }

    private class RequestTask extends AsyncTask<Void, Void, Response> {
        String requestUrl;
        String requestType;
        String requestParams;

        public RequestTask(String requestUrl, String requestType, String requestParams) {
            this.requestUrl = requestUrl;
            this.requestType = requestType;
            this.requestParams = requestParams;
        }

        public RequestTask(String requestUrl, String requestType) {
            this.requestUrl = requestUrl;
            this.requestType = requestType;
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                if (requestType.equals("POST")) {
                    response = RequestHandler.post(requestUrl, requestParams);
                }
            } catch (IOException e) {
                Toast.makeText(Registerpage.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);

            if (response.getResponseCode() >= 400) {
                Toast.makeText(Registerpage.this, "Hiba történt az adatok feldolgozásaa során", Toast.LENGTH_SHORT).show();
                Log.d("onPostExecuteError: ", response.getResponseMessage());
                return;
            }
            if (requestType.equals("POST")) {
                Intent intent = new Intent(Registerpage.this, Home.class);
                startActivity(intent);
                Toast.makeText(Registerpage.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}