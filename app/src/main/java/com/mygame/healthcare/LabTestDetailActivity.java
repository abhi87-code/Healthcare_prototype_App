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

public class LabTestDetailActivity extends AppCompatActivity {
    TextView cost,package_name;
    EditText edmultiline;
    Button backbutton,Addtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        cost=findViewById(R.id.LTDcost);
        package_name=findViewById(R.id.LTDpackages);
        edmultiline=findViewById(R.id.edittextLTD);
        backbutton=findViewById(R.id.LTDbackbutton);
        Addtocart=findViewById(R.id.LTDGoTocart);

        edmultiline.setKeyListener(null);


        Intent it=getIntent();
        package_name.setText(it.getStringExtra("text1"));
        edmultiline.setText(it.getStringExtra("text2"));
        cost.setText("Total Cost :"+it.getStringExtra("text3")+"/-");


        Addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = package_name.getText().toString();
                float price = Float.parseFloat(it.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(LabTestDetailActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addToCart(username, product, price, "lab");
                    Toast.makeText(LabTestDetailActivity.this, "Record Inserted To Cart", Toast.LENGTH_SHORT).show();

                    // Instead of starting the LabTestActivity, start the CartLabActivity
                    Intent intent = new Intent(LabTestDetailActivity.this, CartLabActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
            }
        });
    }
}