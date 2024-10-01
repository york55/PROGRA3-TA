/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.creditomovil.program.main;

import java.util.Date;
import java.util.List;
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
        Supervisor supervisor = new Supervisor(1, new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new Date(), true, "A", 1, "SUP123");
        UsuarioDAO daoUsuario = new UsuarioMySQL();
        //daoUsuario.insertar(supervisor);
        //daoUsuario.modificar(2,supervisor);
        //daoUsuario.eliminar(3);
        List<Usuario> listaUsuarios = daoUsuario.listarTodos();
        for (Usuario usuario : listaUsuarios) {
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
        }
        SupervisorDAO daoSupervisor = new SupervisorMySQL();
        //daoSupervisor.insertar(supervisor);
        //daoSupervisor.modificar(1, supervisor);
        //daoSupervisor.eliminar(1);
        
        //daoUsuario.eliminar(4);
        Administrador administrador = new Administrador(5, new Date(), "Diego", "Pérez", "Gonzalez", "miContrasena", new Date(), true, "A", 1);
        AdministradorDAO daoAdministrador = new AdministradorMySQL();
        //daoAdministrador.insertar(administrador);
        //daoAdministrador.modificar(5, administrador);
        //daoAdministrador.eliminar("A");
    }
    
}
