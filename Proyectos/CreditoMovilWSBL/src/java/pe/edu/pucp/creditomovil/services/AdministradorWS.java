/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

import pe.edu.pucp.creditomovil.rrhh.dao.AdministradorDAO;
import pe.edu.pucp.creditomovil.rrhh.mysql.AdministradorMySQL;
import pe.edu.pucp.creditomovil.model.Administrador;

@WebService(serviceName = "AdministradorWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class AdministradorWS {

    private AdministradorDAO daoAdministrador = new AdministradorMySQL();
    
    @WebMethod(operationName = "insertarAdministrador")
    public void insertarAdministrador(@WebParam(name = "administrador") Administrador administrador) {
        try{
            daoAdministrador.insertar(administrador);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "modificarAdministrador")
    public void modificarAdministrador(@WebParam(name = "id") int id,
            @WebParam(name = "administrador") Administrador administrador) {
        try{
            daoAdministrador.modificar(id, administrador);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarAdministrador")
    public void eliminarAdministrador(@WebParam(name = "idadministrador") int id) {
        try{
            daoAdministrador.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "obtenerPorDocIdenAdmin")
    public Administrador obtenerPorDocIdenAdmin(@WebParam(name = "docIdentidad") String docIdentidad,
                                                @WebParam(name = "tipoDocumento")String tipoDocumento) {
        Administrador admin = null;
        try{
            admin = daoAdministrador.obtenerPorDocIdentidad(docIdentidad,tipoDocumento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return admin;
    }
    
    @WebMethod(operationName = "obtenerPorIDAdministrador")
    public Administrador obtenerPorIDAdministrador(@WebParam(name = "idadministrador") int id) {
        Administrador administrador = null;
        try{
            administrador = daoAdministrador.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return administrador;
    }
    
    @WebMethod(operationName = "listarTodosAdministradores")
    public List<Administrador> listarTodosAdministradores() {
        List<Administrador> administradores = null;
        try{
            administradores = daoAdministrador.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return administradores;
    }   
}
