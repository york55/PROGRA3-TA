/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.edu.pucp.creditomovil.rrhh.dao.UsuarioDAO;
import pe.edu.pucp.creditomovil.rrhh.model.Usuario;
/**
 *
 * @author diego
 */
public class UsuarioMySQL implements UsuarioDAO{
   private Connection conexion;

//    public UsuarioMySQL(ConexionBD conexionBD) {
//        try {
//            this.conexion = conexionBD.obtenerConexion();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void insertar(Usuario usuario) {
//        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getCorreo());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void modificar(Usuario usuario) {
//        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE usuario_id = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getCorreo());
//            ps.setInt(3, usuario.getUsuarioId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE usuario_id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Usuario obtenerPorId(int id) {
//        String sql = "SELECT * FROM usuarios WHERE usuario_id = ?";
//        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Usuario(rs.getInt("usuario_id"), rs.getString("nombre"), rs.getString("correo"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public List<Usuario> listarTodos() {
//        List<Usuario> usuarios = new ArrayList<>();
//        String sql = "SELECT * FROM usuarios";
//        try (PreparedStatement ps = conexion.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                usuarios.add(new Usuario(rs.getInt("usuario_id"), rs.getString("nombre"), rs.getString("correo")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return usuarios;
//    }    
}
