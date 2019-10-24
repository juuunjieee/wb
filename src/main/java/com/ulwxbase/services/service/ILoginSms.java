package com.ulwxbase.services.service;

public interface ILoginSms {

	public int send(String mobile,String content);
	
	public int send(String type,String numbers, String msgContent);
}
