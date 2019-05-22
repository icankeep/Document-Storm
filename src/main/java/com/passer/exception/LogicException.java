package com.passer.exception;  
/** 
 * @ClassName: LogicException<p>

 * @description: <p>

 * @author: passer<p>

 * @Date: 2019年3月24日 下午12:37:22<p>
 */
public class LogicException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	* @param message	异常信息
	* @param cause		异常根本原因
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	* @param message	异常信息
	 */
	public LogicException(String message) {
		super(message);
	}

	
}
