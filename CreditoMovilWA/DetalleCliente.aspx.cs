using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleCliente : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Deshabilitar_Componentes()
        {
            txtNombre.Enabled = false;
            txtApPaterno.Enabled = false;
            txtApMaterno.Enabled = false;
            txtApMaterno.Enabled = false;
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {

        }
    }
}