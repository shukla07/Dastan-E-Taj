package com.Taj.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.Taj.client.GreetingService;
import com.Taj.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	Connection con=null;
	Statement st=null;
	int count;
	Statement ssst=null;
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taj","Tanuj","Tanuj@1996");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st=con.createStatement();
			ssst=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String check(String uid, String pwd) throws IllegalArgumentException {
		// TODO Auto-generated method stub
	
		init();
		ResultSet rs=null;
		String s=null;
		try {
			rs=st.executeQuery("select * from Login where u_id = '"+uid+"' and Pass = '"+pwd+"'");
			if(rs.next())
			{
				s= "true";
				
			}
			else
			{
				s= "false";
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String put(String lon, String ltt,String nm,String des, String rd,String key,String lin) throws IllegalArgumentException {
		// TODO Auto-generated method stub
	
		init();
		int rad=Integer.parseInt(rd);
		float lo=Float.parseFloat(lon);
		float lt=Float.parseFloat(ltt);
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("INSERT INTO description(Longi,Latt,name,Descr,Rad,key_,Link) VALUES (?,?,?,?,?,?,?)");
			preparedStmt.setFloat(1, lo);
			preparedStmt.setFloat(2, lt);
			preparedStmt.setString(3, nm);
		    preparedStmt.setString(4, des);
		    preparedStmt.setInt(5, rad);
		    preparedStmt.setString(6, key);
		    preparedStmt.setString(7, lin);
		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	    
	}

	@Override
	public String put(String pwd, String uid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int i = 0;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement("UPDATE Login SET Pass = ? WHERE U_id = ?");
			preparedStmt.setString(1,pwd);
			preparedStmt.setString(2, uid);
		    i=preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ii = Integer.toString(i);
		return ii;
	}

	@Override
	public String chec(String uid, String Ph) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs=null;
		String s=null;
		try {
			rs=st.executeQuery("SELECT * FROM Login where u_id= '"+uid+"' and M_no= '"+Ph+"'");
			if(rs.next())
			{
				s= "true";
				
			}
			else
			{
				s= "false";
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String chec(String OTP) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int coun() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet r = null;
		try {
			r=ssst.executeQuery("SELECT longi , Latt FROM description");
			r.last();
			count = r.getRow();
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public String get(String key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs=null;
		int size=0;
		String s = null;
		try {
			rs=st.executeQuery("SELECT * FROM description where key_='"+key+"'");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while(rs.next())
			{
				s=rs.getString(3)+"@"+rs.getString(4)+"@"+rs.getString(6);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String getpf(String uid) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		ResultSet rs=null;
		String s="";
		try {
			rs=st.executeQuery("SELECT * FROM login where U_id = '"+uid+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{
			s=rs.getString(1);
			s=s+"@"+rs.getString(2);
			s=s+"@"+rs.getString(3);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
