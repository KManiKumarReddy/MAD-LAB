package com.kmanikumarreddy.datafromactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
		startActivityForResult(new Intent("com.kmanikumarreddy.datafromactivity.SecondActivity"), requestCode);
	}
    
    public void onActivityResult(int reqCode, int resultCode, Intent i ) {
		if(reqCode == requestCode)
			if(resultCode == RESULT_OK) {
				Toast.makeText(getApplicationContext(), i.getStringExtra("peeprica"), Toast.LENGTH_LONG).show();
				TextView tv = (TextView)findViewById(R.id.textView1);
				tv.setText(i.getStringExtra("peeprica"));
			}
    }
}
