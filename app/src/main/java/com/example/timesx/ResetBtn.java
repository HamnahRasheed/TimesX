package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class ResetBtn extends AppCompatActivity{
    Button resetbtn;
    EditText password,cnfrmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pass_btn);
        resetbtn=findViewById(R.id.resetNewPass);
        password=findViewById(R.id.passWord);
        cnfrmPassword=findViewById(R.id.confirmPassWord);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnfrmPassword.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(ResetBtn.this, "Password reset successfully", Toast.LENGTH_SHORT).show();
                    Intent main=new Intent(ResetBtn.this,Login.class);
                    startActivity(main);
                }
                else{
                    Toast.makeText(ResetBtn.this,"Password not matched",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

