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
            
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnVisualizarSupervisores_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/ListaSupervisoresAsignar.aspx");
        }

    }
}