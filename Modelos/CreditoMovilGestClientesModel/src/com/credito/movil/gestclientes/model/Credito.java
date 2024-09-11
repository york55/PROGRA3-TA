/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credito.movil.gestclientes.model;

import java.util.Date;
import java.util.ArrayList;
import com.credito.movil.rrhh.model.Usuario;
import com.credito.movil.gestcredito.model.Transaccion;
/**
 *
 * @author aaron
 */
public class Credito {

    public String numCredito;
    public double monto;
    public double tasaInteres;
    public Date fechaOtorgamiento;
    public Usuario cliente;
    public String estado;
    public int numCuotas;
    public ArrayList<Transaccion> transacciones;
    
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
}

