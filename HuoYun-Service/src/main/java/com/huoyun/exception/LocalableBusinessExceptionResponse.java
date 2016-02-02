package com.huoyun.exception;

public class LocalableBusinessExceptionResponse extends BusinessExceptionResponse {

	private String path;
	
	public LocalableBusinessExceptionResponse(LocalableBusinessException ex) {
		super(ex);
		this.path = ex.getPath();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
