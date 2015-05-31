package com.example.file_chapter15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	EditText txtData;
	Button btnWriteSDFile;
	Button btnReadSDFile;
	Button btnClearScreen;
	Button btnFinish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		// bind GUI elements with local controls
		txtData = (EditText) findViewById(R.id.txtData);
		txtData.setHint("Enter some lines of data here...");
		btnWriteSDFile = (Button) findViewById(R.id.btnWriteSDFile);
		btnWriteSDFile.setOnClickListener(this);
		btnReadSDFile = (Button) findViewById(R.id.btnReadSDFile);
		btnReadSDFile.setOnClickListener(this);
		btnClearScreen = (Button) findViewById(R.id.btnClearScreen);
		btnClearScreen.setOnClickListener(this);
		btnFinish = (Button) findViewById(R.id.btnFinish);
		btnFinish.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId())
		{
		case R.id.btnClearScreen:
			txtData.setText("");
			break;
		case R.id.btnFinish:
			finish();
			break;
		case R.id.btnReadSDFile:
			try 
			{
				File myFile = new File("mnt/sdcard/my_text.txt");
				FileInputStream fIn = new FileInputStream(myFile);
				BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
				String aDataRow = "";
				String aBuffer = "";
				while ((aDataRow = myReader.readLine()) != null)
				{
					aBuffer += aDataRow + "\n";
				}
				txtData.setText(aBuffer);
				myReader.close();
				Toast.makeText(getBaseContext(), 
				"Done reading SD 'mysdfile.txt'", 1).show();
			}
			catch (Exception e)
			{
				Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
			}
			break;
		case R.id.btnWriteSDFile:
			try {
				File myFile = new File("mnt/sdcard/my_text.txt");
				myFile.createNewFile();
				FileOutputStream fOut = new FileOutputStream(myFile);
				OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				myOutWriter.append(txtData.getText());
				myOutWriter.close();
				fOut.close();
				Toast.makeText(getApplicationContext(),
				"Done writing SD 'mysdfile.txt'", 
				Toast.LENGTH_SHORT).show();
			}
			catch (Exception e) 
			{
				Toast.makeText(getApplicationContext(), 
				e.getMessage(), Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}
