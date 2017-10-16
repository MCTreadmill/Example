package provider;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Food;

/**
 * Created by androiddevelopment on 13.10.17..
 */


public class FoodProvider {

    public static List<Food> getFoods() {

        Category meat = new Category(0, "Meat");
        Category vegetarian = new Category(1, "Vegetarian");
        Category vegan = new Category(2, "Vegan");

        List<Food> foods = new ArrayList<>();
        foods.add(new Food(0, "cevapi.jpg", "Cevapi", "Sauseges served with fresh onions and white bread", meat, 650, 10));
        foods.add(new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12));
        foods.add(new Food(2, "macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9));
        foods.add(new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8 ));
        foods.add(new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6));
        foods.add(new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5));
        return foods;
    }

    public static List<String> getFoodNames() {

        List<String> names = new ArrayList<>();
        names.add("Cevapi");
        names.add("Pljeskavica");
        names.add("Mac'N'Cheese");
        names.add("Sour Cream Potatoes");
        names.add("Vegan Curry");
        names.add("Fried Veggies");
        return names;
    }

    public static Food getFoodById(int id) {

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
    }
}
