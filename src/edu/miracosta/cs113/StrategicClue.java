package edu.miracosta.cs113;

/**
 * StrategicClue.java : This class will allow the program to guess the correct answer
 * in 20 guesses or under. Not much is changed outside of the Random class other than giving values to the
 * variables instead of calling random every time and adding a loop in the while loop so it checks the values
 * beforehand
 *
 *
 * @author Spencer Unitt
 * @version 1.0
 *
 */


import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class StrategicClue {

    /*
     *  ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      solution = jack.checkAnswer(weapon, location, murder);
     *
     *      if (solution == 1) {
                weapon++;
            }
            else if (solution == 2) {
                location++;
            }
            else if (solution == 3){
                murder++;
            }
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        //Variable Declaration and Initialization
        int answerSet, solution, murder = 1, weapon = 1, location = 1;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);


        // Input
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // Process
        jack = new AssistantJack(answerSet);

        do {

            // Sets solution to the value of the initial variables and checks if any are correct
            solution = jack.checkAnswer(weapon, location, murder);

            //If the solutions are incorrect, go in and increment the value by 1 until there is a matching pair
            if (solution == 1) {
                weapon++;
            }
            else if (solution == 2) {
                location++;
            }
            else if (solution == 3){
                murder++;
            }

        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // Output
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}