package provider;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Food;
import model.Ingredients;

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

    /*public static Food getFoodById(int id) {

        Category meat = new Category(0, "Meat");
        Category vegetarian = new Category(1, "Vegetarian");
        Category vegan = new Category(2, "Vegan");

        switch (id) {
            case 0:
                return new Food(0, "cevapi.jpg", "Cevapi", "Sauseges served with fresh onions and white bread", meat, 650, 10);
            case 1:
                return new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12);
            case 2:
                return new Food(2, "Macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9);
            case 3:
                return new Food(3, "sourcreampotato.jpg", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8 );
            case 4:
                return new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6);
            case 5:
                return new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5);

            default:
                return null;
        }
    }*/
}
