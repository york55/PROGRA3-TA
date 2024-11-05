/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

/**
 *
 * @author USER
 */
public class Billetera extends MetodoPago {

    private String numeroTelefono;

    public Billetera() {
    }

    public Billetera(int idMetodoPago, byte[] foto,
            String nombreTitular, String numeroTelefono) {
        super(idMetodoPago, foto, nombreTitular);
        this.numeroTelefono = numeroTelefono;
    }

    ;

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

}
