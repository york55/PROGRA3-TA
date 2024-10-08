/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.rrhh.dao.SupervisorDAO;
import pe.edu.pucp.creditomovil.rrhh.model.Supervisor;

/**
 *
 * @author diego
 */
public class SupervisorMySQL implements SupervisorDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Supervisor supervisor) {
        CallableStatement cs;
        String query = "{CALL InsertarSupervisor(?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,supervisor.getIdUsuario());
            cs.setString(2,supervisor.getCodigoEv());
            cs.setInt(3,supervisor.getCodigoCargo());
            cs.setString(4, supervisor.getAgenciaAsignacion());
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(int id,Supervisor supervisor) {
        CallableStatement cs;
        String query = "{CALL ModificarSupervisor(?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,id);
            cs.setString(2,supervisor.getCodigoEv());
            cs.setInt(3,supervisor.getCodigoCargo());
            cs.setString(4, supervisor.getAgenciaAsignacion());
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int usuarioId) {
        CallableStatement cs;
        String query = "{CALL EliminarSupervisor(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, usuarioId);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Supervisor obtenerPorId(int usuarioId) {
        CallableStatement cs;
        String query = "{CALL ObtenerSupervisor(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, usuarioId);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Supervisor> listarTodos() {
        List<Supervisor> supervisores = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarSupervisores()}";
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            while (rs.next()) {
                //
                Supervisor supervisor = new Supervisor(
                    rs.getInt("usuario_usuario_id"), 
                    new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new Date(), true,
                    rs.getString("codigo_sup"),
                    rs.getInt("codigo_cargo"),
                    rs.getString("agencia_asignacion")
                );
                supervisores.add(supervisor);
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
        return supervisores;
    }
  
}
