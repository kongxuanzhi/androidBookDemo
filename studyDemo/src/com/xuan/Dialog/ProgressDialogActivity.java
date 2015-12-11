package com.xuan.Dialog;

import java.util.Calendar;
import com.xuan.studydemo.R;
import com.xuan.threads.DoLengthyWork_thread;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class ProgressDialogActivity  extends ActionBarActivity 
					implements OnClickListener{

	private Button mBtnProgDlg;
	private Handler mHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_dialog);
		setupViewComponent();
	}
	private void setupViewComponent(){
		mBtnProgDlg = (Button) this.findViewById(R.id.btnProgDlg);
		mBtnProgDlg.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnProgDlg:
			final ProgressDialog progDlg = new ProgressDialog(ProgressDialogActivity.this);
			progDlg.setTitle("请稍等");
			progDlg.setMessage("执行中......");
			progDlg.setIcon(android.R.drawable.ic_dialog_info);
			progDlg.setCancelable(false);
			progDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progDlg.setMax(100);
			progDlg.show();
			
			new Thread(new Runnable() {
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
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									progDlg.setProgress(100);
								}
							});
							break;
						}
						
						mHandler.post(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								progDlg.setProgress(iDiffSec*2);
							}
						});
						
						if(iDiffSec*4<100){
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									progDlg.setSecondaryProgress(iDiffSec*4);
								}
							});		
						}else{
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									progDlg.setSecondaryProgress(100);
								}
							});
						}
					}while(true);
					progDlg.cancel();
				}
			}).start();
			break;
		default:
			break;
		}
	}

}
