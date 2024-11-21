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

        protected void btnGenerarReportes_Click(object sender, EventArgs e)
        {
            Byte[] FileBuffer = clienteDAO.reportePDF();
            if (FileBuffer != null)
            {
                Response.ContentType = "application/pdf";
                Response.AddHeader("content-length", FileBuffer.Length.ToString());
                Response.BinaryWrite(FileBuffer);
            }
        }

        protected void btnBuscarCli_Click(object sender, EventArgs e)
        {
            cliente[] listCli = null;
            gvClientes.DataSource = listCli = clienteDAO.listarClientesPorNombre(texBuscar.Text);
            gvClientes.DataBind();
        }

        //protected void btnAddMetodoPago_Click(object sender, EventArgs e)
        //{
        //    Response.Redirect("~/AdminAddMetodoPago.aspx");
        //}

        protected void btnDetalles_Click(object sender, EventArgs e)
        {
            Response.Redirect($"Registro.aspx?op=detail_cliente&cod_person={Int32.Parse(((Button)sender).CommandArgument)}");
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            /*CAMBIO*/
            Button btnEliminar = (Button) sender;
            int codigoCliente = Int32.Parse(btnEliminar.CommandArgument);
            if (clienteDAO.eliminarClienteLogico(codigoCliente))
            {
                msjSuccess.Text = "Se ha desactivado correctamente el cliente";
                gvClientes.DataBind();
            }
            else
            {
                msjError.Text = "Error: No se ha desactivo el cliente";
            }
        }

        //protected void btnActivar_Click(object sender, EventArgs e)
        //{

        //}

        protected void btnAddSupervisor_Click(object sender, EventArgs e)
        {
            Response.Redirect($"Registro.aspx?op=add_supervisor&cod_person=0");
        }

    }
}