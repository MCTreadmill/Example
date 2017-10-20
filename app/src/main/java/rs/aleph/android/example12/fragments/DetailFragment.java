package rs.aleph.android.example12.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.model.Ingredients;
import rs.aleph.android.example12.provider.CategoryProvider;
import rs.aleph.android.example12.provider.FoodProvider;

/**
 * Created by androiddevelopment on 20.10.17..
 */

public class DetailFragment extends Fragment {

    private int position = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FoodProvider.getFoodById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        String name = getString(R.string.food_name);
        tvName.setText(name + FoodProvider.getFoodById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        String description = getString(R.string.food_description);
        tvDescription.setText(description + FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int) FoodProvider.getFoodById(position).getCategory().getId());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        String calories = getString(R.string.food_calories);
        String cal = getString(R.string.food_cal);
        tvCalories.setText(calories + Float.toString(FoodProvider.getFoodById(position).getCalories()) + cal);

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        String price = getString(R.string.food_price);
        String eur = getString(R.string.food_eur);
        tvPrice.setText(price + Float.toString(FoodProvider.getFoodById(position).getPrice()) + eur);

        // Loads fruits from array resource
        final List<Ingredients> ingredients = FoodProvider.getFoodById(position).getIngredients();
        final List<String> ingredientNames = new ArrayList<>();
        for (Ingredients ingredient1 : ingredients){
            String output = ingredient1.getName();
            ingredientNames.add(output);
        }

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item2, ingredientNames);
        ListView listView = (ListView) getView().findViewById(R.id.ingredients_list);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    // Called to set fragment's content.
    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    // Called to update fragment's content.
    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);


        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FoodProvider.getFoodById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        String name = getString(R.string.food_name);
        tvName.setText(name + FoodProvider.getFoodById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        String description = getString(R.string.food_description);
        tvDescription.setText(description + FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int) FoodProvider.getFoodById(position).getCategory().getId());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        String calories = getString(R.string.food_calories);
        String cal = getString(R.string.food_cal);
        tvCalories.setText(calories + Float.toString(FoodProvider.getFoodById(position).getCalories()) + cal);

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        String price = getString(R.string.food_price);
        String eur = getString(R.string.food_eur);
        tvPrice.setText(price + Float.toString(FoodProvider.getFoodById(position).getPrice()) + eur);

        // Loads fruits from array resource
        final List<Ingredients> ingredients = FoodProvider.getFoodById(position).getIngredients();
        final List<String> ingredientNames = new ArrayList<>();
        for (Ingredients ingredient1 : ingredients){
            String output = ingredient1.getName();
            ingredientNames.add(output);
        }

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item2, ingredientNames);
        ListView listView = (ListView) getView().findViewById(R.id.ingredients_list);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);
    }
}
