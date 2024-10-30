using CreditoMovilWATesterC_.WSCliente;
using CreditoMovilWATesterC_.WSCredito;
using CreditoMovilWATesterC_.WSSupervisor;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CreditoMovilWATesterC_
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ClienteWSClient cliente = new ClienteWSClient();
            cliente[] listCli = cliente.listarClientes();
            foreach (cliente cli in listCli)
            {
                Console.WriteLine("ID:" + cli.idUsuario.ToString());
                Console.WriteLine("Nombre:" + cli.nombre);
            }

            Console.ReadLine();

            CreditoWSClient cred = new CreditoWSClient();
            credito[] listCred = cred.listarCreditos();
            foreach (credito cre in listCred)
            {
                Console.WriteLine("ID:" + cre.numCredito.ToString());
                Console.WriteLine("Nombre:" + cre.fechaOtorgamiento.ToString());
            }
            Console.ReadLine();

            SupervisorWSClient sup = new SupervisorWSClient();
            supervisor[] listSup = sup.listarSupervisor();
            foreach (supervisor supevisor in listSup)
            {
                Console.WriteLine("ID:" + supevisor.idUsuario.ToString());
                Console.WriteLine("Nombre:" + supevisor.nombre);
                Console.WriteLine("Apellido:" + supevisor.apPaterno);
            }
            Console.ReadLine();
        }
    }
}
