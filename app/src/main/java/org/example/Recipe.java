package org.example;

public class Recipe {
    private int lemonsPerPitcher;
    private int sugarPerPitcher;
    private int waterPerPitcher;
    private double pricePerCup;
    public static final int CUPS_PER_PITCHER = 8;

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
        if (price > 0)
        {
            this.pricePerCup = price;
        }
        else
        {
            System.out.println("Price must be at least $0.01.");
        }

    }

    public void setRecipe(int lemons, int sugar, int water)
    {
        if (lemons < 0 || sugar < 0 || water < 0)
        {
            System.out.println("Can't use a negative amount for a recipe...");
            return;
        }
        this.lemonsPerPitcher = lemons;
        this.sugarPerPitcher = sugar;
        this.waterPerPitcher = water;
    }


}
