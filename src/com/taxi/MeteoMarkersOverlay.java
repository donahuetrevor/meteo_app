package com.taxi;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.graphics.Point;

import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MeteoMarkersOverlay extends Overlay {

	Paint paint = new Paint();
	
	public static List<Point> points = new ArrayList<Point>();
	
	public MeteoMarkersOverlay() {
		points.add(new Point(10, 10));
	}

	@Override
	 public void draw(Canvas canvas, MapView mapview, boolean shadow) {
	        super.draw(canvas, mapview, shadow);
	            paint = new Paint();
	            paint.setColor(Color.WHITE);
	            paint.setAntiAlias(true);
	            paint.setARGB(80,0,0,255);
	            for (Point point : points) {
	            	canvas.drawCircle(point.x, point.y, 5, paint);
	            }
	 }

}