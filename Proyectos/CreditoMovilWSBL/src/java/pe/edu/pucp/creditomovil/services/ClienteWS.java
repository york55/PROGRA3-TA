/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.creditomovil.conexion.DBManager;

import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.model.Cliente;

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
    public boolean eliminarCliente(@WebParam(name = "idcliente") int id) {
        boolean resultado = false;
        try{
            resultado = daoCliente.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPorCodCliente")
    public Cliente obtenerPorIDCliente(@WebParam(name = "codCliente") int cod) {
        Cliente cliente = null;
        try{
            cliente = daoCliente.obtenerPorCodigo(cod);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
    @WebMethod(operationName = "obtenerPorDocIdenCliente")
    public Cliente obtenerPorDocIdenCliente(@WebParam(name = "docIdentidad") String docIdentidad,
                                                @WebParam(name = "tipoDocumento")String tipoDocumento) {
        Cliente cliente = null;
        try{
            cliente = daoCliente.obtenerPorDocIdentidad(docIdentidad,tipoDocumento);
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
    
    @WebMethod(operationName = "listarClientesPorNombre")
    public List<Cliente> listarClientesPorNombre(@WebParam(name = "nombre") String nombre) {
        List<Cliente> clientes = null;
        try{
            clientes = daoCliente.listarClientesPorNombre(nombre );
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    private String getFileResource(String fileName){ 
        String filePath = ClienteWS.class.getResource("/pe/edu/pucp/creditomovil/resources/"+fileName).getPath();
        filePath = filePath.replace("%20", " ");
        return filePath;
    }
    
    @WebMethod(operationName = "reportePDF")
    public byte[] reportePDF() throws Exception {
        try {            
            Map<String, Object> params = new HashMap<>();
            params.put("docIden","7233415");
            params.put("tipoDocIden","DNI");            
            return generarBuffer(getFileResource("Cliente.jrxml"), params);                    
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
