package com.example.zjazd2.ui.recipes;

import androidx.lifecycle.ViewModel;

public class RecipesViewModel extends ViewModel {
    public String getRecipe1() {
        return "Recipe 1:\n\n" +
                "Chicken Salad\n\n" +
                "Ingredients:\n" +
                "- 2 chicken breasts\n" +
                "- 1 lettuce\n" +
                "- 2 tomatoes\n" +
                "- 1 cucumber\n" +
                "- Olive oil\n" +
                "- Salt\n" +
                "- Pepper\n\n" +
                "Instructions:\n" +
                "1. Cook the chicken breasts until they're done.\n" +
                "2. Cut the lettuce, tomatoes, and cucumber into small pieces.\n" +
                "3. Mix everything together in a bowl.\n" +
                "4. Add olive oil, salt, and pepper to taste.\n" +
                "5. Enjoy your chicken salad!";
    }

    public String getRecipe2() {
        return "Recipe 2:\n\n" +
                "Pasta Carbonara\n\n" +
                "Ingredients:\n" +
                "- 200g spaghetti\n" +
                "- 100g pancetta\n" +
                "- 2 eggs\n" +
                "- 50g pecorino cheese\n" +
                "- Salt\n" +
                "- Pepper\n\n" +
                "Instructions:\n" +
                "1. Cook the spaghetti in salted water until it's al dente.\n" +
                "2. In a separate pan, cook the pancetta until it's crispy.\n" +
                "3. In a bowl, mix the eggs and pecorino cheese together.\n" +
                "4. Once the spaghetti is done, drain it and add it to the pan with the pancetta.\n" +
                "5. Remove the pan from the heat and add the egg and cheese mixture. Stir quickly until it forms a creamy sauce.\n" +
                "6. Add salt and pepper to taste.\n" +
                "7. Enjoy your pasta carbonara!";
    }
}
