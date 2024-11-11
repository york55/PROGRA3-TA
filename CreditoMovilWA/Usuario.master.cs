using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace CreditoMovilWA
{
    public partial class Usuario : System.Web.UI.MasterPage
    {
        // PUSE ESTO EN APPLICATION xd
        /*protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Incrementa el contador de visitas
                if (Application["Visitas"] == null)
                {
                    Application["Visitas"] = 1;
                }
                else
                {
                    Application["Visitas"] = (int)Application["Visitas"] + 1;
                }


            }
        }*/

        public bool MostrarHeader
        {
            get { return headerDiv.Visible; }
            set { headerDiv.Visible = value; }
        }
        protected void btnLogout_Click(object sender, EventArgs e)
        {
            // Lógica de cierre de sesión, por ejemplo:
            //ession.Clear();
            Session["Cliente"] = null;
            Session["Supervisor"] = null;
            FormsAuthentication.SignOut();
            Response.Redirect("Home.aspx");
        }

        public static void ControlDeAcceso(HttpContext context, string requiredRole)
        {
            /*var user = context.Session["Usuario"] as Usuario;
            if (user == null || user.Role != requiredRole)
            {
                context.Response.Redirect("~/Login.aspx");
            }*/
        }
    }
}