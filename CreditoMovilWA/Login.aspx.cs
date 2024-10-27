using System;

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
        Response.Redirect("Main.aspx");
        }
    }
}