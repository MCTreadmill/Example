package model;

/**
 * Created by androiddevelopment on 11.10.17..
 */

public class Ingredients {

    private int id;
    private String name;
    private Food food;

    public Ingredients(){

    }

    public Ingredients(int id, String name, Food food) {
        this.id = id;
        this.name = name;
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
