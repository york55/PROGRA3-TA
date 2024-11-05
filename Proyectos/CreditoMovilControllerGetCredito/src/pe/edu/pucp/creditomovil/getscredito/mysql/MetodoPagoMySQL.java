package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.getscredito.dao.MetodoPagoDAO;
import pe.edu.pucp.creditomovil.model.MetodoPago;

public class MetodoPagoMySQL implements MetodoPagoDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(MetodoPago metodoPago) {

        CallableStatement cs;
        String query = "{CALL InsertarMetodoPago(?,?,?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);

            cs.setInt(1, metodoPago.getIdMetodoPago());
            cs.setString(2, metodoPago.getNombreTitular());
            cs.setBytes(3, metodoPago.getFoto());

            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean modificar(MetodoPago metodoPago) {
        CallableStatement cs;
        String query = "{CALL ModificarMetodoPago(?,?,?)}";
        boolean resultado = false;
        
        try {
            
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, metodoPago.getIdMetodoPago());
            cs.setBytes(2, metodoPago.getFoto());
            cs.setString(3, metodoPago.getNombreTitular());
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean eliminar(int idMetodoPago) {
        CallableStatement cs;
        String query = "{CALL EliminarMetodoPago(?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idMetodoPago);

            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public MetodoPago obtenerPorId(int idMetodoPago) {
        CallableStatement cs;
        String query = "{CALL ObtenerMetodoPago(?)}";
        int  resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, idMetodoPago);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MetodoPago> listarTodos() {
        List<MetodoPago> metodos = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarMetodosPago()}";
        rs = null;
        try{
            
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            
//            while(rs.next()){
//                MetodoPago metodo = new MetodoPago(
//                Es abstracta aaaaaaaaaaaaaaaaaaaaaaaa
//                );
//            }
            
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
        return null; // Parece que no usaremos este listar (?
    }

}
