using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class SolicitudCredito : System.Web.UI.Page
    {

        private CreditoWSClient daoCredito = new CreditoWSClient();

        protected void Page_Init(object sender, EventArgs e)
        {
            cliente cli = (cliente)Session["Cliente"];
            if (cli == null)
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            cliente cli = (cliente)Session["Cliente"];
            // Obtener el monto del HiddenField
            int monto = int.Parse(hfMonto.Value);

            // Calcular el rango de interés (5% - 15%)
            double minInteres = monto * 0.05;
            double maxInteres = monto * 0.15;

            // Mostrar el interés en el Label
            //lblInteres.Text = $"Interés aproximado: S/. {minInteres:F2} - S/. {maxInteres:F2}";

            credito cred = new credito();
            cred.cliente = null; //falta guardar al cliente btw, eso se hace desde el login
            cred.estado = "Solicitado";
            cred.tasaInteres = maxInteres;
            cred.fechaOtorgamiento = DateTime.Now;
            cred.monto = monto;
            cred.numCuotas = Int32.Parse(selectedCuotas.Value); // no sé cómo colocar esto btw, creo que es así, vamos a ver
            cred.numCredito = "CRED133";
            cred.fechaOtorgamientoSpecified = true;

            daoCredito.insertarCredito(cred,cli.documento,cli.tipoDocumento.ToString());

            Response.Redirect("MainCliente.aspx");
        }
    }
}