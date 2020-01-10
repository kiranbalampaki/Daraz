package com.example.daraz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daraz.R;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    private TextView login_text;
    private EditText etPhoneNumber, etSMSCode;
    private Button btnSendSMS;

    int min=1;
    int max=1000;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etSMSCode = findViewById(R.id.etSMSCode);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSendSMS = findViewById(R.id.btnSendSMS);

        login_text = findViewById(R.id.login_text);


        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString())){
                    etPhoneNumber.setError("Enter Phone Number");
                    return;
                }
                Thread threaddelay = new Thread(){
                    @Override
                    public void run(){
                        try {
                            sleep(2000);
                            //int a = r.nextInt(max - min + 1)+ min;
                            etSMSCode.setText(Integer.toString(23));
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                threaddelay.start();
            }
        });

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
