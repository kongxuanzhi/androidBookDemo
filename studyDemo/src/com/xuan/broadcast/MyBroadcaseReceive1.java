package com.xuan.broadcast;

import com.xuan.Dialog.toastDialog;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class MyBroadcaseReceive1 extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String sender = intent.getExtras().getString("sender_name");
		new toastDialog(context, "BroadcastReceiver1收到"+sender+"发送的Broadcase信息").show();
	}
}
