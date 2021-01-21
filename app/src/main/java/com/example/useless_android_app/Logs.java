package com.example.useless_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Logs extends AppCompatActivity {
    DbHelper dbHelper;

    String customerName;
    String customerMobile;
    String sales;
    String dateOfSale;
    String region;
    String typeOfCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        customerName = getIntent().getStringExtra("customerName");
        customerMobile = getIntent().getStringExtra("customerMobile");
        sales = getIntent().getStringExtra("sales");
        dateOfSale = getIntent().getStringExtra("dateOfSale");
        region = getIntent().getStringExtra("region");
        typeOfCustomer = getIntent().getStringExtra("typeOfCustomer");

        dbHelper.saveLog(customerName, customerMobile, sales, dateOfSale, region, typeOfCustomer);
        Toast.makeText(Logs.this, "Log Saved!", Toast.LENGTH_SHORT).show();
    }
}