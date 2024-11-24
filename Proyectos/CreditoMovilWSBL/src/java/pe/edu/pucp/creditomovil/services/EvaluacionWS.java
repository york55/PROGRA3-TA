/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.EvaluacionMySQL;
import pe.edu.pucp.creditomovil.model.Evaluacion;

@WebService(serviceName = "EvaluacionWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
public class EvaluacionWS {

    private EvaluacionDAO daoEvaluacion = new EvaluacionMySQL();
    
    @WebMethod(operationName = "insertarEvaluacion")
    public boolean insertarEvaluacion(@WebParam(name = "evaluacion") Evaluacion evaluacion,
                                        @WebParam(name = "codSup") int codSup) {
        boolean resultado = false;
        try{
            resultado = daoEvaluacion.insertar(evaluacion, codSup);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarEvaluacion")
    public void modificarEvaluacion(@WebParam(name = "evaluacion") Evaluacion evaluacion) {
        try{
            daoEvaluacion.modificar(evaluacion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "eliminarEvaluacion")
    public void eliminarEvaluacion(@WebParam(name = "idevaluacion") int id) {
        try{
            daoEvaluacion.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @WebMethod(operationName = "listarTodosPorSupervisor")
    public List<Evaluacion> listarPorSupervisor(@WebParam(name = "codSup") int codSup) {
        List<Evaluacion> ev = null;
        try{
            ev = daoEvaluacion.listarTodosPorSupervisor(codSup);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ev;
    }
    
    @WebMethod(operationName = "listarPendientesPorSupervisor")
    public List<Evaluacion> listarPendientesPorSupervisor(@WebParam(name = "codSup") int codSup) {
        List<Evaluacion> ev = null;
        try{
            ev = daoEvaluacion.listarPendientesPorSupervisor(codSup);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ev;
    }
    
    @WebMethod(operationName = "listarRealizadosPorSupervisor")
    public List<Evaluacion> listarRealizadosPorSupervisor(@WebParam(name = "codSup") int codSup) {
        List<Evaluacion> ev = null;
        try{
            ev = daoEvaluacion.listarRealizadosPorSupervisor(codSup);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ev;
    }
    
    @WebMethod(operationName = "obtenerPorNumEvaluacion")
    public Evaluacion obtenerPorIDEvaluacion(@WebParam(name = "numEvaluacion") int numEvaluacion) {
        Evaluacion evaluacion = null;
        try{
            evaluacion = daoEvaluacion.obtenerPorId(numEvaluacion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return evaluacion;
    }
//    
//    @WebMethod(operationName = "listarEvaluacionesSupervisor")
//    public List<Evaluacion> listarEvaluacionesSupervisor(@WebParam(name = "idSup") int idSup) {
//        List<Evaluacion> evaluacions = null;
//        try{
//            evaluacions = daoEvaluacion.listarPorSupervisor(idSup);
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return evaluacions;
//    }
//    
//    @WebMethod(operationName = "listarTodosEvaluacions")
//    public List<Evaluacion> listarTodosEvaluacions() {
//        List<Evaluacion> evaluacions = null;
//        try{
//            evaluacions = daoEvaluacion.listarTodos();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return evaluacions;
//    }
    
    
}
