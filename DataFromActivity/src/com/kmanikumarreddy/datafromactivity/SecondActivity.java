package com.kmanikumarreddy.datafromactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
	
	public void onClick(View view) {
		Intent i = new Intent();
		EditText et1 = (EditText)findViewById(R.id.editText1);
		i.putExtra("peeprica", et1.getText().toString());
		setResult(1, i);
		finish();
	}
}
