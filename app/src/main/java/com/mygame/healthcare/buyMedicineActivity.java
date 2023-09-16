package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class buyMedicineActivity extends AppCompatActivity {
    private String[][] medicine = {
            {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
            {"Healthvit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
            {"Vitamin B Complex Capsule", "", "", "", "449"},
            {"Inlife Vitamin E with Wheat Germ Oil Capsule", "", "", "", "641"},
            {"Dolo 650 Tablet", "", "", "", "40"},
            {"Crocine 650 Advance Tablet", "", "", "", "50"},
            {"Strepsils Medicated Lozenge For Sore Throat", "", "", "", "57"},
            {"Tata 1mg Calcium + Vitamin D3 Tablet", "", "", "", "28"},
            {"Feronia-XT Tablet", "", "", "", "130"},
    };

    private String[] medicine_details = {
            "Uprise-D3 1000IU Capsule:\n" +
                    "- Building and keeping the bones and teeth strong\n" +
                    "- Reducing fatigue/stress and muscular pains\n" +
                    "- Boosting immunity and increasing resistance against infection",
            "Healthvit Chromium Picolinate 200mcg Capsule:\n" +
                    "- Supporting healthy blood sugar levels\n" +
                    "- Aiding in weight management\n" +
                    "- Enhancing energy production",
            "Vitamin B Complex Capsule:\n" +
                    "- Supporting energy production\n" +
                    "- Promoting healthy metabolism\n" +
                    "- Supporting nervous system function",
            "Inlife Vitamin E with Wheat Germ Oil Capsule:\n" +
                    "- Providing antioxidant support\n" +
                    "- Nourishing and protecting the skin\n" +
                    "- Supporting overall immune health",
            "Dolo 650 Tablet:\n" +
                    "- Relieving pain and fever\n" +
                    "- Reducing inflammation\n" +
                    "- Providing temporary relief from headaches",
            "Crocine 650 Advance Tablet:\n" +
                    "- Providing relief from pain and fever\n" +
                    "- Reducing inflammation\n" +
                    "- Suitable for adults and children above 12 years",
            "Strepsils Medicated Lozenge For Sore Throat:\n" +
                    "- Soothing sore throat and irritation\n" +
                    "- Providing relief from throat discomfort\n" +
                    "- Helping to reduce coughing",
            "Tata 1mg Calcium + Vitamin D3 Tablet:\n" +
                    "- Supporting bone health and development\n" +
                    "- Promoting calcium absorption\n" +
                    "- Providing essential nutrients for strong bones",
            "Feronia-XT Tablet:\n" +
                    "- Treating iron deficiency anemia\n" +
                    "- Providing essential nutrients for red blood cell production\n" +
                    "- Supporting overall energy and vitality",
    };

    ListView lst;
    HashMap<String,String> item;
    SimpleAdapter sa;
    ArrayList list;
    Button back,gtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

          gtc=findViewById(R.id.BMGoTocart);
          gtc.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(new Intent(buyMedicineActivity.this,CartMedicineActivity.class));
              }
          });

        back=findViewById(R.id.BMbackbutton);
        lst=findViewById(R.id.listviewBM);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<medicine.length;i++){
            item=new HashMap<String,String>();
            item.put( "line1", medicine[i][0]);
            item.put( "line2", medicine[i][1]);
            item.put( "line3", medicine[i][2]);
            item.put( "line4", medicine[i][3]);
            item.put( "line5", "Cons "+medicine[i][4]+"/-");
            list.add(item);
        }
        sa =new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(buyMedicineActivity.this,MedicineDetailsActivity.class);
                intent.putExtra("medicineName",medicine[i][0]);
                intent.putExtra("medicineDetail",medicine_details[i]);
                intent.putExtra("Cost",medicine[i][4]);
                startActivity(intent);
            }
        });

    }
}