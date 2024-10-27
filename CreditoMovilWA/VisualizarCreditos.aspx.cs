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
                // Cargar datos iniciales de los créditos si es necesario
                CargarCreditos();
            }
        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            // Código para cerrar sesión
            // Session.Abandon();
            Response.Redirect("Main.aspx");
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Código para filtrar los créditos según los criterios de búsqueda
            string fechaInicio = txtFechaInicio.Text;
            string fechaFin = txtFechaFin.Text;
            string estado = txtEstado.Text;
            // Lógica para filtrar y actualizar el GridView
            CargarCreditos(fechaInicio, fechaFin, estado);
        }

        protected void btnPagar_Click(object sender, EventArgs e)
        {
            // Obtener el ID del crédito a pagar desde el CommandArgument del botón
            string idCredito = ((Button)sender).CommandArgument;
            // Código para procesar el pago del crédito con el ID especificado
        }

        private void CargarCreditos(string fechaInicio = "", string fechaFin = "", string estado = "")
        {
            // Lógica para cargar los datos de los créditos y enlazarlos al GridView
            // gvCreditos.DataSource = ...;
            // gvCreditos.DataBind();
        }
    }
}