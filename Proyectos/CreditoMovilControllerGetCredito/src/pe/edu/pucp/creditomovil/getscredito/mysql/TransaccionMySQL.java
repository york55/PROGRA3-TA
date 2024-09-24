/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.mysql;

import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.edu.pucp.creditomovil.getscredito.model.Transaccion;
/**
 *
 * @author diego
 */
public class TransaccionMySQL implements TransaccionDAO{
    private Connection conexion;

//    public TransaccionMySQL(ConexionBD conexionBD) {
//        try {
//            this.conexion = conexionBD.obtenerConexion();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void insertar(Transaccion transaccion) {
        String sql = "INSERT INTO transacciones (fecha, concepto, monto, anulado, usuarioRegistrado, agencia) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(transaccion.getFecha().getTime()));
            ps.setString(2, transaccion.getConcepto());
            ps.setDouble(3, transaccion.getMonto());
            ps.setBoolean(4, transaccion.isAnulado());
            //ps.setString(5, transaccion.getUsuarioRegistrado().getNombre());
            ps.setString(6, transaccion.getAgencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Transaccion transaccion) {
        String sql = "UPDATE transacciones SET concepto = ?, monto = ?, anulado = ? WHERE numOperacion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, transaccion.getConcepto());
            ps.setDouble(2, transaccion.getMonto());
            ps.setBoolean(3, transaccion.isAnulado());
            ps.setInt(4, transaccion.getNumOperacion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int numOperacion) {
        String sql = "DELETE FROM transacciones WHERE numOperacion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numOperacion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Transaccion obtenerPorId(int numOperacion) {
//        String sql = "SELECT * FROM transacciones WHERE numOperacion = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, numOperacion);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Transaccion(rs.getDate("fecha"), rs.getString("concepto"), rs.getDouble("monto"),
//                        rs.getBoolean("anulado"), new Usuario(rs.getString("usuarioRegistrado")), rs.getString("agencia"), numOperacion);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public List<Transaccion> listarTodos() {
//        List<Transaccion> transacciones = new ArrayList<>();
//        String sql = "SELECT * FROM transacciones";
//        try (PreparedStatement ps = conexion.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                transacciones.add(new Transaccion(rs.getDate("fecha"), rs.getString("concepto"), rs.getDouble("monto"),
//                        rs.getBoolean("anulado"), new Usuario(rs.getString("usuarioRegistrado")), rs.getString("agencia"), rs.getInt("numOperacion")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return transacciones;
//    }
}
