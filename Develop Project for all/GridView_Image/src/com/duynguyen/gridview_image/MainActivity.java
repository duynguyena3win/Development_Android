package com.duynguyen.gridview_image;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtMsg;
	
	Integer[] thumbNail = {R.drawable.hinh1, R.drawable.hinh2, R.drawable.hinh3, 
			R.drawable.hinh4, R.drawable.hinh5, R.drawable.hinh6};
	
	Integer[] largeImages = {R.drawable.hinh1, R.drawable.hinh2, R.drawable.hinh3, 
			R.drawable.hinh4, R.drawable.hinh5, R.drawable.hinh6};
	
	ImageView selectedImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		txtMsg = (TextView) findViewById(R.id.textView1);
		selectedImage = (ImageView) findViewById(R.id.imageView1);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		
		gallery.setAdapter(new ImageAdapter(this, thumbNail));
		
		gallery.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				BitmapDrawable bitmapDrawable = 
						(BitmapDrawable) getResources().getDrawable(largeImages[position]);
				Bitmap bm = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(),
						(int) (bitmapDrawable.getIntrinsicHeight() * 1.0), 
						(int) (bitmapDrawable.getIntrinsicWidth() * 1.0),false);
				selectedImage.setImageBitmap(bm);
				selectedImage.setScaleType(ScaleType.FIT_XY);
			}
		});
		
		gallery.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					break;
					
				case MotionEvent.ACTION_MOVE:
					break;
					
				case MotionEvent.ACTION_UP:
					break;
				}
				txtMsg.append("\n Touched... " + event.getAction());
				return false;
			}
			
		});
	}

	
}
