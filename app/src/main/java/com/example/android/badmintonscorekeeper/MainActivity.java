package com.example.android.badmintonscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Tracks score for player 1.
    int scoreP1;

    //Tracks score for player 2.
    int scoreP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreP1 = 0;
        scoreP2 = 0;
    }

    /**
     * Increase the score for Player 1.
     */
    public void addPointP1(View v) {
        scoreP1++;
        displayForP1(scoreP1);
        showComment("");
        winCheck();
    }

    /**
     * Displays the given score for Player 1.
     */
    public void displayForP1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Player 2.
     */
    public void addPointP2(View v) {
        scoreP2++;
        displayForP2(scoreP2);
        showComment("");
        winCheck();
    }

    /**
     * Displays the given score for Player 2.
     */
    public void displayForP2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays any string in the commentBox TextView.
     */
    public void showComment(String comment) {
        TextView commentView = (TextView) findViewById(R.id.commentBox);
        commentView.setText(comment);
    }

    /**
     * Method to check for winner.
     */
    public void winCheck() {
        if(scoreP1 == 30) {
            showComment("Player-1 wins!!");
            buttonToggle(false);
        }
        else if(scoreP2 == 30) {
            showComment("Player-2 wins!!");
            buttonToggle(false);
        }
        else if(scoreP1 == 21 && scoreP2 < scoreP1 - 1 || scoreP2 == 21 && scoreP1 < scoreP2 - 1)
        {
            if(scoreP1 == 21) {
                showComment("Player-1 wins!!");
                buttonToggle(false);
            }
            else {
                showComment("Player-2 wins!!");
                buttonToggle(false);
            }
        }
        else if(scoreP1 >= 20 && scoreP2 >= 20) {
            if(scoreP1 - scoreP2 == 2) {
                showComment("Player-1 wins!!");
                buttonToggle(false);
            }
            else if(scoreP2 - scoreP1 == 2) {
                showComment("Player-2 wins!!");
                buttonToggle(false);
            }
        }
    }

    public void buttonToggle(boolean flag) {
        Button btn1 = (Button) findViewById(R.id.player1_score_button);
        Button btn2 = (Button) findViewById(R.id.player2_score_button);
        btn1.setEnabled(flag);
        btn2.setEnabled(flag);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreP1 = 0;
        scoreP2 = 0;
        displayForP1(scoreP1);
        displayForP2(scoreP2);
        showComment("");
        buttonToggle(true);
    }

}
