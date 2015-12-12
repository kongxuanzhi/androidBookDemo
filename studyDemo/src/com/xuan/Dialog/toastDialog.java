package com.xuan.Dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

public class toastDialog {

	private Toast mToast;
	private Context mCcontext;
	@SuppressLint("ShowToast")
	public toastDialog(Context mCcontext, String msg) {
		// TODO Auto-generated constructor stub
		this.mCcontext = mCcontext;
		mToast = Toast.makeText(mCcontext, msg,Toast.LENGTH_SHORT);
	}
	
	@SuppressLint("ShowToast")
	public toastDialog(Context mCcontext, int resId) {
		// TODO Auto-generated constructor stub
		this.mCcontext = mCcontext;
		mToast = Toast.makeText(mCcontext, resId,Toast.LENGTH_SHORT);
	}
	public void show(){
		if(mToast != null){
			mToast.show();
		}
	}

}



