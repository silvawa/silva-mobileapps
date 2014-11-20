package com.example.silvafinalproject;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends Activity {
// Fields for Animation View
	private AnimationView animationView;
	
	// Sensor Manager for the Accelerometer
	private SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Initialize the animation view
	animationView = (AnimationView)findViewById(R.id.animationView);
	
	// Enable the listener - there will be an error for a bit
	enableAccelerometerListening();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void enableAccelerometerListening() {
		// Initialize the Sensor Manager
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener,  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}
	private SensorEventListener sensorEventListener = new SensorEventListener() {
		
		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			
			
		}
		
		@Override
		public void onSensorChanged(SensorEvent event){
			float x= event.values[0];
			float y= event.values[1];
			float z= event.values[2];
			
			// Pass the Values to the AnimationView object
			animationView.setAX(x);
			animationView.setAY(y);
			animationView.setAZ(z);
		}
		
	}; // End SensorEventListener
		
	
} // End Main Class
