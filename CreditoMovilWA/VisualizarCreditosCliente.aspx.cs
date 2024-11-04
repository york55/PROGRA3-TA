using System;
using System.Collections.Generic;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class VisualizarCreditos : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                lblError.Text = "";
            }
            else if (ViewState["ModalAbierto"] != null && (bool)ViewState["ModalAbierto"])
            {
                ScriptManager.RegisterStartupScript(this, GetType(), "AbrirModal", "openModal();", true);
            }
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            DateTime fechaInicio, fechaFin;
            bool isFechaInicio = DateTime.TryParse(txtFechaInicio.Text, out fechaInicio);
            bool isFechaFin = DateTime.TryParse(txtFechaFin.Text, out fechaFin);

            if (isFechaInicio && isFechaFin)
            {
                var resultados = ObtenerCreditosPorFecha(fechaInicio, fechaFin);

                if (resultados.Count > 0)
                {
                    gvCreditos.DataSource = resultados;
                    gvCreditos.DataBind();
                    lblError.Text = "";
                }
                else
                {
                    gvCreditos.DataSource = null;
                    gvCreditos.DataBind();
                    lblError.Text = "No se encontraron créditos en el rango de fechas especificado.";
                }
            }
            else
            {
                lblError.Text = "Por favor, seleccione ambas fechas.";
            }
        }

        private List<Credito> ObtenerCreditosPorFecha(DateTime fechaInicio, DateTime fechaFin)
        {
            List<Credito> listaCreditos = new List<Credito>
            {
                new Credito { IdCredito = 1, Monto = 1000, NumCuotas = 10, TasaInteres = 5.0, FechaOtorgamiento = DateTime.Now, Estado = "Activo" },
                new Credito { IdCredito = 2, Monto = 2000, NumCuotas = 15, TasaInteres = 4.5, FechaOtorgamiento = DateTime.Now.AddMonths(-1), Estado = "Inactivo" }
            };

            return listaCreditos.FindAll(c => c.FechaOtorgamiento >= fechaInicio && c.FechaOtorgamiento <= fechaFin);
        }

        protected void btnPagar_Click(object sender, EventArgs e)
        {
            string idCredito = (sender as Button).CommandArgument;
            ViewState["ModalAbierto"] = true; // Almacena el estado del modal en ViewState
            ClientScript.RegisterStartupScript(this.GetType(), "OpenModal", "openModal();", true);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            if (fileUpload.HasFile)
            {
                // Guarda el archivo en Session para uso posterior
                Session["ImagenPago"] = fileUpload.FileBytes;

                lblError.Text = "Archivo subido correctamente y pago registrado.";
                lblError.ForeColor = System.Drawing.Color.Green;
            }
            else
            {
                lblError.Text = "Por favor, selecciona un archivo para subir.";
                lblError.ForeColor = System.Drawing.Color.Red;
            }

            // Cierra el modal después de grabar
            ViewState["ModalAbierto"] = false;
            ScriptManager.RegisterStartupScript(this, this.GetType(), "CloseModal", "closeModal();", true);
        }

        protected void btnVerDetalles_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string idCredito = btn.CommandArgument;
            Session["idCredito"] = idCredito;
            Response.Redirect("DetalleCredito.aspx");
        }
    }

    public class Credito
    {
        public int IdCredito { get; set; }
        public double Monto { get; set; }
        public int NumCuotas { get; set; }
        public double TasaInteres { get; set; }
        public DateTime FechaOtorgamiento { get; set; }
        public string Estado { get; set; }
    }
}
