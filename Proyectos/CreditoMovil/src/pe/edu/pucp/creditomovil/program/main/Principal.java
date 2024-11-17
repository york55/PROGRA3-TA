/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.creditomovil.program.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import pe.edu.pucp.creditomovil.model.Cliente;
import pe.edu.pucp.creditomovil.model.Credito;
import pe.edu.pucp.creditomovil.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.CreditoMySQL;
import pe.edu.pucp.creditomovil.getsclientes.mysql.EvaluacionMySQL;
import pe.edu.pucp.creditomovil.getscredito.dao.BancoDAO;
import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import pe.edu.pucp.creditomovil.getscredito.mysql.BancoMySQL;
import pe.edu.pucp.creditomovil.model.Transaccion;
import pe.edu.pucp.creditomovil.getscredito.mysql.TransaccionMySQL;
import pe.edu.pucp.creditomovil.rrhh.dao.AdministradorDAO;
import pe.edu.pucp.creditomovil.rrhh.dao.SupervisorDAO;
import pe.edu.pucp.creditomovil.rrhh.dao.UsuarioDAO;
import pe.edu.pucp.creditomovil.model.Administrador;
import pe.edu.pucp.creditomovil.model.Banco;
import pe.edu.pucp.creditomovil.model.Supervisor;
import pe.edu.pucp.creditomovil.model.TipoDocumento;
import pe.edu.pucp.creditomovil.model.Usuario;
import pe.edu.pucp.creditomovil.rrhh.mysql.AdministradorMySQL;
import pe.edu.pucp.creditomovil.rrhh.mysql.SupervisorMySQL;
import pe.edu.pucp.creditomovil.rrhh.mysql.UsuarioMySQL;

/**
 *
 * @author diego
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDAO cliDAO = new ClienteMySQL();
        Cliente cli = cliDAO.obtenerPorCodigo(1);
        if(cli!=null)
            System.out.println(cli.getNombre());
    }
}
