package rs.aleph.android.example12.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;


import java.util.ArrayList;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.adapters.DrawerAdapter;
import rs.aleph.android.example12.dialogs.AboutDialog;
import rs.aleph.android.example12.fragments.DetailFragment;
import rs.aleph.android.example12.fragments.ListFragment;
import rs.aleph.android.example12.model.NavigationItem;

// Each activity extends Activity class
public class FirstActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener{

	/* The click listner for ListView in the navigation drawer */
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if (position == 0) {
				// FirstActivity is already shown
			} else if (position == 1) {
				Intent settings = new Intent(FirstActivity.this,SettingsActivity.class);
				startActivity(settings);
			} else if (position == 2) {
				if (dialog == null){
					dialog = new AboutDialog(FirstActivity.this).prepareDialog();
				} else {
					if (dialog.isShowing()) {
						dialog.dismiss();
					}
				}

				dialog.show();
			}

			drawerList.setItemChecked(position, true);
			setTitle(drawerItems.get(position).getTitle());
			drawerLayout.closeDrawer(drawerPane);

		}
	}

	// Attributes used by NavigationDrawer
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;
	private RelativeLayout drawerPane;
	private CharSequence drawerTitle;
	private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();

	// Attributes used by Dialog
	private android.app.AlertDialog dialog;

	boolean landscape = false;


	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_main);

		//Toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

		if (actionBar != null) {
			actionBar.show();
		}

		//Fragments
		// If the activity is started for the first time create list fragment
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

		// Manages NavigationDrawer

		// Populates a list of NavigationDrawer items
		drawerItems.add(new NavigationItem(getString(R.string.drawer_home), R.drawable.ic_action_home));
		drawerItems.add(new NavigationItem(getString(R.string.drawer_settings), R.drawable.ic_action_settings));
		drawerItems.add(new NavigationItem(getString(R.string.drawer_about), R.drawable.ic_action_about));

		drawerTitle = getTitle();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerList = (ListView) findViewById(R.id.navList);

		// Populates NavigtionDrawer with options
		drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
		DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

		// Sets a custom shadow that overlays the main content when NavigationDrawer opens
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		drawerList.setAdapter(adapter);

		drawerToggle = new ActionBarDrawerToggle(
				this,                           /* host Activity */
				drawerLayout,                   /* DrawerLayout object */
				toolbar,                        /* nav drawer image to replace 'Up' caret */
				R.string.drawer_open,           /* "open drawer" description for accessibility */
				R.string.drawer_close           /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
			}
		};
	}
	@Override
	public void onItemSelected(int position) {

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

	// Method(s) that manage Toolbar.

	// onCreateOptionsMenu method initialize the contents of the Activity's Toolbar.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_create:
				Snackbar.make(findViewById(R.id.list_view), R.string.tb_create, Snackbar.LENGTH_SHORT).show();
				break;
			case R.id.action_update:
				Snackbar.make(findViewById(R.id.list_view), R.string.tb_update, Snackbar.LENGTH_SHORT).show();
				break;
			case R.id.action_delete:
				Snackbar.make(findViewById(R.id.list_view), R.string.tb_delete, Snackbar.LENGTH_SHORT).show();
				break;
		}

		return super.onOptionsItemSelected(item);
	}
	// Overrides setTitle method to support older api levels
	@Override
	public void setTitle(CharSequence title) {
		getSupportActionBar().setTitle(title);
	}



	// Method(s) that manage NavigationDrawer.

	// onPostCreate method is called often onRestoreInstanceState to synchronize toggle state
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	// onConfigurationChanged method is called when the device configuration changes to pass configuration change to the drawer toggle
	@Override
	public void onConfigurationChanged(Configuration configuration) {
		super.onConfigurationChanged(configuration);

		// Pass any configuration change to the drawer toggle
		drawerToggle.onConfigurationChanged(configuration);
	}

}
