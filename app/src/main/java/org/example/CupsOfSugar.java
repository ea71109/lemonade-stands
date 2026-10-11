package org.example;

public class CupsOfSugar extends Ingredient
{
    public CupsOfSugar()
    {
        super("Sugar", 0.50);
    }

    @Override
    public boolean expiresAtEndOfDay()
    {
        return false;
    }
}
