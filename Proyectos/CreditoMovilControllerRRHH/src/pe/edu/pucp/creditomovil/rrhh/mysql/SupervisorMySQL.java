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
            cs = con.prepareCall("{CALL InsertarSupervisor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            // Asignar valores a los parámetros
            cs.setDate(1, new java.sql.Date(supervisor.getFecha().getTime()));
            cs.setString(2, supervisor.getNombre());
            cs.setString(3, supervisor.getApPaterno());
            cs.setString(4, supervisor.getApMaterno());
            cs.setString(5, supervisor.getContrasenha());
            cs.setDate(6, new java.sql.Date(supervisor.getFechaVencimiento().getTime()));
            cs.setString(7, supervisor.getActivo() ? "1" : "0");
            cs.setString(8, supervisor.getCodigoEv());
            cs.setInt(9, supervisor.getCodigoCargo());
            cs.setString(10, supervisor.getAgenciaAsignacion());

            // Ejecutar el procedimiento
            resultado = cs.executeUpdate() > 0;

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
    public boolean modificar(Supervisor supervisor) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ModificarSupervisor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Parámetros para la tabla usuario
            cs.setInt(1, supervisor.getIdUsuario());
            cs.setString(2, supervisor.getCodigoEv());
            cs.setDate(3, new java.sql.Date(supervisor.getFecha().getTime()));
            cs.setString(4, supervisor.getNombre());
            cs.setString(5, supervisor.getApPaterno());
            cs.setString(6, supervisor.getApMaterno());
            cs.setString(7, supervisor.getContrasenha());
            cs.setDate(8, new java.sql.Date(supervisor.getFechaVencimiento().getTime()));
            cs.setBoolean(9, supervisor.getActivo());
            cs.setDate(10, supervisor.getUltimoLogueo() != null ? new java.sql.Date(supervisor.getUltimoLogueo().getTime()) : null);

            // Parámetros para la tabla cliente
            cs.setInt(11, supervisor.getCodigoCargo());
            cs.setString(12, supervisor.getAgenciaAsignacion());

            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
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
    }

    @Override
    public void eliminar(String id) {
        CallableStatement cs;
        String query = "{CALL EliminarSupervisor(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, id);

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
        List<Supervisor> listaSupervisores = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ListarSupervisores() }";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                // Crea un nuevo objeto Cliente y llena sus datos
                Supervisor sup = new Supervisor(
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha"),
                        rs.getString("nombre"),
                        rs.getString("ap_paterno"),
                        rs.getString("ap_materno"),
                        rs.getString("contrasena"),
                        rs.getDate("fecha_venc"),
                        rs.getBoolean("activo"),
                        rs.getString("codigo_sup"),
                        rs.getInt("codigo_cargo"),
                        rs.getString("agencia_asignacion")
                );

                listaSupervisores.add(sup); // Añade el cliente a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        return listaSupervisores;
    }

}
