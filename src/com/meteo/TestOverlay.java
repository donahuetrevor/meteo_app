package com.taxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.app.DialogFragment;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;


public class TestOverlay extends Overlay {
	
	@Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        // TODO Auto-generated method stub
        super.draw(canvas, mapView, shadow);
        
        Projection projection = mapView.getProjection();
        
        int latSpan = mapView.getLatitudeSpan();
        int lngSpan = mapView.getLongitudeSpan();
        GeoPoint mapCenter = mapView.getMapCenter();
        int mapLeftGeo = mapCenter.getLongitudeE6() - (lngSpan / 2);
        int mapRightGeo = mapCenter.getLongitudeE6() + (lngSpan / 2);
        int mapTopGeo = mapCenter.getLatitudeE6() - (latSpan / 2);
        int mapBottomGeo = mapCenter.getLatitudeE6() + (latSpan / 2);
        
        
        GeoPoint geoPoint = this.getSampleLocation();
        
        if ((geoPoint.getLatitudeE6() > mapTopGeo && geoPoint.getLatitudeE6() < mapBottomGeo)
                && (geoPoint.getLongitudeE6() > mapLeftGeo && geoPoint.getLongitudeE6() < mapRightGeo)) {
         
        	Point myPoint = new Point();
            projection.toPixels(geoPoint, myPoint);
//            Bitmap marker = BitmapFactory.decodeResource(mapView.getContext().getResources(), R.drawable.markerblue);
//            canvas.drawBitmap(marker, myPoint.x - 15, myPoint.y - 30, null);
            
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setAntiAlias(true);
            paint.setARGB(80,0,0,255);
            
//            canvas.drawCircle(myPoint.x - 15, myPoint.y - 30, 5, paint);
            
//            int coef = 15;
//            
//            float x0 = myPoint.x - coef;
//            float y0 = myPoint.y - coef;
//            float x1 = myPoint.x + coef;
//            float y1 = myPoint.y + coef;
//            
//            canvas.drawRect(x0, y0, x1, y1, paint);
            
//            this.getRawJSON();
            
            int radiusInMeters = 50;
            Point center = projection.toPixels(new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6()), null);
            float radius = projection.metersToEquatorPixels(radiusInMeters);
            canvas.drawCircle(myPoint.x, myPoint.y, radius, paint);
            
            
            
        }
    }
	
	private GeoPoint getSampleLocation() {
	    // Create GeoPoint to secret location....
//	    GeoPoint sampleGeoPoint = 
//	        new GeoPoint((int)(56.27058500725475 * 1E6),
//	            (int)(-2.6984095573425293 * 1E6));
//	    return sampleGeoPoint;
		return new GeoPoint((int)(45.45622 * 1E6), (int)(-75.7231 * 1E6));
	}
	
//	private String getRawJSON() {
//		return Common.readTextFile("events_sample.json");
//	}
}


