package com.example.aids.a09application;
import android.widget.Toast;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Connor on 26/07/2017.
 */



public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nav_to_event);

        try {
            // Loading map
            initialiseMap();
        } catch (Exception e) {//return errors
            e.printStackTrace();
        }
    }

    /**
     * function to load map. If map is not created it will create it for you
     * */
    public void initialiseMap() {
        if (map == null) {
            MapFragment googleMap = (MapFragment) getFragmentManager().findFragmentById(R.id.nav_map);
            googleMap.getMapAsync(this);
        }

        // check if map is created successfully or not
        if (map == null) {
            Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialiseMap();
    }
}
