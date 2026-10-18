package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    public void setUp()
    {
        recipe = new Recipe();
    }

    @Test
    public void recipeWithZeroIngredientsTest()
    {
        recipe.setRecipe(0,0,0);
        assertEquals(0, recipe.getLemonsPerPitcher());
        assertEquals(0, recipe.getSugarPerPitcher());
        assertEquals(0, recipe.getWaterPerPitcher());
    }

    @Test
    public void recipeWithOneOfEachIngredientTest()
    {
        recipe.setRecipe(1,1,1);
        assertEquals(1, recipe.getLemonsPerPitcher());
        assertEquals(1, recipe.getSugarPerPitcher());
        assertEquals(1, recipe.getWaterPerPitcher());
    }

    @Test
    public void recipeWithMultipleIngredientsTest()
    {
        recipe.setRecipe(4,2,3);
        assertEquals(4, recipe.getLemonsPerPitcher());
        assertEquals(2, recipe.getSugarPerPitcher());
        assertEquals(3, recipe.getWaterPerPitcher());
    }

    @Test
    public void defaultRecipePricePerCupTest()
    {
        assertEquals(4, recipe.getLemonsPerPitcher());
        assertEquals(4, recipe.getSugarPerPitcher());
        assertEquals(4, recipe.getWaterPerPitcher());
        assertEquals(0.25, recipe.getPricePerCup());
    }

    @Test
    public void numberOfCupsInPitcherTest()
    {
        assertEquals(8, Recipe.CUPS_PER_PITCHER);
    }

    @Test
    public void smallestAllowedPricePerCupTest()
    {
        recipe.setPricePerCup(0.01);
        assertEquals(0.01, recipe.getPricePerCup());
    }

    @Test
    public void zeroDollarsPerCupTest()
    {
        recipe.setPricePerCup(0);
        assertEquals(0.25, recipe.getPricePerCup());
    }

    @Test
    public void negativePricePerCupTest()
    {
        recipe.setPricePerCup(-1.00);
        assertEquals(0.25, recipe.getPricePerCup());
    }

    @Test
    public void negativeIngredientsInRecipeTest()
    {
        recipe.setRecipe(-1, 3, 5);

        assertEquals(4, recipe.getLemonsPerPitcher());
        assertEquals(4, recipe.getSugarPerPitcher());
        assertEquals(4, recipe.getWaterPerPitcher());
    }

    @Test
    public void changingPricePerCupMultipleTimesTest()
    {
        recipe.setPricePerCup(0.50);
        recipe.setPricePerCup(0.75);
        assertEquals(0.75, recipe.getPricePerCup());
    }

    @Test
    public void changingRecipeMultipleTimesTest()
    {
        recipe.setRecipe(1, 1, 1);
        recipe.setRecipe(6, 2, 8);
        assertEquals(6, recipe.getLemonsPerPitcher());
        assertEquals(2, recipe.getSugarPerPitcher());
        assertEquals(8, recipe.getWaterPerPitcher());
    }

}
