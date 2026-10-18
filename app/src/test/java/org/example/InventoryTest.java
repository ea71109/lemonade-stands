package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Recipe recipe;

    private void stock(int lemons, int sugar)
    {
        inventory.getLemons().addQuantity(lemons);
        inventory.getSugar().addQuantity(sugar);
    }

    @BeforeEach
    public void setUp()
    {
        inventory = new Inventory();
        recipe = new Recipe();
    }

    @Test
    public void newInventoryTest()
    {
        assertEquals(0, inventory.getLemons().getQuantity());
        assertEquals(0, inventory.getSugar().getQuantity());
        assertEquals(0, inventory.getCupsAvailable());
        assertEquals(0, inventory.getPitchersMade());
    }

    @Test
    public void cannotMakePitchersWithNoIngredientsTest()
    {
        assertFalse(inventory.makePitchers(recipe, 1));
        assertEquals(0, inventory.getCupsAvailable());
    }

    @Test
    public void makingZeroPitchersFailsTest()
    {
        stock(40, 40);

        assertFalse(inventory.makePitchers(recipe, 0));
        assertEquals(40, inventory.getLemons().getQuantity());
        assertEquals(40, inventory.getSugar().getQuantity());
    }

    @Test
    public void makingOnePitcherTest()
    {
        stock(4, 4);

        assertTrue(inventory.makePitchers(recipe, 1));
        assertEquals(Recipe.CUPS_PER_PITCHER, inventory.getCupsAvailable());
        assertEquals(1, inventory.getPitchersMade());
        assertEquals(0, inventory.getLemons().getQuantity());
        assertEquals(0, inventory.getSugar().getQuantity());
    }

    @Test
    public void sellingOneCupTest()
    {
        stock(4, 4);
        inventory.makePitchers(recipe, 1);

        assertTrue(inventory.sellCup());
        assertEquals(7, inventory.getCupsAvailable());
    }

    @Test
    public void makingManyPitchers()
    {
        stock(20, 20);

        assertTrue(inventory.makePitchers(recipe, 3));
        assertEquals(24, inventory.getCupsAvailable());
        assertEquals(8, inventory.getLemons().getQuantity());
        assertEquals(8, inventory.getSugar().getQuantity());
    }

    @Test
    public void exactlyEnoughIngredientsTest()
    {
        stock(4, 4);
        assertTrue(inventory.makePitchers(recipe, 1));
    }

    @Test
    public void notEnoughLemonsTest()
    {
        stock(3, 4);

        assertFalse(inventory.makePitchers(recipe, 1));
        assertEquals(3, inventory.getLemons().getQuantity());
        assertEquals(4, inventory.getSugar().getQuantity());
        assertEquals(0, inventory.getCupsAvailable());
    }

    @Test
    public void notEnoughSugarTest()
    {
        stock(4, 3);
        assertFalse(inventory.makePitchers(recipe, 1));
        assertEquals(4, inventory.getLemons().getQuantity());
        assertEquals(3, inventory.getSugar().getQuantity());
        assertEquals(0, inventory.getCupsAvailable());
    }

    @Test
    public void unknownIngredientTest()
    {
        assertNull(inventory.getIngredient("Banana"));
    }

    @Test
    public void negativePitcherCountTest()
    {
        stock(40, 40);

        assertFalse(inventory.makePitchers(recipe, -3));
        assertEquals(40, inventory.getLemons().getQuantity());
        assertEquals(0, inventory.getCupsAvailable());
    }

    @Test
    public void endOfDayDumpsLemonadeButKeepsIngredientsTest()
    {
        stock(10, 10);
        inventory.makePitchers(recipe, 1);   // leaves 6 lemons, 6 sugar, 8 cups

        inventory.endOfDay();

        assertEquals(0, inventory.getCupsAvailable());
        assertEquals(6, inventory.getLemons().getQuantity());
        assertEquals(6, inventory.getSugar().getQuantity());
    }

    @Test
    public void customRecipeUsesNewAmountsTest()
    {
        Recipe custom = new Recipe();
        custom.setRecipe(2, 1, 3);
        stock(4, 2);

        assertTrue(inventory.makePitchers(custom, 2));
        assertEquals(0, inventory.getLemons().getQuantity());
        assertEquals(0, inventory.getSugar().getQuantity());
        assertEquals(16, inventory.getCupsAvailable());
    }


















}
