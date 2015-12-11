package com.xuan.studydemo;

import com.xuan.threads.DoLengthyWork_thread;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TabHost.TabSpec;

@SuppressLint("NewApi")
public class TabActivity extends ActionBarActivity {

		private Handler mhandler = new Handler();
		
		  //-----------------进度条tab----------------
		private RatingBar mRatBar;
		private SeekBar mSeekBar;
		private TextView mTxtSeekBar, mTxt1RatBar,mTxt2RatBar;
	
		
		//----------------时间tab---------------------
	      private DatePicker mDataPik;
		  private TimePicker mTimePik;
		  
		  private TextView mTextResult;
		  private Button mBtnOK;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_tabs);
			setViewComponent();
		}
		private void	setViewComponent(){			
			TabHost tabHost = (TabHost) this.findViewById(R.id.tabHost);
			tabHost.setup();
			
			TabSpec Spec=tabHost.newTabSpec("tab1");
			Spec.setContent(R.id.tab1);
			Spec.setIndicator("日期和时间"+getResources().getDrawable(android.R.drawable.ic_lock_idle_alarm));
			tabHost.addTab(Spec);
			
			Spec=tabHost.newTabSpec("tab2");
			Spec.setContent(R.id.tabl2);
			Spec.setIndicator("ProgressBar Demo"+getResources().
					getDrawable(android.R.drawable.ic_dialog_alert));
			tabHost.addTab(Spec);
			
			tabHost.setCurrentTab(0);
			//==============================================
			mDataPik = (DatePicker) this.findViewById(R.id.dataPic);
			  mTimePik = (TimePicker) this.findViewById(R.id.timePic);
			  mTextResult = (TextView) this.findViewById(R.id.text_result);
			  mBtnOK = (Button) this.findViewById(R.id.btn_Ok);
			  
			  mBtnOK.setOnClickListener(btnDoOkonClick);
			  //==================================
			  final ProgressBar proBar = (ProgressBar) this.findViewById(R.id.proBar_hor);
				new DoLengthyWork_thread(mhandler,proBar).start();
				
				mRatBar = (RatingBar) this.findViewById(R.id.ratBar);
				mSeekBar = (SeekBar) this.findViewById(R.id.seekBar);
				mTxtSeekBar = (TextView) this.findViewById(R.id.txtSeekBar);
				mTxt1RatBar = (TextView) this.findViewById(R.id.txt1RatBar);
				mTxt2RatBar = (TextView) this.findViewById(R.id.txt2RatBar);
				
				mSeekBar.setOnSeekBarChangeListener(seeBarOnChangeLis);
				mRatBar.setOnRatingBarChangeListener(ratBarOnChangeLis);
		}
		  private Button.OnClickListener btnDoOkonClick = new Button.OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String s = getString(R.string.result);
					mTextResult.setText(s+mDataPik.getYear() + "年"+
					(mDataPik.getMonth()+1)+"月"+
							mDataPik.getDayOfMonth() +"日"+mTimePik.getCurrentHour()+"点"+
					mTimePik.getCurrentMinute()+"分"
							);
				}		  
			  };
			  
				SeekBar.OnSeekBarChangeListener seeBarOnChangeLis = new SeekBar.OnSeekBarChangeListener() {
					
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						String s = getString(R.string.resultSeekBar);
						mTxtSeekBar.setText(s+Integer.toString(progress));
					}
				};
				
				RatingBar.OnRatingBarChangeListener ratBarOnChangeLis = new RatingBar.OnRatingBarChangeListener() {
					
					@Override
					public void onRatingChanged(RatingBar ratingBar, float rating,
							boolean fromUser) {
						// TODO Auto-generated method stub
						String s = getString(R.string.resultRatBar);
						mTxt1RatBar.setText(s+Float.toString(rating));
						
						s = getString(R.string.result2RatBar);
						mTxt2RatBar.setText(s+Integer.toString(mRatBar.getProgress()));
					}
				};
}
