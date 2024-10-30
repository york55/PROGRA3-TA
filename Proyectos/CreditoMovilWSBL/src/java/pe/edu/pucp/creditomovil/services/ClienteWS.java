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

import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;

@WebService(serviceName = "ClienteWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class ClienteWS {

    private ClienteDAO daoCliente;

    @WebMethod(operationName = "listarClientes")
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = null;
        try {
            daoCliente = new ClienteMySQL();
            clientes = daoCliente.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    @WebMethod(operationName = "insertarCliente")
    public boolean insertarCliente(@WebParam(name = "cliente") Cliente cliente) {
        boolean resultado = false;
        try {
            daoCliente = new ClienteMySQL();
            resultado = daoCliente.insertar(cliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(@WebParam(name = "idCliente") String idCliente) {
        boolean resultado = false;
        try {
            daoCliente = new ClienteMySQL();
            resultado = daoCliente.eliminar(idCliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerClientePorId")
    public Cliente obtenerEventoPorId(@WebParam(name = "idCliente") String idCliente) {
        Cliente cliente = null;
        try {
            daoCliente = new ClienteMySQL();
            cliente = daoCliente.obtenerPorId(idCliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
}
