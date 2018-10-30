package com.example.annak.mygame;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private static final int MIN_GUESS = 0;
    private static final int MAX_GUESS = 100;

    private Guess number = new Guess(MIN_GUESS, MAX_GUESS);
    private boolean isStarted = false;

    private Button btn;
    private Button yes;
    private Button no;
    private TextView display;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.press);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        display = findViewById(R.id.display);
        res = getResources();

        display.setText(res.getString(R.string.main_display, MIN_GUESS, MAX_GUESS));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStarted) {
                    btn.setText(R.string.end);
                    btn.setBackgroundResource(R.drawable.stop);
                    yes.setEnabled(true);
                    no.setEnabled(true);
                    display.setText(res.getString(R.string.ask_greater, number.currentGuess()));
                    isStarted = true;
                } else {
                    btn.setText(R.string.start);
                    btn.setBackgroundResource(R.drawable.btns);
                    yes.setEnabled(false);
                    no.setEnabled(false);
                    display.setText(res.getString(R.string.main_display, MIN_GUESS, MAX_GUESS));
                    isStarted = false;
                    number = new Guess(MIN_GUESS, MAX_GUESS);
                }
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.guessed()) {
                    display.setText(res.getString(R.string.result, number.nextGuess(true)));
                    yes.setEnabled(false);
                    no.setEnabled(false);
                } else {
                    display.setText(res.getString(R.string.ask_greater, number.nextGuess(true)));
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.guessed()) {
                    display.setText(res.getString(R.string.result, number.nextGuess(false)));
                    yes.setEnabled(false);
                    no.setEnabled(false);
                } else {
                    display.setText(res.getString(R.string.ask_greater, number.nextGuess(false)));
                }
            }
        });
    }
}
