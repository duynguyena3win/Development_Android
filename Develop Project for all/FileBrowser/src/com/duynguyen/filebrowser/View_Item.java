package com.duynguyen.filebrowser;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class View_Item extends LinearLayout {
	
	public ImageView    photo;
    public TextView     name;
    public TextView     sub_files;
    public TextView     datetime;
    
	public View_Item(Context context) {
		super(context);
		
		LayoutInflater linflater = (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	    linflater.inflate(R.layout.row_items, this);
	    
	    photo = (ImageView) findViewById(R.id.fd_Icon1);
	    name = (TextView) findViewById(R.id.TextViewName);
	    sub_files = (TextView) findViewById(R.id.TextView02);
	    datetime = (TextView) findViewById(R.id.TextViewDate);   
	}
	
	public void setListItem(Item it){
        photo.setImageResource(it.getIcon());
        name.setText(it.getName());
        sub_files.setText(it.getData());
        datetime.setText(it.getDate());
    }	
}
