package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText userName,passWord;
    Button btnReset;
    TextView forgPass,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        forgPass=findViewById(R.id.forgPass);
        userName=findViewById(R.id.userName);
        //String stName=userName.getText().toString();
        passWord=findViewById(R.id.passWord);
        btnReset=findViewById(R.id.btnReset);
        signUp=findViewById(R.id.SignUp);

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                userName.setText("");
                passWord.setText("");
                Toast.makeText(Login.this, "RESET", Toast.LENGTH_SHORT).show();
            }
        });

        forgPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotten=new Intent(Login.this,ForgotPassword.class);
                startActivity(forgotten);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp=new Intent(Login.this,SignUp.class);
                startActivity(SignUp);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View v){

        if(userName.getText().toString().equals("hamnah") && passWord.getText().toString().equals("12345")){
            Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent home=new Intent(Login.this, HomePage.class);
            String editName=userName.getText().toString().trim();
            home.putExtra("UserName", String.valueOf(editName));
            startActivity(home);
        }

        else{
            Toast.makeText(Login.this, "Wrong Username or password", Toast.LENGTH_SHORT).show();
        }

    }

//    1st mwthod
//    Button Reset=findViewById(R.id.btnReset);
//    public void rst(View v){
//        userName.setText(" ");
//        passWord.setText(" ");
//   }
}

