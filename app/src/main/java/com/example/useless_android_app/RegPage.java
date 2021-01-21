package com.example.useless_android_app;


import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegPage extends AppCompatActivity {

    TextView name;
    String st;
    String number;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        name = findViewById(R.id.textView2);

        st = getIntent().getStringExtra("key");
        name.setText(st);
        save = findViewById(R.id.button4);


    }


    public void save(View view) {
        SmsManager smsManager =  SmsManager.getDefault();

        smsManager.sendTextMessage(number,null,"Congrats! Registered successfully!!",null,null); //we need to add permission in manifest file to send sms

        Toast.makeText(this, "Sms Send successfully!", Toast.LENGTH_SHORT).show();
    }
}