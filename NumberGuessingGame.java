import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int targetNumber = random.nextInt(max - min + 1) + min;
        int numGuesses = 0;
        int maxGuesses = 10;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + min + " and " + max + ". Try to guess it!");

        while (numGuesses < maxGuesses) {
            System.out.print("Enter your guess (between " + min + " and " + max + "): ");
            int guess = scanner.nextInt();
            
            if (guess < min || guess > max) {
                System.out.println("Your guess is outside the valid range. Please guess again.");
                continue;
            }
            
            numGuesses++;
            
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the correct number in " + numGuesses + " guesses!");
                break;
            }
        }
        
        if (numGuesses == maxGuesses) {
            System.out.println("Sorry, you've run out of guesses. The correct number was " + targetNumber + ".");
        }
        
        scanner.close();
    }
}
