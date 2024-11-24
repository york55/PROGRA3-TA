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
import java.sql.Types;
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
    private ResultSet rs = null;

    @Override
    public boolean insertar(Evaluacion evaluacion, int codSup) {
        Connection conn = null;
        CallableStatement csEvaluacion = null;
        CallableStatement csAsociar = null;
        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false); // Deshabilitar autocommit manualmente
            String sql = "{ CALL InsertarEvaluacion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            csEvaluacion = conn.prepareCall(sql);
            Cliente cli = (Cliente) evaluacion.getClienteAsignado();
            csEvaluacion.setInt(1, cli.getCodigoCliente()); // Asegúrate de que clienteAsignado no sea null
            csEvaluacion.setDate(2, new java.sql.Date(evaluacion.getFechaRegistro().getTime()));
            csEvaluacion.setString(3, evaluacion.getNombreNegocio());
            csEvaluacion.setString(4, evaluacion.getDireccionNegocio());
            csEvaluacion.setString(5, evaluacion.getTelefonoNegocio());
            csEvaluacion.setDouble(6, evaluacion.getVentasDiarias());
            csEvaluacion.setDouble(7, evaluacion.getInventario());
            csEvaluacion.setDouble(8, evaluacion.getCostoVentas());
            csEvaluacion.setDouble(9, evaluacion.getMargenGanancia());
            csEvaluacion.setBoolean(10, evaluacion.isActivo());
            csEvaluacion.setDouble(11, evaluacion.getPuntaje());
            csEvaluacion.setString(12, evaluacion.getObservaciones());
            csEvaluacion.registerOutParameter(13, Types.INTEGER);
            csEvaluacion.executeUpdate();
            int numEvaluacion = csEvaluacion.getInt(13);
            evaluacion.setNumeroEvaluacion(numEvaluacion);
            
            // Asociar el evaluacion al supervisor
            String sqlAsociar = "{ CALL AsociarEvaluacionASupervisor(?, ?) }";
            csAsociar = conn.prepareCall(sqlAsociar);
            csAsociar.setInt(1, codSup);
            csAsociar.setInt(2, numEvaluacion);
            csAsociar.execute();

            conn.commit(); // Confirma la transacción
            
            return true;
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revierte la transacción en caso de error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (csEvaluacion != null) {
                    csEvaluacion.close();
                }
                if (csAsociar != null) {
                    csAsociar.close();
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
    public void modificar(Evaluacion evaluacion) {
        CallableStatement cs;
        String query = "{CALL ModificarEvaluacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            Cliente cli = (Cliente) evaluacion.getClienteAsignado();
            cs.setInt(2, cli.getCodigoCliente()); // Asegúrate de que clienteAsignado no sea null
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
        ClienteDAO daoCliente = new ClienteMySQL();
        Evaluacion ev = new Evaluacion();
        CallableStatement cs;
        String query = "{CALL ObtenerEvaluacion(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);

            rs = cs.executeQuery();
            
            if(rs.next()){
                ev.setActivo(true);
                Cliente cli = daoCliente.obtenerPorCodigo(rs.getInt("cliente_codigo_cliente"));
                ev.setClienteAsignado(cli);
                ev.setCostoVentas(rs.getDouble("costo_ventas"));
                ev.setDireccionNegocio(rs.getString("direccion_negocio"));
                ev.setFechaRegistro(rs.getDate("fecha_registro"));
                ev.setInventario(rs.getDouble("inventario"));
                ev.setMargenGanancia(rs.getDouble("margen_ganancia"));
                ev.setNombreNegocio(rs.getString("nombre_negocio"));
                ev.setNumeroEvaluacion(idEvaluacion);
                ev.setObservaciones(rs.getString("observaciones"));
                ev.setPuntaje(rs.getDouble("puntaje"));
                ev.setTelefonoNegocio(rs.getString("telefono_negocio"));
                ev.setVentasDiarias(rs.getDouble("ventas_diarias"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ev;
    }
    
    @Override
    public List<Evaluacion> listarPorSupervisor(int codSup){
        List<Evaluacion> evaluaciones = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarEvaluacionesPorSupervisor(?)}";
        CallableStatement stmtCliente = null;
        
        ClienteDAO clienteDAO = new ClienteMySQL();
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, codSup);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                int numEva = rs.getInt("num_evaluacion");
                int codClien = rs.getInt("cliente_codigo_cliente");
                Cliente cliente = clienteDAO.obtenerPorCodigo(codClien);
                
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
                        cliente, ventasDia, inventario, costoVentas, 
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

    @Override
    public List<Evaluacion> listarTodos() {
        List<Evaluacion> evaluaciones = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarEvaluaciones()}";
        CallableStatement stmtCliente = null;
        
        ClienteDAO clienteDAO = new ClienteMySQL();
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int numEva = rs.getInt("num_evaluacion");
                int codClien = rs.getInt("cliente_codigo_cliente");
                Cliente cliente = clienteDAO.obtenerPorCodigo(codClien);
                
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
                        cliente, ventasDia, inventario, costoVentas, 
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
