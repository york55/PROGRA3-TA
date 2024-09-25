/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;

/**
 *
 * @author Bleak
 */
public interface ClienteDAO {
    void insertar(Cliente usuario);
    void modificar(int id,Cliente usuario);
    void eliminar(String id);
    Cliente obtenerPorId(String id);
    List<Cliente> listarTodos();
}
