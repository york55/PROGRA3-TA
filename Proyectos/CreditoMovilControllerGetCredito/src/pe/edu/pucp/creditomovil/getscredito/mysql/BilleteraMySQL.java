package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
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

        CallableStatement cs;
        String query = "{CALL InsertarBilletera(?,?,?,?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setInt(1, billetera.getIdMetodoPago());
            cs.setString(2, billetera.getNombreTitular());
            cs.setBytes(3, billetera.getFoto());
            cs.setString(4, billetera.getNumeroTelefono());
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean modificar(Billetera billetera) {
        CallableStatement cs;
        String query = "{CALL ModificarBilletera(?,?)}";
        boolean resultado = false;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setInt(1, billetera.getIdMetodoPago());
            cs.setString(2, billetera.getNumeroTelefono());
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return true;
    }

    @Override
    public boolean eliminar(String numeroTelefono) {
        CallableStatement cs;
        String query = "{CALL EliminarBilletera(?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setString(1, numeroTelefono);
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultado;
    }

    @Override
    public Billetera obtenerPorId(String numeroTelefono) {
        
        CallableStatement cs;
        String query = "{CALL ObtenerBilletera(?)}";
        int  resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, numeroTelefono);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
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
                        rs.getString("telefono")
                        
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
