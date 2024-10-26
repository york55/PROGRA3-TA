/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;
import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
/**
 *
 * @author diego
 */
public class EvaluacionMySQL implements EvaluacionDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Evaluacion evaluacion) {
        CallableStatement cs;
        String query = "{CALL InsertarEvaluacion(?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setDate(1, new java.sql.Date(evaluacion.getFechaRegistro().getTime()));
            cs.setString(2,evaluacion.getNombreNegocio());
            cs.setString(3, evaluacion.getDireccionNegocio());
            cs.setString(4,evaluacion.getTelefonoNegocio());
            cs.setDouble(5,evaluacion.getVentasDiarias());
            cs.setDouble(6,evaluacion.getInventario());
            cs.setDouble(7, evaluacion.getCostoVentas());
            cs.setDouble(8, evaluacion.getMargenGanancia());
            if(evaluacion.isActivo()){
                cs.setString(9,"S");
            }else cs.setString(9, "N");
            Cliente cli = (Cliente)evaluacion.getClienteAsignado();
            cs.setString(10, cli.getCodigoCliente());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Evaluacion evaluacion) {
        CallableStatement cs;
        String query = "{CALL ModificarEvaluacion(?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, evaluacion.getNumeroEvaluacion());
            cs.setDate(2, new java.sql.Date(evaluacion.getFechaRegistro().getTime()));
            cs.setString(3,evaluacion.getNombreNegocio());
            cs.setString(4, evaluacion.getDireccionNegocio());
            cs.setString(5,evaluacion.getTelefonoNegocio());
            cs.setDouble(6,evaluacion.getVentasDiarias());
            cs.setDouble(7,evaluacion.getInventario());
            cs.setDouble(8, evaluacion.getCostoVentas());
            cs.setDouble(9, evaluacion.getMargenGanancia());
            if(evaluacion.isActivo()){
                cs.setString(10,"S");
            }else cs.setString(10, "N");
            Cliente cli = (Cliente)evaluacion.getClienteAsignado();
            cs.setString(11, cli.getCodigoCliente());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idEvaluacion) {
        CallableStatement cs;
        String query = "{CALL EliminarEvaluacion(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Evaluacion obtenerPorId(int idEvaluacion) {
        CallableStatement cs;
        String query = "{CALL ObtenerEvaluacion(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idEvaluacion);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Evaluacion> listarTodos() {
        List<Evaluacion> evaluaciones = new ArrayList<>();
        CallableStatement cs;
        String query = "{CALL ListarEvaluaciones()}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            resultado = cs.executeUpdate();
            while (rs.next()) {
//                evaluaciones.add(new Evaluacion(rs.getInt("idEvaluacion"), rs.getDouble("puntaje"), rs.getString("observaciones")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluaciones;
    }
}
