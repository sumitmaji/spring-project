package com.sum.hr.server.hrexception;

public class CustomGenericException extends RuntimeException {
	 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -6850702417750071582L;
	private String errCode;
	private String errMsg;
 
	//getter and setter methods
 
	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
 
}