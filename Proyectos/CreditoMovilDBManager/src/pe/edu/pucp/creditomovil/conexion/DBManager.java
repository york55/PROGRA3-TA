/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diego
 */
public class DBManager {
    private static DBManager dbManager;
    private String url;
    private String usuario;
    private String password;
    private Connection con;
    private ResultSet rs;
    private final String nombreArchivo = "datosConexion.txt";
    
    private DBManager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            leerArchivoYCrearCadena();
        }catch(ClassNotFoundException ex){
            System.out.println("Error registrando el driver: " + ex.getMessage());
        }
    }
    
    public void leerArchivoYCrearCadena() {
        Map<String, String> config = new HashMap<>();
        String rutaArchivo = "";
        try{
            URL resourceUrl = DBManager.class.getResource("/pe/edu/pucp/creditomovil/config/");
            String decodedPath = URLDecoder.decode(resourceUrl.getPath(), "UTF-8");
            rutaArchivo = decodedPath + nombreArchivo;
        }catch(UnsupportedEncodingException ex){
            System.out.println(ex.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    config.put(partes[0].trim(), partes[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo de conexion: " + e.getMessage());
        }

        usuario = config.get("user");
        password = config.get("password");
        url = "jdbc:mysql://" + config.get("hostname") + ":" + config.get("port") + "/" + config.get("database") + "?useSSL=false";

    }
    
    public Connection getConnection(){
        try{
            con = DriverManager.getConnection(url, usuario, password);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
    
    public void cerrarConexion() {
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                System.out.println("Error al cerrar el lector:" + ex.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();  
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión:" + ex.getMessage());
            }
        }
    }
}
