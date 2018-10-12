package com.Taj.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String check(String uid, String pwd) throws IllegalArgumentException;
	
	String put(String pwd, String uid) throws IllegalArgumentException;

	String chec(String uid, String Ph) throws IllegalArgumentException;
	
	String chec(String otp) throws IllegalArgumentException;
	
	String put(String lon, String ltt,String nm,String des, String rd,String key,String lin) throws IllegalArgumentException;
	
	String get(String key) throws IllegalArgumentException;
	
	String getpf(String uid) throws IllegalArgumentException;
	
	int coun() throws IllegalArgumentException;
	
}
