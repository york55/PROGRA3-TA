/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;

public class Transaccion {

    private Date fecha;
    private String concepto;
    private double monto;
    private boolean anulado;
    private String agencia;
    private Credito credito;
    private int numOperacion;
    private MetodoPago metodoPago;

    public Transaccion(){}
    public Transaccion(Date fecha, String concepto, double monto,
            boolean anulado, String agencia,
            int numOperacion, Credito credito) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.anulado = anulado;
        this.agencia = agencia;
        this.numOperacion = numOperacion;
        this.credito = credito;
    }

    public void registrarTransaccion() {

    }

    public void anulaTransaccion() {

    }

//    public Transaccion encuentraTransaccion(){
//        
//    }
    public void imprimirVoucher() {

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getNumOperacion() {
        return numOperacion;
    }

    public void setNumOperacion(int numOperacion) {
        this.numOperacion = numOperacion;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

}
