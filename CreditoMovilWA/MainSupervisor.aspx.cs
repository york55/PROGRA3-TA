using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class MainSupervisor : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Aquí carga los datos de las evaluaciones
                CargarEvaluaciones();
            }
        }

        private void CargarEvaluaciones()
        {
            // Ejemplo de carga de datos, reemplaza con tu lógica real
            gvEvaluaciones.DataSource = ObtenerEvaluaciones();
            gvEvaluaciones.DataBind();
        }

        protected void btnVerDetalle_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            var idEvaluacion = btn.CommandArgument;

            // Redirigir a una página de detalles o abrir un modal con detalles
            Response.Redirect($"DetalleEvaluacion.aspx?IdEvaluacion={idEvaluacion}");
        }

        private object ObtenerEvaluaciones()
        {
            // Devuelve una lista de evaluaciones simulada para el ejemplo
            return new[]
            {
                new { IdEvaluacion = 1, Negocio = "Negocio 1", Ventas = 1000, MargenGanancia = 20, Puntaje = 80, Estado = "Aprobado" },
                new { IdEvaluacion = 2, Negocio = "Negocio 2", Ventas = 800, MargenGanancia = 25, Puntaje = 75, Estado = "Pendiente" },
                // Agrega más evaluaciones según tu lógica de datos
            };
        }
    }
}