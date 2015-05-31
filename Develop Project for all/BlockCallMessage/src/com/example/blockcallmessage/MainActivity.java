package com.example.blockcallmessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	@Override
	protected void onPause() {
		
		super.onPause();
	}

	@Override
	protected void onResume() {
		
		super.onResume();
	}

	BroadcastReceiver receiver = new SimpleBroadcastReceiver();
	EditText edit_number;
	CheckBox Chb_BlockCall;
	CheckBox Chb_Messsage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Chb_BlockCall = (CheckBox) findViewById(R.id.checkbox_call);
		Chb_Messsage = (CheckBox) findViewById(R.id.checkbox_mess);
		edit_number = (EditText) findViewById(R.id.editText1);
		Chb_BlockCall.setOnCheckedChangeListener(this);
		Chb_Messsage.setOnCheckedChangeListener(this);
		edit_number.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				SimpleBroadcastReceiver.number_block = edit_number.getText().toString().split("\n");
				Toast.makeText(MainActivity.this,edit_number.getText(),Toast.LENGTH_LONG).show();
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch(buttonView.getId())
		{
		case R.id.checkbox_call:
			SimpleBroadcastReceiver.callblock = Chb_BlockCall.isChecked();
			Toast.makeText(this,"Call",Toast.LENGTH_LONG).show();
			break;
		case R.id.checkbox_mess:
			SimpleBroadcastReceiver.messageblock = Chb_BlockCall.isChecked();
			Toast.makeText(this,"Message",Toast.LENGTH_LONG).show();
			break;
		}
	}

}
