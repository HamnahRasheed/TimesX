package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button signup,login,guestUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        guestUser=findViewById(R.id.guestUser);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.SignUp);

        guestUser.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                //generate random id
                Random random = new Random();
                int userID = random.nextInt(1000);
                Intent user=new Intent(MainActivity.this, HomePage.class);
                user.putExtra("UserID", userID);
                startActivity(user);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginUser=new Intent(MainActivity.this,Login.class);
                startActivity(loginUser);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp=new Intent(MainActivity.this,SignUp.class);
                startActivity(SignUp);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}