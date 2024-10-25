/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.rrhh.dao.AdministradorDAO;
import pe.edu.pucp.creditomovil.rrhh.model.Administrador;
/**
 *
 * @author Bleak
 */
public class AdministradorMySQL implements AdministradorDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Administrador administrador) {
        CallableStatement cs;
        String query = "{CALL InsertarAdmin(?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, administrador.getIdUsuario());
            cs.setString(2, administrador.getCodigoAdm());
            cs.setInt(3, administrador.getCodigoCargo());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(int id,Administrador administrador) {
        CallableStatement cs;
        String query = "{CALL ModificarAdmin(?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, administrador.getIdUsuario());
            cs.setString(2, administrador.getCodigoAdm());
            cs.setInt(3, administrador.getCodigoCargo());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String codigoAdmin) {
        CallableStatement cs;
        String query = "{CALL EliminarAdmin(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, codigoAdmin);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Administrador obtenerPorId(String codigoAdmin) {
        CallableStatement cs;
        String query = "{CALL ObtenerAdmin(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, codigoAdmin);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Administrador> listarTodos() {
        List<Administrador> administradores = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarAdmin()}";
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            while (rs.next()) {
                //
                Administrador admin = new Administrador(
                    rs.getInt("usuario_usuario_id"), 
                    new java.util.Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new java.util.Date(), true,
                    rs.getString("codigo_admin"),
                    rs.getInt("codigo_cargo")
                );
                administradores.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(rs != null) rs.close();
                if(cs != null) cs.close();
                if(conexion!=null) conexion.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return administradores;
    }
    
}
