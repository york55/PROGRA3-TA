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
public class FotoMySQL implements FotoDAO {

    private Connection conexion;
    private ResultSet rs;

    @Override
    public boolean insertar(Foto foto) {
        Connection con = null;
        CallableStatement cs = null;
        boolean resultado = false;

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL InsertarFoto(?, ?, ?)}");

            // Asignar valores a los parámetros
            cs.setInt(1, foto.getTipoFoto());
            cs.setInt(2, foto.getTransaccion().getNumOperacion());

            // Convertir el ArrayList de caracteres en una cadena para almacenarla en la base de datos
            StringBuilder fotoString = new StringBuilder();
//            for (Character ch : foto.getFoto()) {
//                fotoString.append(ch);
//            }
            cs.setString(3, fotoString.toString());

            // Ejecutar el procedimiento
            resultado = cs.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void modificar(Foto foto) {
        CallableStatement cs;
        String query = "{CALL ModificarFoto(?,?,?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, foto.getTipoFoto());
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
