/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Bleak
 */
public class Credito {

    private String numCredito;
    private double monto;
    private double tasaInteres;
    private Date fechaOtorgamiento;
    private Usuario cliente;
    private String estado;
    private int numCuotas;
    private ArrayList<Transaccion> transacciones;
    
    public Credito(String numCredito, double monto, double tasaInteres,
            Date fechaOtorgamiento, Usuario cliente, String estado,
            int numCuotas){
                this.numCredito = numCredito;
                this.monto = monto;
                this.tasaInteres = tasaInteres;
                this.fechaOtorgamiento = fechaOtorgamiento;
                this.cliente = cliente;
                this.estado = estado;
                this.numCuotas = numCuotas;
                transacciones = new ArrayList<Transaccion>();
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

    public String getNumCredito() {
        return numCredito;
    }

    public void setNumCredito(String numCredito) {
        this.numCredito = numCredito;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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


}
