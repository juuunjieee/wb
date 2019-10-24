package com.ulwxbase.services.service;

import com.ulwx.database.MDataBase;
import com.ulwx.database.MDbManager;
import com.ulwxbase.domain.db.sys.SysSms;
import com.ulwxbase.services.dao.SmsDao;
import com.ulwxbase.utils.CbAppConfig;
import com.ulwxbase.utils.CbDao;
import com.ulwxbase.utils.CbThreadPoolUtils;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

/**
 * 短信发送接口
 */
public class SmsService {
	public static SmsService instance = new SmsService();

	private static Logger logger = Logger.getLogger(SmsService.class);

	
	public static void main(String[] args) {
		SmsService s = new SmsService();
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
		s.sendCaptcha("1", "18565574709", "警察叔叔来抓你拉.", "110");
	}

	/**
	 * 发送验证码
	 * 
	 * @param mobile
	 *            手机号
	 * @param content
	 *            内容
	 */
	public void sendCaptcha(String type ,String numbers, String msgContent, String smsCode) {
		CbThreadPoolUtils.pool.execute(new Runnable() {
            @Override
            public void run() {
            	try {
            		smsSend(type,numbers,msgContent, smsCode);
            	}catch (Exception e) {
					// TODO: handle exception
            		logger.error(e,e);
				}
            	
            }
        });
	}

	private int addCaptcha(String mobile, String captcha, String smsCode, String response, String responseId)
			throws Exception {
		MDataBase manager = null;
		int result = 1;
		try {
			manager = MDbManager.getDataBase(CbDao.sys);
			manager.setAutoCommit(false);
			SysSms sSms = new SysSms();
			sSms.setContent(captcha);
			sSms.setMobile(mobile);
			sSms.setSmsType(42);
			sSms.setSmsCode(smsCode);
			sSms.setCreateTime(LocalDateTime.now());
			sSms.setResponse(response);
			sSms.setResponseId(responseId);
			// MDbUtils.insert(Dao.jyd2,sSms);
			manager.insert(sSms);
			manager.commit();
		} catch (Exception e) {
			result = -1;
			if (manager != null)
				manager.rollback();
			logger.error(e, e);
			throw new Exception("******** ERROR SmsServiceImpl.addCaptcha " + e.getMessage());
		} finally {
			if (manager != null)
				manager.close();
		}
		return result;
	}

	/**
	 * 调用玄武,发送短信
	 * 
	 * @param mobile
	 *            手机号
	 * @param content
	 *            内容
	 */
	private void smsSend(String type,String numbers, String msgContent, String smsCode) {
		try {
			String smsClass=CbAppConfig.getLoginSmsClass();
			ILoginSms loginSms=(ILoginSms)Class.forName(smsClass).newInstance();
			
			Integer i =loginSms.send(type, numbers, msgContent);
			if(i != null) {
				String str = i.toString();
				addCaptcha(numbers, msgContent, smsCode, str, str);
			}	
		} catch (Exception e) {
			logger.error(e,e);
		}
	}

	/**
	 * 短信五分钟内记录
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public SysSms getSmsInfo(String mobile) throws Exception {
		try {
			return SmsDao.getSmsInfo(mobile);
		} catch (Exception e) {
			logger.error("", e);
			throw new Exception("*********ERROR********SmsService的获取短信信息异常*******" + e.getMessage());
		}

	}

	/**
	 * 短信最近验证码记录
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public SysSms getSmsInfoRecent(String mobile) throws Exception {
		try {
			return SmsDao.getSmsInfoRecent(mobile);
		} catch (Exception e) {
			logger.error("", e);
			throw new Exception("*********ERROR********SmsService的获取短信最近信息异常*******" + e.getMessage());
		}

	}
}
