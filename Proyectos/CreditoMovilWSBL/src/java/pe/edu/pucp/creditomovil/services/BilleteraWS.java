/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.Date;

import java.util.List;

import pe.edu.pucp.creditomovil.getscredito.dao.BilleteraDAO;
import pe.edu.pucp.creditomovil.getscredito.mysql.BilleteraMySQL;
import pe.edu.pucp.creditomovil.model.Billetera;

@WebService(serviceName = "BilleteraWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class BilleteraWS {

    private BilleteraDAO daoBilletera = new BilleteraMySQL();
    
    @WebMethod(operationName = "insertarBilletera")
    public boolean insertarBilletera(@WebParam(name = "billetera") Billetera billetera) {
        boolean resultado = false;
        try{
            resultado = daoBilletera.insertar(billetera);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
   
    
    @WebMethod(operationName = "modificarBilletera")
    public boolean modificarBilletera(@WebParam(name = "billetera") Billetera billetera) {
        boolean resultado = false;
        try{
            resultado = daoBilletera.modificar(billetera);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarBilletera")
    public boolean eliminarBilletera(@WebParam(name = "idbilletera") int id) {
        boolean resultado = false;
        try{
            resultado = daoBilletera.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPorIDBilletera")
    public Billetera obtenerPorIDBilletera(@WebParam(name = "idbilletera") int id) {
        Billetera billetera = null;
        try{
            billetera = daoBilletera.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return billetera;
    }
    
    @WebMethod(operationName = "obtenerPorNombreBilletera")
    public Billetera obtenerPorNombreBilletera(@WebParam(name = "nombrebilletera") String nombre) {
        Billetera billetera = null;
        try{
            billetera = daoBilletera.obtenerPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return billetera;
    }
    
    @WebMethod(operationName = "listarTodosBilleteras")
    public List<Billetera> listarTodosBilleteras() {
        List<Billetera> billeteras = null;
        try{
            billeteras = daoBilletera.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return billeteras;
    }
    
}
