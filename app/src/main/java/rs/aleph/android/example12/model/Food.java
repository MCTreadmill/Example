package rs.aleph.android.example12.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 11.10.17..
 */

public class Food {
    private int id;
    private String image;
    private String name;
    private String description;
    private Category category;
    private float calories;
    private float price;
    private List<Ingredients> ingredients;

    public Food(){
        ingredients = new ArrayList<>();
    }

    public Food(int id, String image, String name, String description, Category category, float calories, float price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.calories = calories;
        this.price = price;

        ingredients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }



}
