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

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            // Obtener el monto del HiddenField
            int monto = int.Parse(hfMonto.Value);

            // Calcular el rango de interés (5% - 15%)
            double minInteres = monto * 0.05;
            double maxInteres = monto * 0.15;

            // Mostrar el interés en el Label
            //lblInteres.Text = $"Interés aproximado: S/. {minInteres:F2} - S/. {maxInteres:F2}";

            credito cred = new credito();
            //cred.cliente = (cliente)Session["cliente"]; //falta guardar al cliente btw, eso se hace desde el login
            cred.cliente = null;
            cred.estado = "Solicitado";
            cred.tasaInteres = maxInteres;
            cred.fechaOtorgamiento = DateTime.Now;
            cred.monto = monto;
            cred.numCuotas = Int32.Parse(selectedCuotas.Value); // no sé cómo colocar esto btw, creo que es así, vamos a ver
            cred.numCredito = "CRED124";
            cred.fechaOtorgamientoSpecified = true;

            daoCredito.insertarCredito(cred,"CL123");

            Response.Redirect("MainCliente.aspx");
        }
    }
}