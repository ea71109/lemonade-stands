package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
    private Ingredient ingredient;

    @BeforeEach
    public void setUp()
    {
        ingredient = new Lemon();
    }

    @Test
    public void newIngredientHasNoQuantityTest()
    {
        assertEquals(0, ingredient.getQuantity());
    }

    @Test
    public void addingZeroTest()
    {
        ingredient.addQuantity(0);
        assertEquals(0, ingredient.getQuantity());
    }

    @Test
    public void addingOneToQuantityTest()
    {
        ingredient.addQuantity(1);
        assertEquals(1, ingredient.getQuantity());
    }

    @Test
    public void addingLargeQuantityTest()
    {
        ingredient.addQuantity(10);
        assertEquals(10, ingredient.getQuantity());
    }

    @Test
    public void addMultipleTimesTest()
    {
        ingredient.addQuantity(10);
        ingredient.addQuantity(15);
        assertEquals(25, ingredient.getQuantity());
    }

    @Test
    public void usingZeroOfIngredientTest()
    {
        ingredient.addQuantity(1);
        ingredient.useQuantity(0);
        assertEquals(1, ingredient.getQuantity());
    }

    @Test
    public void usingOneOfIngredientTest()
    {
        ingredient.addQuantity(1);
        ingredient.useQuantity(1);
        assertEquals(0, ingredient.getQuantity());
    }

    @Test
    public void usingMultipleOfIngredientTest()
    {
        ingredient.addQuantity(10);
        ingredient.useQuantity(6);
        assertEquals(4, ingredient.getQuantity());
    }

    @Test
    public void usingMoreIngredientesThanInInventoryTest()
    {
        ingredient.addQuantity(10);
        ingredient.useQuantity(11);
        assertEquals(10, ingredient.getQuantity());
    }

    @Test
    public void hasEnoughIngredientsTest()
    {
        ingredient.addQuantity(10);
        assertTrue(ingredient.hasEnough(10));
        assertFalse(ingredient.hasEnough(11));
    }

    @Test
    public void clearsQuantityToZeroTest()
    {
        ingredient.addQuantity(25);
        ingredient.clearQuantity();
        assertEquals(0, ingredient.getQuantity());
    }

    @Test
    public void usingNegativeAmountTest()
    {
        ingredient.addQuantity(25);
        ingredient.useQuantity(-20);
        assertEquals(25, ingredient.getQuantity());
    }

    @Test
    public void hasNegativeIsNegativeTest()
    {
        ingredient.addQuantity(25);
        assertFalse(ingredient.hasEnough(-5));
    }





}
