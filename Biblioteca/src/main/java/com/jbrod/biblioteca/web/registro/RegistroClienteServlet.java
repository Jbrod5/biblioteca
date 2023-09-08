
package com.jbrod.biblioteca.web.registro;

import com.jbrod.biblioteca.data.UsuarioDB;
import com.jbrod.biblioteca.model.Cliente;
import com.jbrod.biblioteca.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author Jorge
 */
@WebServlet("/nuevocliente")
public class RegistroClienteServlet extends HttpServlet{

   private UsuarioDB usuarioDB; 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        HttpSession sesion = req.getSession();
        Connection conexion = (Connection) sesion.getAttribute("conexion");
        usuarioDB = new UsuarioDB(conexion);
        
       String nombre = req.getParameter("name");
       String username = req.getParameter("username");
       String correo = req.getParameter("correo");
       String pass = req.getParameter("password");
       
       Cliente cliente = new Cliente(correo, username, nombre, pass);
       ((Usuario) cliente).setSuspendido(false);
       
       usuarioDB.registrarCliente(cliente);
       resp.sendRedirect("index.jsp");
       
    }
    
    
    
}
