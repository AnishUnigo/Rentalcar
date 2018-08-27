package org.anish.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class displayByName
 */





public class displayByName extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();        
              String name=request.getParameter("byname");
              System.out.println(name);
              try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalcar_db1","root","");               
                     PreparedStatement ps=con.prepareStatement("select * from cars_db where user_name=?");
                     ps.setString(1,name);                   
                    
                     out.print("<center><h1>Total Bookings Made by:" +name + "</h1></center>");
                     ResultSet rs=ps.executeQuery();                
                     /* Printing column names */
                     ResultSetMetaData rsmd=rs.getMetaData();
                     while(rs.next())
                        {
                    	 out.print("<center>");
                    	 out.print("<table width=25% border=1>");	 
                     out.print("<tr>");
                     out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                        out.print("<td>"+rs.getString(1)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                        out.print("<td>"+rs.getString(2)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td></tr>");
                        out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td></tr>"); 
                        out.print("</table>");
                        out.print("</br>");
                        out.print("</center>");
                     }
                     
 
              }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
 
              finally{out.close();
                }
       }
 
} 