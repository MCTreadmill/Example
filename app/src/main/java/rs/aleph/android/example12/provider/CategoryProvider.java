package rs.aleph.android.example12.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.Category;

/**
 * Created by androiddevelopment on 13.10.17..
 */

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Meat"));
        categories.add(new Category(1, "Vegetarian"));
        categories.add(new Category(2, "Vegan"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Meat");
        names.add("Vegetarian");
        names.add("Vegan");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Meat");
            case 1:
                return new Category(1, "Vegetarian");
            case 2:
                return new Category(2, "Vegan");
            default:
                return null;
        }
    }
}
