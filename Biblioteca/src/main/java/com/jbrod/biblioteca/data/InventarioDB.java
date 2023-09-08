
package com.jbrod.biblioteca.data;

import com.jbrod.biblioteca.model.inventario.Libro;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Maneja las acciones que se pueden realizar con los libros en la base de datos.
 * @author Jorge
 */
public class InventarioDB {

    private Connection conexion; 
    
    public InventarioDB(Connection conexion){
        
        this.conexion = conexion;
        
    }
    
    public boolean agregarLibro(Libro libro){
        
        boolean libroAgregado = false;
        
        String query = "INSERT INTO LIBROS(isbn, autor, titulo, editorial, costo, cantidad) VALUES (?,?,?,?,?,?)";
        
        try(var preparedStatement = conexion.prepareStatement(query)){
        
            preparedStatement.setString (1, libro.getIsbn       ());
            preparedStatement.setString (2, libro.getAutor      ());
            preparedStatement.setString (3, libro.getTitulo     ());
            preparedStatement.setString (4, libro.getEditorial  ());
            preparedStatement.setInt    (5, libro.getCosto      ());
            preparedStatement.setInt    (6, libro.getCantidad   ());
            
            preparedStatement.executeUpdate();
            System.out.println("Libro agregado exitosamente");
        
            
        }catch(SQLException e){
            System.out.println("Error al agregar el libro: " + e);
        }
        
        return libroAgregado;
    }
    
    /**
     * Este metodo actualiza el inventario de una unica biblioteca a la vez.
     **/
    public void actualizarInventarioBiblioteca(Libro libro, int idBiblioteca, int cantidad){
        
        String query;
        String isbn = libro.getIsbn();
        
        if(comprobarExistenciaLibro(libro, idBiblioteca)){
            //Si existe, actualizar
            query = "UPDATE INVENTERIO_BIBLIOTECA SET cantidad_disponible = ? WHERE  id_biblioteca = ? AND  isbn = ?";    
        }else{
            //Si no existe, insertar
            query = "INSERT INTO INVENTARIO_BIBLIOTECA(cantidad_disponible, id_biblioteca, isbn) VALUES (?,?,?)";    
        }
        
        try(var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, cantidad);
            preparedStatement.setInt(2, idBiblioteca);
            preparedStatement.setString(3, isbn);
            
            preparedStatement.executeUpdate();
            System.out.println("Inventario actualizado con exito");
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar inventario: " + e);
        }
        
        
    }
    
    private boolean comprobarExistenciaLibro(Libro libro, int id){
        String query = "SELECT * FROM INVENTARIO_BIBLIOTECA WHERE isbn = ? AND id_biblioteca = ?";
        
        try(var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, libro.getIsbn());
            preparedStatement.setInt(2, id);
            
            try (var resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }
            
        } catch (SQLException e) {
            System.out.println("Error al comprobar: " + e);
        }
        
        return false; 
    }
    
}
