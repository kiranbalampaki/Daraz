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
import com.example.daraz.api.UserAPI;
import com.example.daraz.model.User;
import com.example.daraz.url.URL;

import java.util.Random;

import retrofit2.Call;

public class RegisterActivity extends AppCompatActivity {

    private TextView login_text;
    private EditText etName, etEmail, etPhoneNumber, etSMSCode, etPasswordRegister;
    private Button btnSendSMS, btnSignUp;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etSMSCode = findViewById(R.id.etSMSCode);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPasswordRegister = findViewById(R.id.etPasswordRegister);
        btnSendSMS = findViewById(R.id.btnSendSMS);
        btnSignUp = findViewById(R.id.btnSignUp);

        login_text = findViewById(R.id.login_text);


        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString())){
                    etPhoneNumber.setError("Enter Phone Number");
                    return;
                }
                final int random = (int)(Math.random() * 9999 + 0000);
                etSMSCode.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        etSMSCode.setText(Integer.toString(random));
                    }
                }, 3000);
            }
        });

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhoneNumber.getText().toString();
                String password = etPasswordRegister.getText().toString();
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                User users = new User(name, email, password, phone);

                UserAPI usersAPI = URL.getInstance().create(UserAPI.class);
                //Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);
            }
        });
    }
}
