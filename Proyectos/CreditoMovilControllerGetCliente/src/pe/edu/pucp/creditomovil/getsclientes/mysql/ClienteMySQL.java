/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.model.Cliente;
import pe.edu.pucp.creditomovil.model.TipoDocumento;

/**
 *
 * @author Bleak
 */
public class ClienteMySQL implements ClienteDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Cliente cliente) {
        Connection conn = null;
        CallableStatement stmtUsuario = null;
        CallableStatement stmtCliente = null;

        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false); // Inicia una transacción

            // Llamada al procedimiento `InsertarUsuario`
            String sqlInsertarUsuario = "{ CALL InsertarUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?) }";
            stmtUsuario = conn.prepareCall(sqlInsertarUsuario);
            stmtUsuario.setDate(1, new java.sql.Date(cliente.getFecha().getTime()));
            stmtUsuario.setString(2, cliente.getNombre());
            stmtUsuario.setString(3, cliente.getApPaterno());
            stmtUsuario.setString(4, cliente.getApMaterno());
            stmtUsuario.setString(5, cliente.getContrasenha());
            stmtUsuario.setDate(6, new java.sql.Date(cliente.getFechaVencimiento().getTime()));
            stmtUsuario.setBoolean(7, true);
            stmtUsuario.setDate(8, cliente.getUltimoLogueo() != null ? new java.sql.Date(cliente.getUltimoLogueo().getTime()) : null);
            stmtUsuario.setString(9, cliente.getTipoDocumento().name());
            stmtUsuario.setString(10, cliente.getDocumento());
            stmtUsuario.setString(11, cliente.getSalt());
            
            stmtUsuario.registerOutParameter(12, Types.INTEGER); // Para capturar el ID generado
            stmtUsuario.executeUpdate();

            // Obtener el ID generado
            int usuarioId = stmtUsuario.getInt(12);
            cliente.setIdUsuario(usuarioId); // Asignar el ID al objeto cliente

            // Llamada al procedimiento `InsertarCliente`
            String sqlInsertarCliente = "{ CALL InsertarCliente(?, ?, ?, ?, ?, ?, ?) }";
            stmtCliente = conn.prepareCall(sqlInsertarCliente);
            stmtCliente.setInt(1, usuarioId);
            stmtCliente.setString(2, cliente.getDireccion());
            stmtCliente.setString(3, cliente.getTelefono());
            stmtCliente.setString(4, cliente.getEmail());
            stmtCliente.setString(5, cliente.getTipoCliente());
            stmtCliente.setDouble(6, cliente.getRanking());
            stmtCliente.registerOutParameter(7, Types.INTEGER);
            stmtCliente.executeUpdate();
            
            int clienteID = stmtCliente.getInt(7);
            cliente.setCodigoCliente(clienteID);
            
            conn.commit(); // Confirma la transacción
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Deshace la transacción en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (stmtCliente != null) {
                    stmtCliente.close();
                }
                if (stmtUsuario != null) {
                    stmtUsuario.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean modificar(Cliente cliente) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ModificarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Parámetros para la tabla usuario
            cs.setInt(1, cliente.getIdUsuario());
            cs.setInt(2, cliente.getCodigoCliente());
            cs.setDate(3, new java.sql.Date(cliente.getFecha().getTime()));
            cs.setString(4, cliente.getNombre());
            cs.setString(5, cliente.getApPaterno());
            cs.setString(6, cliente.getApMaterno());
            cs.setString(7, cliente.getContrasenha());
            cs.setDate(8, new java.sql.Date(cliente.getFechaVencimiento().getTime()));
            cs.setBoolean(9, cliente.getActivo());
            cs.setDate(10, cliente.getUltimoLogueo() != null ? new java.sql.Date(cliente.getUltimoLogueo().getTime()) : null);
            cs.setString(11, cliente.getTipoDocumento().name());
            cs.setString(12, cliente.getDocumento());
            cs.setString(13, cliente.getSalt());
            // Parámetros para la tabla cliente
            cs.setString(14, cliente.getDireccion());
            cs.setString(15, cliente.getTelefono());
            cs.setString(16, cliente.getEmail());
            cs.setString(17, cliente.getTipoCliente());
            cs.setDouble(18, cliente.getRanking());

            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean eliminar(int id) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL EliminarCliente(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);

            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Cliente obtenerPorCodigo(int cod) {
        Cliente cli = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerClientePorCod(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, cod);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                String tipoDocStr = rs.getString("tipo_doc");
                if(tipoDocStr ==null) tipoDocStr = "DNI"; //Por defecto es peruano
                TipoDocumento tipoDoc = null;
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) { 
                    System.out.println("Error: " + e);
                }
                cli = new Cliente(
                    rs.getInt("usuario_id"),
                    rs.getDate("fecha"),
                    rs.getString("nombre"),
                    rs.getString("ap_paterno"),
                    rs.getString("ap_materno"),
                    rs.getString("contrasena"),
                    rs.getDate("fecha_venc"),
                    rs.getBoolean("activo"),
                    tipoDoc,
                    rs.getString("documento"),
                    rs.getString("salt"),
                    rs.getInt("codigo_cliente"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("tipo_cliente"),
                    rs.getDouble("ranking")
                );
            }else{
                System.out.println("No se encontró el cliente");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cli;
    }
    
    @Override
    public Cliente obtenerPorDocIdentidad(String docIden, String tipoDocIden) {
        Cliente cli = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerClientePorDocIdentidad(?, ?) }";
            cs = conn.prepareCall(sql);
            cs.setString(1, docIden);
            cs.setString(2, tipoDocIden);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                String tipoDocStr = rs.getString("tipo_doc");
                if(tipoDocStr ==null) tipoDocStr = "DNI"; //Por defecto es peruano
                TipoDocumento tipoDoc = null;
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) { 
                    System.out.println("Error: " + e);
                }
                cli = new Cliente(
                    rs.getInt("usuario_id"),
                    rs.getDate("fecha"),
                    rs.getString("nombre"),
                    rs.getString("ap_paterno"),
                    rs.getString("ap_materno"),
                    rs.getString("contrasena"),
                    rs.getDate("fecha_venc"),
                    rs.getBoolean("activo"),
                    tipoDoc,
                    rs.getString("documento"),
                    rs.getString("salt"),
                    rs.getInt("codigo_cliente"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("tipo_cliente"),
                    rs.getDouble("ranking")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cli; 
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> listaClientes = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ListarClientes() }";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                // Crea un nuevo objeto Cliente y llena sus datos
                
                String tipoDocStr = rs.getString("tipo_doc");
                if(tipoDocStr ==null) tipoDocStr = "DNI"; //Por defecto es peruano
                TipoDocumento tipoDoc = null;
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) { 
                    System.out.println("Error: " + e);
                }
                Cliente cliente = new Cliente(
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha"),
                        rs.getString("nombre"),
                        rs.getString("ap_paterno"),
                        rs.getString("ap_materno"),
                        rs.getString("contrasena"),
                        rs.getDate("fecha_venc"),
                        rs.getBoolean("activo"),
                        tipoDoc,
                        rs.getString("documento"),
                        rs.getString("salt"),
                        rs.getInt("codigo_cliente"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("tipo_cliente"),
                        rs.getDouble("ranking")
                );

                listaClientes.add(cliente); // Añade el cliente a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaClientes;
    }

    @Override
    public List<Cliente> listarClientesPorNombre(String nombre) {
        List<Cliente> listaClientes = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ListarClientesPorNombre(?) }";
            cs = conn.prepareCall(sql);
            cs.setString(1, nombre);
            rs = cs.executeQuery();

            while (rs.next()) {
                // Crea un nuevo objeto Cliente y llena sus datos
                
                String tipoDocStr = rs.getString("tipo_doc");
                if(tipoDocStr ==null) tipoDocStr = "DNI"; //Por defecto es peruano
                TipoDocumento tipoDoc = null;
                try {
                    tipoDoc = TipoDocumento.valueOf(tipoDocStr);
                } catch (IllegalArgumentException e) { 
                    System.out.println("Error: " + e);
                }
                Cliente cliente = new Cliente(
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha"),
                        rs.getString("nombre"),
                        rs.getString("ap_paterno"),
                        rs.getString("ap_materno"),
                        rs.getString("contrasena"),
                        rs.getDate("fecha_venc"),
                        rs.getBoolean("activo"),
                        tipoDoc,
                        rs.getString("documento"),
                        rs.getString("salt"),
                        rs.getInt("codigo_cliente"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("tipo_cliente"),
                        rs.getDouble("ranking")
                );

                listaClientes.add(cliente); // Añade el cliente a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaClientes;
    }
}
