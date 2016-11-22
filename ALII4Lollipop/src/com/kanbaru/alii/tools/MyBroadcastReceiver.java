package com.kanbaru.alii.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent i) {
		
		Intent i1=new Intent(context,com.kanbaru.alii.tools.LockService.class);
		context.startService(i1);
	}

}
