/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import java.sql.Connection;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.model.Credito;

/**
 *
 * @author diego
 */
public class CreditoMySQL implements CreditoDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Credito credito, int codigoCliente) {
        Connection conn = null;
        CallableStatement csCredito = null;
        CallableStatement csAsociar = null;

        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false); // Inicia una transacción

            // Insertar en la tabla credito
            String sqlCredito = "{ CALL InsertarCredito(?, ?, ?, ?, ?, ?, ?, ?) }";
            csCredito = conn.prepareCall(sqlCredito);
            csCredito.setDouble(1, credito.getMonto());
            csCredito.setDouble(2, credito.getTasaInteres());
            csCredito.setDate(3, new java.sql.Date(credito.getFechaOtorgamiento().getTime()));
            csCredito.setString(4, credito.getEstado());
            csCredito.setInt(5, credito.getNumCuotas());
            csCredito.setBoolean(6, credito.isCancelado());
            csCredito.setString(7, credito.getMotivo());
            csCredito.registerOutParameter(8, Types.INTEGER);
            csCredito.executeUpdate();
            int creditoID = csCredito.getInt(8);
            credito.setNumCredito(creditoID);
            
            // Asociar el crédito al cliente
            String sqlAsociar = "{ CALL AsociarCreditoACliente(?, ?) }";
            csAsociar = conn.prepareCall(sqlAsociar);
            csAsociar.setInt(1, creditoID);
            csAsociar.setInt(2, codigoCliente);
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
                if (csAsociar != null) {
                    csAsociar.close();
                }
                if (csCredito != null) {
                    csCredito.close();
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
    public boolean modificar(Credito credito) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ModificarCredito(?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            cs.setInt(1, credito.getNumCredito());
            cs.setDouble(2, credito.getMonto());
            cs.setDouble(3, credito.getTasaInteres());
            cs.setDate(4, new java.sql.Date(credito.getFechaOtorgamiento().getTime()));
            cs.setString(5, credito.getEstado());
            cs.setInt(6, credito.getNumCuotas());
            cs.setBoolean(7, credito.isCancelado());
            cs.setString(8, credito.getMotivo());

            cs.execute();
            return true;
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
    public void eliminar(int numCredito) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL EliminarCredito(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, numCredito);
            cs.execute();
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
    }

    @Override
    public Credito obtenerPorId(int numCredito) {
        Credito cred = new Credito();
        CallableStatement cs;
        String query = "{CALL ObtenerCredito(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, numCredito);

            rs = cs.executeQuery();
            if(rs.next()){
                cred.setEstado(rs.getString("estado"));
                cred.setFechaOtorgamiento(rs.getDate("fecha_otorgamiento"));
                cred.setMonto(rs.getDouble("monto"));
                cred.setNumCredito(rs.getInt("num_credito"));
                cred.setNumCuotas(rs.getInt("num_cuotas"));
                cred.setTasaInteres(rs.getDouble("tasa_interes"));
                cred.setCancelado(rs.getBoolean("cancelado"));
                cred.setMotivo(rs.getString("motivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cred;
    }
    
    @Override
    public List<Credito> listarTodosFiltros(int cliId, Date fechaini, Date fechafin, String estado){
        List<Credito> listaCreditos = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;          
        
        try{
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerCreditosPorClienteFecha(?, ?, ?, ?) }";

            java.sql.Date fechainiSQL = new java.sql.Date(fechaini.getTime());
            java.sql.Date fechafinSQL = new java.sql.Date(fechafin.getTime());

        
        
            cs = conn.prepareCall(sql);
            cs.setInt(1, cliId);
            cs.setDate(2, fechainiSQL);
            cs.setDate(3, fechafinSQL);
            cs.setString(4, estado);
            rs = cs.executeQuery();
            
            
            while (rs.next()) {
                int numCredito = rs.getInt("num_credito");
                double monto = rs.getDouble("monto");
                double tasaInteres = rs.getDouble("tasa_interes");
                Date fechaOtorgamiento = rs.getDate("fecha_otorgamiento");
                String est = rs.getString("estado");
                int numCuotas = rs.getInt("num_cuotas");
                boolean cancelado = rs.getBoolean("cancelado");
                String motivo = rs.getString("motivo");
                // Crear el objeto Credito. Nota que el cliente es null por simplicidad
                Credito credito = new Credito(numCredito, monto, tasaInteres, fechaOtorgamiento, est, numCuotas,cancelado, motivo);
                listaCreditos.add(credito);
            }
            
        }catch (SQLException ex){
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
        return listaCreditos;
    }


    public List<Credito> listarTodos() {
        List<Credito> listaCreditos = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ListarCreditos() }";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                int numCredito = rs.getInt("num_credito");
                double monto = rs.getDouble("monto");
                double tasaInteres = rs.getDouble("tasa_interes");
                Date fechaOtorgamiento = rs.getDate("fecha_otorgamiento");
                String estado = rs.getString("estado");
                int numCuotas = rs.getInt("num_cuotas");
                boolean cancelado = rs.getBoolean("cancelado");
                String motivo = rs.getString("motivo");
                // Crear el objeto Credito. Nota que el cliente es null por simplicidad
                Credito credito = new Credito(numCredito, monto, tasaInteres, fechaOtorgamiento, estado, numCuotas,cancelado, motivo);
                listaCreditos.add(credito);
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

        return listaCreditos;
    }
    
    public List<Credito> listarCredPendPorCliente(int codCliente){
        List<Credito> listaCreditos = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerCreditosPendientesPorCliente(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, codCliente);
            rs = cs.executeQuery();

            while (rs.next()) {
                int numCredito = rs.getInt("num_credito");
                double monto = rs.getDouble("monto");
                double tasaInteres = rs.getDouble("tasa_interes");
                Date fechaOtorgamiento = rs.getDate("fecha_otorgamiento");
                String estado = rs.getString("estado");
                int numCuotas = rs.getInt("num_cuotas");
                boolean cancelado = rs.getBoolean("cancelado");
                String motivo = rs.getString("motivo");
                // Crear el objeto Credito. Nota que el cliente es null por simplicidad
                Credito credito = new Credito(numCredito, monto, tasaInteres, fechaOtorgamiento, estado, numCuotas,cancelado, motivo);
                listaCreditos.add(credito);
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

        return listaCreditos;
    }
}
