
package com.jbrod.biblioteca.model;

/**
 *
 * @author Jorge
 */
public class Cliente extends Usuario{

    private String correo; 
    private boolean premium; 
    
    /**
     * Al crear un cliente para registro puede no ser premium
     **/
    public Cliente(String correo, String userName, String nombre, String password) {
        //Cliente cod. 3
        super(userName, nombre, 3, password);
        this.correo = correo; 
        premium = false; 
    }
    
    /**
     * Para un cliente que se lee de la base de datos, no se requiere la contraseña pero SI si es premium o no
     **/
    public Cliente(String correo, String userName, String nombre, boolean premium){
        super(userName, nombre, 3);
        this.correo = correo; 
        this.premium = premium; 
        
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    
    
}
