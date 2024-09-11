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
import java.util.ArrayList;


public class Foto {


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
