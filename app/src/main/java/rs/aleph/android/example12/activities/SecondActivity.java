package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

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
