/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/update"})
public class updateServlet extends HttpServlet {

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
            
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/servlet","root","admin");
            
            PreparedStatement pst=con.prepareStatement("update  new set username= ?,password = ?");
            
            pst.setString(1, username);
            pst.setString(2, password);
            int rs=pst.executeUpdate();
            
            if(rs>0)
            {
                out.print("sucessfully edited");
            }
            else
            {
                out.print("not edited");
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}