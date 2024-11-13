using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class ListaSupervisoresAsignar : System.Web.UI.Page
    {
        private AdministradorWSClient daoAdministrador = new AdministradorWSClient();
        private SupervisorWSClient daoSupervisor = new SupervisorWSClient();

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
            gvEvaluaciones.DataSource = daoSupervisor.listarTodosSupervisors();
            gvEvaluaciones.DataBind();
        }

        protected void btnAsignar_Click(object sender, EventArgs e)
        {
            
        }
    }
}