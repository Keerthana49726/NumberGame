/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_game;

/**
 *
 * @author LENOVO
 */
import java.util.Random;
import java.util.Scanner;
public class Number_game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            // Game settings
            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 5;
            int attempts = 0;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            // Game loop for each round
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + " of " + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1; // Award points based on attempts left
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Feedback after max attempts
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + numberToGuess);
            }

            // Ask the user if they want to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Display final score
        System.out.println("\nGame Over! Your final score is: " + score);
        scanner.close();
    }
    
}
