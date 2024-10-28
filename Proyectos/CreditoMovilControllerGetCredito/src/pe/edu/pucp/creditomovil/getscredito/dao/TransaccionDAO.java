/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.getscredito.model.Transaccion;

/**
 *
 * @author diego
 */
public interface TransaccionDAO {
    boolean insertar(Transaccion transaccion);
    boolean modificar(Transaccion transaccion);
    boolean eliminar(int numOperacion);
    Transaccion obtenerPorId(int numOperacion);
    List<Transaccion> listarTodos();
}
