package org.example;

public class Sugar extends Ingredient
{
    public Sugar()
    {
        super("Sugar", 0.50);
    }

    @Override
    public boolean expiresAtEndOfDay()
    {
        return false;
    }
}
