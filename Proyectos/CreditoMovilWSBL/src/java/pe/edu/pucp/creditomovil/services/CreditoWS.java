/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.CreditoMySQL;
import pe.edu.pucp.creditomovil.model.Credito;

@WebService(serviceName = "CreditoWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class CreditoWS {

    private CreditoDAO daoCredito = new CreditoMySQL();

    @WebMethod(operationName = "insertarCredito")
    public void insertarCredito(@WebParam(name = "credito") Credito credito, 
            @WebParam(name = "idCliente") String id) {
        try{
            daoCredito.insertar(credito,id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    
    @WebMethod(operationName = "modificarCredito")
    public void modificarCredito(@WebParam(name = "credito") Credito credito) {
        try{
            daoCredito.modificar(credito);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarCredito")
    public void eliminarCredito(@WebParam(name = "credito") String id) {
        try{
            daoCredito.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "obtenerPorIDCredito")
    public Credito obtenerPorIDCredito(@WebParam(name = "credito") String id) {
        Credito credito = null;
        try{
            credito = daoCredito.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return credito;
    }
    
    @WebMethod(operationName = "listarCreditosFiltro")
    public List<Credito> listarCreditosFiltro(@WebParam(name = "idcli") String idcli,
            @WebParam(name = "fechaini") Date fechaini, @WebParam(name = "fechafin") Date fechafin,
            @WebParam(name = "estado") String estado) {
        List<Credito> creditos = null;
        try{
            creditos = daoCredito.listarTodosFiltros(idcli, fechaini, fechafin, estado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return creditos;
    }
    
    @WebMethod(operationName = "listarTodosCreditos")
    public List<Credito> listarTodosCreditos() {
        List<Credito> creditos = null;
        try{
            creditos = daoCredito.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return creditos;
    }
    
}
