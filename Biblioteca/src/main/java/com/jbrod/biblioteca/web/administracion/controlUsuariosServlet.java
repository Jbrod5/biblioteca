
package com.jbrod.biblioteca.web.administracion;

import com.jbrod.biblioteca.data.UsuarioDB;
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
@WebServlet("/controlUsuarios")
public class controlUsuariosServlet extends HttpServlet{

    private UsuarioDB usuarioDB; 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        if(accion == null){
            HttpSession sesion = req.getSession();
            Connection conexion  = (Connection) sesion.getAttribute("conexion");

            usuarioDB = new UsuarioDB(conexion);

            var usuarios = usuarioDB.obtenerUsuarios();

            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(usuarios.get(i).getNombre());
            }

            req.setAttribute("usuarios", usuarios);
            req.getRequestDispatcher("administracion/control-usuarios.jsp").forward(req, resp); 
        }else if(accion.equals("eliminar")){
            String username = req.getParameter("iddelete");
            System.out.println(username);
            usuarioDB.eliminar(username);
            HttpSession sesion = req.getSession();
            sesion.setAttribute("success", "usuario eliminado con exito");
            
            System.out.println("Usuario eliminado con exito");
            resp.sendRedirect("inicio.jsp");
            
            
        }else if(accion.equals("editarusuario")){
            
        }
        
        
    }
    
    
    
    
}
