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
    void insertar(Supervisor supervisor);
    void modificar(int id,Supervisor supervisor);
    void eliminar(int id);
    Supervisor obtenerPorId(int id);
    List<Supervisor> listarTodos();
}
