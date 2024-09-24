/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
import pe.edu.pucp.creditomovil.getsclientes.model.Evaluacion;
/**
 *
 * @author diego
 */
public class EvaluacionMySQL implements EvaluacionDAO{
private Connection conexion;

//    public EvaluacionMySQL(ConexionBD conexionBD) {
//        try {
//            this.conexion = conexionBD.obtenerConexion();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void insertar(Evaluacion evaluacion) {
//        String sql = "INSERT INTO evaluaciones (puntaje, observaciones) VALUES (?, ?)";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setDouble(1, evaluacion.getPuntaje());
//            ps.setString(2, evaluacion.getObservaciones());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void modificar(Evaluacion evaluacion) {
//        String sql = "UPDATE evaluaciones SET puntaje = ?, observaciones = ? WHERE idEvaluacion = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setDouble(1, evaluacion.getPuntaje());
//            ps.setString(2, evaluacion.getObservaciones());
//            ps.setInt(3, evaluacion.getIdEvaluacion());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void eliminar(int idEvaluacion) {
//        String sql = "DELETE FROM evaluaciones WHERE idEvaluacion = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, idEvaluacion);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public Evaluacion obtenerPorId(int idEvaluacion) {
//        String sql = "SELECT * FROM evaluaciones WHERE idEvaluacion = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, idEvaluacion);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Evaluacion(rs.getInt("idEvaluacion"), rs.getDouble("puntaje"), rs.getString("observaciones"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public List<Evaluacion> listarTodos() {
//        List<Evaluacion> evaluaciones = new ArrayList<>();
//        String sql = "SELECT * FROM evaluaciones";
//        try (PreparedStatement ps = conexion.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                evaluaciones.add(new Evaluacion(rs.getInt("idEvaluacion"), rs.getDouble("puntaje"), rs.getString("observaciones")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return evaluaciones;
//    }
}
