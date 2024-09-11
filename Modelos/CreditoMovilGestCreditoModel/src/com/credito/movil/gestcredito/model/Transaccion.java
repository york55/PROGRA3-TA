/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credito.movil.gestcredito.model;
import com.credito.movil.rrhh.model.Usuario;
/**
 *
 * @author pdext
 */
import java.util.Date;

public class Transaccion {

    public Date Fecha;
    public String concepto;
    public double monto;
    public boolean anulado;
    public Usuario usuarioRegistrado;
    public String agencia;
    public int numOperacion;
    
    public void registrarTransaccion(){
        
    }
    
    public void anulaTransaccion(){
        
    }
    
    //public Transaccion encuentraTransaccion(){
        
    //}
    
    public void imprimirVoucher(){
        
    }
}
