/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class NewServlet2 extends HttpServlet {

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
            /* Moordale Signup output your page here. You may use following sample code. */
            
            String uname=request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String cpassword = request.getParameter("cpassword");       
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","admin");
           PreparedStatement pst=con.prepareStatement("select * from new");
           ResultSet rs=pst.executeQuery();
           
           while(rs.next())
           {
               String username=rs.getString("username");
               
               String pass=rs.getString("password");

               String cpass=rs.getNString("cpassword");
               
           
               if(username.equals(uname) && pass.equals(password))
               {
                   out.print("success");
               }
           
               else
               {

                   out.print("not");

               }

               if(pass.equals(password) && cpass.equals(cpassword)){
                out.print("Success");
               }
               else{
                out.print("not");
               }
              
                         
           }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

}


