/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.model.Cliente;

/**
 *
 * @author Bleak
 */
public interface ClienteDAO {
    boolean insertar(Cliente usuario);
    boolean modificar(Cliente usuario);
    boolean eliminar(int id);
    Cliente obtenerPorId(int id);
    Cliente obtenerPorDocIdentidad(String docIden, String tipoDocIden);
    List<Cliente> listarTodos();
}
