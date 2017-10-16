package rs.aleph.android.example12.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 11.10.17..
 */

public class Category {

    private int id;
    private String name;
    private List<Food> foods;

    public Category(){

        foods = new ArrayList<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;

        foods = new ArrayList<>();
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
}
