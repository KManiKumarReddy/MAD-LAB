package com.kmanikumarreddy.sms;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.telephony.gsm.SmsManager;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	String SENT = "SMS_SENT";
	String DELIVERED = "SMS_DELIVERED";
	PendingIntent sentPI, deliveredPI;
	BroadcastReceiver smsSentBroadcastReceiver, smsDeliveredBroadcastReceiver; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sentPI = PendingIntent.getBroadcast(this, 0,  new Intent(SENT), 0);
		deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);
	}
	
	protected void onResume() {
		super.onResume();
		smsSentBroadcastReceiver = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS SENT", Toast.LENGTH_LONG).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(), "NULL PDU", Toast.LENGTH_LONG).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(), "No Service", Toast.LENGTH_LONG).show();
					break;
				}
				
			}
		};
		smsDeliveredBroadcastReceiver = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS DELIVERED", Toast.LENGTH_LONG).show();
					break;
				case Activity.RESULT_CANCELED:
					Toast.makeText(getBaseContext(), "SMS NOT DELIVERED", Toast.LENGTH_LONG).show();
					break;
				}
			}
		};
		registerReceiver(smsSentBroadcastReceiver, new IntentFilter(SENT));
		registerReceiver(smsDeliveredBroadcastReceiver, new IntentFilter(DELIVERED));
	}
	
	protected void onPause() {
		super.onPause();
		unregisterReceiver(smsSentBroadcastReceiver);
		unregisterReceiver(smsDeliveredBroadcastReceiver);
	}
	
	public void onClick(View v) {
		sendSms("5556", "hi");
	}
	
	private void sendSms(String phoneNumber, String message) {
		SmsManager sm = SmsManager.getDefault();
		sm.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
	}
	
}
