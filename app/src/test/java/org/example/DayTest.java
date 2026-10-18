package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class DayTest {
    private Player player;
    private void playDay(String input)
    {
        Scanner scanner = new Scanner(input);
        new Day(1).playDay(player, scanner);
    }

    @BeforeEach
    public void setUp()
    {
        player = new Player();
    }

    @Test
    public void skippingPreperationPhaseDoesNotChangeMoneyTest()
    {
        playDay("6\n");
        assertEquals(100.00, player.getMoney());
    }

    @Test
    public void skippingPreperationPhaseDoesNotCHangeCupsTest()
    {
        playDay("6\n");
        assertEquals(0, player.getInventory().getCupsAvailable());
    }

    @Test
    public void makingPitchersWithNoIngredientsTest()
    {
        playDay("4\n1\n6\n");
        assertEquals(0, player.getInventory().getCupsAvailable());
        assertEquals(100.00, player.getMoney());
    }

    @Test
    public void buyingOneOfEachIngredientTest()
    {
        playDay("1\n1\n1\n6\n");
        assertEquals(1, player.getInventory().getLemons().getQuantity());
        assertEquals(1, player.getInventory().getSugar().getQuantity());
        assertEquals(98.50, player.getMoney());
    }

    @Test
    public void buyingManyOfEachIngredientTest()
    {
        playDay("1\n10\n10\n6\n");
        assertEquals(10, player.getInventory().getLemons().getQuantity());
        assertEquals(10, player.getInventory().getSugar().getQuantity());
        assertEquals(85.00, player.getMoney());
    }

    @Test
    public void unaffordablePurchaseTest()
    {
        playDay("1\n101\n0\n6\n");
        assertEquals(0, player.getInventory().getLemons().getQuantity());
        assertEquals(100.00, player.getMoney());
    }





}
