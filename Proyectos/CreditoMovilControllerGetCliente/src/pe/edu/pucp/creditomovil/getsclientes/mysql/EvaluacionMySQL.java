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
import pe.edu.pucp.creditomovil.model.Cliente;
import pe.edu.pucp.creditomovil.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;

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
            Cliente cli = (Cliente) evaluacion.getClienteAsignado();
            if(cli.getCodigoCliente()!=null)
                cs.setString(2, cli.getCodigoCliente()); // Asegúrate de que clienteAsignado no sea null
            else cs.setString(2, " ");
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
        CallableStatement stmtCliente = null;
        
        ClienteDAO clienteDAO = new ClienteMySQL();
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int numEva = rs.getInt("num_evaluacion");
                String codClien = rs.getString("cliente_codigo_cliente");
                Cliente cliente = clienteDAO.obtenerPorId(codClien);
                
                Date fechaReg = rs.getDate("fecha_registro");
                String nombreNeg = rs.getString("nombre_negocio");
                String dirNeg = rs.getString("direccion_negocio");
                String telNeg = rs.getString("telefono_negocio");
                double ventasDia = rs.getDouble("ventas_diarias");
                double inventario = rs.getDouble("inventario");
                double costoVentas = rs.getDouble("costo_ventas");
                double margenGan = rs.getDouble("margen_ganancia");
                boolean activo = rs.getBoolean("activo");
                double puntaje = rs.getDouble("puntaje");
                String obser = rs.getString("observaciones");
                        
                Evaluacion eva = new Evaluacion(fechaReg, nombreNeg, dirNeg, telNeg,
                        null, cliente, ventasDia, inventario, costoVentas, 
                        margenGan, numEva, activo, puntaje, obser);
                evaluaciones.add(eva);
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
