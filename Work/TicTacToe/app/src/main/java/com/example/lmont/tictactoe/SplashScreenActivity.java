package com.example.lmont.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ((Button) findViewById(R.id.startButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.putExtra("player1", ((EditText) findViewById(R.id.player1Text)).getText().toString());
                intent.putExtra("player2", ((EditText) findViewById(R.id.player2Text)).getText().toString());
                startActivity(intent);
            }
        });
    }
}
