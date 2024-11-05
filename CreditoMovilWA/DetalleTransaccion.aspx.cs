using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleTransaccion : System.Web.UI.Page
    {
        private TransaccionWSClient daoTransaccion = new TransaccionWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Obtener el ID de la transacción desde la consulta
                string idTransaccion = (string)Session["idTransaccion"];
                if (!string.IsNullOrEmpty(idTransaccion))
                {
                    // Cargar los datos de la transacción
                    CargarDatosTransaccion(idTransaccion);
                }

            }
        }
        private void CargarDatosTransaccion(string idTransaccion)
        {
            transaccion trans = daoTransaccion.obtenerPorIDTransaccion(Int32.Parse(idTransaccion));
            txtAgencia.Text = trans.agencia;
            txtIdTransaccion.Text = trans.numOperacion.ToString();
            txtFechaTransaccion.Text = trans.fecha.ToString();
            txtMonto.Text = trans.monto.ToString();
            if (trans.foto != null)
            {
                string base64String = Convert.ToBase64String(trans.foto);
                string imageUrl = "data:image/jpeg;base64," + base64String;
                imgTransaccion.ImageUrl = imageUrl;
            }
        }
    }
}