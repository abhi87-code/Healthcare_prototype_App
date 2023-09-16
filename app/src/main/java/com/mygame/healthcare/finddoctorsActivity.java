package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class finddoctorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctors);
        CardView exit=findViewById(R.id.exit);
        CardView physician=findViewById(R.id.physician);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(finddoctorsActivity.this,HomeActivity.class)});
            }
        });
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent it=new Intent(finddoctorsActivity.this,DoctorDetailActivity.class);
              it.putExtra("title","Physician");
              startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.Dietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(finddoctorsActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        CardView dentist=findViewById(R.id.Dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(finddoctorsActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        CardView surgion=findViewById(R.id.Surgion);
        surgion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(finddoctorsActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Surgion");
                startActivity(it);
            }
        });

        CardView cardiologist=findViewById(R.id.cardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(finddoctorsActivity.this,DoctorDetailActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });
    }
}