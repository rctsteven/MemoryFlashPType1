package com.example.owner.memoryflashptype1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FlashMemGame extends AppCompatActivity {

    ImageView gameImageView;
    TextView gameTextArea;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;

    int countDownIndex;

    int numCorrect;
    int totalRounds;

    int userStringLength;

    // Ids for pictures
    int checkMarkId;
    int redXId;
    int whiteDefaultId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_mem_game);

        // Find and bind the views
        gameImageView = (ImageView) findViewById(R.id.imageView);
        gameTextArea = (TextView) findViewById(R.id.gameTextArea);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);

        // Find ids for pictures
        checkMarkId = getResources().getIdentifier("checkmark", "drawable", getPackageName());
        redXId = getResources().getIdentifier("redx", "drawable", getPackageName());
        whiteDefaultId = getResources().getIdentifier("whitedefault", "drawable", getPackageName());

        isGameStringShown = false;
        isLengthShown = false;
        betweenRounds = false;

        numCorrect = 0;
        totalRounds = 0;

        // Start countdown to let the user get ready
        String ready = "Ready";
        countDownIndex = 0;
        gameTextArea.setText(ready);
        countDown();
    }

    public void countDown(){
        final String[] countDownWords = new String[3];
        countDownWords[0] = "Ready";
        countDownWords[1] = "Set";
        countDownWords[2] = "Go";

        new CountDownTimer(4600, 1500){

            @Override
            public void onTick(long l) {
                gameTextArea.setText(countDownWords[countDownIndex]);
                countDownIndex++;
            }

            @Override
            public void onFinish() {
                startRound();
            }
        }.start();
    }


    String empty = "";
    String userString = ""; // user's input
    String gameString = ""; // string created by the game
    boolean isLengthShown; // indicates if the length is currently being show in the gameTextArea
    boolean isGameStringShown; // indicates if the game string is currently being shown in the gameTextArea
    boolean betweenRounds; // indicates if the game is inbetween 2 rounds

    public void startRound(){
        userString = empty;
        gameString = empty;

        userStringLength = 0;
        betweenRounds = false;
        totalRounds++;
        gameString = generateGameString(3, 5);
        int gameStrLength = gameString.length();
        String characterCount = gameStrLength + " characters";
        gameTextArea.setText(characterCount);
        isLengthShown = true;

        // Tell the user how many characters will be in the next gameString
        new CountDownTimer(1000, 500){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                isLengthShown = false;
                showGameString(); // Show the game string for a given period of time
            }
        }.start();


        // Set the button listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown && !betweenRounds){ // Only allow input if the length isn't currently being shown and a round is active
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("1");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("2");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("3");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("4");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("5");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("6");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("7");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("8");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("9");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLengthShown  && !betweenRounds){ // Only allow input if the length isn't currently being shown
                    if(isGameStringShown) {
                        // If the game string is currently being shown, clear it from the gameTextArea
                        gameTextArea.setText(empty);
                    }
                    updateUserString("0");
                    userStringLength++;
                    isEndOfRound();
                }
            }
        });
    }

    public String generateGameString(int minChars, int maxChars){
        String newGameString = "";
        Random r = new Random();
        int length = r.nextInt((maxChars - minChars) + 1) + minChars;
        for(int i = 0; i < length; i++){
            int randInt = r.nextInt(10);
            newGameString+=String.valueOf(randInt);
        }
        return newGameString;
    }

    public void showGameString(){
        isGameStringShown = true;
        gameTextArea.setText(gameString);

        // Only show the game string for a set amount of time
        new CountDownTimer(750, 500){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                isGameStringShown = false;
                gameTextArea.setText(empty);
            }
        }.start();
    }

    public void updateUserString(String i){
        userString+=i;
        gameTextArea.setText(userString);
    }

    public void isEndOfRound(){
        // Check if an end condition is met
        // If the userString matches the game string, the user is correct, end the round, show the green checkmark, award a point
        // If the user makes a mistake, end the round, show the red X

        // Check if user is correct
        if(userString.equals(gameString)){
            // User is correct
            betweenRounds = true; // Round ended, no round is active so deactivate the buttons
            numCorrect++; // Give the user a point

            // Show the green checkmark for a given period of time
            gameImageView.setImageResource(checkMarkId);
            new CountDownTimer(1000, 500){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    // Change the picture back to white default
                    gameImageView.setImageResource(whiteDefaultId);

                    // Begin the next round
                    startRound();
                }
            }.start();


        }


        // Check if user is incorrect
        if(userString.charAt(userStringLength - 1) != gameString.charAt(userStringLength - 1)){
            // User's last character is incorrect
            betweenRounds = true;

            // Show the red x for a given period of time
            gameImageView.setImageResource(redXId);
            new CountDownTimer(1000, 500){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    // Change the picture back to white default
                    gameImageView.setImageResource(whiteDefaultId);

                    // Begin the next round
                    startRound();

                }
            }.start();


        }


    }
}
