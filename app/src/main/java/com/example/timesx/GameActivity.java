package com.example.timesx;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView txtScore, txtDamage, txtGameName;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game); // your game.xml layout

        txtScore = findViewById(R.id.txtScore);
        txtDamage = findViewById(R.id.txtDamage);
        txtGameName = findViewById(R.id.txtGameName);
        gameView = findViewById(R.id.gameView);

        String gameName = getIntent().getStringExtra("gameName");
        if (gameName != null) {
            txtGameName.setText(gameName);
        }

        // Update score/damage periodically
        txtScore.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (gameView != null) {
                    txtScore.setText("Score: " + gameView.score);
                    txtDamage.setText("Damage: " + gameView.damage + "/10");
                    if (gameView.damage < 10) {
                        txtScore.postDelayed(this, 100); // refresh every 0.1s
                    }
                }
            }
        }, 100);
    }
}
