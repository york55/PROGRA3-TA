/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author diego
 */
public class DBManager {
    private Connection con;
    private static DBManager dbManager;
    private String url = "jdbc:mysql://db-credito-movil-20242.cb8koixgmiui.us-east-1.rds.amazonaws.com:3306/dbcreditomovil";
    private String username = "admin";
    private String password = "creditomovil20242";
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);     
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public static DBManager getInstance(){
        if(dbManager == null){
            createInstance();
        }
        return dbManager;
    }
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
}
