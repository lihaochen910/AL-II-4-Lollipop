package com.kanbaru.alii.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.EventLog;
import android.util.EventLog.Event;
import android.util.JsonWriter;
import android.util.Log;

public class LockService extends Service {

	boolean threadDisable;
	int count=0;
	
	public void onCreate() {
        super.onCreate();
        /** 创建一个线程，每秒计数器加一，并在控制台进行Log输出 */
        new Thread(new Runnable() {
            public void run() {
                
				while (!threadDisable) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    count++;
                    Log.v("CountService", "Count is" + count);
                }
            }
        }).start();
    }
	
	@Override
	public void onStart(Intent intent, int startId) {
		Log.w("服务已启动", "");
		while(true){
			checkAppPackageName();
		}
	}

	void checkAppPackageName(){
		try {  
		    int tagCode = EventLog.getTagCode("am_proc_start");  
		    Collection<Event> output = new ArrayList<EventLog.Event>();  
		    EventLog.readEvents(new int[] { tagCode }, output);  
		    for (Event event : output) {  
		        // PID, UID, Process Name, Type, Component  
		        Object[] objects = (Object[]) event.getData();  
		        ComponentName componentName = ComponentName  
		                .unflattenFromString(objects[4].toString());  
		        String packageName = componentName.getPackageName();  
		        Log.d("am_proc_start ", "packageName=" + packageName);  
		    }  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}  
	}
	void write2json(String value){
		String filePath = Environment.getExternalStorageDirectory().toString()+ "/AppPackageName.json";
		
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(
					fos, "UTF-8"));

			jsonWriter.beginObject();
			jsonWriter.name("package").value(value);
			jsonWriter.endObject();
			jsonWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
