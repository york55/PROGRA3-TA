package pe.edu.pucp.creditomovil.getscredito.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.model.MetodoPago;

public interface MetodoPagoDAO {
    boolean insertar(MetodoPago metodoPago);
    boolean modificar(MetodoPago metodoPago);
    boolean eliminar(int idMetodoPago);
    MetodoPago obtenerPorId(int idMetodoPago);
    List<MetodoPago> listarTodos();
}
