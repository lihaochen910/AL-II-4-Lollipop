package com.kanbaru.alii;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class AppListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_list);
		Intent i=new Intent(this,com.kanbaru.alii.tools.LockService.class);
		startService(i);
		Log.e("Æô¶¯·þÎñ", "");
	}

	
}
