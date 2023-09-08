
package com.jbrod.biblioteca.model;

/**
 *
 * @author Jorge
 */
public class Usuario {
    
    private String userName; 
    private String nombre; 
    private int tipo;
    private boolean suspendido; 
    
    private String password; 

    
    public Usuario(String userName, String nombre, int tipo, String password) {
        this.userName = userName;
        this.nombre = nombre;
        this.tipo = tipo;
        this.password = password; 
    }
    
    public Usuario(String userName, String nombre, int tipo){
        this.userName = userName;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuspendido() {
        return suspendido;
    }

    public void setSuspendido(boolean suspendido) {
        this.suspendido = suspendido;
    }
    
    
    
    
    
}
