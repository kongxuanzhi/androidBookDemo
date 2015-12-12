package com.xuan.broadcast;

import com.xuan.Dialog.toastDialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcaseReceive2 extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String sender = intent.getExtras().getString("sender_name");
		new toastDialog(context, "BroadcastReceiver2收到"+sender+"发送的Broadcase信息").show();
	}

}
