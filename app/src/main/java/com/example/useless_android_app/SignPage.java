package com.example.useless_android_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignPage extends AppCompatActivity {

    TextView head;
    EditText name;
    EditText pwd;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_page);
        head=findViewById(R.id.textView3);
        name=findViewById(R.id.editTextTextPersonName6);
        pwd=findViewById(R.id.editTextTextPassword);
        log=findViewById(R.id.button5);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignPage.this, "Signed in", Toast.LENGTH_SHORT).show();
            }
        });

    }
}