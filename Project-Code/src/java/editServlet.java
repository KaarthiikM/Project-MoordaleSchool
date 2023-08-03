/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/edit"})
public class editServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String username=request.getParameter("name");
            
            Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","admin");
           PreparedStatement pst=con.prepareStatement("select * from new where username = ?");
           pst.setString(1, username);
           ResultSet rs=pst.executeQuery();
           
           
           while(rs.next())
           {
               out.print("<form action='update' method='Post'>");
               out.print("<table border='1px'>");
               out.print("<tr><td>UerName</td> <td><input type='text' name='name' value='"+rs.getString("username")+"'</td></tr>");
            out.print("<tr><td>Password</td> <td><input type='text' name='pass' value='"+rs.getString("password")+"'</td></tr>");
       out.print("<tr><td> </td> <td><input type='submit' value='Edit'></td></tr>");
       out.print("</table></form>");
       
           }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}