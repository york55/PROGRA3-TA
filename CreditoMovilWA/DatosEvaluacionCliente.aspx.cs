using AjaxControlToolkit.HtmlEditor.ToolbarButtons;
using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DatosEvaluacionCliente : System.Web.UI.Page
    {
        private ClienteWSClient clienteDAO = new ClienteWSClient();
        private SupervisorWSClient supervisorDAO = new SupervisorWSClient();
        private EvaluacionWSClient evaluacionDAO = new EvaluacionWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cliente cli = (cliente)Session["Cliente"];
                if (cli == null)
                {
                    Response.Redirect("Login.aspx");
                }
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            cliente cli = (cliente)Session["Cliente"];
            evaluacion ev = new evaluacion();
            supervisor sup = ObtenerSupervisorRandom();

            ev.nombreNegocio = txtNombreNeg.Text;
            ev.numeroEvaluacion = 0;
            ev.direccionNegocio = txtDireccionNeg.Text;
            ev.margenGanancia = double.Parse(txtUtilidadPromedio.Text);
            ev.ventasDiarias = double.Parse(txtVentasDiarias.Text);
            ev.costoVentas = double.Parse(txtCostosVentas.Text);
            ev.inventario = double.Parse(txtInventario.Text);
            ev.margenGanancia = double.Parse(txtUtilidadPromedio.Text);
            ev.clienteAsignado = cli;
            ev.activo = true;
            ev.fechaRegistro = DateTime.Now;
            ev.fechaRegistroSpecified = true;
            ev.telefonoNegocio = txtTelefonoNeg.Text;
            ev.observaciones = txtObservaciones.Text;

            double margenImpacto = ev.margenGanancia > 50 ? 50 : ev.margenGanancia; // Máximo peso para margen: 50.
            double eficienciaVentas = (1 - (ev.costoVentas / ev.ventasDiarias)) * 30; // Máximo peso para eficiencia: 30.
            double inventarioImpacto = Math.Min((ev.inventario / ev.ventasDiarias) * 10, 20); // Máximo peso para inventario: 20.

            ev.puntaje = margenImpacto + eficienciaVentas + inventarioImpacto;

            // Aseguramos que el puntaje esté en el rango 0-100.
            ev.puntaje = Math.Max(0, Math.Min(100, ev.puntaje));

            if (VerificarContraseña(txtContrasena.Text, cli.salt, cli.contrasenha) 
                && txtContrasena.Text.Equals(txtConfirmarContrasena.Text))
            {
                if (evaluacionDAO.insertarEvaluacion(ev, sup.codigoEv /*sup.codigoEv*/))
                {
                    cli.tipoCliente = "Pendiente";
                    if (clienteDAO.modificarCliente(cli)) Response.Redirect("MainCliente.aspx");
                }
            }
            else
            {
                lblError.Text = "Por favor verifique su contraseña";
            }
        }
        private supervisor ObtenerSupervisorRandom()
        {
            supervisor[] listSup = supervisorDAO.listarTodosSupervisors();
            Random ran = new Random();
            int indAleatorio = ran.Next(listSup.Length);

            return listSup[indAleatorio];
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            /*Cierra sesión automáticamente*/
            Session["Cliente"] = null;
            FormsAuthentication.SignOut();
            Response.Redirect("Home.aspx");
        }

        private bool VerificarContraseña(string contraseñaIngresada, string salAlmacenada, string contraseñaHashAlmacenada)
        {
            // Combinar la contraseña ingresada con el salt almacenado
            string saltedPassword = contraseñaIngresada + salAlmacenada;

            // Recalcular el hash usando SHA256
            using (var sha256 = SHA256.Create())
            {
                byte[] hashBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(saltedPassword));
                string computedHash = Convert.ToBase64String(hashBytes);

                // Comparar el hash calculado con el hash almacenado
                return computedHash == contraseñaHashAlmacenada;
            }
        }
    }
}