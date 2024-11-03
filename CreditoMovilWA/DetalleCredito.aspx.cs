using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleCredito : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDetalleCredito();
                CargarTransacciones();
            }
        }

        private void CargarDetalleCredito()
        {
            // Cargar datos de ejemplo para los detalles del crédito.
            txtFechaOtorgamiento.Text = "28/10/2024";
            txtEstado.Text = "Activo";
            txtMonto.Text = "5000";
            txtNumeroCuotas.Text = "12";
            txtTasaInteres.Text = "5%";
        }

        private void CargarTransacciones()
        {
            // Cargar datos de ejemplo o conectar a la base de datos para obtener transacciones.
            gvTransacciones.DataSource = ObtenerDatosTransacciones();
            gvTransacciones.DataBind();
        }

        protected void btnVerDetalleTransaccion_Click(object sender, EventArgs e)
        {
            Response.Redirect("DetalleTransaccion.aspx");
        }

        private object ObtenerDatosTransacciones()
        {
            // Retorna una lista de transacciones de ejemplo.
            return new[]
            {
                new { IdTransaccion = "T001", Fecha = "01/10/2024", Concepto = "Pago", Monto = "200", Anulado = "No" },
                new { IdTransaccion = "T002", Fecha = "01/11/2024", Concepto = "Pago", Monto = "200", Anulado = "No" }
            };
        }

        protected void btnBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("VisualizarCreditosCliente.aspx");
        }
    }
}