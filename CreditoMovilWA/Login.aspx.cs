using System;
using System.Web.UI.WebControls;
using System.Web.UI;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Cryptography;

namespace CreditoMovilWA
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
        }

        protected void btnIngresar_Click(object sender, EventArgs e)
        {
            // falta implementar logica de inicio
            //if(esCliente)
            Response.Redirect("MainCliente.aspx");
            //Session["Usuario"] = new Usuario { Nombre = "NombreUsuario", Role = "Cliente" };

            //else(esSupervisor)
            //Response.Redirect("MainSupervisor.aspx");
            //Session["Usuario"] = new Usuario { Nombre = "NombreUsuario", Role = "Supervisor" };
            //else
            //Response.Redorect("MainAdmin.aspx");
            //Session["Usuario"] = new Usuario { Nombre = "NombreUsuario", Role = "Admin" };

            string dni = txtDocumento.Text.Trim();
            string password = txtPassword.Text;

            // Obtener la cadena de conexión desde Web.config
            /*tring connectionString = ConfigurationManager.ConnectionStrings["ConexionBD"].ConnectionString;

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                string query = "SELECT ContraseñaHash, Sal FROM Usuarios WHERE DNI = @DNI";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@DNI", dni);

                conn.Open();
                SqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                {
                    string contraseñaHashAlmacenada = reader["ContraseñaHash"].ToString();
                    string salAlmacenada = reader["Sal"].ToString();

                    // Verificar la contraseña ingresada
                    bool esValida = VerificarContraseña(password, salAlmacenada, contraseñaHashAlmacenada);

                    if (esValida)
                    {
                        // La contraseña es correcta, iniciar sesión
                        Session["UsuarioDNI"] = dni;
                        Response.Redirect("MainCliente.aspx");
                    }
                    else
                    {
                        // Contraseña incorrecta
                        lblError.Text = "Usuario o contraseña incorrectos.";
                    }
                }
                else
                {
                    // Usuario no encontrado
                    lblError.Text = "Usuario o contraseña incorrectos.";
                }

                reader.Close();
            }*/

            //Session["UsuarioDNI"] = dni;
        }

        private bool VerificarContraseña(string contraseñaIngresada, string salAlmacenada, string contraseñaHashAlmacenada)
        {
            // Convertir la sal y la contraseña hasheada almacenadas de Base64 a bytes
            byte[] salBytes = Convert.FromBase64String(salAlmacenada);
            byte[] hashAlmacenadoBytes = Convert.FromBase64String(contraseñaHashAlmacenada);

            // Hashear la contraseña ingresada con la misma sal
            using (var pbkdf2 = new Rfc2898DeriveBytes(contraseñaIngresada, salBytes, 10000))
            {
                byte[] hashIngresadoBytes = pbkdf2.GetBytes(32); // 256 bits

                // Comparar los hashes
                return hashIngresadoBytes.SequenceEqual(hashAlmacenadoBytes);
            }
        }
    }
}