/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Date;
/**
 *
 * @author Bleak
 */
public class Transaccion {

    private Date fecha;
    private String concepto;
    private double monto;
    private boolean anulado;
    private Usuario usuarioRegistrado;
    private String agencia;
    private int numOperacion;
    
    public Transaccion(Date fecha, String concepto, double monto, 
            boolean anulado, Usuario usuarioRegistrado, String agencia,
            int numOperacion){
                this.fecha = fecha;
                this.concepto = concepto;
                this.monto = monto;
                this.anulado = anulado;
                this.usuarioRegistrado = usuarioRegistrado;
                this.agencia = agencia;
                this.numOperacion = numOperacion;
    }

    public void registrarTransaccion(){
        
    }
    
    public void anulaTransaccion(){
        
    }
    
    public Transaccion encuentraTransaccion(){
        
    }
    
    public void imprimirVoucher(){
        
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

    public Usuario getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(Usuario usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
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

}
