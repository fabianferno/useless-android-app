package com.example.useless_android_app;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SalesLogForm extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    EditText textViewCustomerName;
    EditText textViewCustomerNumber;
    EditText textViewSales;
    EditText textViewDate;

    Spinner regionSpinner;

    RadioGroup typeOfCustomerRadioGroup;
    CheckBox agreeCheckBox;

    Button submitButton;
    Button callCustomerButtom;

    ArrayList regionList;

    ArrayAdapter arrayAdapter;


    String customerName;
    String customerMobile;
    String sales;
    String dateOfSale;
    String region;
    String typeOfCustomer;
    Boolean agree;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.sales_log_form);


        mediaPlayer = MediaPlayer.create(SalesLogForm.this, R.raw.notification);

        textViewCustomerName = findViewById(R.id.textViewCustomerName);
        textViewCustomerNumber = findViewById(R.id.textViewCustomerNumber);
        textViewSales = findViewById(R.id.textViewSales);
        textViewDate = findViewById(R.id.textViewDate);
        regionSpinner = findViewById(R.id.regionSpinner);
        typeOfCustomerRadioGroup = findViewById(R.id.typeOfCustomerRadioGroup);
        agreeCheckBox = findViewById(R.id.agreeCheckBox);

        submitButton = findViewById(R.id.submitButton);
        callCustomerButtom = findViewById(R.id.callCustomerButtom);


        regionList = new ArrayList();

        regionList.add("Select Region");
        regionList.add("Chester's Apartment");
        regionList.add("Golden Enclave");
        regionList.add("Prince Courtyard");
        regionList.add("Dawn Dale");


        arrayAdapter = new ArrayAdapter(SalesLogForm.this, android.R.layout.simple_list_item_1, regionList);

        regionSpinner.setAdapter(arrayAdapter);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agree = agreeCheckBox.isChecked();
                if (agree) {
                    customerName = textViewCustomerName.getText().toString();
                    customerMobile = textViewCustomerNumber.getText().toString();
                    sales = textViewSales.getText().toString();
                    dateOfSale = textViewDate.getText().toString();
                    region = regionSpinner.toString();
                    int i = typeOfCustomerRadioGroup.getCheckedRadioButtonId();
                    switch (i) {
                        case R.id.homeCustomer:
                            typeOfCustomer = "Home";
                            break;

                        case R.id.commercialCustomer:
                            typeOfCustomer = "Commercial";
                            break;
                    }
                    Intent logs = new Intent(SalesLogForm.this, Logs.class);
                    logs.putExtra("customerName", customerName);
                    logs.putExtra("customerMobile", customerMobile);
                    logs.putExtra("sales", sales);
                    logs.putExtra("dateOfSale", dateOfSale);
                    logs.putExtra("region", region);
                    logs.putExtra("typeOfCustomer", typeOfCustomer);

                    startActivity(logs);
                    Toast.makeText(SalesLogForm.this, "Log Saved!", Toast.LENGTH_SHORT).show();
                } else {
                    new AlertDialog.Builder(SalesLogForm.this)//for alert message
                            .setTitle("Hold Up!")
                            .setMessage("Authorize as Sales Person to save the log")
                            .setPositiveButton("Okay", null)
                            .show();
                    mediaPlayer.start();
                }
            }
        });
        callCustomerButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerMobile = textViewCustomerNumber.getText().toString();
                if (customerMobile == "") {
                    new AlertDialog.Builder(SalesLogForm.this)//for alert message
                            .setTitle("Empty Field")
                            .setMessage("Enter the customer number in the field")
                            .setPositiveButton("Okay", null)
                            .show();
                    mediaPlayer.start();
                } else {

                    Intent call = new Intent(SalesLogForm.this, SMSCustomer.class);
                    call.putExtra("customerMobile", customerMobile);
                    startActivity(call);
                }
            }
        });


    }


    public void showDatePicker(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(SalesLogForm.this, new DatePickerDialog.OnDateSetListener() {

            @Override

            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                textViewDate.setText(i + "/" + i1 + "/" + i2);

                textViewDate.setEnabled(false);

            }

        }, 1999, 0, 1);

        datePickerDialog.show();

    }


}