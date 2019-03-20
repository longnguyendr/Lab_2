package com.example.lab_2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnGame;
    private TextView shows, timeCountdown;
    private int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeCountdown = findViewById(R.id.timer_game);
        btnGame = findViewById(R.id.game_button);
        shows = findViewById(R.id.show_game);

        shows.setText("You have click: " + num + " times");
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                shows.setText("You have click: " + num + " times");
            }
        });
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeCountdown.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeCountdown.setText("done!");
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("score", String.valueOf(num));
                startActivity(intent);
            }
        }.start();

    }
}


