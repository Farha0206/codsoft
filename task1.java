import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int round = 0;
        int totalAttempt = 0;

        while(playAgain){
            round++;
            System.out.println("\nRound"+ round);
            int attempt = playGame(scanner);
            totalAttempt += attempt;

            System.out.println("do you want to play again ? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        
    System.out.println("Game over! you Played" +round + "round with total of " + totalAttempt + "attempt");
    double averageAttempt = round > 0 ? (double) totalAttempt / round : 0;
    System.out.printf("your Average per round were: %.2f\n", averageAttempt );
    }

    public static int playGame(Scanner scanner){
        Random random = new Random();
        int minRange = 1;
        int maxRange = 300;
        int number = random.nextInt((maxRange - minRange + 1)) + minRange;
        int attempts = 0;
        int maxAttempt = 7;
        
        
        System.out.println("Guess the number between" + minRange + "and" + maxRange+ ".");


        while(attempts < maxAttempt){
            System.out.println("Attempt" + (attempts + 1) + "/" + maxAttempt + "Enter your guess");
            int guess = scanner.nextInt();
            attempts++;

            if(guess == number){
                System.out.println("congratulations you guessed the right answer");
                return attempts;
            }
            else if (guess < number){
                System.out.println("too low ! Try Again");
            
            } 
            else {
                System.out.println("too high! try again");
            }
            }
            System.out.println("Sorry you have used all" + maxAttempt + " attempts.the correct number was " + number + ".");
            return attempts;

        }
    }

