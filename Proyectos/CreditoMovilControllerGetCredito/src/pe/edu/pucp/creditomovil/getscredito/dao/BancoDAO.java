package pe.edu.pucp.creditomovil.getscredito.dao;

import java.util.List;
import pe.edu.pucp.creditomovil.model.Banco;

public interface BancoDAO {
    boolean insertar(Banco banco);
    boolean modificar(Banco banco);
    boolean eliminar(String CCI);
    Banco obtenerPorId(String CCI);
    List<Banco> listarTodos();
}
