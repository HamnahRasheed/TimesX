package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {
    Button resetpasswordbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);
        resetpasswordbtn=findViewById(R.id.resetpasswordbtn);

        resetpasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset=new Intent(ForgotPassword.this,ResetBtn.class);
                startActivity(reset);
            }
        });
    }
}

