/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.rrhh.dao.SupervisorDAO;
import pe.edu.pucp.creditomovil.model.Supervisor;
import pe.edu.pucp.creditomovil.rrhh.mysql.SupervisorMySQL;

/**
 *
 * @author diego
 */
@WebService(serviceName = "SupervisorWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class SupervisorWS {

    private SupervisorDAO daoSupervisor = new SupervisorMySQL();
    
    @WebMethod(operationName = "insertarSupervisor")
    public boolean insertarSupervisor(@WebParam(name = "supervisor") Supervisor supervisor) {
        boolean resultado = false;
        try{
            resultado = daoSupervisor.insertar(supervisor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarSupervisor")
    public void modificarSupervisor(@WebParam(name = "id") int id,
            @WebParam(name = "supervisor") Supervisor supervisor) {
        try{
            daoSupervisor.modificar(id,supervisor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarSupervisor")
    public void eliminarSupervisor(@WebParam(name = "idsupervisor") int id) {
        try{
            daoSupervisor.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "obtenerPorIDSupervisor")
    public Supervisor obtenerPorIDSupervisor(@WebParam(name = "idsupervisor") int id) {
        Supervisor supervisor = null;
        try{
            supervisor = daoSupervisor.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return supervisor;
    }
    
    @WebMethod(operationName = "obtenerPorDocIdenSup")
    public Supervisor obtenerPorDocIdenSup(@WebParam(name = "docIdentidad") String docIdentidad,
                                                @WebParam(name = "tipoDocumento")String tipoDocumento) {
        Supervisor sup = null;
        try{
            sup = daoSupervisor.obtenerPorDocIdentidad(docIdentidad,tipoDocumento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return sup;
    }
    
    @WebMethod(operationName = "listarTodosSupervisors")
    public List<Supervisor> listarTodosSupervisors() {
        List<Supervisor> supervisors = null;
        try{
            supervisors = daoSupervisor.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return supervisors;
    }
    
    @WebMethod(operationName = "obtenerPorCliente")
    public Supervisor obtenerPorCliente(int codCliente) {
        Supervisor sup = null;
        try{
            sup = daoSupervisor.obtenerPorCliente(codCliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return sup;
    }
}
