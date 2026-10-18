package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean playing = true;
        int dayNumber = 1;

        System.out.println("Welcome to the Lemonade Stand Tycoon!\n");

        while (playing)
        {
            Day day = new Day(dayNumber);
            day.playDay(player, scanner);

            if (isBankrupt(player))
            {
                System.out.println("\nYou're out of money...");
                System.out.println("Game over.");
                playing = false;
            }
            else
            {
                System.out.println("\nLet's get a good night sleep and try again tomorrow!");
                dayNumber++;
            }
        }
        scanner.close();
    }

    private static boolean isBankrupt(Player player)
    {
        return player.getMoney() < 0.50;
    }
}
