package com.Taj.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class MySpace {

	static MySpace me=null;
	Login l=null;
	DTET dt=null;
	profile pr=null;
	private MySpace() {
		
	}
	
	static MySpace getInstance() {
		if(me==null)
			me=new MySpace();
		return me;
	}
	
	public void func() {
		if(History.getToken().equals("Login"))
		{if(l.ky==1)
		{
			RootPanel.get("d1").clear();
			RootPanel.get("d").clear();
			RootPanel.get("d").add(getDTET().header);
			RootPanel.get("d1").add(getDTET().con);
		}
		else {
			History.forward();
		}
		}
		else if (History.getToken().equals("Home")) 
		{
			if(l.ky==1) {
			RootPanel.get("d").clear();
			RootPanel.get("d").add(getDTET().header);
			RootPanel.get("d1").clear();
			RootPanel.get("d1").add(getDTET().con);
			}
			else {
				History.forward();
			}
		}
		else if (History.getToken().equals("Profile")) 
		{
			if(l.ky==1) {
			RootPanel.get("d1").clear();
			RootPanel.get("d").clear();
			RootPanel.get("d").add(getprofile().header);
			RootPanel.get("d1").add(getprofile().con);
			}
			else {
				History.forward();
			}
		}
		else if (History.getToken().equals("Logout")) 
		{
			if(l.ky==0)
			{
			l=null;
			pr=null;
			dt=null;
			System.gc();
			RootPanel.get("d1").clear();
			RootPanel.get("d").clear();
			RootPanel.get("d").add(getlogin().header);
			RootPanel.get("d1").add(getlogin().con);
			}
			else
			{
				History.forward();
			}
		}
	}
	Login getlogin() {
		if(l==null) {
			l=new Login();
		}
		return l;
	}
	profile getprofile() {
		if(pr==null) {
			pr=new profile();
		}
		return pr;
	}
	DTET getDTET() {
		if(dt==null) {
			dt=new DTET();
		}
		return dt;
	}
}
