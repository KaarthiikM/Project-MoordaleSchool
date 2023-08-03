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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class NewServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* Moordale Login output your page here. You may use following sample code. */
           String username=request.getParameter("username");
            String password=request.getParameter("password");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","admin");
            PreparedStatement pst=con.prepareStatement("insert into new(username,password)values(?,?)");
            pst.setString(1, username);
            pst.setString(2, password);
            int rs=pst.executeUpdate();
            
            if(rs>0)
            {
               out.println("sucess");
            }
            else
            {
                out.println("not");
            }
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        }
    }

    