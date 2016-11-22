package com.kanbaru.alii.diy;

import com.kanbaru.alii.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class UnlockDialog extends Dialog {

	TextView error_msg;
	protected UnlockDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.force_stop_simple_ver);
		
		error_msg=(TextView) findViewById(R.id.error_textView);
		error_msg.setText("很抱歉，'com.kanbaru.alii'进程已停止运行。");
		error_msg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doubleClick_check();
			}
		});
	}
	
    public void doubleClick_check() {
    	long[] mHits_double = new long[2];
        // 双击事件响应
        // 实现数组的移位操作，点击一次，左移一位，末尾补上当前开机时间（cpu的时间）
    	
        System.arraycopy(mHits_double, 1, mHits_double, 0, mHits_double.length - 1);
        mHits_double[mHits_double.length - 1] = SystemClock.uptimeMillis();
        //双击事件的时间间隔500ms
        if (mHits_double[0] >= (SystemClock.uptimeMillis() - 500)) {
            //双击后具体的操作
        	Log.e("用户执行了快速双击", "");
            
        }
    }
}
