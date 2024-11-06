package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscredito.dao.BancoDAO;
import pe.edu.pucp.creditomovil.model.Banco;

public class BancoMySQL implements BancoDAO{
    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Banco banco) {
        Connection conn = null;
        CallableStatement stmtMetodoPago = null;
        CallableStatement stmtBanco = null;

        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false); // Inicia una transacción

            // Llamada al procedimiento InsertarCliente
            String sqlInsertarMetodoPago = "{ CALL InsertarMetodoPago(?, ?, ?) }";
            stmtMetodoPago = conn.prepareCall(sqlInsertarMetodoPago);
            stmtMetodoPago.setBytes(1, banco.getFoto());
            stmtMetodoPago.setString(2, banco.getNombreTitular());
            stmtMetodoPago.registerOutParameter(3, Types.INTEGER); // Para capturar el ID generado
            stmtMetodoPago.executeUpdate();
            // Obtener el ID generado
            int metodoPagoId = stmtMetodoPago.getInt(3);
            banco.setIdMetodoPago(metodoPagoId); // Asignar el ID al objeto cliente
            
            // Llamada al procedimiento metodo
            String sqlInsertarBanco = "{ CALL InsertarBanco(?, ?, ?, ?) }";
            stmtBanco = conn.prepareCall(sqlInsertarBanco);
            stmtBanco.setInt(1, banco.getIdMetodoPago());
            stmtBanco.setString(2, banco.getCCI());
            stmtBanco.setString(3, banco.getTipoCuenta());
            stmtBanco.setString(4, banco.getNombreBanco());//ACA NUEVO//ACA NUEVO//ACA NUEVO
            stmtBanco.executeUpdate();            

            stmtBanco.executeUpdate();

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
                if (stmtBanco != null) {
                    stmtBanco.close();
                }
                if(stmtMetodoPago != null){
                    stmtMetodoPago.close();
                }
                if (stmtMetodoPago != null) {
                    stmtMetodoPago.close();
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
    public boolean modificar(Banco banco) {
        Connection conn = null;
        CallableStatement cs = null;
        
        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ModificarCliente(?, ?, ?, ?, ?, ?) }";
            cs = conexion.prepareCall(sql);
            
            cs.setInt(1, banco.getIdMetodoPago());
            cs.setBytes(2, banco.getFoto());
            cs.setString(3, banco.getNombreTitular());
            cs.setString(4, banco.getCCI());
            cs.setString(5, banco.getTipoCuenta());
            cs.setString(6, banco.getNombreBanco());//ACA NUEVO//ACA NUEVO//ACA NUEVO
            
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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
    public boolean eliminar(int idMetodoPago) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String query = "{CALL EliminarBanco(?)}";
            cs = conn.prepareCall(query);
            cs.setInt(1, idMetodoPago);
            
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Banco obtenerPorId(int idMetodoPago) {
        Banco bank = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerBancoPorID(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, idMetodoPago);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                bank = new Banco(
                    rs.getInt("idMetodoPago"),
                    rs.getBytes("foto"),
                    rs.getString("nombreTitular"),
                    rs.getString("CCI"),
                    rs.getString("tipoCuenta"),
                    rs.getString("nombreBanco")//ACA NUEVO//ACA NUEVO//ACA NUEVO
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
        return bank;
    }

    @Override
    public Banco obtenerPorNombre(String nombre) {
        Banco bank = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerBancoPorNombre(?) }";
            cs = conn.prepareCall(sql);
            cs.setString(1, nombre);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                bank = new Banco(
                    rs.getInt("idMetodoPago"),
                    rs.getBytes("foto"),
                    rs.getString("nombreTitular"),
                    rs.getString("CCI"),
                    rs.getString("tipoCuenta"),
                    rs.getString("nombreBanco")//ACA NUEVO//ACA NUEVO//ACA NUEVO
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
        return bank;
    }
    
    
    @Override
    public List<Banco> listarTodos() {
        List<Banco> listaBancos = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ListarBancos() }";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            
            while(rs.next()){
                Banco bank = new Banco(
                    rs.getInt("idMetodoPago"),
                    rs.getBytes("foto"),
                    rs.getString("nombreTitular"),
                    rs.getString("CCI"),
                    rs.getString("tipoCuenta"),
                    rs.getString("nombreBanco")//ACA NUEVO//ACA NUEVO//ACA NUEVO
                );
                
                listaBancos.add(bank);
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
        return listaBancos;
    }
}
