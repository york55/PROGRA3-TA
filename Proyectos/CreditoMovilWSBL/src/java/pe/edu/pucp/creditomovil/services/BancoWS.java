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

import pe.edu.pucp.creditomovil.getscredito.dao.BancoDAO;
import pe.edu.pucp.creditomovil.getscredito.mysql.BancoMySQL;
import pe.edu.pucp.creditomovil.model.Banco;
import pe.edu.pucp.creditomovil.model.TipoDocumento;

@WebService(serviceName = "BancoWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class BancoWS {

    private BancoDAO daoBanco = new BancoMySQL();
    
    @WebMethod(operationName = "insertarBanco")
    public boolean insertarBanco(@WebParam(name = "banco") Banco banco) {
        boolean resultado = false;
        try{
            resultado = daoBanco.insertar(banco);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
   
    
    @WebMethod(operationName = "modificarBanco")
    public boolean modificarBanco(@WebParam(name = "banco") Banco banco) {
        boolean resultado = false;
        try{
            resultado = daoBanco.modificar(banco);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarBanco")
    public boolean eliminarBanco(@WebParam(name = "idbanco") int id) {
        boolean resultado = false;
        try{
            resultado = daoBanco.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPorIDBanco")
    public Banco obtenerPorIDBanco(@WebParam(name = "idbanco") int id) {
        Banco banco = null;
        try{
            banco = daoBanco.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return banco;
    }
    
    @WebMethod(operationName = "listarTodosBancos")
    public List<Banco> listarTodosBancos() {
        List<Banco> bancos = null;
        try{
            bancos = daoBanco.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return bancos;
    }
    
}
