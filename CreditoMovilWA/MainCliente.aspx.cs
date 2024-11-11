using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class MainCliente : System.Web.UI.Page
    {
        protected void Page_Init(object sender, EventArgs e)
        {
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
            cliente cli = (cliente)Session["Cliente"];
            if (cli == null)
            {
                Response.Redirect("Login.aspx");
            }
            hola.InnerText += " " + cli.nombre + "!";
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                cliente cli = (cliente)Session["Cliente"];
                double ranking = cli.ranking;

                // Asigna el puntaje al Label de ranking
                lblRanking.Text = ranking + "%";

                //Cambia el color del medidor basado en el puntaje (esto se puede personalizar)
                if (ranking < 25) 
                    lblRanking.ForeColor = System.Drawing.Color.Red;
                else if (ranking < 50) 
                    lblRanking.ForeColor = System.Drawing.Color.Orange;
                else if (ranking<75)
                    lblRanking.ForeColor = System.Drawing.Color.Yellow;
                else
                    lblRanking.ForeColor = System.Drawing.Color.Green;
            }
        }

        // Método para obtener el ranking sin el símbolo de porcentaje
        public string ObtenerRankingSinPorcentaje()
        {
            return lblRanking.Text.Replace("%", "");
        }

        protected void btnSolicitarCredito_Click(object sender, EventArgs e)
        {
         
            Response.Redirect("SolicitudCredito.aspx");
        }

        protected void btnVerCreditos_Click(object sender, EventArgs e)
        {
            Response.Redirect("VisualizarCreditosCliente.aspx");
        }

        protected void btnModificarDatos_Click(object sender, EventArgs e)
        {
            Response.Redirect("ModificarDatosCliente.aspx");
        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            Session["Cliente"] = null;
            Session["Supervisor"] = null;
            FormsAuthentication.SignOut();
            Response.Redirect("Home.aspx");
        }
    }
}