/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;
/**
 *
 * @author Bleak
 */
public class ClienteMySQL implements ClienteDAO{
   private Connection conexion;
   private ResultSet rs;

    @Override
    public void insertar(Cliente cliente) {
        CallableStatement cs;
        String query = "{CALL InsertarCliente(?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1,cliente.getIdUsuario());
            cs.setString(2, cliente.getCodigoCliente());
            cs.setString(3,cliente.getDireccion());
            cs.setString(4,cliente.getTelefono());
            cs.setString(5, cliente.getEmail());
            cs.setString(6, cliente.getTipoCliente());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public void modificar(int id,Cliente cliente) {
        CallableStatement cs;
        String query = "{CALL ModificarCliente(?,?,?,?,?,?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, cliente.getCodigoCliente());
            cs.setInt(2, cliente.getIdUsuario());
            cs.setString(3,cliente.getDireccion());
            cs.setString(4,cliente.getTelefono());
            cs.setString(5, cliente.getEmail());
            cs.setString(6, cliente.getTipoCliente());
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        CallableStatement cs;
        String query = "{CALL EliminarCliente(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, id);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerPorId(String id) {
        CallableStatement cs;
        String query = "{CALL ObtenerCliente(?)}";
        int resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, id);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; //por ahora es null, necesito ver qué añadirle
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarClientes()}";
        ResultSet rs = null;
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            while (rs.next()) {
                //
                Cliente cliente = new Cliente(
                    rs.getInt("usuario_usuario_id"), 
                    new java.util.Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new java.util.Date(), true,
                    rs.getString("codigo_cliente"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("tipo_cliente")
                );
                clientes.add(cliente);
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
        return clientes;
    }  
}
