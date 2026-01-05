package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class UserFragment extends Fragment {
    TextView accId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        accId = view.findViewById(R.id.Idnumber);
        Intent intent = requireActivity().getIntent();
        int userID = intent.getIntExtra("UserID", -1);
        String userName = intent.getStringExtra("UserName");

        if (userName != null) {
            accId.setText("Player " + userName);
        } else {
            accId.setText("Player " + String.format("%03d", userID));
        }

        return view;
    }
}