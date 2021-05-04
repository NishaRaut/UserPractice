package com.bridgelabz.user.model;

public class Response {
private String ResponseStatus;
private int ResponseCode;

public Response(String responseStatus, int responseCode) {
	super();
	ResponseStatus = responseStatus;
	ResponseCode = responseCode;
}



public Response() {
	super();
}



public String getResponseStatus() {
	return ResponseStatus;
}
public void setResponseStatus(String responseStatus) {
	ResponseStatus = responseStatus;
}
public int getResponseCode() {
	return ResponseCode;
}
public void setResponseCode(int responseCode) {
	ResponseCode = responseCode;
}
}
