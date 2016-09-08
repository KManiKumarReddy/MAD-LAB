package com.example.builtinapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClickWebBrowser(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://kmanikumarreddy.github.io"));
		startActivity(i);
	}
    
    public void onClickMakeCall(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:+7207863707"));
		startActivity(i);
	}
    
    public void onClickMyActivity(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://kmanikumarreddy.github.io"));
		startActivity(i);
	}
}