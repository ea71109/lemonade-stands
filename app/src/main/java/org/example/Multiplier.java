package org.example;

public class Multiplier {
    private Recipe recipe;

    private static final double IDEAL_LEMONS_PER_WATER = 9.0 / 32.0;
    private static final double IDEAL_SUGAR_PER_WATER = 7.0 / 32.0;
    private static final double CLOSE_TOLERANCE = 1;
    private static final double EXACT_TOLERANCE = 0.01;

    public static double applyMultiplier(Recipe recipe)
    {
        int lemons = recipe.getLemonsPerPitcher();
        int sugar = recipe.getSugarPerPitcher();
        int water = recipe.getWaterPerPitcher();

        if (water == 0)
        {
            return 0.0;
        }
        else if (lemons == 0 && sugar == 0)
        {
            return 0.1;
        }
        else if (sugar == 0)
        {
            return 0.5;
        }

        double lemonDiff = lemons / water - IDEAL_LEMONS_PER_WATER;
        double sugarDiff = sugar / water - IDEAL_SUGAR_PER_WATER;

        if (lemonDiff <= EXACT_TOLERANCE && sugarDiff <= EXACT_TOLERANCE)
        {
            return 1.5;
        }
        else if (lemonDiff <= CLOSE_TOLERANCE && sugarDiff <= CLOSE_TOLERANCE)
        {
            return 1.25;
        }
        else
        {
            return 1.0;
        }

    }

}
