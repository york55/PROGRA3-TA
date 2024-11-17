using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class MainAdmin : System.Web.UI.Page
    {
        ClienteWSClient clienteDAO = new ClienteWSClient();

        protected void Page_Init(object sender, EventArgs e)
        {
            administrador admin = (administrador)Session["Administrador"];
            if (admin == null)
            {
                Response.Redirect("Login.aspx");
            }
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
            }
        }

        protected void btnVisualizarSupervisores_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/ListaSupervisoresAsignar.aspx");
        }

        protected void btnVisualizarClientes_Click(object sender, EventArgs e)
        {

        }

        protected void btnGenerarReportes_Click(object sender, EventArgs e)
        {

        }

        protected void btnBuscarCli_Click(object sender, EventArgs e)
        {
            gvClientes.DataSource = clienteDAO.listarClientesPorNombre(texBuscar.Text);
            gvClientes.DataBind();
        }

        protected void btnDetalles_Click(object sender, EventArgs e)
        {
            Response.Redirect($"Registro.aspx?op=detail_cliente&cod_cli={Int32.Parse(((Button)sender).CommandArgument)}");
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {

        }
    }
}