package com.example.lab_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textResult;
    private Button btnReplay, btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final Intent intent = getIntent();
        String message = intent.getStringExtra("score");
        textResult= findViewById(R.id.result_text);
        textResult.setText(message);

        btnReplay = findViewById(R.id.replay_button);
        btnHome = findViewById(R.id.home_button);
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, StartScreenActivity.class));
            }
        });
    }
}
