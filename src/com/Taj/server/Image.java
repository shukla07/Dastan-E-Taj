package com.Taj.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Image extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<HTML>");
		out.print("<HEAD><TITLE>Upload Image</TITLE></HEAD>");
		out.print("<BODY>");
		out.print("<img src='user.png' alt='image' />");
		out.print("</BODY>");
		out.print("</HTML>");
		out.close();
	}
}
