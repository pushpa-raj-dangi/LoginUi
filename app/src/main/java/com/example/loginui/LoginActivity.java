package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private TextView loginPassword,loginEmail;
    private Button signUuBtn,loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");


        loginBtn = findViewById(R.id.loginBtn);
        signUuBtn = findViewById(R.id.signUpBtn);

        loginPassword = findViewById(R.id.loginPassword);
        loginEmail = findViewById(R.id.loginEmail);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("abc",MODE_PRIVATE);
                String fuserName = sharedPreferences.getString("username","");
                String fpassword= sharedPreferences.getString("password","");

                String uuser = loginEmail.getText().toString();
                String upassword = loginPassword.getText().toString();

                if(fuserName.equals(uuser) && fpassword.equals(upassword)){

                    Toast.makeText(LoginActivity.this, "login succeed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"in correct username",Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        signUuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });



    }
}