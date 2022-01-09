package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button signupBtn;
        EditText email,pw;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Signup");

        signupBtn = findViewById(R.id.signUpBtn);
        email = findViewById(R.id.loginEmail);
        pw = findViewById(R.id.loginPassword);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = email.getText().toString();
                String password = pw.getText().toString();

                SharedPreferences sp = getSharedPreferences("abc", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed= sp.edit();


                ed.putString("username",username);
                ed.putString("password",password);

                ed.apply();

                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}