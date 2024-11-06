/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import pe.edu.pucp.creditomovil.getscredito.mysql.TransaccionMySQL;
import pe.edu.pucp.creditomovil.model.Transaccion;

@WebService(serviceName = "TransaccionWS")
public class TransaccionWS {

    private TransaccionDAO daoTransaccion = new TransaccionMySQL();
    
    @WebMethod(operationName = "insertarTransaccion")
    public boolean insertarTransaccion(@WebParam(name = "transaccion") Transaccion transaccion) {
        boolean resultado = false;
        try{
            resultado = daoTransaccion.insertar(transaccion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarTransaccion")
    public boolean modificarTransaccion(@WebParam(name = "transaccion") Transaccion transaccion) {
        boolean resultado = false;
        try{
            resultado = daoTransaccion.modificar(transaccion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarTransaccion")
    public boolean eliminarTransaccion(@WebParam(name = "idtransaccion") int id) {
        boolean resultado = false;
        try{
            resultado = daoTransaccion.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPorIDTransaccion")
    public Transaccion obtenerPorIDTransaccion(@WebParam(name = "idtransaccion") int id) {
        Transaccion transaccion = null;
        try{
            transaccion = daoTransaccion.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return transaccion;
    }
    
    @WebMethod(operationName = "listarTransaccionCredito")
    public List<Transaccion> listarTransaccionCredito(@WebParam(name = "idCred") String idCred) {
        List<Transaccion> transaccions = null;
        try{
            transaccions = daoTransaccion.listarPorCredito(idCred);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return transaccions;
    }
    
    @WebMethod(operationName = "listarTodosTransaccions")
    public List<Transaccion> listarTodosTransaccions() {
        List<Transaccion> transaccions = null;
        try{
            transaccions = daoTransaccion.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return transaccions;
    }
    
}
