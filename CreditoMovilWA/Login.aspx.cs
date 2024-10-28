using System;
using System.Web.UI.WebControls;
using System.Web.UI;

namespace CreditoMovilWA
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnIngresar_Click(object sender, EventArgs e)
        {
            // falta implementar logica de inicio
            //if(esCliente)
            Response.Redirect("MainCliente.aspx");
            //else(esSupervisor)
            //Response.Redirect("MainSupervisor.aspx");
            //else
            //Response.Redorect("MainAdmin.aspx");
        }
    }
}