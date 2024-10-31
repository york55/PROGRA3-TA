using CreditoMovilWA.ClienteWebService;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class Registro : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            cliente cli = new cliente();
            cli.nombre = txtNombre.Text;
            cli.apMaterno = txtApMaterno.Text;
            cli.apPaterno = txtApPaterno.Text;
            cli.email = txtEmail.Text;
            cli.direccion = txtDireccion.Text;
            cli.telefono = txtTelefono.Text;
            cli.tipoCliente = txtTipoDocumento.Text;

            Response.Redirect("Home.aspx");
        }
    }
}