package rs.aleph.android.example12.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.*;

/**
 * Created by androiddevelopment on 13.10.17..
 */


public class FoodProvider {

    public static List<Food> getFoods() {

        Category meat = new Category(0, "Meat");
        Category vegetarian = new Category(1, "Vegetarian");
        Category vegan = new Category(2, "Vegan");

        /*Food cevapi = new Food(0, "cevapi.jpg", "Cevapi", "Sausages served with fresh onions and white bread", meat, 650, 10);
        Food pljeskavica = new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12);
        Food macnCheese = new Food(2, "macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9);
        Food sourCreamPotatoes = new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8 );
        Food veganCurry = new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6);
        Food friedVeg = new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5);*/

        ArrayList<Ingredients> ingredients0 = new ArrayList<>();
        ArrayList<Ingredients> ingredients1 = new ArrayList<>();
        ArrayList<Ingredients> ingredients2 = new ArrayList<>();
        ArrayList<Ingredients> ingredients3 = new ArrayList<>();
        ArrayList<Ingredients> ingredients4 = new ArrayList<>();
        ArrayList<Ingredients> ingredients5 = new ArrayList<>();

       /* ingredients0.add(new Ingredients(0, "Sauseges", cevapi));
        ingredients0.add(new Ingredients(1, "Onions", cevapi));
        ingredients0.add(new Ingredients(2, "White Bread", cevapi));
        ingredients1.add(new Ingredients(3, "Beefburger", pljeskavica));
        ingredients1.add(new Ingredients(4, "Pitabread", pljeskavica));
        ingredients1.add(new Ingredients(5, "Tomatoes", pljeskavica));
        ingredients1.add(new Ingredients(6, "Green Salad", pljeskavica));
        ingredients2.add(new Ingredients(7, "Maccharoni", macnCheese));
        ingredients2.add(new Ingredients(8, "Cheddarcheese", macnCheese));
        ingredients3.add(new Ingredients(9, "Potatoes", sourCreamPotatoes));
        ingredients3.add(new Ingredients(10, "Sour Cream", sourCreamPotatoes));
        ingredients4.add(new Ingredients(11, "Asian Noodles", veganCurry));
        ingredients4.add(new Ingredients(12, "Paprikas", veganCurry));
        ingredients4.add(new Ingredients(13, "Peas", veganCurry));
        ingredients4.add(new Ingredients(14, "Peanuts", veganCurry));
        ingredients4.add(new Ingredients(15, "Green Curry", veganCurry));
        ingredients5.add(new Ingredients(16, "Paprikas", friedVeg));
        ingredients5.add(new Ingredients(17, "Broccoli", friedVeg));
        ingredients5.add(new Ingredients(18, "Mushrooms", friedVeg));
        ingredients5.add(new Ingredients(19, "Peas", friedVeg));
        ingredients5.add(new Ingredients(20, "Soya Sauce", friedVeg));*/

        List<Food> foods = new ArrayList<>();
        foods.add(new Food(0, "cevapi.jpg", "Cevapi", "Sausages served with fresh onions and white bread", meat, 650, 10, ingredients0));
        foods.add(new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12, ingredients1));
        foods.add(new Food(2, "macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9, ingredients2));
        foods.add(new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8, ingredients3));
        foods.add(new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6, ingredients4));
        foods.add(new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5, ingredients5));
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

        ArrayList<Ingredients> ingredients0 = new ArrayList<>();
        ArrayList<Ingredients> ingredients1 = new ArrayList<>();
        ArrayList<Ingredients> ingredients2 = new ArrayList<>();
        ArrayList<Ingredients> ingredients3 = new ArrayList<>();
        ArrayList<Ingredients> ingredients4 = new ArrayList<>();
        ArrayList<Ingredients> ingredients5 = new ArrayList<>();

        Food cevapi = new Food(0, "cevapi.jpg", "Cevapi", "Sausages served with fresh onions and white bread", meat, 650, 10, ingredients0);
        Food pljeskavica = new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12, ingredients1);
        Food macnCheese = new Food(2, "macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9, ingredients2);
        Food sourCreamPotatoes = new Food(3, "sourcreampotato.png", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8, ingredients3);
        Food veganCurry = new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6, ingredients4);
        Food friedVeg = new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5, ingredients5);


        ingredients0.add(new Ingredients(0, "Sauseges", cevapi));
        ingredients0.add(new Ingredients(1, "Onions", cevapi));
        ingredients0.add(new Ingredients(2, "White Bread", cevapi));
        ingredients1.add(new Ingredients(3, "Beefburger", pljeskavica));
        ingredients1.add(new Ingredients(4, "Pitabread", pljeskavica));
        ingredients1.add(new Ingredients(5, "Tomatoes", pljeskavica));
        ingredients1.add(new Ingredients(6, "Green Salad", pljeskavica));
        ingredients2.add(new Ingredients(7, "Maccharoni", macnCheese));
        ingredients2.add(new Ingredients(8, "Cheddarcheese", macnCheese));
        ingredients3.add(new Ingredients(9, "Potatoes", sourCreamPotatoes));
        ingredients3.add(new Ingredients(10, "Sour Cream", sourCreamPotatoes));
        ingredients4.add(new Ingredients(11, "Asian Noodles", veganCurry));
        ingredients4.add(new Ingredients(12, "Paprikas", veganCurry));
        ingredients4.add(new Ingredients(13, "Peas", veganCurry));
        ingredients4.add(new Ingredients(14, "Peanuts", veganCurry));
        ingredients4.add(new Ingredients(15, "Green Curry", veganCurry));
        ingredients5.add(new Ingredients(16, "Paprikas", friedVeg));
        ingredients5.add(new Ingredients(17, "Broccoli", friedVeg));
        ingredients5.add(new Ingredients(18, "Mushrooms", friedVeg));
        ingredients5.add(new Ingredients(19, "Peas", friedVeg));
        ingredients5.add(new Ingredients(20, "Soya Sauce", friedVeg));

        switch (id) {
            case 0:
                return new Food(0, "cevapi.jpg", "Cevapi", "Sausages served with fresh onions and white bread", meat, 650, 10, ingredients0);
            case 1:
                return new Food(1, "pljeskavica.jpg", "Pljeskavica", "Beefburger served in Pitabread with veggies", meat, 750, 12, ingredients1);
            case 2:
                return new Food(2, "macncheese.jpg", "Mac'N'Cheese", "Italian Maccharoni cooked with Cheddarcheese", vegetarian, 600, 9, ingredients2);
            case 3:
                return new Food(3, "sourcreampotato.jpg", "Sour Cream Potatoes", "Baked potatoes with sour cream", vegetarian, 550, 8, ingredients3);
            case 4:
                return new Food(4, "vegancurry.jpg", "Vegan Curry", "Asian noodles with mixed Veg and green curry", vegan, 590, 6, ingredients4);
            case 5:
                return new Food(5, "friedveg.jpg", "Fried Veggies", "Mixed fried Vegetables with Soya Sauce", vegan, 500, 5, ingredients5);

            default:
                return null;
        }
    }
}
