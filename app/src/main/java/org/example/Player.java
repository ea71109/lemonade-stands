package org.example;

public class Player {
    private double money;
    private Inventory inventory;

    public Player()
    {
        this.money = 100.0;
        this.inventory = new Inventory();
    }

    public boolean buyIngredient(String itemName, int quantity)
    {
        Ingredient item = inventory.getIngredient(itemName);
        if (item == null || quantity <= 0)
        {
            System.out.println("Invalid number or quantity.");
            return false;
        }

        double totalCost = item.getCostPerUnit() * quantity;
        return true;
        //Add validation to make player have enough money to buy ingredients
    }
}
