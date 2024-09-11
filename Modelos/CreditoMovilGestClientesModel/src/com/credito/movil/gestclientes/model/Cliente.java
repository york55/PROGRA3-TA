/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credito.movil.gestclientes.model;

import java.util.ArrayList;
import com.credito.movil.rrhh.model.Usuario;
/**
 *
 * @author aaron
 */
public class Cliente extends Usuario{

    public String codigoCliente;
    public String direccion;
    public String telefono;
    public String email;
    public String tipoCliente;
    public ArrayList<Credito> creditos;
    
    @Override
    public void registrar(){
        
    }
    
    public void desactivar(){
        
    }
    
    public void actualizar(){
        
    }
    
    public void listarCreditos(){
        
    }
}