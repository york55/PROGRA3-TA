/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

/**
 *
 * @author USER
 */
public class Banco extends MetodoPago{
    private String CCI;
    
    public Banco(){}
    public Banco(int idMetodoPago, String nombre, String destinatario, String beneficiario, String CCI){
        super(idMetodoPago,nombre,destinatario,beneficiario);
        this.CCI = CCI;
    };

    public String getCCI() {
        return CCI;
    }

    public void setCCI(String CCI) {
        this.CCI = CCI;
    }
    
}
