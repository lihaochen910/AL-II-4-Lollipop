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
		error_msg.setText("�ܱ�Ǹ��'com.kanbaru.alii'������ֹͣ���С�");
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
        // ˫���¼���Ӧ
        // ʵ���������λ���������һ�Σ�����һλ��ĩβ���ϵ�ǰ����ʱ�䣨cpu��ʱ�䣩
    	
        System.arraycopy(mHits_double, 1, mHits_double, 0, mHits_double.length - 1);
        mHits_double[mHits_double.length - 1] = SystemClock.uptimeMillis();
        //˫���¼���ʱ����500ms
        if (mHits_double[0] >= (SystemClock.uptimeMillis() - 500)) {
            //˫�������Ĳ���
        	Log.e("�û�ִ���˿���˫��", "");
            
        }
    }
}
