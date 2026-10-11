package org.example;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Ingredient> items;
    private int pitchersMade;

    public Inventory()
    {
        items = new ArrayList<>();
        items.add(new Lemon());
        items.add(new CupsOfSugar());
        pitchersMade = 0;
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

    public int getPitchersMade()
    {
        return pitchersMade;
    }

    public void setPitchersMade(int pitchers)
    {
        this.pitchersMade = pitchers;
    }

    public void endOfDay()
    {
        this.pitchersMade = 0;
    }

}
