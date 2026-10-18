package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SugarTest
{
    private Sugar sugar;

    @BeforeEach
    void setUp()
    {
        sugar = new Sugar();
    }

    @Test
    public void initialSugarPrice()
    {
        assertEquals(0.50, sugar.getCostPerUnit());
    }

    @Test
    public void initialSugarAmount()
    {
        assertEquals(0, sugar.getQuantity());
    }

    @Test
    public void identifiedAsSugarTest()
    {
        assertEquals("Sugar", sugar.getName());
    }

    @Test
    public void doesNotExpire()
    {
        assertFalse(sugar.expiresAtEndOfDay());
    }

    @Test
    public void sugarUsedRemovedFromSugarTotal()
    {
        sugar.addQuantity(8);
        sugar.useQuantity(4);
        assertEquals(4, sugar.getQuantity());
    }
}
