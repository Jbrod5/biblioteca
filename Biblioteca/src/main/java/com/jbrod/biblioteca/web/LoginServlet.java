
package com.jbrod.biblioteca.web;

import com.jbrod.biblioteca.data.UsuarioDB;
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
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    
    private Usuario usuario; 
    private UsuarioDB usuarioDB;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ 
            procesarRequerimiento(req, resp);
    }
    
    private void procesarRequerimiento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       
        HttpSession sesion = req.getSession(); 
        Connection conexion = (Connection) sesion.getAttribute("conexion");
        
        Usuario usuario = (Usuario) sesion.getAttribute("user");
        
        if(usuario != null){
            resp.sendRedirect("inicio.jsp");
            return; 
        }
        
        usuarioDB = new UsuarioDB(conexion);
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if(validarUsuario(username, password)){
            sesion.setAttribute("user", this.usuario);
            resp.sendRedirect("inicio.jsp");
        }else{
            req.setAttribute("error", "No se encuentra el usuario especificado");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
        
    }
    
    private boolean validarUsuario(String user, String pass){
        
        var usuario = usuarioDB.obtenerUsuario(user, pass);
        if(usuario.isEmpty()) return false; 
        
        this.usuario = usuario.get(); 
        return true; 
        
    }

    
    
}
