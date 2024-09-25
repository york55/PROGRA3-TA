/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.mysql;

import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscredito.dao.FotoDAO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.getscredito.model.Foto;
/**
 *
 * @author diego
 */
public class FotoMySQL implements FotoDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Foto foto) {
        CallableStatement cs;
        String query = "{CALL InsertarFoto(?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,foto.getTipoFoto());
//            cs.setString(2, foto.recuperafoto()); no se como
//            cs.setInt(3, foto.getTransaccion().getnumOperacion());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Foto foto) {
        CallableStatement cs;
        String query = "{CALL ModificarFoto(?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,foto.getTipoFoto());
//            cs.setString(2, foto.recuperafoto()); no se como
//            cs.setInt(3, foto.getTransaccion().getnumOperacion());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int tipoFoto) {
        CallableStatement cs;
        String query = "{CALL EliminarFoto(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, tipoFoto);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Foto obtenerPorId(int tipoFoto) {
        CallableStatement cs;
        String query = "{CALL ObtenerFoto(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, tipoFoto);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Foto> listarTodos() {
        List<Foto> fotos = new ArrayList<>();
        CallableStatement cs;
        String query = "{CALL ListarFotos()}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            resultado = cs.executeUpdate();
            while (rs.next()) {
//                fotos.add(new Foto());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fotos;
    } 
}
