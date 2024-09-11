/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credito.movil.gestclientes.model;
import com.credito.movil.rrhh.model.Usuario;
import java.util.Date;
/**
 *
 * @author aaron
 */
public class Evaluacion {

    public Date fechaRegistro;
    public String nombreNegocio;
    public String direccionNegocio;
    public String telefonoNegocio;
    public Usuario usuarioRegistrador;
    public double ventasDiarias;
    public double inventario; //monto de lo que poseen (electrodomesticos etc)
    public double costoVentas;
    public double margenGanancia;
    public double latitud;
    public double longitud;
    public int numeroEvaluacion;
    public boolean activo;

    public void registrarEvaluacion(){
        
    }
    
    public void anularEvaluacion(){
        
    }
    
    public void imprimirEvaluacion(){
        
    }
    
    //public Evaluacion recuperaEvaluacion(){

    //}
    
    
}
