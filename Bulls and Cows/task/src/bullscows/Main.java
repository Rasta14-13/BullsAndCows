package bullscows;

import java.util.*;

public class Main {

    static public int inputNumber;
    static public int inputNumberOfSymbols;
    static public int counterOfBulls;
    static public int counterOfCows;
    static public int counterOfTurns = 1;
    static public String guessNumber;
    static public String randomNumberToString;
    static public String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        inputMethod();
        showSecretCode();
        randomChar();
        System.out.println("Okay, let's start a game!");
        while (counterOfBulls != inputNumber) {
            letsPlay();
            counterOfTurns++;
        }
    }

    static void checkBullAndCow (String randomNumberToString, String guessNumber) {
        counterOfCows = 0;
        counterOfBulls = 0;
        for (int i = 0; i < inputNumber; i++) {
            for (int j = 0; j < inputNumber; j++) {
                if (randomNumberToString.charAt(i) == guessNumber.charAt(j)) {
                    counterOfCows++;
                }
            }
            if (randomNumberToString.charAt(i) == guessNumber.charAt(i)) {
                counterOfBulls++;
                counterOfCows--;
            }
        }
    }

    static void showResult (int b, int c) {
        System.out.print("Grade: ");
        if (b == 0 && b == c) {
            System.out.println("None.");
        } else if (b == inputNumber){
            System.out.print(inputNumber + " bulls. \n" +
                    "Congratulations! You guessed the secret code.");
            System.exit(0);
        }
        else {
            System.out.printf(" %d bulls and %d cows.", b, c);
        }
    }

    static void letsPlay () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Turn " + counterOfTurns);
        guessNumber = scan.nextLine();
        checkBullAndCow(randomNumberToString, guessNumber);
        showResult(counterOfBulls, counterOfCows);
        System.out.println();
    }
    
    static void randomChar () {
        StringBuilder random = new StringBuilder();
        StringBuilder error = new StringBuilder();
        Random ran = new Random();
        String a;
        int randomInt;
        if (inputNumber < 37) {
            for (int i = 0; i < inputNumber; i++) {
                do {
                    randomInt = ran.nextInt(inputNumberOfSymbols);
                    char al = alphabet.charAt(randomInt);
                    a = Character.toString(al);
                } while (random.toString().contains(a));
                random.append(a);
            }
            randomNumberToString = random.toString();
        } else {
            error.append("Error: can't generate a secret number with a length of ");
            error.append(inputNumber).append("because there aren't enough unique digits.");
            System.out.println(error);
        }
    }

    static void showSecretCode () {
        if (inputNumberOfSymbols < 37) {
            char star = '*';
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < inputNumber; i++) {
                System.out.print(star);
            }
            if (inputNumberOfSymbols < 11) {
                System.out.println(" (0-" + (inputNumberOfSymbols - 1) + ").");
            } else if (inputNumberOfSymbols == 11) {
                System.out.println(" (0-9, a).");
            } else {
                System.out.println(" (0-9, a-" + alphabet.charAt(inputNumberOfSymbols - 1) + ").");
            }
        }
    }

    static void inputMethod () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String input = sc.nextLine();
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException inputNumber) {
            System.out.println("Error: " + input + " isn't a valid number.");
            System.exit(0);
        }
        if (inputNumber == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of 0");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        inputNumberOfSymbols = sc.nextInt();
        if (inputNumberOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        if (inputNumber > inputNumberOfSymbols) {
            System.out.printf("\nError: it's not possible to generate a code" +
                    " with a length of %d with %d unique symbols.",inputNumber, inputNumberOfSymbols);
            System.exit(0);
        }
    }
}
