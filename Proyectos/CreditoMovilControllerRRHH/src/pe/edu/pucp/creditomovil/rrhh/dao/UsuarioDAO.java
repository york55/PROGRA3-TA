/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.rrhh.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.rrhh.model.Usuario;

/**
 *
 * @author diego
 */
public interface UsuarioDAO {
    void insertar(Usuario usuario);
    void modificar(Usuario usuario);
    void eliminar(int id);
    Usuario obtenerPorId(int id);
    List<Usuario> listarTodos();
}
