package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LemonTest {
    private Lemon lemon;

    @BeforeEach
    void setUp()
    {
        lemon = new Lemon();
    }

    @Test
    public void lemonInitialPrice()
    {
        assertEquals("Lemon", lemon.getName());
        assertEquals(1.00, lemon.getCostPerUnit());
    }

    @Test
    public void lemonInitialAmount()
    {
        assertEquals("Lemon", lemon.getName());
        assertEquals(0, lemon.getQuantity());
    }

    @Test
    public void doesNotExpireTest()
    {
        assertFalse(lemon.expiresAtEndOfDay());
    }

    @Test
    public void identifiedAsLemonTest()
    {
        assertEquals("Lemon", lemon.getName());
    }

    @Test
    public void lemonUseRemovesFromTotalTest()
    {
        lemon.addQuantity(4);
        lemon.useQuantity(2);
        assertEquals(2, lemon.getQuantity());
    }
}
