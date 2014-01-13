package com.example.notifier;

import android.graphics.Bitmap;

public class NotificationFactory {
	public NotificationItem newNotification(String headerText,String subText, Bitmap img)
	{
		return new NotificationItem(headerText,subText,img);
	}
	
}
