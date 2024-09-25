/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.rrhh.dao.UsuarioDAO;
import pe.edu.pucp.creditomovil.rrhh.model.Usuario;
/**
 *
 * @author diego
 */
public class UsuarioMySQL implements UsuarioDAO{
   private Connection conexion;
   private ResultSet rs;

    @Override
    public void insertar(Usuario usuario) {
        CallableStatement cs;
        String query = "{CALL InsertarUsuario(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setDate(1, (Date) usuario.getFecha());
            cs.setString(2, usuario.getNombre());
            cs.setString(3,usuario.getApPaterno());
            cs.setString(4,usuario.getApMaterno());
            cs.setString(5, usuario.getContrasenha());
            cs.setDate(6, (Date) usuario.getFechaVencimiento());
            if(usuario.getActivo()) cs.setString(7,"S");
            else cs.setString(7,"N");
            cs.setDate(8, (Date) usuario.getUltimoLogueo());
//            cs.setString(9,usuario.getClase???)
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Usuario usuario) {
        CallableStatement cs;
        String query = "{CALL ModificarUsuario(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setDate(1, (Date) usuario.getFecha());
            cs.setString(2, usuario.getNombre());
            cs.setString(3,usuario.getApPaterno());
            cs.setString(4,usuario.getApMaterno());
            cs.setString(5, usuario.getContrasenha());
            cs.setDate(6, (Date) usuario.getFechaVencimiento());
            if(usuario.getActivo()) cs.setString(7,"S");
            else cs.setString(7,"N");
            cs.setDate(8, (Date) usuario.getUltimoLogueo());
//            cs.setString(9,usuario.getClase???)
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        CallableStatement cs;
        String query = "{CALL EliminarUsuario(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, id);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        CallableStatement cs;
        String query = "{CALL ObtenerUsuario(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, id);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        CallableStatement cs;
        String query = "{CALL ListarUsuarios()}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            resultado = cs.executeUpdate();
            while (rs.next()) {
//                usuarios.add(new Usuario());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }    
}
