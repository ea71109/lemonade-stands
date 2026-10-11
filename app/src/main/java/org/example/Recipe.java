package org.example;

public class Recipe {
    private int lemonsPerPitcher;
    private int sugarPerPitcher;
    private int waterPerPitcher;
    private double pricePerCup;

    public final int CUPS_PER_PITCHER = 8;

    public Recipe()
    {
        this.lemonsPerPitcher = 4;
        this.sugarPerPitcher = 4;
        this.waterPerPitcher = 4;
        this.pricePerCup = 0.25;
    }

    public int getLemonsPerPitcher()
    {
        return lemonsPerPitcher;
    }

    public int getSugarPerPitcher()
    {
        return sugarPerPitcher;
    }

    public int getWaterPerPitcher()
    {
        return waterPerPitcher;
    }

    public double getPricePerCup()
    {
        return pricePerCup;
    }

    public void setPricePerCup(double price)
    {
        if (price >= 0.01)
        {
            this.pricePerCup = price;
            System.out.println("Price per cup updated to $" + price);
        }
        else
        {
            System.out.println("New price must be at least $0.01.");
        }
    }
}
