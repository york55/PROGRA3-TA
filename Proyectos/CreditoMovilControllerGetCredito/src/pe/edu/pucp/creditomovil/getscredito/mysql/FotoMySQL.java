/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.mysql;

import pe.edu.pucp.creditomovil.getscredito.dao.FotoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.edu.pucp.creditomovil.getscredito.model.Foto;
/**
 *
 * @author diego
 */
public class FotoMySQL implements FotoDAO{
    private Connection conexion;

//    public FotoMySQL(ConexionBD conexionBD) {
//        try {
//            this.conexion = conexionBD.obtenerConexion();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void insertar(Foto foto) {
        String sql = "INSERT INTO fotos (tipoFoto) VALUES (?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, foto.getTipoFoto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Foto foto) {
        String sql = "UPDATE fotos SET tipoFoto = ? WHERE tipoFoto = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, foto.getTipoFoto());
            ps.setInt(2, foto.getTipoFoto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int tipoFoto) {
        String sql = "DELETE FROM fotos WHERE tipoFoto = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, tipoFoto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Foto obtenerPorId(int tipoFoto) {
//        String sql = "SELECT * FROM fotos WHERE tipoFoto = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, tipoFoto);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Foto(rs.getInt("tipoFoto"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public List<Foto> listarTodos() {
//        List<Foto> fotos = new ArrayList<>();
//        String sql = "SELECT * FROM fotos";
//        try (PreparedStatement ps = conexion.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                fotos.add(new Foto(rs.getInt("tipoFoto")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return fotos;
//    } 
}
