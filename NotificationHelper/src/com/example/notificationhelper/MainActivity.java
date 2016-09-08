package com.example.notificationhelper;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

@SuppressWarnings("unused")
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    
    public void onClickButton(View view){
    	displayNotification();
    }
    
    @SuppressWarnings("deprecation")
	protected void displayNotification(){
    	Intent i = new Intent(this, NotificationView.class);
    	i.putExtra("notificationId", 1);
    	PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
    	NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    	Notification notif = new Notification(R.drawable.ic_launcher,"Reminder:Meeting starts in 5 minutes",System.currentTimeMillis());
    	CharSequence form = "systemAlarm";
    	CharSequence message = "Meeting with customer at 3pm";
    	notif.setLatestEventInfo(this, form, message, pendingIntent);
    	notif.vibrate = new long[]{100,150,200,500};
    	nm.notify(1, notif);
    }

}
