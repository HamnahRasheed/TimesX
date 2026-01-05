package com.example.timesx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_page);

        //when home page opens it shows the home fragment and all the UI
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }


        //bottom nav k items ko access krna hai
        BottomNavigationView bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item->{
            int id=item.getItemId();
            Fragment selectedFragment=null;
            if (id == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            }
            else if (id == R.id.nav_explore) {
                selectedFragment = new ExploreFragment();
            }
            else if (id == R.id.nav_user) {
                selectedFragment = new UserFragment();
            }
            if(selectedFragment!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            }
            return true;
        });

    }
}
