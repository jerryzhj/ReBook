package com.zhj.rebook.SMSTest;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FinalActivity {
	@ViewInject(id=R.id.sender)
	private TextView sender;
	@ViewInject(id=R.id.content)
	private TextView content;
	
	private IntentFilter receiveFilter;
	private MessageReceiver messageReceiver;

	@ViewInject(id=R.id.button1,click="startService")
	Button button_stopService;
	@ViewInject(id=R.id.button2,click="stopService")
	Button button_startService;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		receiveFilter = new IntentFilter();
//		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
//		receiveFilter.setPriority(100);
//		messageReceiver = new MessageReceiver();
//		registerReceiver(messageReceiver, receiveFilter);
	}
	//开启对父短信拦截器
	public void startService(View v){

		Intent startIntent = new Intent(this, FatherStopperService.class);
		startService(startIntent); // 启动服务
	}
	//关闭对父短信拦截器
	public void stopService(View v){
		Intent stopIntnet = new Intent(this, FatherStopperService.class);
		stopService(stopIntnet); // 关闭
	}
	
	protected void onDestroy() {
		super.onDestroy();
//		unregisterReceiver(messageReceiver);
	}
	
	//------------------------------内部类----------------
//	class MessageReceiver extends BroadcastReceiver {
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			Bundle bundle = intent.getExtras();
//			Object[] pdus = (Object[]) bundle.get("pdus"); //  提取短信消息
//			SmsMessage[] messages = new SmsMessage[pdus.length];
//		for (int i = 0; i < messages.length; i++) {
//			messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
//		}
//		String address = messages[0].getOriginatingAddress(); //  获取发送方号码
//		String fullMessage = "";
//		for (SmsMessage message : messages) {
//			fullMessage += message.getMessageBody(); //  获 取短信内容
//		}
//		sender.setText(address);
//		content.setText(fullMessage);
//		//发送短信的功能
//		@SuppressWarnings("deprecation")
//		SmsManager manager = SmsManager.getDefault();
//		String nummber = "15655192111";
//		String nummber2 = "18055524621";
//		manager.sendTextMessage(nummber2, null, "今天很好，生活很规律", null, null);
//		abortBroadcast();
//		}
//		
//	}
}
