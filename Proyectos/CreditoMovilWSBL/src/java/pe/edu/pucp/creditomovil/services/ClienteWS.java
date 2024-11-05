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

import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.model.Cliente;
import pe.edu.pucp.creditomovil.model.TipoDocumento;

@WebService(serviceName = "ClienteWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class ClienteWS {

    private ClienteDAO daoCliente = new ClienteMySQL();
    
    @WebMethod(operationName = "insertarCliente")
    public boolean insertarCliente(@WebParam(name = "cliente") Cliente cliente) {
        boolean resultado = false;
        try{
            resultado = daoCliente.insertar(cliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
   
    
    @WebMethod(operationName = "modificarCliente")
    public boolean modificarCliente(@WebParam(name = "cliente") Cliente cliente) {
        boolean resultado = false;
        try{
            resultado = daoCliente.modificar(cliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(@WebParam(name = "idcliente") String id) {
        boolean resultado = false;
        try{
            resultado = daoCliente.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPorIDCliente")
    public Cliente obtenerPorIDCliente(@WebParam(name = "idcliente") String id) {
        Cliente cliente = null;
        try{
            cliente = daoCliente.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
    @WebMethod(operationName = "listarTodosClientes")
    public List<Cliente> listarTodosClientes() {
        List<Cliente> clientes = null;
        try{
            clientes = daoCliente.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
}
