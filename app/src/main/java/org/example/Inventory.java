package org.example;

import java.util.ArrayList;

public class Inventory {
    public static final String LEMON = "Lemon";
    public static final String SUGAR = "Sugar";

    private ArrayList<Ingredient> items;
    private int cupsAvailable;

    public Inventory()
    {
        items = new ArrayList<>();
        items.add(new Lemon());
        items.add(new Sugar());
        cupsAvailable = 0;
    }

    public ArrayList<Ingredient> getItems()
    {
        return new ArrayList<>(items);
    }

    public Ingredient getIngredient(String name)
    {
        for (Ingredient item: items)
        {
            if (item.getName().equalsIgnoreCase(name))
            {
                return item;
            }
        }
        return null;
    }

    public Ingredient getLemons()
    {
        return getIngredient(LEMON);
    }

    public Ingredient getSugar()
    {
        return getIngredient(SUGAR);
    }

    public int getCupsAvailable()
    {
        return cupsAvailable;
    }

    public int getPitchersMade()
    {
        return cupsAvailable / Recipe.CUPS_PER_PITCHER;
    }

    public boolean makePitchers(Recipe recipe, int count)
    {
        if (count <= 0)
        {
            return false;
        }

        int lemonsNeeded = recipe.getLemonsPerPitcher() * count;
        int sugarNeeded = recipe.getSugarPerPitcher() * count;

        Ingredient lemons = getLemons();
        Ingredient sugar = getSugar();

        if (!lemons.hasEnough(lemonsNeeded) || !sugar.hasEnough(sugarNeeded))
        {
            return false;
        }

        lemons.useQuantity(lemonsNeeded);
        sugar.useQuantity(sugarNeeded);
        cupsAvailable += count * Recipe.CUPS_PER_PITCHER;
        return true;
    }

    public boolean sellCup()
    {
        if (cupsAvailable > 0)
        {
            cupsAvailable--;
            return true;
        }
        return false;
    }

    //dumping out leftover lemonade. for conditional may be used for future ingredients.
    public void endOfDay()
    {
        cupsAvailable = 0;

        for (Ingredient item : items)
        {
            if (item.expiresAtEndOfDay())
            {
                item.clearQuantity();
            }
        }

    }



}
