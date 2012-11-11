package com.meteo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.maps.MapView;
import android.R;
import com.meteo.apiclient.Client;

public class MainActivity extends FragmentActivity
						  implements NoticeDialogFragment.NoticeDialogListener
{
    private Button loginButton;
    private EditText usernameText;
    private EditText passwordText;
    private MapView mapView;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findAllViewsById();
        
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Client apiClient = new Client();
                if (apiClient.login(usernameText.getText().toString(), passwordText.getText().toString())) {
                    Intent intent = new Intent(view.getContext(), MapActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivityForResult(intent, 0);
                }
            }
        });
        
//        String content = Common.readTextFile(getResources().openRawResource(R.raw.events_sample), mapView.getContext());
        
//        DialogFragment newFragment = new TestDialog(content);
//    	newFragment.show(getSupportFragmentManager(), "missiles");
    }
    
    public void findAllViewsById()
    {
        loginButton = (Button) findViewById(R.id.loginButton);
        usernameText = (EditText) findViewById(R.id.username_input);
        passwordText = (EditText) findViewById(R.id.password_input);
        mapView = (MapView) findViewById(R.id.mapview);
    }
    
	public void onDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

}
