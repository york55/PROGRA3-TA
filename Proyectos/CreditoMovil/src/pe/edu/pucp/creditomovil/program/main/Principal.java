/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.creditomovil.program.main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import pe.edu.pucp.creditomovil.getscliente.model.Cliente;
import pe.edu.pucp.creditomovil.getscliente.model.Credito;
import pe.edu.pucp.creditomovil.getscliente.model.Evaluacion;
import pe.edu.pucp.creditomovil.getsclientes.dao.ClienteDAO;
import pe.edu.pucp.creditomovil.getsclientes.dao.CreditoDAO;
import pe.edu.pucp.creditomovil.getsclientes.dao.EvaluacionDAO;
import pe.edu.pucp.creditomovil.getsclientes.mysql.ClienteMySQL;
import pe.edu.pucp.creditomovil.getsclientes.mysql.CreditoMySQL;
import pe.edu.pucp.creditomovil.getsclientes.mysql.EvaluacionMySQL;
import pe.edu.pucp.creditomovil.getscredito.dao.TransaccionDAO;
import pe.edu.pucp.creditomovil.getscredito.model.Transaccion;
import pe.edu.pucp.creditomovil.getscredito.mysql.TransaccionMySQL;
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

        // Crear la instancia de ClienteDAO
        ClienteDAO clienteDAO = new ClienteMySQL();

//         Configurar los datos del Cliente de prueba
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(1990, Calendar.JANUARY, 1); // Fecha de ejemplo

        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.set(2025, Calendar.DECEMBER, 31); // Fecha de vencimiento de ejemplo
//
        Cliente cliente = new Cliente(
                0, // idUsuario (se generará automáticamente en la base de datos)
                fechaNacimiento.getTime(),
                "Juan",
                "Pérez",
                "González",
                "password123",
                fechaVencimiento.getTime(),
                true,
                "CL123",
                "123 Calle Falsa",
                "123456789",
                "juan.perez@example.com",
                "Premium"
        );
//
//        // Intentar insertar el cliente en la base de datos
//        boolean exito = clienteDAO.insertar(cliente);
//
//        if (exito) {
//            System.out.println("Cliente insertado exitosamente con ID: " + cliente.getIdUsuario());
//        } else {
//            System.out.println("Error al insertar el cliente.");
//        }
        //eliminar
//        String codigoCliente = "CL123";
//        boolean exito = clienteDAO.eliminar(codigoCliente);
//
//        if (exito) {
//            System.out.println("Cliente eliminado exitosamente.");
//        } else {
//            System.out.println("No se pudo eliminar el cliente. Verifica el codigo.");
//        }
        //modificar
//        Cliente cliente = new Cliente(
//            0, new Date(), "NombreActualizado", "ApellidoPaterno", "ApellidoMaterno", 
//            "nuevaContrasena", new Date(), true, "CL123", "Nueva Direccion", 
//            "987654321", "nuevoemail@example.com", "VIP"
//        );
//
//        boolean exito = clienteDAO.modificar(cliente);
//
//        if (exito) {
//            System.out.println("Cliente actualizado exitosamente.");
//        } else {
//            System.out.println("No se pudo actualizar el cliente.");
//        }
        //listar
//        List<Cliente> clientes = clienteDAO.listarTodos();
//
//        for (Cliente cliente : clientes) {
//            System.out.println("ID Usuario: " + cliente.getIdUsuario());
//            System.out.println("Nombre: " + cliente.getNombre());
//            System.out.println("Apellido Paterno: " + cliente.getApPaterno());
//            System.out.println("Apellido Materno: " + cliente.getApMaterno());
//            System.out.println("Codigo Cliente: " + cliente.getCodigoCliente());
//            System.out.println("Direccion: " + cliente.getDireccion());
//            System.out.println("Telefono: " + cliente.getTelefono());
//            System.out.println("Email: " + cliente.getEmail());
//            System.out.println("Tipo Cliente: " + cliente.getTipoCliente());
//            System.out.println("Activo: " + cliente.getActivo());
//            System.out.println("Fecha de Registro: " + cliente.getFecha());
//            System.out.println("ultimo Logueo: " + cliente.getUltimoLogueo());
//            System.out.println("----------------------------------------");
//        }
        //CREDITO
        CreditoDAO creditoDAO = new CreditoMySQL();
        //INSERTAR

        // Crear un objeto Credito
        Credito credito = new Credito(
                "CRED123",
                5000.00,
                5.5,
                new Date(), // Fecha de otorgamiento
                cliente,
                "Activo",
                12 // Número de cuotas
        );

        // Código del cliente al que se le asignará el crédito
//        String codigoCliente = cliente.getCodigoCliente(); // Asegúrate de que este código exista en la base de datos
        // Insertar el crédito
//        creditoDAO.insertar(credito, codigoCliente);
//        System.out.println("Credito insertado y asociado al cliente con codigo: " + codigoCliente);
        //eliminar
//        String numCredito = "CRED123";
//        creditoDAO.eliminar(numCredito);
//        System.out.println("Credito con numero " + numCredito + " ha sido eliminado.");
        //modificar
//        Credito credito = new Credito("CRED123", 5000.00, 3.5,
//                new Date(), null, "Activo", 12); // Asegúrate de que este crédito exista
        // Modificar el crédito
//        creditoDAO.modificar(credito);
//        System.out.println("Crédito con número " + credito.getNumCredito() + " ha sido modificado.");
        //listar
//        List<Credito> creditos = creditoDAO.listarTodos();
//        for (Credito credito : creditos) {
//            System.out.println("Numero de Credito: " + credito.getNumCredito());
//            System.out.println("Monto: " + credito.getMonto());
//            System.out.println("Tasa de Interes: " + credito.getTasaInteres());
//            System.out.println("Fecha de Otorgamiento: " + credito.getFechaOtorgamiento());
//            System.out.println("Estado: " + credito.getEstado());
//            System.out.println("Numero de Cuotas: " + credito.getNumCuotas());
//            System.out.println("------------------------------");
//        }
        //transaccion
