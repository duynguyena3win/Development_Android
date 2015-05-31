package com.example.life_cycle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	String Text;
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Text += "Application Destroy";
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Text +="Application Pause!";
		txt_Msg.setText(Text);
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Text +="Application Resume!";
		txt_Msg.setText(Text);
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Text +="Application Start!";
		txt_Msg.setText(Text);
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Text +="Application Stop!";
		txt_Msg.setText(Text);
	}


	TextView txt_Msg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		txt_Msg = (TextView) findViewById(R.id.textView1);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
