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
    boolean insertar(Credito credito, int codigoCliente);
    boolean modificar(Credito credito);
    void eliminar(int numCredito);
    Credito obtenerPorId(int numCredito);
    public List<Credito> listarTodosFiltros(int cliId, Date fechaini, Date fechafin, String estado);
    public List<Credito> listarTodos();
    public List<Credito> listarCredPendPorCliente(int codCliente);
}
