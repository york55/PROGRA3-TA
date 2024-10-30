/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;
import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;

/**
 *
 * @author diego
 */
public class EvaluacionMySQL implements EvaluacionDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Evaluacion evaluacion) {
        Connection conn = null;
        CallableStatement cs = null;
        boolean resultado = false;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL InsertarEvaluacion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Configura los parámetros
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            cs.setString(2, " "); // Asegúrate de que clienteAsignado no sea null
            cs.setDate(3, new java.sql.Date(evaluacion.getFechaRegistro().getTime()));
            cs.setString(4, evaluacion.getNombreNegocio());
            cs.setString(5, evaluacion.getDireccionNegocio());
            cs.setString(6, evaluacion.getTelefonoNegocio());
            cs.setDouble(7, evaluacion.getVentasDiarias());
            cs.setDouble(8, evaluacion.getInventario());
            cs.setDouble(9, evaluacion.getCostoVentas());
            cs.setDouble(10, evaluacion.getMargenGanancia());
            cs.setBoolean(11, evaluacion.isActivo());
            cs.setDouble(12, evaluacion.getPuntaje());
            cs.setString(13, evaluacion.getObservaciones());

            // Ejecuta la consulta
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        return resultado;
    }

    @Override
    public void modificar(Evaluacion evaluacion) {
        CallableStatement cs;
        String query = "{CALL ModificarEvaluacion(?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            cs.setDate(2, new java.sql.Date(evaluacion.getFechaRegistro().getTime()));
            cs.setString(3, evaluacion.getNombreNegocio());
            cs.setString(4, evaluacion.getDireccionNegocio());
            cs.setString(5, evaluacion.getTelefonoNegocio());
            cs.setDouble(6, evaluacion.getVentasDiarias());
            cs.setDouble(7, evaluacion.getInventario());
            cs.setDouble(8, evaluacion.getCostoVentas());
            cs.setDouble(9, evaluacion.getMargenGanancia());
            if (evaluacion.isActivo()) {
                cs.setString(10, "S");
            } else {
                cs.setString(10, "N");
            }
            Cliente cli = (Cliente) evaluacion.getClienteAsignado();
            cs.setString(11, cli.getCodigoCliente());

            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idEvaluacion) {
        CallableStatement cs;
        String query = "{CALL EliminarEvaluacion(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);

            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Evaluacion obtenerPorId(int idEvaluacion) {
        CallableStatement cs;
        String query = "{CALL ObtenerEvaluacion(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);

            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Evaluacion> listarTodos() {
        List<Evaluacion> evaluaciones = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarEvaluaciones()}";
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                //
//                Evaluacion eva = new Evaluacion(
//                    rs.getDate("fecha_registro"), 
//                    rs.getString("nombre_negocio"),
//                    rs.getString("direccion_negocio"),                   
//                    rs.getString("telefono_negocio"),               
//                    rs.getDouble("ventas_diarias"),               
//                    rs.getDouble("inventario"),                       
//                    rs.getDouble("costo_ventas"),          
//                    rs.getDouble("margen_ganancia"),      
//                    rs.getInt("numero_evaluacion"),
//                    rs.getString("activo").equals("S"),
//                    rs.getString("cliente_codigo_cliente")
//                );
//                evaluaciones.add(eva);
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
        return evaluaciones;
    }
}
