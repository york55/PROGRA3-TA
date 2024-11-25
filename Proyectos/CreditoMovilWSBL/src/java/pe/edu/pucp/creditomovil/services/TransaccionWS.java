/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.creditomovil.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.creditomovil.conexion.DBManager;

import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import pe.edu.pucp.creditomovil.getscredito.mysql.TransaccionMySQL;
import pe.edu.pucp.creditomovil.model.Transaccion;

@WebService(serviceName = "TransaccionWS", targetNamespace
        = "https://services.creditomovil.pucp.edu.pe")
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
    public List<Transaccion> listarTransaccionCredito(@WebParam(name = "idCred") int idCred) {
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
    
    private String getFileResource(String fileName){ 
        String filePath = ClienteWS.class.getResource("/pe/edu/pucp/creditomovil/resources/"+fileName).getPath();
        filePath = filePath.replace("%20", " ");
        return filePath;
    }
    
    @WebMethod(operationName = "reporteTransaccionClientePDF")
    public byte[] reportePDF() throws Exception {
        try {            
            Map<String, Object> params = new HashMap<>();        
            return generarBuffer(getFileResource("Transaccion.jrxml"), params);                    
         } catch (Exception ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
    Compila el xml,genera el reporte y lo retorna como un array de bytes
    */
    public byte[] generarBuffer(String inFileXML, Map<String, Object> params) throws Exception{
        //Se compila una sola vez
        String fileJasper = inFileXML +".jasper";
        if(!new File(fileJasper).exists()){
            //para compilar en GlassFish se requiere las librerias: jasperreports-jdt, ecj
            JasperCompileManager.compileReportToFile(inFileXML, fileJasper);         
        }
        //1- leer el archivo compilado
        JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(fileJasper);
        //2- poblar el reporte
        Connection conn = DBManager.getInstance().getConnection();
        JasperPrint jp = JasperFillManager.fillReport(jr,params, conn);          
        return JasperExportManager.exportReportToPdf(jp);
    }
    
}
