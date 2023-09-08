
package com.jbrod.biblioteca.data;

import com.jbrod.biblioteca.model.inventario.Biblioteca;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Administra las bibliotecas individuales
 * @author Jorge
 */
public class BibliotecaDB {

    private Connection conexion; 
    
    public BibliotecaDB(Connection conexion){
        this.conexion = conexion; 
    }
    
    
    public void insertarBiblioteca(Biblioteca biblioteca){
    
        String query = "INSERT INTO BIBLIOTECAS (direccion) VALUES (?)";
        
        try (var preparedStatement = conexion.prepareStatement(query)){
            preparedStatement.setString(1, biblioteca.getDireccion());
            
            preparedStatement.executeUpdate();
            System.out.println("Biblioteca agregada con exito");
            
        } catch (SQLException e) {
            System.out.println("Error al agregar la biblioteca: " + e);
        }
        
    }
    
    public List<Biblioteca> listarBibliotecas(){
        List <Biblioteca> bibliotecas = new ArrayList<>();
        
        String query = "SELECT * FROM BIBLIOTECAS";
        
        
        try(var preparedStatement = conexion.prepareStatement(query)){
            
            try(var resultSet = preparedStatement.executeQuery()) {
                
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String direccion = resultSet.getString("direccion");
                    
                    Biblioteca biblioteca = new Biblioteca(id, direccion);
                    bibliotecas.add(biblioteca);
                }
            } 
            
        }catch(SQLException e){
            System.out.println("Error al obtener bibliotecas: " + e);
        }
        
        return bibliotecas;
    }
    
    
        public void eliminarBiblioteca(int id){
            String query = "DELETE FROM BIBLIOTECAS WHERE id = ?";
            
            try(var preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                
                preparedStatement.executeUpdate();
                System.out.println("Biblioteca eliminada con exito");
            } catch (SQLException e) {
                System.out.println("Error al eliminar biblioteca: " + e);
            }
            
        }
    
}