//        TransaccionDAO transaccionDAO = new TransaccionMySQL();
        //Insertar
//        Transaccion transaccion = new Transaccion(
//                new Date(), // Fecha actual
//                "Pago mensual", // Concepto
//                100.0, // Monto
//                false, // Anulado
//                cliente, // Usuario registrado
//                "Agencia Central", // Agencia
//                1, // Número de operación
//                credito // Crédito asociado
//        );
//
//        boolean exito = transaccionDAO.insertar(transaccion);
//
//        if (exito) {
//            System.out.println("Transaccion insertada con exito.");
//        } else {
//            System.out.println("Error al insertar la transaccion.");
//        }
        //eliminar
//        int numTransaccion = 1;
//
//        boolean eliminado = transaccionDAO.eliminar(numTransaccion);
//        if (eliminado) {
//            System.out.println("La transaccion con numero " + numTransaccion + " fue eliminada exitosamente.");
//        } else {
//            System.out.println("No se encontró la transacción con número " + numTransaccion + " o no se pudo eliminar.");
//        }
        //modificar
//        Transaccion transaccion = new Transaccion(
//                new Date(), // Fecha
//                "Nuevo Concepto", // Concepto
//                1500.0, // Monto
//                false, // Anulado
//                cliente,
//        "Agencia Actualizada",              // Agencia
//        1,                              // Número de operación
//        credito
//    );
//    
//    boolean modificado = transaccionDAO.modificar(transaccion);
//        if (modificado) {
//            System.out.println("La transacción fue modificada exitosamente.");
//        } else {
//            System.out.println("No se pudo modificar la transacción.");
//        }
        //listar
//        List<Transaccion> transacciones = transaccionDAO.listarTodos();
        // Imprimir las transacciones
//    for (Transaccion transaccion : transacciones) {
//        System.out.println("Transacción #" + transaccion.getNumOperacion());
//        System.out.println("Fecha: " + transaccion.getFecha());
//        System.out.println("Concepto: " + transaccion.getConcepto());
//        System.out.println("Monto: " + transaccion.getMonto());
//        System.out.println("Anulado: " + transaccion.isAnulado());
//        System.out.println("Agencia: " + transaccion.getAgencia());
//        //System.out.println("Usuario ID: " + transaccion.getUsuarioRegistrado().getIdUsuario());
//        System.out.println("-------------------------------------");
//    }
        //FOTO
        //INSERTAR
        //ver lo de la foto, no se como se maneja
        //SUPERVISOR
        SupervisorDAO supervisorDAO = new SupervisorMySQL();
        //INSERTAR
        Supervisor supervisor = new Supervisor(
                0, // ID de usuario (se generará automáticamente)
                new Date(), // Fecha actual
                "Carlos", // Nombre
                "Pérez", // Apellido paterno
                "López", // Apellido materno
                "password123", // Contraseña
                new Date(System.currentTimeMillis() + 86400000L * 365), // Fecha de vencimiento (1 año después)
                true, // Activo
                "SUP001", // Código de supervisor
                102, // Código de cargo
                "Agencia CentralMOD" // Agencia de asignación
        );
        // Insertar el supervisor en la base de datos
//        if (supervisorDAO.insertar(supervisor)) {
//            System.out.println("Supervisor insertado correctamente.");
//        } else {
//            System.out.println("Error al insertar el supervisor.");
//        }
        //eliminar
        //supervisorDAO.eliminar("SUP001");
        //modificar
        //supervisorDAO.modificar(supervisor);
        //listar
        List<Supervisor> supervisores = supervisorDAO.listarTodos();

        for (Supervisor sup : supervisores) {
            System.out.println("ID Usuario: " + sup.getIdUsuario());
            System.out.println("Nombre: " + sup.getNombre());
            System.out.println("Apellido Paterno: " + sup.getApPaterno());
            System.out.println("Apellido Materno: " + sup.getApMaterno());
            System.out.println("Codigo SUper: " + sup.getCodigoEv());
            System.out.println("Codigo Cargo: " + sup.getCodigoCargo());
            System.out.println("Agencia: " + sup.getAgenciaAsignacion());
            System.out.println("Activo: " + sup.getActivo());
            System.out.println("Fecha de Registro: " + sup.getFecha());
            System.out.println("ultimo Logueo: " + sup.getUltimoLogueo());
            System.out.println("----------------------------------------");
        }
        //EVALUACION
        //INSERTAR
        EvaluacionDAO evaluacionDAO = new EvaluacionMySQL();
        Evaluacion evaluacion = new Evaluacion(new Date(), "NegocioMOD", "direccion", "telefonitoXD", (Usuario) supervisor,
                (Usuario) cliente, 24.0, 1022.0, 224.0, 12.0, 0.0, 0.0, 1, true, 20.0, "observandoMOD");
        //evaluacionDAO.insertar(evaluacion);
        //ELIMINAR
        //evaluacionDAO.eliminar(1);
        //MODIFICAR
        //evaluacionDAO.modificar(evaluacion);
        //LISTAR
//        List<Evaluacion> evaluaciones = evaluacionDAO.listarTodos();
//        for (Evaluacion eva : evaluaciones) {
//            System.out.println("evaluacion #" + eva.getNumeroEvaluacion());
//            System.out.println("Fecha: " + eva.getFechaRegistro());
//            System.out.println("Dir: " + eva.getDireccionNegocio());
//            System.out.println("-------------------------------------");
//        }
           
    }

}
