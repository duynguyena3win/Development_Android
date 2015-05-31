package com.duynguyen.filebrowser;



public class Item implements Comparable<Item>{
	private String Name;
	private String Data;
	private String Date;
	private String Path;
	private int Icon;
	
	public Item(String name, String data, String date,
			String path, int icon) {
		Name = name;
		Data = data;
		Date = date;
		Path = path;
		Icon = icon;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public String getData() {
		return Data;
	}

	public String getPath() {
		return Path;
	}

	public String getDate() {
		return Date;
	}

	public int getIcon() {
		return Icon;
	}
	
	public int compareTo(Item o) {
		if(this.Name != null)
			return this.Name.toLowerCase().compareTo(o.getName().toLowerCase()); 
		else 
			throw new IllegalArgumentException();
	}
	
}
