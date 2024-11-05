package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

        CallableStatement cs;
        String query = "{CALL InsertarBanco(?,?,?,?,?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setInt(1, banco.getIdMetodoPago());
            cs.setString(2, banco.getNombreTitular());
            cs.setBytes(3, banco.getFoto());
            cs.setString(4, banco.getCCI());
            cs.setString(5, banco.getTipoCuenta());
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean modificar(Banco banco) {
        CallableStatement cs;
        String query = "{CALL ModificarBanco(?,?,?)}";
        boolean resultado = false;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setInt(1, banco.getIdMetodoPago());
            cs.setString(2, banco.getCCI());
            cs.setString(3, banco.getTipoCuenta());
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return true;
    }

    @Override
    public boolean eliminar(String CCI) {
        CallableStatement cs;
        String query = "{CALL EliminarBanco(?)}";
        boolean resultado = false;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            
            cs.setString(1, CCI);
            
            resultado = cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultado;
    }

    @Override
    public Banco obtenerPorId(String CCI) {
        
        CallableStatement cs;
        String query = "{CALL ObtenerBanco(?)}";
        int  resultado = 0;
        
        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setString(1, CCI);
            
            resultado = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Banco> listarTodos() {
        List<Banco> bancos = new ArrayList<>();
        CallableStatement cs = null;
        String query = "{CALL ListarBancos()}";
        rs = null;
        try{
            
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);            
            rs = cs.executeQuery();
            
            while(rs.next()){
                Banco banco = new Banco(
                        
                        rs.getInt("idMetodoPago"),
                        rs.getBytes("foto"),
                        rs.getString("nombreTitular"),
                        rs.getString("CCI"),
                        rs.getString("tipoCuenta")
                        
                );
                bancos.add(banco);
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
        return bancos;
    }

}
