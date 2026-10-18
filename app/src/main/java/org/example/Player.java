package org.example;

public class Player {
    private double money;
    private Inventory inventory;
    private Recipe recipe;

    public Player()
    {
        this.money = 100.00;
        this.inventory = new Inventory();
        this.recipe = new Recipe();
    }

    public boolean buyIngredient(String itemName, int quantity) {
        Ingredient item = inventory.getIngredient(itemName);
        if (item == null || quantity < 0) {
            System.out.println("Invalid ingredient or quantity.");
            return false;
        }

        double totalCost = item.getCostPerUnit() * quantity;

        if (totalCost > money) {
            System.out.println("Not enough money! Buy less ingredients.");
            return false;
        }

        subtractMoney(totalCost);
        item.addQuantity(quantity);
        System.out.printf("Bought %d x %s for $%.2f.%n", quantity, item.getName(), totalCost);
        return true;
    }

    public double getMoney()
    {
        return money;
    }

    public void addMoney(double amount)
    {
        if (amount > 0)
        {
            this.money += amount;
        }
    }

    public void subtractMoney(double amount)
    {
        if (amount > 0)
        {
            this.money -= amount;
        }
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }
}
