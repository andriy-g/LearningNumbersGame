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

    int number, number2;
    int countTotal = 0;
    int gamesWon = 0;

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

        randomNumberStart();
        countTotal++;
    }

    public void randomNumberStart()
    {
        //Generates random numbers for left and right button
        Random rand = new Random();
        number = rand.nextInt(10)+1;
        number2 = rand.nextInt(10)+1;
        TextView myText = (TextView)findViewById(R.id.buttonLeft);
        TextView myText2 = (TextView)findViewById(R.id.buttonRight);
        String myString = String.valueOf(number);
        String myString2 = String.valueOf(number2);
        myText.setText(myString);
        myText2.setText(myString2);
    }



    //Left Button
    public void left(View v)
    {
        if (number > number2)
        {
            gamesWon++;
            Toast.makeText(getBaseContext(), "You got it", Toast.LENGTH_LONG).show();
            countTotalGames();
            totalGamesWon();

//            Button displayWon = (Button)findViewById(R.id.won);
//            displayWon.setText("" + ++gamesWon);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
            countTotalGames();
        }
        countTotal++;
        randomNumberStart();

    }
    //Right Button
    public void right(View v)
    {
        if (number2 > number)
        {
            gamesWon++;
            Toast.makeText(getBaseContext(), "Good Job", Toast.LENGTH_LONG).show();
            countTotalGames();
            totalGamesWon();

//            Button displayWon = (Button)findViewById(R.id.won);
//            displayWon.setText("" + ++gamesWon);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
            countTotalGames();
        }
        countTotal++;
        randomNumberStart();

    }

    //Updates a button with the total games played value
    public void countTotalGames()
    {
        TextView myText = (TextView)findViewById(R.id.totalButton);
        String myString = String.valueOf(countTotal);
        myText.setText(myString);
    }

    //Updates a button with gamesWon value
    public void totalGamesWon()
    {
        TextView myText = (TextView)findViewById(R.id.won);
        String myString = String.valueOf(gamesWon);
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
