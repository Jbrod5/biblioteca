
package com.jbrod.biblioteca.web;

import com.jbrod.biblioteca.data.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Jorge
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        Conexion conexion = new Conexion();
        
        //Obtener la sesion
        HttpSession sesion = req.getSession(); 
        sesion.setMaxInactiveInterval(3220);
        
        //Establecer atributo conexion
        sesion.setAttribute("conexion", conexion.obtenerConexion());
        conexion.obtenerConexion();
        
        //Redirigir a un jsp login
        resp.sendRedirect("login.jsp");
    }
}
