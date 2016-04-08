package agalygin.greenrivertech.net.learningnumbersgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LearningNumbersGame extends AppCompatActivity {

    private LearningNumbersModel model = new LearningNumbersModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_numbers_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Calls method from LearningNumbersModel.java and randomizes the numbers
        model.randomNumberStart();

        //Updates buttons to new random number
        updateButtons();

    }


    //Left Button - Checks if number selected is correct
    public void left(View v)
    {
        countTotalGames();
        boolean result = model.play(LearningNumbersModel.LEFT_SIDE);

        if(result == true) {
            totalGamesWon();
            Toast.makeText(getBaseContext(), "You got it", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
        }
        model.randomNumberStart();
        updateButtons();
    }

    //Updates button with the new random number
    public void updateButtons() {
        TextView myText = (TextView)findViewById(R.id.buttonLeft);
        TextView myText2 = (TextView)findViewById(R.id.buttonRight);
        String myString = String.valueOf(model.getLeftNumber());
        String myString2 = String.valueOf(model.getRightNumber());
        myText.setText(myString);
        myText2.setText(myString2);
    }
    //Right Button - check if it is correct
    public void right(View v)
    {
        countTotalGames();

        boolean result = model.play(LearningNumbersModel.RIGHT_SIDE);
        if(result == true) {
            totalGamesWon();
            Toast.makeText(getBaseContext(), "You got it", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
        }
        model.randomNumberStart();
        updateButtons();
    }

    //Updates a button with the total games played value
    public void countTotalGames()
    {
        TextView myText = (TextView)findViewById(R.id.totalButton);
        String myString = String.valueOf(model.getCountTotal());
        myText.setText(myString);
    }

    //Updates a button with gamesWon value
    public void totalGamesWon()
    {
        TextView myText = (TextView)findViewById(R.id.won);
        String myString = String.valueOf(model.getGamesWon());
        myText.setText(myString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learning_numbers_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
