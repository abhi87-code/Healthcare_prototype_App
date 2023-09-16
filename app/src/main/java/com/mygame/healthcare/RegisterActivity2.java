package com.mygame.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity2 extends AppCompatActivity {

    EditText regusername,regpassword,regconfirmpassword,email;
    Button Register;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        regusername=findViewById(R.id.editTextltbookfullname);
        email=findViewById(R.id.editTextltbookAddress);
        regpassword=findViewById(R.id.editTextltbookpincode);
        regconfirmpassword=findViewById(R.id.editTextltbookcontact);
        Register=findViewById(R.id.ltbookbutton);
        textView=findViewById(R.id.textViewExistinguser);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{ new Intent(RegisterActivity2.this,LoginActivity2.class)});
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=regusername.getText().toString();
                String mail=email.getText().toString();
                String password=regpassword.getText().toString();
                String Confirmpassword=regconfirmpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length()==0 || mail.length()==0 || password.length()==0 ||
                Confirmpassword.length()==0)
                {
                    Toast.makeText(RegisterActivity2.this, "Please fill All details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(Confirmpassword)==0)
                    {
                        if (isValidPassword(password)){
                            db.register(username,mail,password);
                            Toast.makeText(RegisterActivity2.this, "Record inserted", Toast.LENGTH_SHORT).show();
                            Log.d("Register Done", "record inserted successfully");
                            startActivities(new Intent[]{new Intent(RegisterActivity2.this,LoginActivity2.class)});
                        }else {
                        Toast.makeText(RegisterActivity2.this,
                                "The password must contain atleast 8 character, a letter,digit and special character",
                                Toast.LENGTH_SHORT).show();}
                    }else {
                    Toast.makeText(RegisterActivity2.this, "Password and Confirm Password didn't match try again",
                            Toast.LENGTH_SHORT).show();}
                }
            }
        });
    }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}