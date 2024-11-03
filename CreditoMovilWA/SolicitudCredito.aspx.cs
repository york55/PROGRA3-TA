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
            Response.Redirect("MainCliente.aspx");
        }
    }
}