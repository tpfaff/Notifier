package com.example.notifier;

import android.graphics.Bitmap;

public class NotificationItem {
	private String headerText;
	private String subText;
	private Bitmap img;
	
	public NotificationItem(String headerText,String subText, Bitmap img){
		this.headerText=headerText;
		this.subText=subText;
		this.img=img;
	}
	public String getHeaderText() {
		return headerText;
	}
	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}
	public String getSubText() {
		return subText;
	}
	public void setSubText(String subText) {
		this.subText = subText;
	}
	public Bitmap getImg() {
		return img;
	}
	public void setImg(Bitmap img) {
		this.img = img;
	}
}
