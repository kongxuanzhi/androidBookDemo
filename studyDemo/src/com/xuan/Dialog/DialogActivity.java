package com.xuan.Dialog;

import java.util.Calendar;

import com.xuan.studydemo.R;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

@SuppressLint("NewApi")
public class DialogActivity extends ActionBarActivity {
	private Button mBtnTimePicDlg,mBtnDatePicDlg;
	private TextView mTxtResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		
		setupViewComponet();
	}
	private void setupViewComponet(){
		mBtnTimePicDlg = (Button) this.findViewById(R.id.btnTimePicDlg);
		mBtnDatePicDlg = (Button) this.findViewById(R.id.btnDatePicDlg);
		mTxtResult = (TextView) this.findViewById(R.id.txtResult);
		
		mBtnTimePicDlg.setOnClickListener(btnTimePicDlgOnClkLis);
		mBtnDatePicDlg.setOnClickListener(btnDatePicDlgOnClkLis);
	}
	private Button.OnClickListener btnDatePicDlgOnClkLis = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mTxtResult.setText("");
			
			Calendar now = Calendar.getInstance();
			DatePickerDialog dataPicDlg = new DatePickerDialog(
					DialogActivity.this,
					datePicDlgOnDateSelLis,
					now.get(Calendar.YEAR),
					now.get(Calendar.MONTH),
					now.get(Calendar.DAY_OF_MONTH));
			
			dataPicDlg.setTitle("选择日期");
			dataPicDlg.setMessage("请选择适合您的日期");
			dataPicDlg.setIcon(android.R.drawable.ic_dialog_info);
			dataPicDlg.setCancelable(false);
			dataPicDlg.show();
		}
	};
	
	private DatePickerDialog.OnDateSetListener datePicDlgOnDateSelLis = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			mTxtResult.setText("您设定的日期是"+
			Integer.toString(year)+"年"+
			Integer.toString(monthOfYear+1)+"月"+
			Integer.toString(dayOfMonth)+"日"
					);
			
		}
	};	
	private Button.OnClickListener btnTimePicDlgOnClkLis = new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
            mTxtResult.setText("");
			
			Calendar now = Calendar.getInstance();
			TimePickerDialog timePicDlg = new TimePickerDialog(
					DialogActivity.this,
					timePicDlgOnTimeSelLis,
					now.get(Calendar.HOUR_OF_DAY),
					now.get(Calendar.MINUTE),
					true);
			timePicDlg.setTitle("选择时间");
			timePicDlg.setMessage("请选择适合您的时间");
			timePicDlg.setIcon(android.R.drawable.ic_dialog_info);
			timePicDlg.setCancelable(false);
			timePicDlg.show();
		}
	};
	
	private TimePickerDialog.OnTimeSetListener timePicDlgOnTimeSelLis = new 
			TimePickerDialog.OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					mTxtResult.setText("您设定的时间是"+
					Integer.toString(hourOfDay)+"点"+
					Integer.toString(minute)+"分"
				  );
				}
				
			};
}
