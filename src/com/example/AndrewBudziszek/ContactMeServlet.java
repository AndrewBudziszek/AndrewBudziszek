package com.example.AndrewBudziszek;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ContactMeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String senderName = req.getParameter("fullName");
		String senderEmail = req.getParameter("email");
		String msgBody = "";
		
		try 
		{
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("abudziszek.dev@gmail.com", "ADMIN - AndrewBudziszesk.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("abudziszek.dev@gmail.com", "ADMIN - AndrewBudziszek.com"));
			msg.setSubject(senderName + " sent you a message from AndrewBudziszek.com!");
			msgBody = senderName + "\n" + senderEmail + "\n------------------------\n";
			msgBody += req.getParameter("message");
			msg.setText(msgBody);
			Transport.send(msg);
			
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("abudziszek.dev@gmail.com", "ADMIN - Andrew Budziszek.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("2626176215@txt.att.net", "ADMIN - AndrewBudziszek.com"));
			msg.setSubject(senderName + " sent you a message from AndrewBudziszek.com!");
			msg.setText(msgBody);
			Transport.send(msg);
			
			resp.sendRedirect("/?msgSent=suc");
			
		}catch(Exception ex)
		{
			System.out.println("ContactMeServlet(doPost) exception." + ex.getStackTrace());
			resp.sendRedirect("/?msgSent=err"); 
		}
	}
}
