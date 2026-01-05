package com.example.timesx;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    Button exit,game;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //shifting everything from homejava here

        game = view.findViewById(R.id.btnGame);
        exit = view.findViewById(R.id.exitBtn);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().finishAffinity();
                System.exit(0);
            }
        });

        //2. defining data source
        String[] games = {"Catch 2x", "Catch 3x", "Catch 4x"};

        //games=getResources().getStringArray(R.array.game_type_array);

        //3.creating adapter
        ArrayAdapter<String> gtype = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, games);

        //4. getting reference to adapter view
        ListView listView = (ListView) view.findViewById(R.id.gameTypes);

        //5. setting adapter on adapter view
        listView.setAdapter(gtype);

        //setting the view visible
        game.setOnClickListener(v -> {
            listView.setVisibility(View.VISIBLE);
        });

        //6. setting event listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listView.getVisibility() == View.VISIBLE) {
                    Intent intent = new Intent(requireContext(), Game.class);
                    intent.putExtra("v1", String.valueOf(position));
                    listView.setVisibility(View.GONE);
                    startActivity(intent);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }
}