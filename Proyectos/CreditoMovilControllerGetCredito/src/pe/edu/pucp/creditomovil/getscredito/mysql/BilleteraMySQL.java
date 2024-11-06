package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Types;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscredito.dao.BilleteraDAO;
import pe.edu.pucp.creditomovil.model.Billetera;

public class BilleteraMySQL implements BilleteraDAO{
    
    private Connection conexion;
    private ResultSet rs;
    
    @Override
    public boolean insertar(Billetera billetera) {
        Connection conn = null;
        CallableStatement stmtMetodoPago = null;
        CallableStatement stmtBilletera = null;

        try {
            conn = DBManager.getInstance().getConnection();
            conn.setAutoCommit(false); // Inicia una transacción

            // Llamada al procedimiento `InsertarMetodoPago`
            String sqlInsertarMetodoPago = "{ CALL InsertarMetodoPago(?, ?, ?) }";
            stmtMetodoPago = conn.prepareCall(sqlInsertarMetodoPago);
            stmtMetodoPago.setBytes(1, billetera.getFoto());
            stmtMetodoPago.setString(2, billetera.getNombreTitular());
            stmtMetodoPago.registerOutParameter(3, Types.INTEGER); // Para capturar el ID generado
            stmtMetodoPago.executeUpdate();

            // Obtener el ID generado
            int metodoPagoId = stmtMetodoPago.getInt(3);
            billetera.setIdMetodoPago(metodoPagoId); // Asignar el ID al objeto cliente

            // Llamada al procedimiento `InsertarCliente`
            String sqlInsertarBilletera = "{ CALL InsertarBilletera(?, ?, ?) }";
            stmtBilletera = conn.prepareCall(sqlInsertarBilletera);
            stmtBilletera.setInt(1, metodoPagoId);
            stmtBilletera.setString(2, billetera.getNumeroTelefono());
            stmtBilletera.setString(3, billetera.getNombreBilletera());

            stmtBilletera.executeUpdate();

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
                if (stmtBilletera != null) {
                    stmtBilletera.close();
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
    public boolean modificar(Billetera billetera) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ModificarBilletera(?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Parámetros para la tabla usuario
            cs.setInt(1, billetera.getIdMetodoPago());
            cs.setBytes(2, billetera.getFoto());
            cs.setString(3, billetera.getNombreTitular());
            cs.setString(4, billetera.getNumeroTelefono());
            cs.setString(5, billetera.getNombreBilletera());

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
    public boolean eliminar(int idMetodoPago) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL EliminarBilletera(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, idMetodoPago);

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
    public Billetera obtenerPorId(int idMetodoPago) {
        
        Billetera bill = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL ObtenerBilleteraPorId(?) }";
            cs = conn.prepareCall(sql);
            cs.setInt(1, idMetodoPago);
            rs = cs.executeQuery();
            
            
            if(rs.next()){
                bill = new Billetera(
                    rs.getInt("idMetodoPago"),
                    rs.getBytes("foto"),
                    rs.getString("nombreTitular"),
                    rs.getString("numeroTelefono"),
                    rs.getString("nombreBilletera")
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
        return bill;
    }

    @Override
    public List<Billetera> listarTodos() {
        List<Billetera> billeteras = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarBilleteras()}";
        rs = null;
        try{
            
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            
            while(rs.next()){
                Billetera billetera = new Billetera(
                        
                        rs.getInt("idMetodoPago"),
                        rs.getBytes("foto"),
                        rs.getString("nombreTitular"),
                        rs.getString("telefono"),
                        rs.getString("nombreBilletera")
                        
                );
                billeteras.add(billetera);
            }
            
        } catch (SQLException e){
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
        return billeteras;
    }
    
}
