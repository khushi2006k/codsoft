import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;
        int maxAttempts = 6;

        while (true) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("Round " + (rounds + 1));

            while (attempts < maxAttempts) {
                System.out.print("Guess a number between 1 and 100: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct!");
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("You've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Number of attempts: " + attempts);
            System.out.println("Score: " + score);
            rounds++;

            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Total rounds played: " + rounds);
        System.out.println("Final score: " + score);
        scanner.close();
    }
}
