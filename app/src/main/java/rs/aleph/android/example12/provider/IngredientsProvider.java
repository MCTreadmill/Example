package rs.aleph.android.example12.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.*;

/**
 * Created by androiddevelopment on 13.10.17..
 */

public class IngredientsProvider {

    public static List<Ingredients> getIngredients() {

        Category meat = new Category(0, "Meat");
        Category vegetarian = new Category(1, "Vegetarian");
        Category vegan = new Category(2, "Vegan");

        Food cevapi = new Food(0, "cevapi.jpg", "Cevapi", "Sauseges served with fresh onions and white bread", meat, 650, 10);
        Food pljeskavica = new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12);
        Food macnCheese = new Food(2, "Macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9);
        Food sourCreamPotatoes = new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8 );
        Food veganCurry = new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6);
        Food friedVeg = new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5);


        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(new Ingredients(0, "Sauseges", cevapi));
        ingredients.add(new Ingredients(1, "Onions", cevapi));
        ingredients.add(new Ingredients(2, "White Bread", cevapi));
        ingredients.add(new Ingredients(3, "Beefburger", pljeskavica));
        ingredients.add(new Ingredients(4, "Pitabread", pljeskavica));
        ingredients.add(new Ingredients(5, "Tomatoes", pljeskavica));
        ingredients.add(new Ingredients(6, "Green Salad", pljeskavica));
        ingredients.add(new Ingredients(7, "Maccharoni", macnCheese));
        ingredients.add(new Ingredients(8, "Cheddarcheese", macnCheese));
        ingredients.add(new Ingredients(9, "Potatoes", sourCreamPotatoes));
        ingredients.add(new Ingredients(10, "Sour Cream", sourCreamPotatoes));
        ingredients.add(new Ingredients(11, "Asian Noodles", veganCurry));
        ingredients.add(new Ingredients(12, "Paprikas", veganCurry));
        ingredients.add(new Ingredients(13, "Peas", veganCurry));
        ingredients.add(new Ingredients(14, "Peanuts", veganCurry));
        ingredients.add(new Ingredients(15, "Green Curry", veganCurry));
        ingredients.add(new Ingredients(16, "Paprikas", friedVeg));
        ingredients.add(new Ingredients(17, "Broccoli", friedVeg));
        ingredients.add(new Ingredients(18, "Mushrooms", friedVeg));
        ingredients.add(new Ingredients(19, "Peas", friedVeg));
        ingredients.add(new Ingredients(20, "Soya Sauce", friedVeg));
        return ingredients;
    }

    public static List<String> getIngredientNames() {

        List<String> names = new ArrayList<>();
        names.add("Sauseges");
        names.add("Onions");
        names.add("White Bread");
        names.add("Beefburger");
        names.add("Pitabread");
        names.add("Tomatoes");
        names.add("Green Salad");
        names.add("Maccharoni");
        names.add("Cheddarcheese");
        names.add("Potatoes");
        names.add("Sour Cream");
        names.add("Asian Noodles");
        names.add("Paprikas");
        names.add("Peas");
        names.add("Peanuts");
        names.add("Green Curry");
        names.add("Pitabread");
        names.add("Paprikas");
        names.add("Broccoli");
        names.add("Mushrooms");
        names.add("Peas");
        names.add("Soya Sauce");
        return names;
    }

    public static Ingredients getIngredientsById(int id) {

        Category meat = new Category(0, "Meat");
        Category vegetarian = new Category(1, "Vegetarian");
        Category vegan = new Category(2, "Vegan");

        Food cevapi = new Food(0, "cevapi.jpg", "Cevapi", "Sauseges served with fresh onions and white bread", meat, 650, 10);
        Food pljeskavica = new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12);
        Food macnCheese = new Food(2, "Macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9);
        Food sourCreamPotatoes = new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8 );
        Food veganCurry = new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6);
        Food friedVeg = new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5);

        switch (id) {
            case 0:
                return new Ingredients(0, "Sauseges", cevapi);
            case 1:
                return new Ingredients(1, "Onions", cevapi);
            case 2:
                return new Ingredients(2, "White Bread", cevapi);
            case 3:
                return new Ingredients(3, "Beefburger", pljeskavica);
            case 4:
                return new Ingredients(4, "Pitabread", pljeskavica);
            case 5:
                return new Ingredients(5, "Tomatoes", pljeskavica);
            case 6:
                return new Ingredients(6, "Green Salad", pljeskavica);
            case 7:
                return new Ingredients(7, "Maccharoni", macnCheese);
            case 8:
                return new Ingredients(8, "Cheddarcheese", macnCheese);
            case 9:
                return new Ingredients(9, "Potatoes", sourCreamPotatoes);
            case 10:
                return new Ingredients(10, "Sour Cream", sourCreamPotatoes);
            case 11:
                return new Ingredients(11, "Asian Noodles", veganCurry);
            case 12:
                return new Ingredients(12, "Paprikas", veganCurry);
            case 13:
                return new Ingredients(13, "Peas", veganCurry);
            case 14:
                return new Ingredients(14, "Peanuts", veganCurry);
            case 15:
                return new Ingredients(15, "Green Curry", veganCurry);
            case 16:
                return new Ingredients(16, "Paprikas", friedVeg);
            case 17:
                return new Ingredients(17, "Broccoli", friedVeg);
            case 18:
                return new Ingredients(18, "Mushrooms", friedVeg);
            case 19:
                return new Ingredients(19, "Peas", friedVeg);
            case 20:
                return new Ingredients(20, "Soya Sauce", friedVeg);

            default:
                return null;
        }
    }
}