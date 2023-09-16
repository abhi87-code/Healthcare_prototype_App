package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        //Toast.makeText(getApplicationContext(), "Welcome"+username, Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.cardLOGOUT);
        CardView Finddoctors=findViewById(R.id.cardfinddoctors);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivities(new Intent[]{new Intent(HomeActivity.this,LoginActivity2.class)});
            }
        });
        Finddoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(HomeActivity.this,finddoctorsActivity.class)});
            }
        });

        CardView labtest=findViewById(R.id.cardlabtest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
            }
        });

        CardView orderDetails = findViewById(R.id.cardorder);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        CardView BM=findViewById(R.id.cardlanguage);
        BM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,buyMedicineActivity.class));
            }
        });
        CardView artical=findViewById(R.id.cardarticals);
        artical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ArticalActivity.class));
            }
        });
    }
}