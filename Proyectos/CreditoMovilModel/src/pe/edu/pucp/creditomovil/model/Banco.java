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
    private String tipoCuenta;
    
    public Banco(){}
    public Banco(int idMetodoPago,byte[] foto,
            String nombreTitular, String CCI, String tipoCuenta){
        super(idMetodoPago,foto,nombreTitular);
        this.CCI = CCI;
        this.tipoCuenta = tipoCuenta;
    };

    public String getCCI() {
        return CCI;
    }

    public void setCCI(String CCI) {
        this.CCI = CCI;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
}
