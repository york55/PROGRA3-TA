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
import pe.edu.pucp.creditomovil.rrhh.model.Supervisor;
import pe.edu.pucp.creditomovil.rrhh.mysql.SupervisorMySQL;

/**
 *
 * @author diego
 */
@WebService(serviceName = "SupervisorWS")
public class SupervisorWS {

    /**
     * This is a sample web service operation
     */
    private SupervisorDAO supDao;

    @WebMethod(operationName = "listarSupervisor")
    public List<Supervisor> listarSupervisor() {
        List<Supervisor> supevisores = null;
        try {
            supDao = new SupervisorMySQL();
            supevisores = supDao.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return supevisores;
    }
    
    @WebMethod(operationName = "insertarSupervisor")
    public void insertarSupervisor(@WebParam(name = "credito") Supervisor supervisor) {
        try {
            supDao = new SupervisorMySQL();
            supDao.insertar(supervisor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @WebMethod(operationName = "eliminarSupervisor")
    public void eliminarSupervisor(@WebParam(name = "idSupervisor") int idSupervisor) {
        try {
            supDao = new SupervisorMySQL();
            supDao.eliminar(idSupervisor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "obtenerSupervisorPorId")
    public Supervisor obtenerSupervisorPorId(@WebParam(name = "idSupervisor") int idSupervisor) {
        Supervisor supervisor = null;
        try {
            supDao = new SupervisorMySQL();
            supervisor = supDao.obtenerPorId(idSupervisor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return supervisor;
    }
    
    @WebMethod(operationName = "modificarSupervisor")
    public void modificar(@WebParam(name = "idSupervisor") int idSupervisor, 
            @WebParam(name = "supervisor") Supervisor supervisor) {
        try {
            supDao = new SupervisorMySQL();
            supDao.modificar(idSupervisor,supervisor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
