package com.Nguyen1112199.list;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewDemo extends ListActivity {
	TextView Tsg;
	
	String[] items = {  "Data-0", "Data-1", "Data-2", "Data-3", 
			"Data-4", "Data-5", "Data-6", "Data-7"  };
	
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, 
				android.R.id.text1,items));
		
	}
}
