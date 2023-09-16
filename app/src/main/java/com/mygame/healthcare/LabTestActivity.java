package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages=
    {
        {"Packege 1 : Full Body Ckeckup","","","","999"},
        {"Packege 2 : Blood Glucose Fasting","","","","399"},
        {"Packege 3 : COVID-19 Antibody - Ig6","","","","899"},
        {"Packege 4 : Thyroid Check","","","","499"},
        {"Packege 5 : Immunity Check","","","","699"},
    };

    private String[] package_details={
        "Blood Glucose Fasting\n" +
                "Complete Hemogram\n" +
                "HbA1c\n" +
                "Iron Studies" +
                "Kidney Function Test" +
                "Ldh Lactate Dehydrogenase, Serum\n" +
                "Lipid Profile\n" +
                "Liver Fuction Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody - Ig6",
            "Thyroid profile Total (T3, T4 and TSH Ultra-sensitive)",
            "Complete Hemogram\n" +
                    "CRP (C Reactive Profile) Quantitative, Serum\n" +
                    "Iron studies\n" +
                    "Kedney Function Test\n" +
                    "Vitamin-D Total 25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid profile"
    };


    Button ltBack,ltGoToCarrt;
    TextView tvPackages,tvLocation;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    ListView ltPackages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        ltBack=findViewById(R.id.LTDbackbutton);
        ltGoToCarrt=findViewById(R.id.LTDGoTocart);
        ltPackages=findViewById(R.id.edittextLTD);
        ltBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList<>();
        for (int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa =new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ltPackages.setAdapter(sa);


        ltPackages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTestActivity.this,LabTestDetailActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        ltGoToCarrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivities(new Intent[]{new Intent(LabTestActivity.this,CartLabActivity.class)});
            }
        });

    }
}