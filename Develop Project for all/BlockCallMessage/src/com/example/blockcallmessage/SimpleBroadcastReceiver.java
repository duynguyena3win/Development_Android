package com.example.blockcallmessage;

import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class SimpleBroadcastReceiver extends BroadcastReceiver {
	
	private static final String TAG = "Phone call";
	public static String[] number_block;
	
	public static boolean callblock;
	public static boolean messageblock;
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.d(TAG, "Receving....");
		if(intent.getAction() == "android.intent.action.PHONE_STATE" && SimpleBroadcastReceiver.callblock == true)
		{
			String incommingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
			Log.d(TAG, "Receving....");
			TelephonyManager telephony = (TelephonyManager) context
			.getSystemService(Context.TELEPHONY_SERVICE);
			try
			{
				Class c = Class.forName(telephony.getClass().getName());
				Method m = c.getDeclaredMethod("getITelephony");
				m.setAccessible(true);
				//telephonyService = (ITelephony) m.invoke(telephony);
				for (int i = 0; i < number_block.length; i++)
				{
					if (number_block[i].compareTo(incommingNumber) == 0)
					{
					//telephonyService.silenceRinger();
						Object telephonyService = m.invoke(telephony); // Get the internal ITelephony object
						c = Class.forName(telephonyService.getClass().getName()); // Get its class
						m = c.getDeclaredMethod("endCall"); // Get the "endCall()" method
						m.setAccessible(true); // Make it accessible
						m.invoke(telephonyService);
						break;
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			if(intent.getAction() == "android.provider.Telephony.SMS_RECEIVED" && SimpleBroadcastReceiver.messageblock == false)
			{
				Bundle bundle = intent.getExtras();
				if (bundle != null)
				{
				/* Retrieve the SMS. */
					Object[] pdus = (Object[]) bundle.get("pdus");
					SmsMessage msg = SmsMessage.createFromPdu((byte[]) pdus[0]);
					String phoneNumber = msg.getOriginatingAddress();
					for (int i = 0; i < number_block.length; i++)
					{
						if (phoneNumber.compareTo(number_block[i]) == 0)
							abortBroadcast();		
					}
				}
			}
	}	
}
