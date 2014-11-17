package com.example.silvafinalexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
// William Silva
	// All Work here is honestly obtained and is my own.
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
public void handleClick(View v){
	boolean clicked = ((Button )v).isPressed();
	EditText text1= (EditText)findViewById(R.id.editDollars);
	EditText text2 = (EditText)findViewById(R.id.editYen);
	EditText text3 = (EditText)findViewById(R.id.editPounds);
	double value1 = Double.parseDouble(String.valueOf(text1.getText()));
	double value2 = Double.parseDouble(String.valueOf(text2.getText()));
	double value3 = Double.parseDouble(String.valueOf(text3.getText()));
switch(v.getId()) {
case R.id.buttonConvertDollars:
if(clicked) {
		text2.setText(dollarsToYen(value1));
		text3.setText(dollarsToPounds(value1));
}
break;
case R.id.buttonConvertPounds:
if(clicked) {
	text1.setText(poundsToDollars(value3));
	text2.setText(poundsToYen(value3));
	}
break;
case R.id.buttonConvertYen:
	if (clicked) {
		text1.setText(yenToDollars(value2));
		text3.setText(yenToPounds(value2));
	}
	break;
}
}
public String dollarsToPounds(double dollars){
	double pounds = dollars*.62;
	return String.valueOf(pounds);
}
public String dollarsToYen(double dollars){
	double yen = dollars*97.35;
	return String.valueOf(yen);
}
public String poundsToDollars(double pounds){
	double dollars = pounds/0.62;
	return String.valueOf(dollars);
}
public String poundsToYen(double pounds){
	double yen = pounds*.0055;
	return String.valueOf(yen);
}
public String yenToPounds(double yen){
	double pounds = yen/0.0055;
	return String.valueOf(pounds);
}
public String yenToDollars(double yen){
	double dollars= yen/97.35;
	return String.valueOf(dollars);
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
}
