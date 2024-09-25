/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscredito.model.Transaccion;
/**
 *
 * @author diego
 */
public class TransaccionMySQL implements TransaccionDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Transaccion transaccion) {
        CallableStatement cs;
        String query = "{CALL InsertarTransaccion(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setDate(1, (Date) transaccion.getFecha());
            cs.setString(2, transaccion.getConcepto());
            cs.setDouble(3, transaccion.getMonto());
            if(transaccion.isAnulado()) cs.setString(4, "S");
            else cs.setString(4,"N");
//            cs.setString(5, transaccion.getUsuarioRegistrado().getClienteCodigo());
            cs.setString(6, transaccion.getAgencia());
//            cs.setString(7, transaccion.getCredito().getNumCredito());
//            cs.setString(8, transaccion.getUsuarioRegistrado().getClienteCodigo());
            cs.setInt(9,transaccion.getNumOperacion());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Transaccion transaccion) {
        CallableStatement cs;
        String query = "{CALL ModificarTransaccion(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,transaccion.getNumOperacion());
            cs.setDate(2, (Date) transaccion.getFecha());
            cs.setString(3, transaccion.getConcepto());
            cs.setDouble(4, transaccion.getMonto());
            if(transaccion.isAnulado()) cs.setString(5, "S");
            else cs.setString(5,"N");
//            cs.setString(6, transaccion.getUsuarioRegistrado().getClienteCodigo());
            cs.setString(7, transaccion.getAgencia());
//            cs.setString(8, transaccion.getCredito().getNumCredito());
//            cs.setString(9, transaccion.getUsuarioRegistrado().getClienteCodigo());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int numOperacion) {
        CallableStatement cs;
        String query = "{CALL EliminarTransaccion(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, numOperacion);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaccion obtenerPorId(int numOperacion) {
        CallableStatement cs;
        String query = "{CALL ObtenerTransaccion(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, numOperacion);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Transaccion> listarTodos() {
        List<Transaccion> transacciones = new ArrayList<>();
        CallableStatement cs;
        String query = "{CALL ListarTransacciones()}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            resultado = cs.executeUpdate();
            while (rs.next()) {
//                transacciones.add(new Foto());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
}
