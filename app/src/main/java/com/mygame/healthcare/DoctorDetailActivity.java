package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class DoctorDetailActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Tikone", "Hospital Address : Globel City", "Exp : 6yrs",
                            "Mobile No : 8798765434", "Fee : 650"},
                    {"Doctor Name : Harsh Mishra", "Hospital Address : Virar", "Exp : 3yrs",
                            "Mobile No : 8798765443", "Fee : 500"},
                    {"Doctor Name : Ram Shawant", "Hospital Address : MalvelPada", "Exp : 5yrs",
                            "Mobile No : 8798765179", "Fee : 700"},
                    {"Doctor Name : Bhoomika Mane", "Hospital Address : Borivali(E)", "Exp : 7yrs",
                            "Mobile No : 8798765432", "Fee : 600"},
                    {"Doctor Name : Hemant divekar", "Hospital Address : Vasai", "Exp : 7yrs",
                            "Mobile No : 8798765111", "Fee : 500"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Mahesh Kharde", "Hospital Address : Pimpri(E)", "Exp : 6yrs",
                            "Mobile No : 8798765434", "Fee : 650"},
                    {"Doctor Name : Jay Kanishtha", "Hospital Address : Virar(W)", "Exp : 3yrs",
                            "Mobile No : 8798765443", "Fee : 500"},
                    {"Doctor Name : Rajat Varma", "Hospital Address : Nalasopara(E)", "Exp : 5yrs",
                            "Mobile No : 8798765179", "Fee : 700"},
                    {"Doctor Name : Priya Gandhi", "Hospital Address : Borivali(E)", "Exp : 7yrs",
                            "Mobile No : 8798765432", "Fee : 600"},
                    {"Doctor Name : Sharda Singh", "Hospital Address : Vasai(W)", "Exp : 7yrs",
                            "Mobile No : 8798765111", "Fee : 500"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Sanjay Nadda", "Hospital Address : Dahisar(E)", "Exp : 6yrs",
                            "Mobile No : 8798765434", "Fee : 650"},
                    {"Doctor Name : Deepak Dhar", "Hospital Address : Virar(W)", "Exp : 3yrs",
                            "Mobile No : 8798765443", "Fee : 500"},
                    {"Doctor Name : Nusarat Khan", "Hospital Address : Nalasopara(E)", "Exp : 5yrs",
                            "Mobile No : 8798765179", "Fee : 700"},
                    {"Doctor Name : S.K. Dhamde", "Hospital Address : Borivali(E)", "Exp : 7yrs",
                            "Mobile No : 8798765432", "Fee : 600"},
                    {"Doctor Name : Divya Gupta", "Hospital Address : Virar(E)", "Exp : 7yrs",
                            "Mobile No : 8798765111", "Fee : 500"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Jash Parmar", "Hospital Address : Miraroad(E)", "Exp : 7yrs",
                            "Mobile No : 8798765434", "Fee : 1600"},
                    {"Doctor Name : V.M Rao", "Hospital Address : Virar(W)", "Exp : 6yrs",
                            "Mobile No : 8798765443", "Fee : 1500"},
                    {"Doctor Name : Sanjay Kothari", "Hospital Address : Nalasopara(E)", "Exp : 11yrs",
                            "Mobile No : 8798765179", "Fee : 1200"},
                    {"Doctor Name : Supriya Das", "Hospital Address : Borivali(E)", "Exp : 16yrs",
                            "Mobile No : 8798765432", "Fee : 1700"},
                    {"Doctor Name : Sanjeet Mapal", "Hospital Address : Vasai(W)", "Exp : 10yrs",
                            "Mobile No : 8798765111", "Fee : 1500"},
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Shruti Walimbe", "Hospital Address : Pimpri(E)", "Exp : 6yrs",
                            "Mobile No : 8798765434", "Fee : 650"},
                    {"Doctor Name : Vaishnavi Surti", "Hospital Address : Virar(W)", "Exp : 3yrs",
                            "Mobile No : 8798765443", "Fee : 500"},
                    {"Doctor Name : Lokesh Jain", "Hospital Address : Nalasopara(E)", "Exp : 5yrs",
                            "Mobile No : 8798765179", "Fee : 700"},
                    {"Doctor Name : Amit Gupta", "Hospital Address : Borivali(E)", "Exp : 7yrs",
                            "Mobile No : 8798765432", "Fee : 600"},
                    {"Doctor Name : Mohak Tamore", "Hospital Address : Vasai(W)", "Exp : 7yrs",
                            "Mobile No : 8798765111", "Fee : 500"},
            };
    TextView tv;
    String[][] doctors_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button back;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
         tv=findViewById(R.id.TitleLTD);
         back=findViewById(R.id.LTDbackbutton);

        Intent it =getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if (title != null && title.equals("Physician")) {
            doctors_details = doctor_details1;
        } else if (title != null && title.equals("Dietician")) {
            doctors_details = doctor_details2;
        } else if (title != null && title.equals("Dentist")) {
            doctors_details = doctor_details3;
        } else if (title != null && title.equals("Surgeon")) {
            doctors_details = doctor_details4;
        } else {
            doctors_details = doctor_details5;
        }

            back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(DoctorDetailActivity.this,finddoctorsActivity.class)});
            }
        });
            list = new ArrayList();
            for (int i=0;i<doctors_details.length;i++){
                item=new HashMap<String,String>();
                item.put( "line1", doctors_details[i][0]);
                item.put( "line2", doctors_details[i][1]);
                item.put( "line3", doctors_details[i][2]);
                item.put( "line4", doctors_details[i][3]);
                item.put( "line5", "Cons "+doctors_details[i][4]+"/-");
                list.add(item);
            }
            sa =new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                    );


        ListView lst=findViewById(R.id.edittextLTD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctors_details[i][0]);
                it.putExtra("text3",doctors_details[i][1]);
                it.putExtra("text4",doctors_details[i][3]);
                it.putExtra("text5",doctors_details[i][4]);
                startActivity(it);

            }
        });

    }
}