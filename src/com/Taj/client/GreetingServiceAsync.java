package com.Taj.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void check(String uid, String pwd, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void chec(String otp, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void put(String pwd, String uid, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void chec(String uid, String Ph, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void put(String lon, String ltt,String nm,String des, String rd,String key,String lin, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void get(String key,AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void getpf(String uid, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void coun(AsyncCallback<Integer> callback) throws IllegalArgumentException;
	
}
