package com.example.daraz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.daraz.ui.LoginActivity;
import com.example.daraz.ui.RegisterActivity;

public class LoginRegisterActivity extends AppCompatActivity {
    private Button btnOpenRegisterFragment, btnOpenLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        btnOpenRegisterFragment = findViewById(R.id.btnOpenRegisterFragment);
        btnOpenLoginFragment = findViewById(R.id.btnOpenLoginFragment);

        btnOpenRegisterFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginRegisterActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnOpenLoginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginRegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
