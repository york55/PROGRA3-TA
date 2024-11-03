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
    private String nombre;
    private String beneficiario;
    private String destinatario;
    
    
    public MetodoPago(){}
    public MetodoPago(int idMetodoPago,String nombre, String destinatario, String beneficiario){
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.destinatario = destinatario;
        this.beneficiario = beneficiario;
    };

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }
    
}
