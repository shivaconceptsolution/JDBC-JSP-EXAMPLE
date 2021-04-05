/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class RegSer extends HttpServlet {


  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
          Statement st = conn.createStatement();
          int x = st.executeUpdate("insert into reg(staffid,mobileno,fullname,password) values('"+request.getParameter("txtstaffid")+"','"+request.getParameter("txtmobile")+"','"+request.getParameter("txtfname")+"','"+request.getParameter("txtpass")+"')");
          if(x!=0)
          {
             response.sendRedirect("home.jsp?q=reg successfully");
          }
          else
          {
               response.sendRedirect("home.jsp?q=reg not successfully");
          }
        }
        catch(Exception ex)
        {
          out.print(ex.getMessage().toString());  
        }
    }

   

}
