/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.rrhh.model.Supervisor;

/**
 *
 * @author diego
 */
public interface SupervisorDAO {
    boolean insertar(Supervisor supervisor);
    boolean modificar(Supervisor supervisor);
    void eliminar(String id);
    Supervisor obtenerPorId(int id);
    List<Supervisor> listarTodos();
}
