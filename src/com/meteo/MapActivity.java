package com.meteo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.MyLocation;
import com.meteo.R;

public class MapActivity extends FragmentActivity {

    private MapView mapView;
    private MyLocationOverlay myLocationOverlay;
    private LocationManager locationManager;
//    private GPSLocationListener locationListener;
    private NLPLocationListener locationListener;
    private MapController mapController;

    private Overlay demoOverlay;
    
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.map);
        findAllViewsById();

        myLocationOverlay = new MyLocationOverlay(this, mapView);
        mapView.getOverlays().add(myLocationOverlay);
        mapView.postInvalidate();
        
        mapController = mapView.getController();
        mapController.setZoom(16); 

        myLocationOverlay.runOnFirstFix(new Runnable() {

            public void run() {
                mapView.getController().animateTo(myLocationOverlay.getMyLocation());
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new GPSLocationListener(mapView);

        locationListener = new NLPLocationListener(mapView);
        
//        locationManager.requestLocationUpdates(
//                LocationManager.GPS_PROVIDER,
//                0,
//                0,
//                locationListener);
        
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        
//        List<Overlay> mapOverlays = mapView.getOverlays();
//        Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
//        MarkerItemizedOverlay itemizedoverlay = new MarkerItemizedOverlay(drawable, this);
//        
//        GeoPoint point = new GeoPoint(19240000,-99120000);
//        OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
//        
//        GeoPoint point2 = new GeoPoint(35410000, 139460000);
//        OverlayItem overlayitem2 = new OverlayItem(point2, "Sekai, konichiwa!", "I'm in Japan!");
//        
//        itemizedoverlay.addOverlay(overlayitem);        
//        itemizedoverlay.addOverlay(overlayitem2);
//        mapOverlays.add(itemizedoverlay);
        
        this.demoOverlay = new TestOverlay();
        mapView.getOverlays().add(demoOverlay);
     

        String content = Common.readTextFile(getResources().openRawResource(R.raw.events_sample), mapView.getContext());
  	  	
        Gson gson = new GsonBuilder().create();
        MyLocation loc = gson.fromJson(content, MyLocation.class);
        
        
        
        DialogFragment newFragment = new TestDialog(loc.toString());
    	newFragment.show(getSupportFragmentManager(), "missiles");
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.enableCompass();
    }

    @Override
    protected void onPause() {
        super.onPause();
        myLocationOverlay.disableMyLocation();
        myLocationOverlay.disableCompass();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.runFinalizersOnExit(true);
        System.exit(RESULT_OK);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                finish();
                return true;
            case R.id.help:
            	// show THE dialog
            	DialogFragment newFragment = new TestDialog("Test map");
            	newFragment.show(getSupportFragmentManager(), "missiles");
                return true;
            case R.id.options:
                Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void findAllViewsById() {
        mapView = (MapView) findViewById(R.id.mapview);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
