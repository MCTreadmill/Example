package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.provider.FoodProvider;

// Each activity extends Activity class
public class FirstActivity extends Activity {

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_main);

		// Loads fruits from array resource
		final List<String> foodNames = FoodProvider.getFoodNames();

		// Creates an ArrayAdaptar from the array of String
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, foodNames);
		ListView listView = (ListView) findViewById(R.id.food_list);

		// Assigns ArrayAdaptar to ListView
		listView.setAdapter(dataAdapter);

		// Starts the SecondActivity and sends it the selected URL as an extra data
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
	}
}
