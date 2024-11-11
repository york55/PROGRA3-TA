/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.dao;

import java.util.Date;
import java.util.List;
import pe.edu.pucp.creditomovil.model.Credito;

/**
 *
 * @author diego
 */
public interface CreditoDAO {
    void insertar(Credito credito, int codigoCliente);
    void modificar(Credito credito);
    void eliminar(String numCredito);
    Credito obtenerPorId(String numCredito);
    public List<Credito> listarTodosFiltros(String cli, Date fechaini, Date fechafin, String estado);
    public List<Credito> listarTodos(); 
}
