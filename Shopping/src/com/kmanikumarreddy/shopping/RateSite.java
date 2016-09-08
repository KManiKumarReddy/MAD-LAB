package com.kmanikumarreddy.shopping;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;
public class RateSite extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_site);
	}
	
	public void onBack(View v) {
		setResult(RESULT_OK);
		finish();
	}

	public void onSubmit(View v) {
		RatingBar r = (RatingBar)findViewById(R.id.ratingBar1);
		Toast.makeText(getBaseContext(), String.valueOf(r.getRating()), Toast.LENGTH_LONG).show();
		setResult(RESULT_OK);
		finish();
	}
}
