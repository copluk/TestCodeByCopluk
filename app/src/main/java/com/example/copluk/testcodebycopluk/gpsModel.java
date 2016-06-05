package com.example.copluk.testcodebycopluk;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Copluk on 16/3/31.
 */

public class gpsModel {

    Context context;
    Location location;
    public gpsModel(Context cn){
        context = cn;
    }

    private boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private String gpsStatus(){
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String longAndLat;
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){

            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Double latNo = 00.00;
            Double longNo = 00.00;

            if (location != null){
                latNo = location.getLatitude();
                longNo = location.getLongitude();
            }
            longAndLat = "GPS:" + String.valueOf(latNo) + "  " + String.valueOf(longNo);

            return longAndLat;
        }
        else if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            longAndLat = "NET:" + String.valueOf(location.getLatitude()) + "  " + String.valueOf(location.getLongitude());

            return longAndLat;
        }else {
            return "NoLocation";
        }
    }

    public String useGps(){
        if (isConnected()){
            return gpsStatus();
        }else {
            return "noInt";
        }
    }




}
