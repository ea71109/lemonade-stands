package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp()
    {
        player = new Player();
    }

    @Test
    public void startingPlayerMoneyAmountTest()
    {
        assertEquals(100.00, player.getMoney());
    }

    @Test
    public void startingPlayerHasNoIngredientsTest()
    {
        assertEquals(0, player.getInventory().getLemons().getQuantity());
        assertEquals(0, player.getInventory().getSugar().getQuantity());
    }

    @Test
    public void buyingOneLemonTest()
    {
        player.buyIngredient("Lemon", 1);
        assertEquals(99.00, player.getMoney());
        assertEquals(1, player.getInventory().getLemons().getQuantity());
    }

    @Test
    public void buyingOneCupOfSugarTest()
    {
        player.buyIngredient("Sugar", 1);
        assertEquals(99.50, player.getMoney());
        assertEquals(1, player.getInventory().getSugar().getQuantity());
    }

    @Test
    public void moneyAmountIncreasesTest()
    {
        player.addMoney(10);
        assertEquals(110.00, player.getMoney());
    }

    @Test
    public void moneyAmountDecreasesTest()
    {
        player.subtractMoney(10);
        assertEquals(90.00, player.getMoney());
    }

    @Test
    public void negativeQuantityGetsIgnoredTest()
    {
        player.buyIngredient("Lemon", -2);
        assertEquals(100.00, player.getMoney());
        assertEquals(0, player.getInventory().getLemons().getQuantity());
    }

    @Test
    public void unknownIngredientGetsIgnoredTest()
    {
        player.buyIngredient("Banana", 1);
        assertEquals(100.00, player.getMoney());
    }

    @Test
    public void negativeAmountOfMoneyAddedIgnoredTest()
    {
        player.addMoney(-1);
        assertEquals(100.00, player.getMoney());
    }

    @Test
    public void negativeAmountOfMoneySubtractedIgnoredTest()
    {
        player.subtractMoney(-1);
        assertEquals(100.00, player.getMoney());
    }
}
