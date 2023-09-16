package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText edusername,edpassword;
    Button login;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        edusername=findViewById(R.id.editTextUsername);
        edpassword=findViewById(R.id.editTextPassword);
        login=findViewById(R.id.loginButton);
        tv=findViewById(R.id.textViewNewuser);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivities(new Intent[]{new Intent(LoginActivity2.this,HomeActivity.class)});
                String username=edusername.getText().toString();
                String password=edpassword.getText().toString();
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length()==0 || password.length()==0)
                {
                    Toast.makeText(LoginActivity2.this, "Please fill All Details", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(username,password)==1){
                        Toast.makeText(LoginActivity2.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivities(new Intent[]{new Intent(LoginActivity2.this,HomeActivity.class)});
                        Toast.makeText(LoginActivity2.this, "Welcome", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                    }else {
                    Toast.makeText(LoginActivity2.this, "Invalid username And pasword", Toast.LENGTH_SHORT).show();
                }
                }

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivities(new Intent[]{new Intent(LoginActivity2.this, RegisterActivity2.class)});
            }
        });

    }
}