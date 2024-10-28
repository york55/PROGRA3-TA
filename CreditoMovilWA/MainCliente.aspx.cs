using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class Main : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // ACa aun no implemento pero para mostrar
                Random random = new Random();
                int ranking = random.Next(1, 101);

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
        protected void btnLogout_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void btnSolicitarCredito_Click(object sender, EventArgs e)
        {
         
            Response.Redirect("SolicitudCredito.aspx");
        }

        protected void btnVerCreditos_Click(object sender, EventArgs e)
        {
            Response.Redirect("VisualizarCreditosCliente.aspx");
        }
    }
}