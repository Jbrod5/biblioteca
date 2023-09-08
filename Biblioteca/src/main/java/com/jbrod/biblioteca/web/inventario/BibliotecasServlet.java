
package com.jbrod.biblioteca.web.inventario;

import com.jbrod.biblioteca.data.BibliotecaDB;
import com.jbrod.biblioteca.model.inventario.Biblioteca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet para las bibliotecas individuales.
 * @author Jorge
 */
@WebServlet("/controlBibliotecas")
public class BibliotecasServlet extends HttpServlet{
    
    private BibliotecaDB bibliotecaDB;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        HttpSession sesion = req.getSession(); 
        Connection conexion = (Connection) sesion.getAttribute("conexion");
        bibliotecaDB = new BibliotecaDB(conexion);
        
        String direccion = req.getParameter("direccion");
        
        Biblioteca biblioteca = new Biblioteca(direccion);
        bibliotecaDB.insertarBiblioteca(biblioteca);
        resp.sendRedirect("controlBibliotecas");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        //obtener bibliotecas
        if(accion == null){
            HttpSession sesion = req.getSession();
            Connection conexion = (Connection)sesion.getAttribute("conexion");
            bibliotecaDB = new BibliotecaDB(conexion);
            var bibliotecas = bibliotecaDB.listarBibliotecas();

            req.setAttribute("bibliotecas", bibliotecas);
            req.getRequestDispatcher("administracion/control-bibliotecas.jsp").forward(req, resp);
        
        }else if(accion.equals("eliminar")){
            int id = Integer.parseInt(req.getParameter("iddelete"));
            bibliotecaDB.eliminarBiblioteca(id);
            HttpSession sesion = req.getSession();
            sesion.setAttribute("success", "biblioteca eliminada con exito");
            
            System.out.println("Biblioteca eliminada con exito");
            resp.sendRedirect("controlBibliotecas");
        }
        
        
    }

    
    
    
    
}
