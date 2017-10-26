package rs.aleph.android.example12.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
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

    private static int NOTIFICATION_ID = 1;

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
        tvName.setText(FoodProvider.getFoodById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int) FoodProvider.getFoodById(position).getCategory().getId());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        String cal = getString(R.string.food_cal);
        tvCalories.setText(Float.toString(FoodProvider.getFoodById(position).getCalories()) + cal);

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        String eur = getString(R.string.food_eur);
        tvPrice.setText(Float.toString(FoodProvider.getFoodById(position).getPrice()) + eur);

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

        // Finds "btnBuy" Button and sets "onClickListener" listener
        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

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
        tvName.setText(FoodProvider.getFoodById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int) FoodProvider.getFoodById(position).getCategory().getId());

        TextView tvCalories = (TextView) getView().findViewById(R.id.tv_calories);
        String cal = getString(R.string.food_cal);
        tvCalories.setText(Float.toString(FoodProvider.getFoodById(position).getCalories()) + cal);

        TextView tvPrice = (TextView) getView().findViewById(R.id.tv_price);
        String eur = getString(R.string.food_eur);
        tvPrice.setText(Float.toString(FoodProvider.getFoodById(position).getPrice()) + eur);

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

        // Finds "btnBuy" Button and sets "onClickListener" listener
        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    private void showNotification() {
        // Creates notification with the notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setContentTitle(getActivity().getString(R.string.notification_title));
        builder.setContentText(getActivity().getString(R.string.notification_text));
        builder.setLargeIcon(bitmap);

        // Shows notification with the notification manager (notification ID is used to update the notification later on)
        NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }
}
