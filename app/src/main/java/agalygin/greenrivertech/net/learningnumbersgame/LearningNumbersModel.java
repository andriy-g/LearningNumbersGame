package agalygin.greenrivertech.net.learningnumbersgame;

import java.util.Random;

/**
 * Created by Andriy G on 4/7/2016.
 */
public class LearningNumbersModel
{
    private int number;
    private int number2;
    private int countTotal;
    private int gamesWon;

    public LearningNumbersModel()
    {
        randomNumberStart();
        countTotal = 0;
        gamesWon = 0;
    }

    //Randomizes numbers between 1 - 10
    public void randomNumberStart()
    {

        Random rand = new Random();
        number = rand.nextInt(10) + 1;
        number2 = rand.nextInt(10) + 1;

    }

    //Returns count total
    public int getCountTotal() {
        return countTotal;
    }

    //returns games won
    public int getGamesWon() {
        return gamesWon;
    }

    //returns left button number
    public int getLeftNumber()
    {
        return number;
    }

    //returns right button number
    public int getRightNumber()
    {
        return number2;
    }

    public static final int LEFT_SIDE = 0;
    public static final int RIGHT_SIDE = 1;

    //checks left and right button if the number selected is correct
    public boolean play(int choice) {
        countTotal++;

        // choice is either LEFT_SIDE or RIGHT_SIDE
        if(choice == LEFT_SIDE)
        {
            if(number >= number2)
            {
                //System.out.println("Good Job");
                gamesWon++;
                return true;

            }
            else
            {
                //System.out.println("Try Again");
                return false;
            }
        }
        else
        {
            if(number <= number2)
            {
                //System.out.println("Good Job");
                gamesWon++;
                return true;
            }
            else
            {
                //System.out.println("Try Again");
                return false;
            }
        }
    }
}