/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.model;

import java.util.Date;
import java.util.ArrayList;

public class Cliente extends Usuario{

    private int codigoCliente;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoCliente;
    private ArrayList<Credito> creditos;
    private double ranking;

    public Cliente(){}
    public Cliente(int idUsuario, Date fecha, String nombre, String apPaterno, 
            String apMaterno, String contrasenha, Date fechaVencimiento,
            boolean activo, TipoDocumento tipoDocumento, String documento, int codigoCliente, String direccion,
            String telefono, String email, String tipoCliente,double ranking){
                super(idUsuario,fecha,nombre,apPaterno,apMaterno,contrasenha,
                      fechaVencimiento,activo, tipoDocumento, documento);
                this.codigoCliente = codigoCliente;
                this.direccion = direccion;
                this.telefono = telefono;
                this.email = email;
                this.tipoCliente = tipoCliente;
                this.ranking = ranking;
        
                creditos = new ArrayList<Credito>();
    }

    @Override
    public void registrar(){
        
    }
    @Override
    public void desactivar(){
        
    }
    @Override
    public void actualizar(){
        
    }
    
    public void listarCreditos(){
        
    }

    public void agregarCredito(Credito nuevo){
        creditos.add(nuevo);
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }
    
}