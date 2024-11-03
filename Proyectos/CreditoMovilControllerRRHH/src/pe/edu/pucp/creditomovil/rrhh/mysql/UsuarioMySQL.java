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
import pe.edu.pucp.creditomovil.model.Supervisor;
import pe.edu.pucp.creditomovil.model.TipoDocumento;
import pe.edu.pucp.creditomovil.model.Usuario;
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
        String query = "{CALL InsertarUsuario(?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setDate(1, new Date(usuario.getFecha().getTime()));
            cs.setString(2, usuario.getNombre());
            cs.setString(3,usuario.getApPaterno());
            cs.setString(4,usuario.getApMaterno());
            cs.setString(5, usuario.getContrasenha());
            cs.setDate(6, new Date(usuario.getFechaVencimiento().getTime()));
            if(usuario.getActivo()) cs.setString(7,"S");
            else cs.setString(7,"N");
            cs.setDate(8, usuario.getUltimoLogueo() != null ? new Date(usuario.getUltimoLogueo().getTime()) : new Date(System.currentTimeMillis()));
            cs.setString(9, usuario.getTipoDocumento().name());
            cs.setString(10, usuario.getDocumento());
            cs.setBoolean(11,false);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public void modificar(int id,Usuario usuario) {
        CallableStatement cs;
        String query = "{CALL ModificarUsuario(?,?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, id);
            cs.setDate(2, new Date(usuario.getFecha().getTime()));
            cs.setString(3, usuario.getNombre());
            cs.setString(4,usuario.getApPaterno());
            cs.setString(5,usuario.getApMaterno());
            cs.setString(6, usuario.getContrasenha());
            cs.setDate(7, new Date(usuario.getFechaVencimiento().getTime()));
            if(usuario.getActivo()) cs.setString(8,"S");
            else cs.setString(8,"N");
            cs.setDate(9, usuario.getUltimoLogueo() != null ? new Date(usuario.getUltimoLogueo().getTime()) : new Date(System.currentTimeMillis()));
            cs.setBoolean(10,false);
            cs.setString(11, usuario.getTipoDocumento().name());
            cs.setString(12, usuario.getDocumento());
            
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
        CallableStatement cs = null;
        String query = "{CALL ListarUsuarios()}";
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            while (rs.next()) {
                
                String tipoDocStr = rs.getString("tipo_doc");
                TipoDocumento tipoDoc; 
                
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) {
                    tipoDoc = TipoDocumento.OTRO; // solo como manejo básico
                }
                
                Usuario usuario = new Supervisor(
                    rs.getInt("usuario_id"), 
                    rs.getDate("fecha"),
                    rs.getString("nombre"),                   // Columna 'nombre'
                    rs.getString("ap_paterno"),               // Columna 'ap_paterno'
                    rs.getString("ap_materno"),               // Columna 'ap_materno'
                    rs.getString("contrasena"),               // Columna 'contrasena'             
                    rs.getDate("fecha_venc"),          // Columna 'fecha_vencimiento'
                    rs.getString("activo").equals("S"),       // Convertimos "S" o "N" a booleano
                    tipoDoc,
                    rs.getString("documento"),
                    "A",1,"SUP123"
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(rs != null) rs.close();
                if(cs != null) cs.close();
                if(conexion!=null) conexion.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return usuarios;
    }    
}
