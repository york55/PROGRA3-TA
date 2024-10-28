/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.creditomovil.getsclientes.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;

/**
 *
 * @author diego
 */
public interface EvaluacionDAO {
    boolean insertar(Evaluacion evaluacion);
    boolean modificar(Evaluacion evaluacion);
    boolean eliminar(int idEvaluacion);
    Evaluacion obtenerPorId(int idEvaluacion);
    public List<Evaluacion> listarTodos();
}
