package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.fragments.DetailFragment;
import rs.aleph.android.example12.fragments.ListFragment;
import rs.aleph.android.example12.provider.FoodProvider;

// Each activity extends Activity class
public class FirstActivity extends Activity implements ListFragment.OnItemSelectedListener{

	boolean landscape = false;

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_main);

		// If the activity is started for the first time create master fragment
		if (savedInstanceState == null) {
			// FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ListFragment listFragment = new ListFragment();
			ft.add(R.id.list_view, listFragment, "List_Fragment_1");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}

		// If the device is in the landscape mode and the detail fragment is null create detail fragment
		if (findViewById(R.id.detail_view) != null) {
			landscape = true;
			getFragmentManager().popBackStack();

			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			if (detailFragment == null) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				detailFragment = new DetailFragment();
				ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
			}
		}

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
	@Override
	public void onItemSelected(int position) {

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onItemSelected()", Toast.LENGTH_SHORT).show();

		if (landscape) {
			// If the device is in the landscape mode updates detail fragment's content.
			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			detailFragment.updateContent(position);
		} else {
			// If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
			DetailFragment detailFragment = new DetailFragment();
			detailFragment.setContent(position);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.list_view, detailFragment, "Detail_Fragment_2");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
		}
	}
}
