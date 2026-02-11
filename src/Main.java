import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("  Welcome to Java Slots  ");
        System.out.println(" Symbols: 🍉|🍒|🍌|🍍|⭐️");
        System.out.println("*************************");

        int balance = 100;

        String[] emojis = {"\uD83C\uDF49", "\uD83C\uDF52", "\uD83C\uDF4C", "\uD83C\uDF4D", "\u2B50"};


        while (true) {

            int count = 0;

            System.out.printf("Your balance is $%d\n", balance);
            System.out.println("Please enter your bet and press enter: ");

            if (!scanner.hasNextInt()) {
                System.out.println("You must enter a number!");
                scanner.next();
                continue;
            }
            int bet = scanner.nextInt();

            if (bet <= 0) {
                System.out.println("Bet must be a positive number");
            }
            else if (bet >balance) {
                System.out.println("Not enough money!");
                continue;
            }
            else {
                balance -= bet;
                System.out.printf("New balance: $%d\n", balance);
                System.out.println("*********************");
                System.out.println("Good Luck!\n");

                String[] play = new String[3];

                for (int i = 0; i < 3; i++ ) {
                    int emo = (int) (Math.random() * 5);
                    play[i] = emojis[emo];
                }
                System.out.println("Spinning...");
                System.out.printf("|");
                for (String p: play ) {
                    System.out.printf(p);
                    System.out.printf("|");
                }

                if (play[0].equals("\u2B50") && play[1].equals("\u2B50") && play[2].equals("\u2B50") ) {
                    balance += bet * 1000;
                    System.out.printf("\nJackpot !!! You Win $%d", bet*1000);
                }
                else if (play[0] == play[1] && play[1] == play[2]) {
                    balance += bet * 10;
                    System.out.printf("\nWin !!! You Win $%d", bet*10);
                }
                else if (play[0] == play[1] || play[0] == play[2] || play[1] == play[2]) {
                    balance += bet;
                    System.out.printf("\nTwo Correct !!! You Win $%d", bet);
                }
                else {
                    System.out.println("\n\nYou lost!");
                }    System.out.printf("\nNew balance: $%d\n", balance);
            }
            if (balance == 0) {
                System.out.println("No more money! Bye!!");
                break;
            }
            System.out.println("\nDo you want to keep playing? (Y/N)");
            char keep;
            while (true) {
                keep = scanner.next().toUpperCase().charAt(0);
                if (keep == 'Y' || keep == 'N') {
                    break;
                }
                System.out.println("Choose Y or N!");
            }
            if (keep == 'N') {
                break;
            }
        }
    }
}
