/**
 * 
 */
package com.xuan.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * @author 孔轩志
 *
 */
public class ImageAdapter extends BaseAdapter {
	private Context context;
	private Integer[] imgArr;

	public ImageAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	public void setImageArray(Integer[] imgArr){
		this.imgArr = imgArr;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgArr.length;
	}


	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return imgArr[position];
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
		if(convertView==null){
			 v = new ImageView(context);
				v.setImageResource(imgArr[position]);
				v.setAdjustViewBounds(true);
				//设置宽度和高度
				v.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
		}else{
			v= (ImageView)convertView;
		}
		return v;
	}

}
