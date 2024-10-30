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

import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.CreditoMySQL;
import pe.edu.pucp.creditomovil.getscliente.model.Credito;

@WebService(serviceName = "CreditoWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class CreditoWS {

    private CreditoDAO daoCredito;

    @WebMethod(operationName = "listarCreditos")
    public List<Credito> listarCreditos() {
        List<Credito> creditos = null;
        try {
            daoCredito = new CreditoMySQL();
            creditos = daoCredito.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return creditos;
    }
    
    @WebMethod(operationName = "insertarCredito")
    public void insertarCredito(@WebParam(name = "credito") Credito credito,
            @WebParam(name = "codigoCliente") String codigoCliente) {
        try {
            daoCredito = new CreditoMySQL();
            daoCredito.insertar(credito,codigoCliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @WebMethod(operationName = "eliminarCredito")
    public void eliminarCredito(@WebParam(name = "numCredito") String numCredito) {
        try {
            daoCredito = new CreditoMySQL();
            daoCredito.eliminar(numCredito);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "obtenerCreditoPorId")
    public Credito obtenerCreditoPorId(@WebParam(name = "numCredito") String numCredito) {
        Credito credito = null;
        try {
            daoCredito = new CreditoMySQL();
            credito = daoCredito.obtenerPorId(numCredito);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return credito;
    }
    
}
