package pe.edu.pucp.creditomovil.getscredito.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.model.Billetera;

public interface BilleteraDAO {
    boolean insertar(Billetera billetera);
    boolean modificar(Billetera billetera);
    boolean eliminar(String numeroTelefono);
    Billetera obtenerPorId(String numeroTelefono);
    List<Billetera> listarTodos();
}
