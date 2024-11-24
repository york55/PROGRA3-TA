/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.model.Supervisor;

/**
 *
 * @author diego
 */
public interface SupervisorDAO {
    boolean insertar(Supervisor supervisor);
    void modificar(int id,Supervisor supervisor);
    void eliminar(int id);
    Supervisor obtenerPorId(int id);
    Supervisor obtenerPorDocIdentidad(String docIden, String tipoDocIden);
    List<Supervisor> listarTodos();
    Supervisor obtenerPorCliente(int cliente_id);
}
