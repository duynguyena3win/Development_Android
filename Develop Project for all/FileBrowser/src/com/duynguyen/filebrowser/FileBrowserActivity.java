package com.duynguyen.filebrowser;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;








import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ListView;

public class FileBrowserActivity extends ListActivity {
	
	private FileAdapter adapter;
	private File currentDir;
	String dirfile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dirfile = "/";
		currentDir = new File(dirfile);
        fill(currentDir); 
        
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_browser, menu);
		return true;
	}
	
	private void fill(File f)
    {
    	File[]dirs = f.listFiles(); 
		this.setTitle("Current Dir: "+f.getName());
		List<Item>dir = new ArrayList<Item>();
		List<Item>fls = new ArrayList<Item>();
		try{
			for(File ff: dirs)
			{ 
				Date lastModDate = new Date(ff.lastModified()); 
				DateFormat formater = DateFormat.getDateTimeInstance();
				String date_modify = formater.format(lastModDate);
				if(ff.isDirectory())
				{
					File[] fbuf = ff.listFiles(); 
					int buf = 0;
					if(fbuf != null) 
						buf = fbuf.length;
					else
						buf = 0; 
					String num_item = String.valueOf(buf);
					if(buf == 0) num_item = num_item + " item";
					else num_item = num_item + " items";
					
					//String formated = lastModDate.toString();
					dir.add(new Item(ff.getName(),num_item,date_modify,ff.getAbsolutePath(),R.drawable.directory)); 
				}
				else
				{
					String ext=ff.getName().substring(ff.getName().indexOf(".")+1);
			        			        
					fls.add(new Item(ff.getName(),ff.length() + " Byte", date_modify, ff.getAbsolutePath(),Get_Icon(ext)));
				}
			 }
		 }catch(Exception e)
		 {    
			 
		 }
		 Collections.sort(dir);
		 Collections.sort(fls);
		 dir.addAll(fls);
		 if(!dirfile.equalsIgnoreCase("/") == true)
		 {
			dir.add(0,new Item("..","Parent Directory","",f.getParent(),R.drawable.back));
		 }
		 adapter = new FileAdapter(FileBrowserActivity.this,R.layout.row_items,dir);
		 this.setListAdapter(adapter);
		 
    }
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Item o = adapter.getItem(position);
		if(o.getIcon() == R.drawable.directory ||o.getIcon() == R.drawable.back){
			dirfile = o.getPath();
				currentDir = new File(dirfile);
				fill(currentDir);
		}
		else
		{
			onFileClick(o);
		}
	}
	
    private void onFileClick(Item o)
    {
    	try {
    	   	Intent intent = new Intent();
	        intent.setAction(android.content.Intent.ACTION_VIEW);
	        File file = new File(o.getPath());
	       
	        MimeTypeMap mime = MimeTypeMap.getSingleton();
	        String exten=file.getName().substring(file.getName().indexOf(".")+1);
	        String type = mime.getMimeTypeFromExtension(exten);
	      
	        intent.setDataAndType(Uri.fromFile(file),type);
	       
	        startActivity(intent);
    	}
    	catch(Exception e)
    	{
    		AlertDialog alertbox = new AlertDialog.Builder(this).create();
    		alertbox.setTitle("Trợ giúp");
    		alertbox.setMessage("Hệ thống không hổ trợ cho file!");
    		alertbox.setButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					return;
				}
			});
    		alertbox.show(); 	
    	}
    }
    
    int Get_Icon(String n_icon)
    {
    	
    	if(n_icon.equalsIgnoreCase("flac") || n_icon.equalsIgnoreCase("mp3") ||  n_icon.equalsIgnoreCase("aac")||
    			n_icon.equalsIgnoreCase("ogg") || n_icon.equalsIgnoreCase("wav") || n_icon.equalsIgnoreCase("mid"))
    		return R.drawable.music;
    	else
    	if(n_icon.equalsIgnoreCase("jpg") || n_icon.equalsIgnoreCase("gif") ||  n_icon.equalsIgnoreCase("png")||
    			n_icon.equalsIgnoreCase("bmp") || n_icon.equalsIgnoreCase("webp"))
    		return R.drawable.picture;
    	else
    	if(n_icon.equalsIgnoreCase("3gp") || n_icon.equalsIgnoreCase("mp4") ||  n_icon.equalsIgnoreCase("mkv")||
    			n_icon.equalsIgnoreCase("ts") || n_icon.equalsIgnoreCase("webm"))
    		return R.drawable.video;
    	else
    	if(n_icon.equalsIgnoreCase("directory"))
    		return R.drawable.directory;
    	else
    	if(n_icon.equalsIgnoreCase("rar"))
    		return R.drawable.rar;
    	else
    	if(n_icon.equalsIgnoreCase("exe"))
    		return R.drawable.exe;
    	else
    	if(n_icon.equalsIgnoreCase("pdf"))
    		return R.drawable.pdf;
    	else
    	if(n_icon.equalsIgnoreCase("xml"))
    		return R.drawable.xml;
    	else
        	if(n_icon.equalsIgnoreCase("txt"))
        		return R.drawable.txt;
    	else
    	if(n_icon.equalsIgnoreCase("rc"))
    		return R.drawable.system;
    	else
    	return R.drawable.unknow;
    }
}