package com.meteo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.StringMap;
import com.gson.Events;
import com.gson.MyLocation;
import com.meteo.R;

public class TestOverlay extends Overlay {
	
	public MapView mapView;
	public Context cont;
	
	public TestOverlay(Context c) {
		this.cont = c;
	}
	
	@Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        // TODO Auto-generated method stub
        super.draw(canvas, mapView, shadow);
        
        this.mapView = mapView;
        
        Projection projection = mapView.getProjection();
        
        int latSpan = mapView.getLatitudeSpan();
        int lngSpan = mapView.getLongitudeSpan();
        GeoPoint mapCenter = mapView.getMapCenter();
        int mapLeftGeo = mapCenter.getLongitudeE6() - (lngSpan / 2);
        int mapRightGeo = mapCenter.getLongitudeE6() + (lngSpan / 2);
        int mapTopGeo = mapCenter.getLatitudeE6() - (latSpan / 2);
        int mapBottomGeo = mapCenter.getLatitudeE6() + (latSpan / 2);
        
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setARGB(80,0,0,255);
        
        GeoPoint geoPointArray[] = this.getSampleLocation();
        
        for (GeoPoint geoPoint : geoPointArray) {
        	if ((geoPoint.getLatitudeE6() > mapTopGeo && geoPoint.getLatitudeE6() < mapBottomGeo)
                    && (geoPoint.getLongitudeE6() > mapLeftGeo && geoPoint.getLongitudeE6() < mapRightGeo)) {
             
            	Point myPoint = new Point();
                projection.toPixels(geoPoint, myPoint);
                
                int radiusInMeters = 50;
//                Point center = projection.toPixels(new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6()), null);
                float radius = projection.metersToEquatorPixels(radiusInMeters);
                canvas.drawCircle(myPoint.x, myPoint.y, radius, paint);
                
            }
        	
        }
        
    }
	
	private GeoPoint[] getSampleLocation() {
	    // Create GeoPoint to secret location....
//	    GeoPoint sampleGeoPoint = 
//	        new GeoPoint((int)(56.27058500725475 * 1E6),
//	            (int)(-2.6984095573425293 * 1E6));
//	    return sampleGeoPoint;
		
		String content = Common.readTextFile(this.cont.getResources().openRawResource(R.raw.events_sample), this.cont);
		
		Gson gson = new GsonBuilder().create();
		MyLocation loc = gson.fromJson(content, MyLocation.class);
		
		List<StringMap> events = loc.getEvents();
		
		GeoPoint[] resultArray = new GeoPoint[2];
		
		String testString = "debug start";
		int i = 0;
		for (StringMap e : events) {
                    Double lat = (Double) e.get("LaT");
                    Double lng = (Double) e.get("LNG");
                    
                    resultArray[i] = new GeoPoint((int) (lat.doubleValue() * 1E6), (int) (lng.doubleValue() * 1E6));
                    
		}
		
		
		Toast.makeText(this.cont, testString, Toast.LENGTH_SHORT).show();

		resultArray[0] = new GeoPoint((int)(45.45622 * 1E6), (int)(-75.7231 * 1E6));
		resultArray[1] = new GeoPoint((int)(56.27058 * 1E6), (int)(-2.69840 * 1E6));
//		
		return resultArray;
		
//		Context context = mapView.getContext();
		
//		String content = Common.readTextFile(context.getResources().openRawResource(R.raw.events_sample), context);
//  	  	
//        Gson gson = new GsonBuilder().create();
//        MyLocation loc = gson.fromJson(content, MyLocation.class);
//        
//		List events = loc.getEvents();
//		
//		GeoPoint[] resultArray = new GeoPoint[2];
//
//        Iterator<Events> iterator = events.iterator();
//        int i = 0;
//    	while (iterator.hasNext()) {
//    		Events e = iterator.next();
//    		resultArray[i] = new GeoPoint((int)(e.getLaT() * 1E6), (int)(e.getLNG() * 1E6));
//    		i++;
//    	}
//        
//
//    	return resultArray;
	}
	
//	private String getRawJSON() {
//		return Common.readTextFile("events_sample.json");
//	}
}


