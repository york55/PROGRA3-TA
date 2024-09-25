/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.model.Credito;
import pe.edu.pucp.creditomovil.getsclientes.model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class CreditoMySQL implements CreditoDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public void insertar(Credito credito) {
        CallableStatement cs;
        String query = "{CALL InsertarCredito(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1,credito.getNumCredito());
            cs.setDouble(2, credito.getMonto());
            cs.setDouble(3, credito.getTasaInteres());
            cs.setDate(4, (Date) credito.getFechaOtorgamiento());
//            cs.setString(5, credito.getCliente().getCodigoCliente()); //creo que es asi
            cs.setString(6,credito.getEstado());
            cs.setInt(7, credito.getNumCuotas());
//            cs.setString(8, nose); no se como meter las transacciones xd
//            cs.setString(9, credito.getCliente().getCodigoCliente()); // creo que es asi tmb
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Credito credito) {
        CallableStatement cs;
        String query = "{CALL ModificarCredito(?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1,credito.getNumCredito());
            cs.setDouble(2, credito.getMonto());
            cs.setDouble(3, credito.getTasaInteres());
            cs.setDate(4, (Date) credito.getFechaOtorgamiento());
//            cs.setString(5, credito.getCliente().getCodigoCliente()); //creo que es asi
            cs.setString(6,credito.getEstado());
            cs.setInt(7, credito.getNumCuotas());
//            cs.setString(8, nose); no se como meter las transacciones xd
//            cs.setString(9, credito.getCliente().getCodigoCliente()); // creo que es asi tmb
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String numCredito) {
        CallableStatement cs;
        String query = "{CALL EliminarCredito(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, numCredito);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Credito obtenerPorId(String numCredito) {
        CallableStatement cs;
        String query = "{CALL ObtenerCredito(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, numCredito);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }
    
    public List<Credito> listarTodos() {
        List<Credito> creditos = new ArrayList<>();
        CallableStatement cs;
        String query = "{CALL ListarCreditos()}";
        int resultado = 0;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            resultado = cs.executeUpdate();
            while (rs.next()) {
//                credutos.add(new Credito());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditos;
    }
}
