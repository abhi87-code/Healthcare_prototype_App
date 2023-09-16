package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    EditText fullname,address,pincode,contact;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        fullname=findViewById(R.id.editTextltbookfullname);
        address=findViewById(R.id.editTextltbookAddress);
        pincode=findViewById(R.id.editTextltbookpincode);
        contact=findViewById(R.id.editTextltbookcontact);
        book=findViewById(R.id.ltbookbutton);

        Intent intent=getIntent();
        String[]price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("share_pref",Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();

                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                db.addorder(username,fullname.getText().toString(),address.getText().toString(),Integer.parseInt(pincode.getText().toString()),contact.getText().toString(),date,time,price[1],"lab");
                db.deletCart(username,"lab");
                Toast.makeText(LabTestBookActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });


    }
}