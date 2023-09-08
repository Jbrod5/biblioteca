
package com.jbrod.biblioteca.web.inventario;

import com.jbrod.biblioteca.data.BibliotecaDB;
import com.jbrod.biblioteca.data.InventarioDB;
import com.jbrod.biblioteca.model.inventario.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Desde este servlet se pueden agregar libros y controlar el inventario
 * @author Jorge
 */
@WebServlet("/controlInventario")
public class InventarioServlet extends HttpServlet{

    private InventarioDB inventarioDB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        
        HttpSession sesion = req.getSession();
        Connection conexion = (Connection) sesion.getAttribute("conexion");
        
        BibliotecaDB bibliotecaDB = new BibliotecaDB(conexion);
        
        //obtener el listado de bibliotecas
        var bibliotecas = bibliotecaDB.listarBibliotecas();
        sesion.setAttribute("bibliotecas", bibliotecas);
        
        //llamar al jsp
        resp.sendRedirect("administracion/control-invetario.jsp");
        
        
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession(); 
        Connection connection = (Connection) sesion.getAttribute("conexion");
        inventarioDB = new InventarioDB(connection);
        String accion = req.getParameter("accion");
        
        
        //Obtener informacion del libro libros
        String isbn = req.getParameter("isbn");
        String autor = req.getParameter("autor");
        String titulo = req.getParameter("titulo"); 
        String editorial = req.getParameter("editorial"); 
        int costo = Integer.parseInt(req.getParameter("costo"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        
        Libro libro = new Libro(isbn, autor, titulo, editorial, costo, cantidad);
        
        
        //Obtener las cantidades de las bibliotecas
        List<Integer> ids = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        
        
        Enumeration<String> bibliotecas = req.getParameterNames();
        while (bibliotecas.hasMoreElements()) {
          String paramName = bibliotecas.nextElement();
          if (paramName.startsWith("biblioteca_")) {
            String[] datos = paramName.split("_");
              for (int i = 0; i < datos.length; i++) {
                  System.out.println("dato: " + datos[i]);
                  
              }
            int id = Integer.parseInt(datos[1]);
            int cantidadIn = Integer.parseInt(req.getParameter(paramName));
            
            ids.add(id);
            cantidades.add(cantidadIn);
            /*
            String inputIndex = paramName.substring("biblioteca_".length());
            String inputValue = req.getParameter(paramName);
            // Realiza las acciones necesarias con el índice y el valor del input*/
          }
        }

        //comprobar si las cantidades de las tiendas suman lo mismo que la cantidad total de libros
        int acumuladorCantidades = 0; 
        for (int i = 0; i < cantidades.size(); i++) {
            acumuladorCantidades += cantidades.get(i);
        }
        if(acumuladorCantidades == cantidad){
            //Ejecutar operacion
            inventarioDB.agregarLibro(libro);
            for (int i = 0; i < cantidades.size(); i++) {
                acumuladorCantidades += cantidades.get(i);
                inventarioDB.actualizarInventarioBiblioteca(libro, ids.get(i), cantidades.get(i));
            }
            System.out.println("Inventario actualizado correctamente");
        }else{
            //Avisar que algo salio mal 

        }
        
        
    }
    
    
    
    
    
    
}
