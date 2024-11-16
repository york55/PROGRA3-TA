/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;
import java.util.ArrayList;

public class Credito {

    private int numCredito;
    private double monto;
    private double tasaInteres;
    private Date fechaOtorgamiento;
    private Usuario cliente;
    private String estado;
    private int numCuotas;
    private ArrayList<Transaccion> transacciones;
    private boolean cancelado;
    private String motivo;
    
    public Credito(){}
    public Credito(int numCredito, double monto, double tasaInteres,
            Date fechaOtorgamiento, Usuario cliente, String estado,
            int numCuotas, boolean cancelado, String motivo){
                this.numCredito = numCredito;
                this.monto = monto;
                this.tasaInteres = tasaInteres;
                this.fechaOtorgamiento = fechaOtorgamiento;
                this.cliente = cliente;
                this.estado = estado;
                this.numCuotas = numCuotas;
                transacciones = new ArrayList<Transaccion>();
                this.cancelado = cancelado;
                this.motivo = motivo;
    }

    public void CargaDatosCredito(){
        
    }
    
    public void AprobarCredito(){
        
    }
    
    public void RechazarCredito(){
        
    }
    
    public void imprimirCredito(){
        
    }

    public void buscarTransaccion(){
        
    }

    public void agregarTransaccion(Transaccion nuevo){
        transacciones.add(nuevo);
    }

    public int getNumCredito() {
        return numCredito;
    }

    public void setNumCredito(int numCredito) {
        this.numCredito = numCredito;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public Date getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public void setFechaOtorgamiento(Date fechaOtorgamiento) {
        this.fechaOtorgamiento = fechaOtorgamiento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }


}
