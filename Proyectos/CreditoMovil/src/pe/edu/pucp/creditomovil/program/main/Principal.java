/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.creditomovil.program.main;

import java.util.Date;
import java.util.List;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;
import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.rrhh.dao.AdministradorDAO;
import pe.edu.pucp.creditomovil.rrhh.dao.SupervisorDAO;
import pe.edu.pucp.creditomovil.rrhh.dao.UsuarioDAO;
import pe.edu.pucp.creditomovil.rrhh.model.Administrador;
import pe.edu.pucp.creditomovil.rrhh.model.Supervisor;
import pe.edu.pucp.creditomovil.rrhh.model.Usuario;
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
        // TODO code application logic here
        //Supervisor supervisor = new Supervisor(6, new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new Date(), true, "B", 1, "SUP123");
        //UsuarioDAO daoUsuario = new UsuarioMySQL();
        //daoUsuario.insertar(supervisor);
        //daoUsuario.modificar(2,supervisor);
        //daoUsuario.eliminar(3);
        //List<Usuario> listaUsuarios = daoUsuario.listarTodos();
//        for (Usuario usuario : listaUsuarios) {
//            System.out.println("ID: " + usuario.getIdUsuario());
//            System.out.println("Nombre: " + usuario.getNombre());
//        }
        //SupervisorDAO daoSupervisor = new SupervisorMySQL();
        //daoSupervisor.insertar(supervisor);
        //daoSupervisor.modificar(1, supervisor);
        //daoSupervisor.eliminar(1);
        //List<Supervisor> listaSupervisor = daoSupervisor.listarTodos();
//        for (Supervisor sup : listaSupervisor) {
//            System.out.println("ID: " + sup.getIdUsuario());
//            System.out.println("Nombre: " + sup.getNombre());
//            System.out.println("codigo_sup: " + sup.getCodigoEv());
//        }
        
        //daoUsuario.eliminar(4);
        //Administrador administrador = new Administrador(6, new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new Date(), true, "B", 2);
        //AdministradorDAO daoAdministrador = new AdministradorMySQL();
        //daoAdministrador.insertar(administrador);
        //daoAdministrador.modificar(5, administrador);
        //daoAdministrador.eliminar("A");
        //List<Administrador> listaAdministrador = daoAdministrador.listarTodos();
//        for (Administrador admin : listaAdministrador) {
//            System.out.println("ID: " + admin.getIdUsuario());
//            System.out.println("Codigo admin: " + admin.getCodigoAdm());
//            System.out.println("Codigo cargo: " + admin.getCodigoCargo());
//        }


    //GEST CREDITO
    //CLIENTE
        Cliente cliente = new Cliente(6, new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", 
                new Date(), true,"CL1","Somewhere","918232","mail@.com","TipoMODIFICADO");
//        
//        ClienteDAO daoCliente = new ClienteMySQL();
//        daoCliente.insertar(cliente);
        //daoCliente.modificar(6, cliente);//no tiene sentido pasarle tanto el id como el cliente, con el cliente basta
        //daoCliente.eliminar("CL1");
//        List<Cliente> listaClientes = daoCliente.listarTodos();
//        for (Cliente cli : listaClientes) {
//            System.out.println("ID: " + cli.getIdUsuario());
//            System.out.println("Codigo cliente: " + cli.getCodigoCliente());
//            System.out.println("Tipo cliente: " + cli.getTipoCliente());
//        }

    //EVALUACION
        Evaluacion eval = new Evaluacion(new Date(),"negocio1","dirNego","302311",cliente,cliente,12,123,67,54,5,10,1,
            true,14,"observacion");
        EvaluacionDAO 
    }
    
}
