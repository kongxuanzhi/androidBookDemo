package com.xuan.studydemo;

import com.xuan.threads.DoLengthyWork_thread;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ProgressActivity extends ActionBarActivity {

	private Handler mhandler = new Handler();
	
	private RatingBar mRatBar;
	private SeekBar mSeekBar;
	private TextView mTxtSeekBar, mTxt1RatBar,mTxt2RatBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progressbar);
		
		setViewComponent();
	}
	private void 	setViewComponent(){
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
