/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.credito.movil.rrhh.model;

/**
 *
 * @author pdext
 */

import java.util.Date;


public abstract class Usuario {


    public Date fecha;
    public String nombre;
    public String apPaterno;
    public String apMaterno;
    public String contrasenha;
    public Date fechaVencimiento;
    public boolean activo; // Define si el usuario esta activo en el sistema o no
    public Date ultimoLogueo;
   
    public void registrar(){
       
    }
   
    public void desactivar(){
       
    }
   
    public void actualizar(){
       
    }
   
    //listar clientes no se como ponerlo
   
    //busca cliente
}
