package com.duynguyen.filebrowser;

import java.util.List;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class FileAdapter extends ArrayAdapter<Item>{
	Context mContext;
	int id;
	List<Item> items;
	
	public FileAdapter(Context context, int textViewResourceId,
			List<Item> objects) {
		super(context, textViewResourceId, objects);
		mContext = context;
		id = textViewResourceId;
		items = objects;
	}
	
	public Item getItem(int i)
	{
		return items.get(i);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View_Item view = new View_Item(mContext);
        view.setListItem(items.get(position));
        return view;
	}


}
