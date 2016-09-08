package com.kmanikumarreddy.shopping;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class BuyProducts extends ActionBarActivity implements OnCheckedChangeListener{
	
	private CheckBox cb1, cb2, cb3;
	private TextView totalView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_products);
		cb1 = (CheckBox)findViewById(R.id.checkBox1);
		cb2 = (CheckBox)findViewById(R.id.checkBox2);
		cb3 = (CheckBox)findViewById(R.id.checkBox3);
		cb1.setOnCheckedChangeListener(this);
		cb2.setOnCheckedChangeListener(this);
		cb3.setOnCheckedChangeListener(this);
		totalView = (TextView)findViewById(R.id.totalView);
		totalView.setText("0");
	}
	
	public void onClear(View view) {
		cb1.setChecked(false);
		cb2.setChecked(false);
		cb3.setChecked(false);
		// totalView.setText("0");
	}
	
	public void onBack(View v) {
		setResult(RESULT_OK);
		finish();
	}
	
	public void onPay(View v) {
		Toast.makeText(getBaseContext(), "Please pay Rs. " + totalView.getText().toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		int value;
		switch(arg0.getId()) {
			case R.id.checkBox1 : value = 1000; break;
			case R.id.checkBox2 : value = 10000; break;
			case R.id.checkBox3 : value = 4000; break;
			default : value = 0;
		}
		int total = Integer.parseInt(totalView.getText().toString());
		total = arg1 ? total + value : total - value;
		totalView.setText(String.valueOf(total));
	}

}
