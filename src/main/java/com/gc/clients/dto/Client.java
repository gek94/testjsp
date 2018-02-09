package com.gc.clients.dto;

/**
 *
 * @author george
 */
public class Client {
    
    private int id;
    private String cedula;
    private String Nombres;
    private String Apellidos;

    /**
     * Constructor
     */
    public Client() {
    }
    
    /**
     *
     * Constructor
     * @param id
     * @param cedula
     * @param Nombres
     * @param Apellidos 
     */
    public Client(int id, String cedula, String Nombres, String Apellidos) {
        this.id = id;
        this.cedula = cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }

    /**
     * 
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return String
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * 
     * @return String
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * 
     * @return String
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * 
     * @param Nombres 
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    /**
     * 
     * @param Apellidos 
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
        
}
