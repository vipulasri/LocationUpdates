package com.locationupdates;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderApi;


/**
 * Created by HP-HP on 26-11-2015.
 */
public class LocationUpdates extends IntentService {

    private String TAG = this.getClass().getSimpleName();

    public LocationUpdates() {
        super("Fused Location");
    }

    public LocationUpdates(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "onHandleIntent");

        Location location = intent.getParcelableExtra(FusedLocationProviderApi.KEY_LOCATION_CHANGED);
        if(location !=null)
        {
            Log.i(TAG, "onHandleIntent " + location.getLatitude() + "," + location.getLongitude());
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder noti = new NotificationCompat.Builder(this);
            noti.setContentTitle("Fused Location");
            noti.setContentText(location.getLatitude() + "," + location.getLongitude());
            noti.setSmallIcon(R.mipmap.ic_launcher);

            notificationManager.notify(1234, noti.build());
        }
    }
}
