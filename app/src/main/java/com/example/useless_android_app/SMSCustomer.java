package com.example.useless_android_app;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SMSCustomer extends AppCompatActivity {
    SmsManager smsManager = SmsManager.getDefault();
    EditText textviewSellerName;
    EditText textviewMessage;
    Button sendButton;
    String sellerName;
    String message;
    String customerMobile;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sms_customer);


        textviewSellerName = findViewById(R.id.textviewSellerName);
        textviewMessage = findViewById(R.id.textviewMessage);
        sendButton = findViewById(R.id.sendButton);

        customerMobile = getIntent().getStringExtra("customerMobile");

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sellerName = textviewSellerName.getText().toString();
                message = textviewMessage.getText().toString();

                message += sellerName;
                smsManager.sendTextMessage(customerMobile, null, message, null, null);
                Toast.makeText(SMSCustomer.this, "SMS sent", Toast.LENGTH_SHORT).show();
            }
        });

    }
}