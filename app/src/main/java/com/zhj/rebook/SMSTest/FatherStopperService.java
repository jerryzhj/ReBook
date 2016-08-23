package com.zhj.rebook.SMSTest;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.zhj.rebook.R;

/**
 * 
 * @author 张航舰
 *
 * @for(对我爸自动回短信)
 */
 
public class FatherStopperService extends Service{
	private IntentFilter receiveFilter;
	private MessageReceiver messageReceiver;
	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("aa", "startService");
		Toast.makeText(getApplicationContext(), "短信拦截已开启", Toast.LENGTH_LONG).show();
		Notification notification = new Notification(R.drawable.btn2,
				"Notification comes", System. currentTimeMillis());
				Intent notificationIntent = new Intent(this, MainActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				notificationIntent, 0);
		notification.setLatestEventInfo(this, "对父拦截已开启", "点击进入关闭", pendingIntent);
		startForeground(1, notification);
		Log.d("MyService", "onCreate executed");
		receiveFilter = new IntentFilter();
		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		receiveFilter.setPriority(100);
		messageReceiver = new MessageReceiver();
		registerReceiver(messageReceiver, receiveFilter);
	}

	class MessageReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			Object[] pdus = (Object[]) bundle.get("pdus"); //  提取短信消息
			SmsMessage[] messages = new SmsMessage[pdus.length];
		for (int i = 0; i < messages.length; i++) {
			messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
		}
		String address = messages[0].getOriginatingAddress(); //  获取发送方号码
		String fullMessage = "";
		for (SmsMessage message : messages) {
			fullMessage += message.getMessageBody(); //  获 取短信内容
		}
		String number2= "15655192111";
		String number = "18055524621";
		//发送短信的功能
		if(address.equals(number2)){
			String message="";
			if(fullMessage.contains("今天感觉")){
				message="今天很好，生活很规律";
			}else if(fullMessage.contains("今天锻炼")){
				message="恩，今天锻炼了";
			}else if(fullMessage.contains("今天还好")){
				message="今天非常好，睡得不错";
			}
			@SuppressWarnings("deprecation")
			SmsManager manager = SmsManager.getDefault();
			
			manager.sendTextMessage(number2, null,message, null, null);
			//abortBroadcast();
			}
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("MyService", "onStartCommand executed");
		return super.onStartCommand(intent, flags, startId);
		
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(messageReceiver);
		Log.d("MyService", "onDestroy executed");
		
	}
}
