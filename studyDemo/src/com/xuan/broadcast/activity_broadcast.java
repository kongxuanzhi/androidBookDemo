package com.xuan.broadcast;

import com.xuan.studydemo.R;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_broadcast extends Activity implements OnClickListener {

	private Button
								 mBtnRegReceiver,
								 mBtnUnregReceiver,
								 mBtnSendBroadcase1,
								 mBtnSendBroadcase2;
	private MyBroadcaseReceive2 mMyReceiver2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast_rece);
		
		setupViewComponent();
	}
	private void setupViewComponent(){
		 mBtnRegReceiver = (Button) this.findViewById(R.id.btnRegReceiver);  
		 mBtnUnregReceiver= (Button) this.findViewById(R.id.btnUnregReceiver);  
		 mBtnSendBroadcase1= (Button) this.findViewById(R.id.btnSendBroadcase1);  
		 mBtnSendBroadcase2= (Button) this.findViewById(R.id.btnSendBroadcase2);
		 mBtnRegReceiver.setOnClickListener(this);
		 mBtnUnregReceiver.setOnClickListener(this);
		 mBtnSendBroadcase1.setOnClickListener(this);
		 mBtnSendBroadcase2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnRegReceiver:
			IntentFilter itFilter = new IntentFilter("broadcast2.xuan.com");
			mMyReceiver2= new MyBroadcaseReceive2();;
			registerReceiver(mMyReceiver2, itFilter);
			break;
		case R.id.btnUnregReceiver:
					unregisterReceiver(mMyReceiver2);
					break;
		case R.id.btnSendBroadcase1:
				Intent it = new Intent("broadcast1.xuan.com");
				it.putExtra("sender_name", "电量低");
				sendBroadcast(it);
			break;
		case R.id.btnSendBroadcase2:
				Intent its = new Intent("broadcast2.xuan.com");
				its.putExtra("sender_name", "赶快找个女朋友");
				sendBroadcast(its);
				break;
		default:
			break;
		}
	}
	
	
}

