import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        int totalScore = 0;
        int roundNumber = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            roundNumber++;
            System.out.println("\n--- Round " + roundNumber + " ---");
            int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attemptsLeft = 5; // Limit number of attempts
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts. Good luck!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; // Scoring system based on remaining attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you're out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Total Rounds Played: " + roundNumber);
        System.out.println("Final Score: " + totalScore);
    }
}