/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.Map;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.Date;
import java.sql.Time;

import java.net.URL;
import java.net.URLDecoder;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBManager {
    
    private static DBManager dbManager = null;
    
    private BasicDataSource dataSource;
    
    private String url;
    private String user;
    private String password;
    
    private Connection con;
    private ResultSet rs;
    
    private final String nombreArchivo = "datosConexion.txt";
    
    
    private DBManager(){
        connectToDatabase();
    }
    
    
    private void connectToDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            leerArchivoYCrearCadena();
            
            dataSource=new BasicDataSource();
            
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(20);
            dataSource.setMaxOpenPreparedStatements(100);
            System.out.println("....conexion realizada...");
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static DBManager getInstance(){
        if(dbManager == null) createInstance();
        return dbManager;
    }
    
    private static void createInstance(){
        dbManager = new DBManager();
    }
    
    public Connection getConnection() throws SQLException{
        if(dataSource==null || dataSource.isClosed()) 
            connectToDatabase();
        return dataSource.getConnection();
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

        user = config.get("user");
        password = config.get("password");
        url = "jdbc:mysql://" + config.get("hostname") + ":" + config.get("port") + "/" + config.get("database") + "?useSSL=false";

    }
    
    public void cerrarConexion() {
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                System.out.println("Error al cerrar el lector:" + 
                        ex.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();  
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión:" + 
                        ex.getMessage());
            }
        }
    }
}