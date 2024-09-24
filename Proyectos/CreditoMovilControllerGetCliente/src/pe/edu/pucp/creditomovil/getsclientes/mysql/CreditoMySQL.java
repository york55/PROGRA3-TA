/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.model.Credito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class CreditoMySQL implements CreditoDAO{
    private Connection conexion;

//    public CreditoMySQL(ConexionBD conexionBD) {
//        try {
//            this.conexion = conexionBD.obtenerConexion();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void insertar(Credito credito) {
        String sql = "INSERT INTO creditos (numCredito, monto, tasaInteres) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, credito.getNumCredito());
            ps.setDouble(2, credito.getMonto());
            ps.setDouble(3, credito.getTasaInteres());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Credito credito) {
        String sql = "UPDATE creditos SET monto = ?, tasaInteres = ? WHERE numCredito = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, credito.getMonto());
            ps.setDouble(2, credito.getTasaInteres());
            ps.setString(3, credito.getNumCredito());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String numCredito) {
        String sql = "DELETE FROM creditos WHERE numCredito = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, numCredito);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Credito obtenerPorId(String numCredito) {
//        String sql = "SELECT * FROM creditos WHERE numCredito = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setString(1, numCredito);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Credito(rs.getString("numCredito"), rs.getDouble("monto"), rs.getDouble("tasaInteres"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
//    public List<Credito> listarTodos() {
//        List<Credito> creditos = new ArrayList<>();
//        String sql = "SELECT * FROM creditos";
//        try (PreparedStatement ps = conexion.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                creditos.add(new Credito(rs.getString("numCredito"), rs.getDouble("monto"), rs.getDouble("tasaInteres")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return creditos;
//    }
}
