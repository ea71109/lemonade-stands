package org.example;

public abstract class Ingredient {
    private String name;
    private double costPerUnit;
    private int quantity;

    public Ingredient(String name, double costPerUnit)
    {
        this.name = name;
        this.costPerUnit = costPerUnit;
        this.quantity = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getCostPerUnit()
    {
        return costPerUnit;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void addQuantity(int amount)
    {
        if (amount > 0)
        {
            this.quantity += amount;
        }
    }

    public boolean useQuantity(int amount)
    {
        if (amount < 0 || amount > this.quantity)
        {
            return false;
        }
        this.quantity -= amount;
        return true;
    }

    public boolean hasEnough(int amount)
    {
        return amount >= 0 && quantity >= amount;
    }

    //for future edits. Currently, lemons, sugar, and water doesn't need to be cleared
    public void clearQuantity()
    {
        this.quantity = 0;
    }

    public abstract boolean expiresAtEndOfDay();
}
