package com.Taj.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.Taj.client.GreetingServiceAsync;

public class GetDesc extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws  IOException, ServletException {
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws  IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out =  res.getWriter();
		String rq=req.getParameter("t1");
		String s1="not Fetched";
		GreetingServiceImpl a1=new GreetingServiceImpl();
		/*String[] s1= new String[a1.coun()];*/
		s1=a1.get(rq);
		out.print(s1);
	}
}
