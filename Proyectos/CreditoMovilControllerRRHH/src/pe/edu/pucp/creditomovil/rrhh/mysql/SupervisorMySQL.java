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
import java.sql.Types;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.rrhh.dao.SupervisorDAO;
import pe.edu.pucp.creditomovil.model.Supervisor;
import pe.edu.pucp.creditomovil.model.TipoDocumento;

/**
 *
 * @author diego
 */
public class SupervisorMySQL implements SupervisorDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Supervisor supervisor) {
        Connection con = null;
        CallableStatement cs = null;
        boolean resultado = false;

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL InsertarSupervisor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            // Asignar valores a los parámetros
            cs.setDate(1, new java.sql.Date(supervisor.getFecha().getTime()));
            cs.setString(2, supervisor.getNombre());
            cs.setString(3, supervisor.getApPaterno());
            cs.setString(4, supervisor.getApMaterno());
            cs.setString(5, supervisor.getContrasenha());
            cs.setDate(6, new java.sql.Date(supervisor.getFechaVencimiento().getTime()));
            cs.setString(7, supervisor.getActivo()? "1" : "0");
            
            cs.setString(8, supervisor.getTipoDocumento().name());
            cs.setString(9, supervisor.getDocumento());
            cs.setString(10, supervisor.getSalt());
            
            
            cs.setInt(11, supervisor.getCodigoCargo());
            cs.setString(12, supervisor.getAgenciaAsignacion());
            cs.registerOutParameter(13, Types.INTEGER);
            // Ejecutar el procedimiento
            resultado = cs.executeUpdate() > 0;
            int supervisorID = cs.getInt(13);
            supervisor.setCodigoEv(supervisorID);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void modificar(int id, Supervisor supervisor) {
        CallableStatement cs;
        String query = "{CALL ModificarSupervisor(?,?,?,?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, id);
            cs.setInt(2, supervisor.getCodigoEv());
            cs.setInt(3, supervisor.getCodigoCargo());
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
    public Supervisor obtenerPorDocIdentidad(String docIden, String tipoDocIden) {
        Supervisor sup = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerSupervisorPorDocIdentidad(?, ?) }";
            cs = conn.prepareCall(sql);
            cs.setString(1, docIden);
            cs.setString(2, tipoDocIden);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                String tipoDocStr = rs.getString("tipo_doc");
                if(tipoDocStr ==null) tipoDocStr = "DNI"; //Por defecto es peruano
                TipoDocumento tipoDoc = null;
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) { 
                    System.out.println("Error: " + e);
                }
                sup = new Supervisor(
                    rs.getInt("usuario_id"),
                    rs.getDate("fecha"),
                    rs.getString("nombre"),
                    rs.getString("ap_paterno"),
                    rs.getString("ap_materno"),
                    rs.getString("contrasena"),
                    rs.getDate("fecha_venc"),
                    rs.getBoolean("activo"),
                    tipoDoc,
                    rs.getString("documento"),
                    rs.getString("salt"),
                    rs.getInt("codigo_sup"),
                    rs.getInt("codigo_cargo"),
                    rs.getString("agencia_asignacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return sup; 
    }

    @Override
    public List<Supervisor> listarTodos() {
        List<Supervisor> supervisores = new ArrayList<>();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            String query = "{CALL ListarSupervisores()}";
            cs = conexion.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                
                String tipoDocStr = rs.getString("tipo_doc");
                TipoDocumento tipoDoc; 
                // es un enum asi que toca hacer el cambio de string a enum
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) {
                    tipoDoc = TipoDocumento.DNI; // solo como manejo básico
                }
                
                Supervisor supervisor = new Supervisor(
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha"),
                        rs.getString("nombre"),
                        rs.getString("ap_paterno"),
                        rs.getString("ap_materno"),
                        rs.getString("contrasena"),
                        rs.getDate("fecha_venc"),
                        rs.getBoolean("activo"),
                        tipoDoc,
                        rs.getString("documento"),
                        rs.getString("salt"),
                        rs.getInt("codigo_sup"),
                        rs.getInt("codigo_cargo"),
                        rs.getString("agencia_asignacion")
                );
                supervisores.add(supervisor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return supervisores;
    }

}
