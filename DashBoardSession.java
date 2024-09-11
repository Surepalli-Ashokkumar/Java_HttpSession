package com.cisco.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashBoardSession extends HttpServlet
{
           @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
         {
               PrintWriter pw = resp.getWriter();
        	   HttpSession session = req.getSession(false);
        	   resp.setContentType("text/html");
              
              if(session != null)
              {
            	  String UserNameFromSession = (String) session.getAttribute("key");
            	  
            	   if(UserNameFromSession !=null)
            	   {
            		   pw.println("welcome : "+UserNameFromSession);
                       pw.println("<input type='submit' value='LogOut'>");
            		   
            		     
            	   }
            	   else
            	   {
            		   pw.println("unauthorised user");
            	   }
              }
        }
           
           @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
        {
            doGet(req, resp);
        }
}
