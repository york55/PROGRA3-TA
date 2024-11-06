using CreditoMovilWA.CreditoMovil;
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

        private EvaluacionWSClient daoEvaluacion = new EvaluacionWSClient();

        protected void Page_Init(object sender, EventArgs e)
        {
            supervisor sup = (supervisor)Session["Supervisor"];
            if (sup == null)
            {
                Response.Redirect("Login.aspx");
            }
        }

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
            supervisor sup = (supervisor)Session["Supervisor"];


            // Ejemplo de carga de datos, reemplaza con tu lógica real
            gvEvaluaciones.DataSource = daoEvaluacion.listarEvaluacionesSupervisor(sup.codigoEv);
            gvEvaluaciones.DataBind();
        }

        protected void btnVerDetalle_Click(object sender, EventArgs e)
        {
            var btn = (Button)sender;
            string idEvaluacion = btn.CommandArgument;

            // Redirigir a una página de detalles o abrir un modal con detalleS

            Session["idEvaluacion"] = idEvaluacion;

            Response.Redirect($"DetalleEvaluacion.aspx");
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