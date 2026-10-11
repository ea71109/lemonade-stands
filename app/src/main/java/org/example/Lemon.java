package org.example;

public class Lemon  extends Ingredient{
    public Lemon()
    {
        super("Lemon", 1.00);
    }

    @Override
    public boolean expiresAtEndOfDay()
    {
        return false;
    }
}
