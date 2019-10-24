package com.yscf.admin.utils;

import com.jydsoft.sms.utils.SmsUtil;
import com.ulwxbase.services.service.ILoginSms;

public class LogSmsImpl implements ILoginSms {

	public LogSmsImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int send(String mobile, String content) {
		// TODO Auto-generated method stub
		Integer i = SmsUtil.sendMsg(Dao.yscfmdb,1+"", mobile, content);
		return i;
	}

	@Override
	public int send(String type, String numbers, String msgContent) {
		// TODO Auto-generated method stub
		Integer i = SmsUtil.sendMsg(Dao.yscfmdb,type, numbers, msgContent);
		return i;
	}

}
