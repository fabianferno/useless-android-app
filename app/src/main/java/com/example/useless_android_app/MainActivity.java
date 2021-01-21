package com.example.useless_android_app;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    EditText name;
    EditText roll;
    EditText phn;
    EditText grp;

    Spinner sp;
    Spinner sp1;

    RadioGroup radioGroup;
    CheckBox agree;

    Button submit;
    Button signin;

    String s;
    String s1;
    String s2;


    ArrayList arrayList;

    ArrayAdapter arrayAdapter;

    ArrayList arrayList1;

    ArrayAdapter arrayAdapter1;

    EditText eddob;

    AlertDialog.Builder alertDialog;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);

        sp1 = findViewById(R.id.spinner2);
        name = findViewById(R.id.editTextTextPersonName);
        roll = findViewById(R.id.editTextTextPersonName2);
        phn = findViewById(R.id.editTextTextPersonName3);
        grp = findViewById(R.id.editTextTextPersonName5);
        submit = findViewById(R.id.button2);
        signin = findViewById(R.id.button3);
        agree = findViewById(R.id.checkBox);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.notification);

        eddob = findViewById(R.id.editTextTextPersonName4);

        radioGroup = findViewById(R.id.radiogroup);

        arrayList = new ArrayList();

        arrayList1 = new ArrayList();


        arrayList.add("Select Year");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        arrayList1.add("Select Dept");
        arrayList1.add("IT");
        arrayList1.add("EEE");
        arrayList1.add("ECE");
        arrayList1.add("MECH");


        arrayAdapter =

                new ArrayAdapter(MainActivity.this,

                        android.R.layout.simple_list_item_1, arrayList);

        sp.setAdapter(arrayAdapter);

        arrayAdapter1 =

                new ArrayAdapter(MainActivity.this,

                        android.R.layout.simple_list_item_1, arrayList1);

        sp1.setAdapter(arrayAdapter1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = radioGroup.getCheckedRadioButtonId();
                switch (i) {
                    case R.id.radioButton2:
                        s1 = "male";
                        break;

                    case R.id.radioButton:
                        s1 = "female";
                        break;
                }

                boolean st = agree.isChecked();
                if (st) {
                    s = name.getText().toString() + "\n" + roll.getText().toString() + "\n" + phn.getText().toString() + "\n" + s1 + "\n" + grp.getText().toString();
                    Intent an = new Intent(MainActivity.this, RegPage.class);
                    an.putExtra("key", s);
                    startActivity(an);
                    Toast.makeText(MainActivity.this, "Next page Activated!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Agree Terms and Condition!", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(MainActivity.this)//for alert message
                            .setTitle("Alert!")
                            .setMessage("Agree Terms and Condition!")
                            .setPositiveButton("Okayyy!", null)
                            .setNegativeButton("No", null)
                            .show();
                    mediaPlayer.start();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2 = phn.getText().toString();
                Intent ob = new Intent(MainActivity.this, SignPage.class);
                startActivity(ob);
            }
        });


    }


    public void dat(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override

            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                eddob.setText(i + "/" + i1 + "/" + i2);

                eddob.setEnabled(false);

            }

        }, 1999, 0, 1);

        datePickerDialog.show();

    }


}