using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
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
                // Inicializar datos o configuraciones necesarias
                lblMensaje.Text = "";
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
                    lblMensaje.Text = ""; // Limpia el mensaje si hay resultados
                }
                else
                {
                    gvCreditos.DataSource = null;
                    gvCreditos.DataBind();
                    lblMensaje.Text = "No se encontraron créditos en el rango de fechas especificado.";
                }
            }
            else
            {
                lblMensaje.Text = "Por favor, seleccione ambas fechas.";
            }
        }

        private List<Credito> ObtenerCreditosPorFecha(DateTime fechaInicio, DateTime fechaFin)
        {
            // Simulación de la obtención de datos. Reemplazar con la lógica de base de datos real.
            List<Credito> listaCreditos = new List<Credito>
            {
                new Credito { IdCredito = 1, Monto = 1000, NumCuotas = 10, TasaInteres = 5.0, FechaOtorgamiento = DateTime.Now, Estado = "Activo" },
                new Credito { IdCredito = 2, Monto = 2000, NumCuotas = 15, TasaInteres = 4.5, FechaOtorgamiento = DateTime.Now.AddMonths(-1), Estado = "Inactivo" }
            };

            return listaCreditos.FindAll(c => c.FechaOtorgamiento >= fechaInicio && c.FechaOtorgamiento <= fechaFin);
        }

        protected void btnPagar_Click(object sender, EventArgs e)
        {
            // Obtén el ID del crédito del CommandArgument
            Button btn = (Button)sender;
            string idCredito = btn.CommandArgument;

            // Código para manejar el pago del crédito con el ID especificado
            // Ejemplo: Response.Redirect("PagarCredito.aspx?id=" + idCredito);
        }

        protected void btnVerDetalles_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string idCredito = btn.CommandArgument;
            Response.Redirect("DetallesCredito.aspx?id=" + idCredito);
        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            // Lógica para cerrar sesión
            Response.Redirect("Login.aspx");
        }
    }

    //provisional para probar
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