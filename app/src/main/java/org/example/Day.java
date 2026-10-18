package org.example;
import java.util.Scanner;
import java.util.Random;

public class Day {
    private static final int MAX_CUSTOMERS = 500;
    private int dayNumber;

    public Day(int dayNumber)
    {
        this.dayNumber = dayNumber;
    }

    public void playDay(Player player, Scanner scanner)
    {
        System.out.println("\nDay " + dayNumber + ": Preparation Phase");
        System.out.println("Let's prepare for the day!\n");
        printStatus(player);
        runPreparationPhase(player, scanner);
        runSellingPhase(player);
        player.getInventory().endOfDay();
    }

    private void printStatus(Player player)
    {
        Inventory inventory = player.getInventory();

        System.out.println("Lemons: " + inventory.getIngredient("Lemon").getQuantity());
        System.out.println("Cups of sugar: " + inventory.getIngredient("Sugar").getQuantity());
        System.out.println("Cups of water: Infinity");
        System.out.println("Current Pitchers: " + inventory.getPitchersMade());
        System.out.println("Cash: $" + player.getMoney());
    }

    private void runPreparationPhase(Player player, Scanner scanner)
    {
        Inventory inventory = player.getInventory();
        Recipe recipe = player.getRecipe();
        boolean preparing = true;

        while (preparing)
        {
            System.out.println("\n1. Purchase Ingredients");
            System.out.println("2. Change the Recipe");
            System.out.println("3. Set the Price");
            System.out.println("4. Make Pitchers of Lemonade");
            System.out.println("5. Display Money");
            System.out.println("6. Move Onto the Selling Phase");

            System.out.println("What would you like to do? ");

            int choice = readInt(scanner);

            switch (choice)
            {
                case 1:
                    System.out.println("Lemons are $" + inventory.getLemons().getCostPerUnit() + "0 each");
                    System.out.println("Sugar is $" + inventory.getSugar().getCostPerUnit() + "0 per cup");

                    System.out.println("How many lemons do you want to buy? ");
                    int lemonsToPurchase = readInt(scanner);

                    System.out.println("How many cups of sugar do you want to buy? ");
                    int sugarToPurchase = readInt(scanner);

                    if (lemonsToPurchase > 0)
                    {
                        player.buyIngredient("Lemon", lemonsToPurchase);
                    }
                    if (sugarToPurchase > 0)
                    {
                        player.buyIngredient("Sugar", sugarToPurchase);
                    }
                    break;
                case 2:
                    System.out.println("How many lemons do you want per pitcher? ");
                    int lemonsForRecipe = readInt(scanner);

                    System.out.println("How many cups of sugar do you want per pitcher? ");
                    int sugarForRecipe = readInt(scanner);

                    System.out.println("How many cups of water do you want per pitcher? ");
                    int waterForRecipe = readInt(scanner);

                    recipe.setRecipe(lemonsForRecipe, sugarForRecipe, waterForRecipe);

                    System.out.println("Great! Your recipe is set!");
                    break;
                case 3:
                    System.out.println("How much will you sell one cup of lemonade for?");
                    System.out.println("Remember, one pitcher is $" + Recipe.CUPS_PER_PITCHER + ": \n$");

                    double newPrice = readDouble(scanner);

                    recipe.setPricePerCup(newPrice);

                    System.out.println("Great! Each cup of lemonade is now $" + newPrice);
                    System.out.println("Each pitcher is 8 x $" + newPrice + " = $" + (newPrice * 8) + " total");
                    break;
                case 4:
                    System.out.println("How many pitchers of lemonade do you want to make? ");
                    int numberOfPitchersToMake = readInt(scanner);

                    makePitchers(inventory, recipe, numberOfPitchersToMake);
                    break;
                case 5:
                    System.out.println("Money: $" + player.getMoney() + "0");
                    break;
                case 6:
                    preparing = false;
                    break;
                default:
                    System.out.println("Invalid input. Please choose a value 1-5");
            }
        }
    }

    private void makePitchers(Inventory inventory, Recipe recipe, int numberOfPitchers)
    {
        int lemonsNeeded = (recipe.getLemonsPerPitcher() * numberOfPitchers);
        int sugarNeeded = (recipe.getSugarPerPitcher() * numberOfPitchers);
        int waterNeeded = (recipe.getWaterPerPitcher() * numberOfPitchers);

        if (inventory.makePitchers(recipe, numberOfPitchers))
        {
            System.out.println("Fantastic! You made " + numberOfPitchers + " pitchers of lemonade");
            System.out.println("You used " + lemonsNeeded + " lemons");
            System.out.println("You used " + sugarNeeded + " cups of sugar");
            System.out.println("You used " + waterNeeded + " cups of water");
        }
        else if (numberOfPitchers <= 0)
        {
            System.out.println("You need to make at least one pitcher...");
        }
        else
        {
            System.out.println("Not enough ingredients!");
            System.out.println("Needed: " + lemonsNeeded + " lemons, " + sugarNeeded + " cups of sugar");
            System.out.println("You have: " + inventory.getLemons().getQuantity() + " lemons");
            System.out.println("You have: " + inventory.getSugar().getQuantity() + " cups of sugar");
        }
    }

    private void runSellingPhase(Player player)
    {
        Inventory inventory = player.getInventory();
        Recipe recipe = player.getRecipe();
        Random random = new Random();

        System.out.println("\nDay " + dayNumber + ": Selling Phase");

        int customers = random.nextInt(MAX_CUSTOMERS) + 1;
        int cupsStocked = inventory.getCupsAvailable();
        int cupsSold = 0;

        for (int i = 0; i < customers; i++)
        {
            if (inventory.sellCup())
            {
                cupsSold++;
            }
        }

        int customersNotServed = customers - cupsSold;
        int cupsWasted = cupsStocked - cupsSold;
        double profit = cupsSold * recipe.getPricePerCup();

        System.out.println(customers + " customers turned up");
        System.out.println("You sold " + cupsSold + " cups at $" + recipe.getPricePerCup() + " each.");
        System.out.printf("You earned $%.2f%n", profit);
        player.addMoney(profit);

        if (customersNotServed > 0)
        {
            System.out.println("Sadly, " + customersNotServed + " customers left without lemonade...");
        }

        if (cupsWasted > 0)
        {
            System.out.println("Unfortunately, " + cupsWasted + " unsold cups of lemonade were dumped out...");
        }
    }

    private int readInt(Scanner scanner)
    {
        while (true)
        {
            try
            {
                return Integer.parseInt(scanner.nextLine().trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Enter a whole number: ");
            }
        }
    }

    private double readDouble(Scanner scanner)
    {
        while (true)
        {
            try
            {
                return Double.parseDouble(scanner.nextLine().trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number: ");
            }
        }
    }
}
