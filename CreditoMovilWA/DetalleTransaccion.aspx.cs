using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleTransaccion : System.Web.UI.Page
    {
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
            // Obtener la cadena de conexión desde Web.config
            string connectionString = ConfigurationManager.ConnectionStrings["ConexionBD"].ConnectionString;

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                string query = "SELECT IdTransaccion, FechaTransaccion, Agencia, Monto, Imagen FROM Transacciones WHERE IdTransaccion = @IdTransaccion";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@IdTransaccion", idTransaccion);

                conn.Open();
                SqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    // Asignar los valores a los controles
                    txtIdTransaccion.Text = reader["IdTransaccion"].ToString();
                    txtFechaTransaccion.Text = Convert.ToDateTime(reader["FechaTransaccion"]).ToString("dd/MM/yyyy");
                    txtAgencia.Text = reader["Agencia"].ToString();
                    txtMonto.Text = Convert.ToDecimal(reader["Monto"]).ToString("C"); // Formato de moneda

                    // Asignar el número de transacción al encabezado
                    lblNumeroTransaccion.Text = reader["IdTransaccion"].ToString();

                    // Asignar la imagen
                    imgTransaccion.ImageUrl = $"Handlers/MostrarImagen.ashx?id={idTransaccion}";
                }
                else
                {
                    // Manejar si no se encuentra la transacción
                    Response.Write("Transacción no encontrada.");
                }

                reader.Close();
            }
        }
    }
}