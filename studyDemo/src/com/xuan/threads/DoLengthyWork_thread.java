package com.xuan.threads;

import java.util.Calendar;

import android.os.Handler;
import android.widget.ProgressBar;

public class DoLengthyWork_thread extends Thread {

	private Handler mhandler;
	private ProgressBar mProBar;
	
	public DoLengthyWork_thread(Handler h,ProgressBar proBar) {
		// TODO Auto-generated constructor stub
		this.mProBar = proBar;
		this.mhandler = h;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar begin = Calendar.getInstance();
		do{
			Calendar now = Calendar.getInstance();
			final int iDiffSec =60*(now.get(Calendar.MINUTE)-
													  begin.get(Calendar.MINUTE))+
													  now.get(Calendar.SECOND)-
													  begin.get(Calendar.SECOND);
			if(iDiffSec*2>100){
				//只是将Runable对象post到mHandler所在的线程的队列中,运行是在那边(主线程)。
				mhandler.post(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProBar.setProgress(100);
					}
				});
				break;
			}
			
			mhandler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mProBar.setProgress(iDiffSec*2);
				}
			});
			
			if(iDiffSec*4<100){
				mhandler.post(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProBar.setSecondaryProgress(iDiffSec*4);
					}
				});		
			}else{
				mhandler.post(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mProBar.setSecondaryProgress(100);
					}
				});
			}
		}while(true);
	}
}
