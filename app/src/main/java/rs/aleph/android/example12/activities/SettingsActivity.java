package rs.aleph.android.example12.activities;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v4.app.NavUtils;
import android.support.v7.view.menu.MenuAdapter;
import android.view.MenuItem;

import rs.aleph.android.example12.R;

/**
 * Created by androiddevelopment on 25.10.17..
 */

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Replaces activity's content with a an instance of PreferenceFragment
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // PreferenceFragment is used to automatically load preference GUI from an XML resource and
    // save preferences into preferences.xml
    public static class PrefsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            // Loads preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);

        }
    }
}
