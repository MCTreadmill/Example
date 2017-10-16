package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.example12.provider.FoodProvider;
import rs.aleph.android.example12.provider.CategoryProvider;
import rs.aleph.android.example12.provider.IngredientsProvider;
import rs.aleph.android.example12.R;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);

        // Loads an URL into the WebView
        final int position = getIntent().getIntExtra("position", 0);

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getAssets().open(FoodProvider.getFoodById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(FoodProvider.getFoodById(position).getName());

        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(FoodProvider.getFoodById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FoodProvider.getFoodById(position).getCategory().getId());

        TextView tvCalories = (TextView) findViewById(R.id.tv_calories);
        tvCalories.setText(Float.toString(FoodProvider.getFoodById(position).getCalories()));

        TextView tvPrice = (TextView) findViewById(R.id.tv_price);
        tvPrice.setText(Float.toString(FoodProvider.getFoodById(position).getPrice()));

        // Loads fruits from array resource
        final List<String> ingredientNames = IngredientsProvider.getIngredientNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, ingredientNames);
        ListView listView = (ListView) findViewById(R.id.ingredients_list);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

    }


    /*public void btnStartThirdActivityClicked(View view) {
        // This is an explicit intent (class property is specified)
        Intent activity3 = new Intent(SecondActivity.this, ThirdActivity.class);
        // startActivity method starts an activity
        startActivity(activity3);
    }
    public void btnOpenCameraClicked(View view){
        Intent camera = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(camera);
    }*/
}
