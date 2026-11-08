package org.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        boolean playing = true;
        int dayNumber = 1;

        System.out.println("Welcome to the Lemonade Stand Tycoon!\n");

        Day day = new Day(dayNumber);
        day.playDay(player, scanner);

        scanner.close();
    }

}
