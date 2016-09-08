package com.kmanikumarreddy.fliporientation;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private boolean prime;
	private boolean potrait;
	private String number;
	private EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		potrait = true;
		number = "0";
	}
	
	@Override
	protected void onResume() {
		super.onStart();
		et = (EditText)findViewById(R.id.editText1);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		potrait = savedInstanceState.getBoolean("potrait");
		number = savedInstanceState.getString("number");
		et.setText(String.valueOf(number));
		prime = savedInstanceState.getBoolean("prime");
		Toast.makeText(getApplicationContext(), prime? number + " is Prime" : number + " is not Prime", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		number = et.getText().toString();
		prime = isPrime(Integer.parseInt(number));
		outState.putString("number", number);
		outState.putBoolean("prime", prime);
		outState.putBoolean("potrait", potrait);
		super.onSaveInstanceState(outState);
	}
	
	public boolean isPrime(int n) {
		for(int i = 2; i <= n/2; i += 2)
			if(n%i == 0)
				return false;
		return true;
	}
	
	public void flip(View view) {
		potrait = !potrait;
		if(potrait)
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		else
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
}
