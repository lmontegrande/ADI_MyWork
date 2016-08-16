package com.example.lmont.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GameManager gameManager;
    Button restartButton;
    TextView scoreText;
    Button[] buttons;
    GridLayout boardLayout;
    TextView currentPlayerText;
    boolean roundDone;
    Intent passedInIntent;
    String player1;
    String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    private void setUp() {
        gameManager = new GameManager();
        restartButton = (Button) findViewById(R.id.restartButton);
        scoreText = (TextView) findViewById(R.id.scoreText);
        boardLayout = (GridLayout) findViewById(R.id.boardLayout);
        currentPlayerText = (TextView) findViewById(R.id.currentPlayerText);
        passedInIntent = getIntent();
        player1 = passedInIntent.getStringExtra("player1");
        player2 = passedInIntent.getStringExtra("player2");
        roundDone = false;
        buttons = new Button[9];
        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (roundDone) {
                        gameManager.resetRound();
                        resetViews();
                        roundDone = false;
                        return;
                    }
                    int myIndex = boardLayout.indexOfChild(view);
                    if (gameManager.hasButtonBeenClicked(myIndex)) return;
                    int currentPlayerValue = gameManager.isXTurn() ? -1 : 1; // -1, X : 1, O
                    editView(myIndex, currentPlayerValue);
                    gameManager.switchTurn();
                    if(gameManager.setButton(myIndex, currentPlayerValue) != 0) win(currentPlayerValue);
                    if(gameManager.isBoardFull()) win(0);
                }
            });

            resetViews();
        }

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private void editView(int buttonIndex, int playerValue) {
        String playerValueToString = playerValue < 0 ? player1 : player2;
        String nextPlayerValueToString = playerValue > 0 ? player1 : player2;

        buttons[buttonIndex].setText(playerValueToString);
        if (playerValue < 0) {
            buttons[buttonIndex].setBackgroundColor(Color.GREEN);
        } else {
            buttons[buttonIndex].setBackgroundColor(Color.RED);
        }

        currentPlayerText.setText("Current Player:\n" + nextPlayerValueToString);
    }

    private void resetViews() {
        for (Button button : buttons) {
            button.setText("");
            button.setBackgroundResource(0);
            button.setBackgroundColor(Color.YELLOW);
        }
        updateScore();
    }

    private void updateScore() {
        scoreText.setText(player1 + ": " + gameManager.getScoreX() + "\n" + player2 + ": " + gameManager.getScoreO());
        String nextPlayerValueToString = gameManager.isXTurn() ? player1 : player2;
        currentPlayerText.setText("Current Player:\n" + nextPlayerValueToString);
    }

    private void win(int currentPlayerValue) {
        String winner;
        if (currentPlayerValue == 0) {
            winner = "NOBODY ";
        } else {
            winner = currentPlayerValue < 0 ? player1 : player2;
        }
        Toast.makeText(MainActivity.this, winner + " WON!\nTap" +
                " to replay", Toast.LENGTH_SHORT).show();
        gameManager.addToScore(currentPlayerValue);

        updateScore();
        roundDone = true;
    }

    private void resetGame() {
        gameManager.resetGame();
        resetViews();
    }
}
