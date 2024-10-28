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
import pe.edu.pucp.creditomovil.rrhh.model.Supervisor;

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
        CallableStatement csAsociar = null;
        boolean resultado = false;
        
        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false);
            
            String sql = "{ CALL InsertarEvaluacion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Configura los parámetros
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            Cliente cliente = (Cliente)evaluacion.getClienteAsignado();
            if(cliente.getCodigoCliente()!=null)
                cs.setString(2, cliente.getCodigoCliente()); // Asegúrate de que clienteAsignado no sea null
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
            cs.execute();
            
            String sqlAsociar = "{ CALL AsociarEvaluacionASupervisor(?, ?) }";
            Supervisor supervisor = (Supervisor)evaluacion.getevaluador();
            csAsociar = conn.prepareCall(sqlAsociar);
            csAsociar.setString(1, supervisor.getCodigoEv());
            csAsociar.setInt(2, evaluacion.getNumeroEvaluacion());
            csAsociar.execute();
            
            conn.commit();
            resultado = true;
            
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revierte la transacción en caso de error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            ex.printStackTrace();
        } finally {
            try {
                if (csAsociar != null) {
                    csAsociar.close();
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
        return resultado;
    }

    @Override
    public boolean modificar(Evaluacion evaluacion) {
        CallableStatement cs = null;
        String query = "{CALL ModificarEvaluacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            Cliente cli = (Cliente) evaluacion.getClienteAsignado();
            cs.setString(2, cli.getCodigoCliente());
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
            

            resultado = cs.executeUpdate() > 0;
        }  catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public boolean eliminar(int idEvaluacion) {
        CallableStatement cs=null;
        String query = "{CALL EliminarEvaluacion(?)}";
        boolean resultado =false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);

            resultado = cs.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return resultado;
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
            
            //se debe anadir el buscar cliente por codigo para insercion completea del cliente
            while (rs.next()) { 
                int numero_eva = rs.getInt("num_evaluacion");
                String codigo_clien = rs.getString("cliente_codigo_cliente");
                Cliente cliente = new Cliente(0,null, null, null, null, null, null, true, codigo_clien, null, null, null, null);
                Date fecha = rs.getDate("fecha_registro");
                String nombreNeg = rs.getString("nombre_negocio");
                String direccion = rs.getString("direccion_negocio");
                String telefono = rs.getString("telefono_negocio");
                double ventas = rs.getDouble("ventas_diarias");
                double inventario = rs.getDouble("inventario");
                double costo = rs.getDouble("costo_ventas");
                double margen = rs.getDouble("margen_ganancia");
                boolean activo = rs.getBoolean("activo");
                double puntaje = rs.getDouble("puntaje");
                String observaciones = rs.getString("observaciones");
                
                Evaluacion eva = new Evaluacion(fecha,nombreNeg,direccion,telefono,null,cliente,
                        ventas,inventario,costo,margen,0,0,numero_eva,activo,puntaje,observaciones);
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
