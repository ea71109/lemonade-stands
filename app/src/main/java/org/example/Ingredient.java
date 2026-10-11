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

    public boolean consumeQuantity(int amount)
    {
        if (amount <= this.quantity)
        {
            this.quantity -= amount;
            return true;
        }
        return false;
    }

    public abstract boolean expiresAtEndOfDay();
}
