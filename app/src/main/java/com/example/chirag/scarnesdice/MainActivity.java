package com.example.chirag.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView score;
    public ImageView dice;
    public Button roll, hold, reset;

    public int userOverallScore= 0, userTurnScore= 0, comOverallScore = 0, comTurnScore = 0;

    int[] drawables = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*                  VIEWS                     */
        score = (TextView) findViewById(R.id.score);
        dice = (ImageView) findViewById(R.id.imageView);
        roll = (Button) findViewById(R.id.button2);
        hold = (Button) findViewById(R.id.button3);
        reset = (Button) findViewById(R.id.reset);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentRoll = rollDice();
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        private int rollDice(){
            Random random = new Random();
            int randomNumber = random.nextInt(bound:6);
            return randomNumber;
        }

        private void resetGame(){
            userOverallScore = 0;
            comOverallScore = 0;
            userTurnScore = 0;
            comTurnScore = 0;
        }

        private void enableButtons(boolean isEnabled){
            roll.setEnabled(isEnabled);
            hold.setEnabled(isEnabled);
        }

    }
}
