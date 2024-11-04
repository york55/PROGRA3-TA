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
    
//    @WebMethod(operationName = "insertarCliente")
//    public boolean insertarCliente(@WebParam(name = "cliente") Cliente cliente) {
//        boolean resultado = false;
//        try{
//            resultado = daoCliente.insertar(cliente);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return resultado;
//    }
    
    @WebMethod(operationName = "insertarClienteParametros")
    public boolean insertarCliente(@WebParam(name = "idUsuario") int idUsuario,@WebParam(name = "fecha") Date fecha,
            @WebParam(name = "nombre") String nombre,@WebParam(name = "apPaterno") String apPaterno,
            @WebParam(name = "apMaterno") String apMaterno,@WebParam(name = "contrasenha")String contrasenha,
            @WebParam(name = "fechaVencimiento") Date fechaVencimiento,@WebParam(name = "activo") boolean activo,
            @WebParam(name = "tipoDocumento") TipoDocumento tipoDocumento,@WebParam(name = "documento") String documento,
            @WebParam(name = "codigoCliente") String codigoCliente,@WebParam(name = "direccion") String direccion,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "email") String email,@WebParam(name = "tipoCliente") String tipoCliente) {
        boolean resultado = false;
        try{
            Cliente cli = new Cliente(idUsuario, fecha, nombre, apPaterno, apMaterno, 
                    contrasenha, fechaVencimiento, activo, tipoDocumento, documento, 
                    codigoCliente, direccion, telefono, email, tipoCliente);
            resultado = daoCliente.insertar(cli);
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
