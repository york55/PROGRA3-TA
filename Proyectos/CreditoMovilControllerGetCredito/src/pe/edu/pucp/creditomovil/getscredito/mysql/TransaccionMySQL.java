/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.mysql;

import java.sql.CallableStatement;
import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
import pe.edu.pucp.creditomovil.conexion.DBManager;
import pe.edu.pucp.creditomovil.model.Transaccion;

/**
 *
 * @author diego
 */
public class TransaccionMySQL implements TransaccionDAO {

    private Connection conexion;
    private ResultSet rs = null;

    @Override
    public boolean insertar(Transaccion transaccion) {
        Connection conn = null;
        CallableStatement cs = null;
        boolean resultado = false;
        
        try {
            conn = DBManager.getInstance().getConnection();
            String sql = "{ CALL InsertarTransaccion(?, ?, ?, ?, ?, ?, ?, ?) }";
            cs = conn.prepareCall(sql);

            // Configura los parámetros
            
            cs.setTimestamp(1, new java.sql.Timestamp(transaccion.getFecha().getTime()));
            cs.setString(2, transaccion.getConcepto());
            cs.setDouble(3, transaccion.getMonto());
            cs.setBoolean(4, transaccion.isAnulado());
            cs.setString(5, transaccion.getAgencia());
            cs.setInt(6, transaccion.getCredito().getNumCredito()); // Supone que credito no es null
            cs.setInt(7, transaccion.getMetodoPago().getIdMetodoPago());
            cs.registerOutParameter(8, Types.INTEGER);
            // Ejecuta la consulta
            resultado = cs.executeUpdate() > 0;
            int transaccionId = cs.getInt(8);
            transaccion.setNumOperacion(transaccionId);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        return resultado;
    }

    @Override
    public boolean modificar(Transaccion transaccion) {
        Connection con = null;
        CallableStatement cs = null;
        boolean modificado = false;

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL ModificarTransaccion(?, ?, ?, ?, ?, ?, ?)}");

            // Establecer los parámetros de entrada
            cs.setInt(1, transaccion.getNumOperacion());
            cs.setTimestamp(2, new java.sql.Timestamp(transaccion.getFecha().getTime()));
            cs.setString(3, transaccion.getConcepto());
            cs.setDouble(4, transaccion.getMonto());
            cs.setBoolean(5, transaccion.isAnulado());
            cs.setString(6, transaccion.getAgencia());
            cs.setInt(7, transaccion.getMetodoPago().getIdMetodoPago());

            // Ejecutar el procedimiento y verificar si se modificó correctamente
            modificado = (cs.executeUpdate() > 0);

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
        return modificado;
    }

    @Override
    public boolean eliminar(int numOperacion) {
        Connection con = null;
        CallableStatement cs = null;
        boolean eliminado = false;

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL EliminarTransaccion(?)}");

            // Establecer el parámetro de entrada
            cs.setInt(1, numOperacion);

            // Ejecutar el procedimiento y verificar si se eliminó correctamente
            eliminado = (cs.executeUpdate() > 0);

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
        return eliminado;
    }

    @Override
    public Transaccion obtenerPorId(int numOperacion) {
        Transaccion trans = new Transaccion();
        CallableStatement cs;
        String query = "{CALL ObtenerTransaccion(?)}";
        int resultado = 0;

        try {
            conexion = DBManager.getInstance().getConnection();
            cs = conexion.prepareCall(query);
            cs.setInt(1, numOperacion);

            rs = cs.executeQuery();
            if(rs.next()){
                trans.setAgencia(rs.getString("agencia"));
                trans.setAnulado(rs.getInt("anulado")==0?false:true);
                trans.setConcepto(rs.getString("concepto"));
                trans.setCredito(null);
                trans.setFecha(rs.getDate("fecha_y_hora"));
                trans.setMetodoPago(null);
                trans.setMonto(rs.getDouble("monto"));
                trans.setNumOperacion(rs.getInt("num_transaccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trans;
    }
    
    @Override
    public List<Transaccion> listarPorCredito(int numCred){
        Connection con = null;
        CallableStatement cs = null;
        List<Transaccion> transacciones = new ArrayList<>();

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL ObtenerTransaccionesPorCredito(?)}");
            cs.setInt(1, numCred);
            // Ejecutar el procedimiento y obtener el resultado
            rs = cs.executeQuery();

            // Procesar el ResultSet y convertirlo en objetos Transaccion
            while (rs.next()) {
                int numOperacion = rs.getInt("num_transaccion");
                int usuarioId = rs.getInt("usuario_usuario_id");
                Date fecha = rs.getDate("fecha_y_hora");
                String concepto = rs.getString("concepto");
                double monto = rs.getDouble("monto");
                boolean anulado = rs.getBoolean("anulado");
                String agencia = rs.getString("agencia");
                byte[] foto = rs.getBytes("foto");
                int metodoPagoID = rs.getInt("metodo_metodo_pago_id");
                //cargar el usuario con metodo de obtenerCliente usando el ID

            // Crear una instancia de Transaccion
            Transaccion transaccion = new Transaccion(
                        fecha,
                        concepto,
                        monto,
                        anulado,
                        agencia,
                        numOperacion,
                        null
                );

                // Agregar a la lista
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return transacciones;
    }

    @Override
    public List<Transaccion> listarTodos() {
        Connection con = null;
        CallableStatement cs = null;
        List<Transaccion> transacciones = new ArrayList<>();

        try {
            // Obtener la conexión a la base de datos
            con = DBManager.getInstance().getConnection();

            // Preparar la llamada al procedimiento almacenado
            cs = con.prepareCall("{CALL ListarTransacciones()}");

            // Ejecutar el procedimiento y obtener el resultado
            rs = cs.executeQuery();

            // Procesar el ResultSet y convertirlo en objetos Transaccion
            while (rs.next()) {
                int numOperacion = rs.getInt("num_transaccion");
                int usuarioId = rs.getInt("usuario_usuario_id");
                Date fecha = rs.getDate("fecha_y_hora");
                String concepto = rs.getString("concepto");
                double monto = rs.getDouble("monto");
                boolean anulado = rs.getBoolean("anulado");
                String agencia = rs.getString("agencia");
                byte[] foto = rs.getBytes("foto");
                int metodoPagoID = rs.getInt("metodo_metodo_pago_id");
                //cargar el usuario con metodo de obtenerCliente usando el ID

            // Crear una instancia de Transaccion
            Transaccion transaccion = new Transaccion(
                        fecha,
                        concepto,
                        monto,
                        anulado,
                        agencia,
                        numOperacion,
                        null
                );

                // Agregar a la lista
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return transacciones;
    }
}
