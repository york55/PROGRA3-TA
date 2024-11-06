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
    private String nombreBilletera;
    public Billetera() {
    }

    public Billetera(int idMetodoPago, byte[] foto,
            String nombreTitular, String numeroTelefono, String nombreBilletera) {
        super(idMetodoPago, foto, nombreTitular);
        this.numeroTelefono = numeroTelefono;
        this.nombreBilletera = nombreBilletera;
    }

    ;

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombreBilletera() {
        return nombreBilletera;
    }

    public void setNombreBilletera(String nombreBilletera) {
        this.nombreBilletera = nombreBilletera;
    }

}
