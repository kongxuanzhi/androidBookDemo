package com.xuan.Dialog;

import com.xuan.studydemo.R;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class AlertDialogActivity extends ActionBarActivity implements OnClickListener {

		private Button mBtnAlertDlg, mBtnALertDlgBld;
		private TextView mTxtResult;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_alert_dialog);
			
			setupViewComponent();
		
		}
		private void 	setupViewComponent(){
			mBtnAlertDlg = (Button) this.findViewById(R.id.btnAlertDlg);
			mBtnALertDlgBld = (Button) this.findViewById(R.id.btnAlertDlgBld);
			mTxtResult = (TextView) this.findViewById(R.id.txtResult);
			
			mBtnAlertDlg.setOnClickListener(this);
			mBtnALertDlgBld.setOnClickListener(this);
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnAlertDlg:
				mTxtResult.setText("");
				alertDialog  myAltDlg = new alertDialog(AlertDialogActivity.this);
				
				myAltDlg.setTitle("AlertDialog");
				myAltDlg.setMessage("AlertDialog的使用时机是要自己建一个class来继承他");
				myAltDlg.setIcon(android.R.drawable.ic_dialog_info);
				myAltDlg.setCancelable(false);
				myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE,
						"是", altDlgOnClkPosiBtnLis);
				myAltDlg.setButton(DialogInterface.BUTTON_NEGATIVE,
						"否", altDlgOnClkNegaBtnLis);
				myAltDlg.setButton(DialogInterface.BUTTON_NEUTRAL,
						"取消", altDlgOnClkNeuBtnLis);
				myAltDlg.show();
				
				break;
			case R.id.btnAlertDlgBld:
				mTxtResult.setText("");
				
				AlertDialog.Builder altDlgBldr = new AlertDialog.Builder(AlertDialogActivity.this);
				altDlgBldr.setTitle("AlertDialog");
				altDlgBldr.setMessage("由AlertDialog.Builder 产生");
				altDlgBldr.setIcon(android.R.drawable.ic_dialog_info);
				altDlgBldr.setCancelable(false);
				altDlgBldr.setPositiveButton("是",altDlgOnClkPosiBtnLis);
				altDlgBldr.setNegativeButton("否", altDlgOnClkNegaBtnLis);
				altDlgBldr.setNeutralButton("取消", altDlgOnClkNeuBtnLis);
				altDlgBldr.show();
				break;
			default:
				break;
			}
		}
		
		private  DialogInterface.OnClickListener altDlgOnClkPosiBtnLis = new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				mTxtResult.setText("你启动了AlertDialog，而且按下了‘是’的按钮");
			}
		};
	    private  DialogInterface.OnClickListener altDlgOnClkNegaBtnLis = new DialogInterface.OnClickListener() {

				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					mTxtResult.setText("你启动了AlertDialog，而且按下了‘否’的按钮");
				}
			};
		private  DialogInterface.OnClickListener altDlgOnClkNeuBtnLis = new DialogInterface.OnClickListener() {

					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						mTxtResult.setText("你启动了AlertDialog，而且按下了‘取消’的按钮");
						
					}
			};
		
	
}
