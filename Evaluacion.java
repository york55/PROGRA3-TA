/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.Date;
/**
 *
 * @author Bleak
 */
public class Evaluacion {

    private Date fechaRegistro;
    private String nombreNegocio;
    private String direccionNegocio;
    private String telefonoNegocio;
    private Usuario usuarioRegistrador;
    private double ventasDiarias;
    private double inventario; //monto de lo que poseen (electrodomesticos etc)
    private double costoVentas;
    private double margenGanancia;
    private double latitud;
    private double longitud;
    private int numeroEvaluacion;
    private boolean activo;


    public Evaluacion(Date fechaRegistro, String nombreNegocio, 
            String direccionNegocio, String telefonoNegocio, 
            Usuario usuarioRegistrador, double ventasDiarias, double inventario,
            double costoVentas, double margenGanancia, double latitud,
            double longitud, int numeroEvaluacion, boolean activo){
                this.fechaRegistro = fechaRegistro;
                this.nombreNegocio = nombreNegocio;
                this.direccionNegocio = direccionNegocio;
                this.telefonoNegocio = telefonoNegocio;
                this.usuarioRegistrador = usuarioRegistrador;
                this.ventasDiarias = ventasDiarias;
                this,inventario = inventario;
                this.costoVentas = costoVentas;
                this.margenGanancia = margenGanancia;
                this.latitud = latitud;
                this.longitud = longitud;
                this.numeroEvaluacion = numeroEvaluacion;
                this.activo = activo;
    }

    public void registrarEvaluacion(){
        
    }
    
    public void anularEvaluacion(){
        
    }
    
    public void imprimirEvaluacion(){
        
    }
    
    public Evaluacion recuperaEvaluacion(){

    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDireccionNegocio() {
        return direccionNegocio;
    }

    public void setDireccionNegocio(String direccionNegocio) {
        this.direccionNegocio = direccionNegocio;
    }

    public String getTelefonoNegocio() {
        return telefonoNegocio;
    }

    public void setTelefonoNegocio(String telefonoNegocio) {
        this.telefonoNegocio = telefonoNegocio;
    }

    public Usuario getUsuarioRegistrador() {
        return usuarioRegistrador;
    }

    public void setUsuarioRegistrador(Usuario usuarioRegistrador) {
        this.usuarioRegistrador = usuarioRegistrador;
    }

    public double getVentasDiarias() {
        return ventasDiarias;
    }

    public void setVentasDiarias(double ventasDiarias) {
        this.ventasDiarias = ventasDiarias;
    }

    public double getInventario() {
        return inventario;
    }

    public void setInventario(double inventario) {
        this.inventario = inventario;
    }

    public double getCostoVentas() {
        return costoVentas;
    }

    public void setCostoVentas(double costoVentas) {
        this.costoVentas = costoVentas;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getNumeroEvaluacion() {
        return numeroEvaluacion;
    }

    public void setNumeroEvaluacion(int numeroEvaluacion) {
        this.numeroEvaluacion = numeroEvaluacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
