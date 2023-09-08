
package com.jbrod.biblioteca.data;

import com.jbrod.biblioteca.model.Cliente;
import com.jbrod.biblioteca.model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Maneja las acciones que se pueden realizar con los usuarios en la base de datos.
 * @author Jorge
 */
public class UsuarioDB {

    private Connection conexion; 
    
    public UsuarioDB(Connection conexion){
        this.conexion = conexion;
    }
    
    public Optional<Usuario> obtenerUsuario(String username, String password){
    
        String query = "SELECT * FROM USUARIO WHERE username = ? AND PASSWORD = ?";
        Usuario usuario = null; 
        
        try(var preparedStatement = conexion.prepareStatement(query)){
        
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            try(var resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    String user = resultSet.getString("username");
                    String name = resultSet.getString("nombre");    
                    int tipo = resultSet.getInt("tipo");
                    
                    usuario = new Usuario(user, name, tipo);
                }
            }
            
        }catch(SQLException e){
            System.out.println("Fallo al obtener el usuario:" + e);
        }
        
        
        return Optional.ofNullable(usuario);
    }
    
    public void registrarCliente(Cliente cliente){
        //regCiente llama a registrar usuario okei? :)
        // falta implementar el objeto cliente y su logica
        registrarUsuario(cliente);
        
        String query = "INSERT INTO CLIENTE (username, correo, premium) VALUES (?, ?, ?)";
        
        try (var preparedStatement = conexion.prepareStatement(query)) {
            
            String username = cliente.getUserName();
            String correo = cliente.getCorreo();
            boolean premium = cliente.isPremium();
            
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, correo);
            preparedStatement.setBoolean(3, premium);
            
            preparedStatement.executeUpdate();
            
            System.out.println("Cliente registrado correctamente");
            
        } catch (SQLException e) {
            System.out.println("Error al crear al cliente: " + e);
        }

    }
    
    public void registrarUsuario(Usuario usuario){
    
        String query = "INSERT INTO USUARIO (username, nombre, tipo, password) VALUES (?, ?, ?, ?)";

        try(var preparedStatement = conexion.prepareStatement(query)){
            
            String name = usuario.getNombre();
            String uName = usuario.getUserName();
            int type = usuario.getTipo();
            String pass = usuario.getPassword();
            
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, type);
            preparedStatement.setString(4, pass);
            
            preparedStatement.executeUpdate();
            
            System.out.println("Usuario registrado correctamente");
            
        }catch(SQLException e){
            System.out.println("Error al crear al usuario: " + e);
        }
        
    }
    
    public List<Usuario> obtenerUsuarios(){
        
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";
        
        try(var preparedStatement = conexion.prepareStatement(query)) {
            
            try (var resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    
                    String usuario = resultSet.getString("username");
                    String nombre = resultSet.getString("nombre");
                    int tipo = resultSet.getInt("tipo");
                    
                    var getUsuario = new Usuario(usuario, nombre, tipo);
                    usuarios.add(getUsuario);
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener usuarios: " + e);
        }
        
        return usuarios; 
    }
    
    public void eliminar(String username){
    
        String query = "DELETE FROM USUARIO WHERE  username = ?";
        
        try (var preparedStatement = conexion.prepareStatement(query)){
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar al usuario: " + e);
        }
    }
    
}
