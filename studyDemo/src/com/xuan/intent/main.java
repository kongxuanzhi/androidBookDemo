package com.xuan.intent;

import java.io.File;

import com.xuan.studydemo.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class main extends ActionBarActivity 
									implements OnClickListener{

	 private Button  mBtnBrowserWWW,
	 								 mBtnPlayMP3,
	 								 mBtnViewImg,
	 								 mBtnMakeCall;
	 
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		setupViewComponent();
	}
	 private void setupViewComponent(){
		     mBtnBrowserWWW =(Button) this.findViewById(R.id.btnBrowserWWW);
			 mBtnPlayMP3 = (Button) this.findViewById(R.id.btnPlayMp3);
			 mBtnViewImg = (Button) this.findViewById(R.id.btnViewImg);
			 mBtnMakeCall = (Button) this.findViewById(R.id.btnMakeCall);
			 
			 mBtnBrowserWWW.setOnClickListener(this);
			 mBtnPlayMP3.setOnClickListener(this);
			 mBtnViewImg.setOnClickListener(this);
			 mBtnMakeCall.setOnClickListener(this);
	 }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.btnBrowserWWW:
				Uri uri = Uri.parse("https://www.baidu.com/?tn=10018801_hao");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
				break;
	        case R.id.btnPlayMp3:
				Intent it = new Intent(Intent.ACTION_VIEW);
				File file = new File("/sdcard/����.mp3");
				it.setDataAndType(Uri.fromFile(file),"audio/*");
			    startActivity(it);
				break;
	        case R.id.btnViewImg:
				Intent it2 = new Intent(Intent.ACTION_VIEW);
				File file2 = new File("/sdcard/img.jpeg");
				it2.setDataAndType(Uri.fromFile(file2), "image/*");
				startActivity(it2);
				break;
	        case R.id.btnMakeCall:
				Uri uri2 = Uri.parse("tel:15779715751");
				Intent it3 = new Intent(Intent.ACTION_DIAL,uri2);
				startActivity(it3);
				break;
			default:
				break;
		}
	}
}
