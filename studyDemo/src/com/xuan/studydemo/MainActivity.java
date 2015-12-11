package com.xuan.studydemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.xuan.adapters.ImageAdapter;

@SuppressLint("NewApi") 
public class MainActivity extends ActionBarActivity 
										implements ViewSwitcher.ViewFactory{

	
	private Gallery gallery;
	private ImageSwitcher imgSwi;
	
	private Integer[] imgArr={
			R.drawable.img,R.drawable.img2,R.drawable.img3
	};
	private Integer[] thumbImgArr	= {
			R.drawable.img,R.drawable.img2,R.drawable.img3
	};	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewComponent();
    }
   
   public void  setViewComponent(){
	   imgSwi = (ImageSwitcher) this.findViewById(R.id.imgSwi);
	   imgSwi.setFactory(this);
	   //imgSwi.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
	   //imgSwi.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_out));
	   
	   ImageAdapter imgAdap = new ImageAdapter(this);
	   imgAdap.setImageArray(thumbImgArr);
	   
	   gallery = (Gallery) findViewById(R.id.gal);
	   gallery.setAdapter(imgAdap);
	   gallery.setOnItemSelectedListener(adaViewitemSelLis);
   }
    
   @Override
	public View makeView() {
		// TODO Auto-generated method stub
	   ImageView v = new ImageView(this);
	   //v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
			   LayoutParams.FILL_PARENT,
			   LayoutParams.FILL_PARENT
			   ));
		return v;
	}
   
   private AdapterView.OnItemSelectedListener adaViewitemSelLis = 
		   new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch ((int)(Math.random()*3+1)) {
				case 1:
					imgSwi.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha_in));
					imgSwi.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha_out));
					break;
				case 2:
					imgSwi.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_rotate_in));
					imgSwi.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_rotate_out));
					break;
				case 3:
					imgSwi.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_trans_in));
					imgSwi.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_trans_out));
					break;
				default:
					break;
				}
				imgSwi.setImageResource(imgArr[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		};
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
