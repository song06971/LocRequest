package familytech.com.locrequest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    double latitude;
    double longitude;
    GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps = new GPSTracker(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_getLocation) {

            Log.d(" onOptionsItemSelected","enter");
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            Log.d("onOptionsItemSelected", "longtitude is : " + Double.toString(longitude) + " Latitude: " + Double.toString(latitude));
                  // Toast.makeText(this, "longitude: " + longitude + " latitude: " + latitude, 60);

            // Creates an Intent that will load a map of San Francisco
            // geo:latitude,longitude?z=zoom
            Uri gmmIntentUri = Uri.parse("geo:"+Double.toString(latitude) +",longitude" + Double.toString(longitude));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}
