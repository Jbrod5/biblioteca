
package com.jbrod.biblioteca.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jorge
 */
public class Conexion {
    
    private java.sql.Connection conexion = null; 
    
    private final String url = "jdbc:mysql://localhost:3306/biblioteca_database";
    
    private final String user = "admin";
    private final String password = "admin";
    
    public Connection obtenerConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
            return conexion; 
        } catch (SQLException  | ClassNotFoundException e) {
            System.out.println("Error al registrar el driver mysql: " + e);
        }
        return null; 
    }
    
    
}
