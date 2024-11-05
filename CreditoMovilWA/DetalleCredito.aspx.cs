using CreditoMovilWA.CreditoMovil;
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
        private CreditoWSClient daoCredito = new CreditoWSClient();
        private TransaccionWSClient daoTransaccion = new TransaccionWSClient();
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
            String id = (String) Session["idCredito"];

            credito cred = daoCredito.obtenerPorIDCredito(id);

            Session["Credito"] = cred;
            // Cargar datos de ejemplo para los detalles del crédito.
            txtFechaOtorgamiento.Text = cred.fechaOtorgamiento.ToString();
            txtEstado.Text = cred.estado;
            txtMonto.Text = cred.monto.ToString();
            txtNumeroCuotas.Text = cred.numCuotas.ToString();
            txtTasaInteres.Text = cred.tasaInteres.ToString()+"%";

            idCredito.InnerText += " " + cred.numCredito;
        }

        private void CargarTransacciones()
        {
            credito cred = (credito)Session["Credito"];

            // Cargar datos de ejemplo o conectar a la base de datos para obtener transacciones.
            gvTransacciones.DataSource = daoTransaccion.listarTodosTransaccions(); // falta el metodo que sea listar por credito :p
            gvTransacciones.DataBind();
        }

        protected void btnVerDetalleTransaccion_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string idTransaccion = btn.CommandArgument;
            Session["idTransaccion"] = idTransaccion;
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