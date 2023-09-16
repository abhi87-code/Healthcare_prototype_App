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

public class BookMedicineActivity extends AppCompatActivity {

    EditText fullname,address,pincode,contact;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_medicine);
        fullname=findViewById(R.id.editTextbookmedicinefullname);
        address=findViewById(R.id.editTextbookmedicineAddress);
        pincode=findViewById(R.id.editTextbookmedicinepincode);
        contact=findViewById(R.id.editTextbookmedicinecontact);
        book=findViewById(R.id.bookmedicinebutton);

        Intent intent=getIntent();
        String[]price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("share_pref", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();

                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                db.addorder(username,fullname.getText().toString(),address.getText().toString(),Integer.parseInt(pincode.getText().toString()),contact.getText().toString(),date,time,price[1],"medicine");
                db.deletCart(username,"medicine");
                Toast.makeText(BookMedicineActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookMedicineActivity.this,HomeActivity.class));
            }
        });
    }
}