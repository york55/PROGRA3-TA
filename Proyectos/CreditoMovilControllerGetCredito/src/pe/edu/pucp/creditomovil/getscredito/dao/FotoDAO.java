/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getscredito.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.getscredito.model.Foto;

/**
 *
 * @author diego
 */
public interface FotoDAO {
    void insertar(Foto foto);
    void modificar(Foto foto);
    void eliminar(int tipoFoto);
    Foto obtenerPorId(int tipoFoto);
    List<Foto> listarTodos();
}
