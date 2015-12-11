package com.xuan.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterGridView extends BaseAdapter {

	private Context context;
	private Integer[] IntArr;
	
	public ImageAdapterGridView(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public void setImages(Integer[] IntArr){
		this.IntArr = IntArr;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return IntArr.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return IntArr[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView v;
		if(convertView == null){
			v = new ImageView(context);
			v.setLayoutParams(new GridView.LayoutParams(90,90));
			v.setScaleType(ImageView.ScaleType.CENTER_CROP);
			v.setPadding(6, 5, 5, 5);
		}else{
			v = (ImageView)convertView;
		}
		v.setImageResource(IntArr[position]);
		return v;
	}
}
