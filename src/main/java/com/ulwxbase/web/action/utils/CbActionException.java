package com.ulwxbase.web.action.utils;
/**
 *   自定义异常
 * @author Administrator
 *
 */
public class CbActionException extends Exception {
	
   
	/**
	 *  异常错误码 
	 */
    protected int exceptionCode;
    public static final int COMMON_ERR_CODE=9999;

	public CbActionException(int exceptionCode,String message, Throwable cause) {
		super(message, cause);
		this.exceptionCode=exceptionCode;
	}

	public CbActionException(int exceptionCode,String message) {
		super(message);
		this.exceptionCode=exceptionCode;
	}
	public CbActionException(String message) {
		super(message);
		this.exceptionCode=COMMON_ERR_CODE;
	}
	public int getExcnCode(){
		return this.exceptionCode;
	}
	
	



	
	
}
