using CreditoMovilWA.ClienteWebService;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class Registro : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            // Capturar los valores ingresados
            string nombre = txtNombre.Text.Trim();
            string apPaterno = txtApPaterno.Text.Trim();
            string apMaterno = txtApMaterno.Text.Trim();
            string tipoDocumento = ddlTipoDocumento.SelectedValue;
            string nroDocumento = txtNroDoc.Text.Trim();
            string email = txtEmail.Text.Trim();
            string telefono = txtTelefono.Text.Trim();
            string direccion = txtDireccion.Text.Trim();
            string contrasena = txtContrasena.Text;

            // Validaciones básicas
            if (string.IsNullOrEmpty(nombre) || string.IsNullOrEmpty(apPaterno) ||
                string.IsNullOrEmpty(tipoDocumento) || string.IsNullOrEmpty(nroDocumento) ||
                string.IsNullOrEmpty(email) || string.IsNullOrEmpty(contrasena))
            {
                lblError.Text = "Por favor, complete todos los campos.";
                return;
            }

            // Aquí puedes agregar lógica para guardar los datos en la base de datos
            // Asegúrate de hashear la contraseña antes de almacenarla
            string hashedPassword = HashPassword(contrasena);

            // Código para guardar en la base de datos...

            // Redirigir o mostrar mensaje de éxito
            Response.Redirect("Home.aspx");
        }

        private string HashPassword(string password)
        {
            // Implementa un método seguro para hashear la contraseña
            // Por ejemplo, utilizando SHA256 (aunque se recomienda usar algoritmos más seguros como BCrypt)
            using (System.Security.Cryptography.SHA256 sha256 = System.Security.Cryptography.SHA256.Create())
            {
                byte[] bytes = System.Text.Encoding.UTF8.GetBytes(password);
                byte[] hash = sha256.ComputeHash(bytes);
                return Convert.ToBase64String(hash);
            }
        }
    }
}