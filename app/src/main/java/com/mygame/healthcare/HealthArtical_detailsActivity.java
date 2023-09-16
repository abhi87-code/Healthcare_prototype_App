package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArtical_detailsActivity extends AppCompatActivity {

    TextView heading;
    ImageView img;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_artical_details);

        back=findViewById(R.id.HADbackbutton);
        heading=findViewById(R.id.TitleHAD);
        img=findViewById(R.id.HADimageView);

        Intent intent=getIntent();
        heading.setText(intent.getStringExtra("text1"));


        Bundle bundle=getIntent().getExtras();
        if (bundle !=null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(HealthArtical_detailsActivity.this,ArticalActivity.class));
                }
            });
        }
    }
}