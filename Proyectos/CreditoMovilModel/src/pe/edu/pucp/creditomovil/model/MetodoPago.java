/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

/**
 *
 * @author USER
 */
public abstract class MetodoPago {

    private int idMetodoPago;
    private byte[] foto;
    private String nombreTitular;

    public MetodoPago() {
    }

    public MetodoPago(int idMetodoPago, byte[] foto,
            String nombreTitular) {
        this.idMetodoPago = idMetodoPago;
        this.foto = foto;
        this.nombreTitular = nombreTitular;
    }
    
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
}
