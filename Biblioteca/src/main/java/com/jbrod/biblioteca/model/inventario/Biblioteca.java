
package com.jbrod.biblioteca.model.inventario;

/**
 *
 * @author Jorge
 */
public class Biblioteca {
    
    private int id; 
    private String direccion; 

    /**
     * Objeto biblioteca completo.
     **/
    public Biblioteca(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    /**
     * Biblioteca para guardar en base de datos.
     **/
    public Biblioteca(String direccion) {
        this.direccion = direccion; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    
}
 