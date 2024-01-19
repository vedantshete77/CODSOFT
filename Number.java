import java.util.Random;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                score += attempts;
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                System.out.println("Thanks for playing! Your total score is: " + score);
                break;
            }

        } while (true);

        scanner.close();
    }
}
