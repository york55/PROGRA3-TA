using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class ModificarDatosCliente : System.Web.UI.Page
    {
        private ClienteWSClient daoCliente = new ClienteWSClient();
        protected void Page_Load(object sender, EventArgs e)
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
            else {
                if (!IsPostBack)
                {
                    cargarDatosCliente();
                }
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            cliente cli = (cliente)Session["Cliente"];
            cli.nombre = txtNombre.Text;
            cli.apPaterno = txtApPaterno.Text;
            cli.apMaterno = txtApMaterno.Text;
            switch (ddlTipoDocumento.SelectedValue)
            {
                case "DNI":
                    cli.tipoDocumento = tipoDocumento.DNI;
                    break;
                case "Pasaporte":
                    cli.tipoDocumento = tipoDocumento.PASAPORTE;
                    break;
                case "Carnet_Extranjeria":
                    cli.tipoDocumento = tipoDocumento.CARNET_EXTRANJERIA;
                    break;
            }
            cli.documento = txtNroDoc.Text;
            cli.email = txtEmail.Text;
            cli.telefono = txtTelefono.Text;
            cli.direccion = txtDireccion.Text;
            string contrasena = txtContrasena.Text;
            string hashedPassword = HashPassword(contrasena);
            cli.contrasenha = contrasena;

            bool res = daoCliente.modificarCliente(cli);
            if (res) Response.Redirect("MainCliente.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainCliente.aspx");
        }
        private void cargarDatosCliente()
        {
            cliente cli = (cliente)Session["Cliente"];
            txtNombre.Text = cli.nombre;
            txtApPaterno.Text = cli.apPaterno;
            txtApMaterno.Text = cli.apMaterno;
            ddlTipoDocumento.Text = cli.tipoDocumento.ToString();
            txtNroDoc.Text = cli.documento;
            txtEmail.Text = cli.email;
            txtTelefono.Text = cli.telefono;
            txtDireccion.Text = cli.direccion;
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