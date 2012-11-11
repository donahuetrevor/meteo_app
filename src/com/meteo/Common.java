package com.taxi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;



public class Common {

	public static String readTextFile(InputStream inputStream, Context context) throws RuntimeException {
		  
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		int i;
		try {
			i = inputStream.read();
			while (i != -1)
			{
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		return byteArrayOutputStream.toString();
	}

}
