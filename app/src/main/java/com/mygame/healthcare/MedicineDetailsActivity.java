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

public class MedicineDetailsActivity extends AppCompatActivity {

    TextView medicineName,totalCost;
    EditText medicineDetail;
    Button add,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        medicineName=findViewById(R.id.MDpackage);
        totalCost=findViewById(R.id.MDcost);
        medicineDetail=findViewById(R.id.MDedittext);
        add=findViewById(R.id.MDAddTocart);
        back=findViewById(R.id.MDbackbutton);

        medicineDetail.setKeyListener(null);

        Intent it=getIntent();
        medicineName.setText(it.getStringExtra("medicineName"));
        medicineDetail.setText(it.getStringExtra("medicineDetail"));
        totalCost.setText("Total Cost :"+it.getStringExtra("Cost")+"/-");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineDetailsActivity.this,buyMedicineActivity.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                String product = medicineName.getText().toString();
                float price = Float.parseFloat(it.getStringExtra("Cost").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(MedicineDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addToCart(username, product, price, "medicine");
                    Toast.makeText(MedicineDetailsActivity.this, "Record Inserted To Cart", Toast.LENGTH_SHORT).show();
                }

                Intent intent=new Intent(MedicineDetailsActivity.this,CartMedicineActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });



    }
}