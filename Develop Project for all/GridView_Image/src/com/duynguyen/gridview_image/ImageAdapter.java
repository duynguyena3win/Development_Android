package com.duynguyen.gridview_image;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	private Context mContext;
	private Integer[] thumbNail;
	
	public ImageAdapter(Context c, Integer[] thumb)
	{
		mContext = c;
		thumbNail = thumb;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return thumbNail.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView iv = new ImageView(mContext);
		iv.setImageResource(thumbNail[position]);
		iv.setLayoutParams(new Gallery.LayoutParams(150,100));
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		return null;
	}
}
