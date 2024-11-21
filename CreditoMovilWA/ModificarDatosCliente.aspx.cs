using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
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
            /*Datos Cliente*/
            cliente cli = (cliente)Session["Cliente"];
            if(!string.IsNullOrEmpty(txtNombre.Text)) cli.nombre = txtNombre.Text;
            if (!string.IsNullOrEmpty(txtApPaterno.Text)) cli.apPaterno = txtApPaterno.Text;
            if (!string.IsNullOrEmpty(txtApMaterno.Text)) cli.apMaterno = txtApMaterno.Text;
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
            if (!string.IsNullOrEmpty(txtNroDoc.Text)) cli.documento = txtNroDoc.Text;
            if (!string.IsNullOrEmpty(txtEmail.Text)) cli.email = txtEmail.Text;
            if (!string.IsNullOrEmpty(txtTelefono.Text)) cli.telefono = txtTelefono.Text;
            if (!string.IsNullOrEmpty(txtDireccion.Text)) cli.direccion = txtDireccion.Text;
            cli.activo = true;
            cli.fecha = DateTime.Now;
            cli.fechaSpecified = true;
            cli.fechaVencimiento = DateTime.Now; // falta ver
            cli.fechaVencimientoSpecified = true;
            cli.ultimoLogueo = DateTime.Now; // falta ver, no lo utiliza para la creacion de cliente
            cli.ultimoLogueoSpecified = true;
            string contraNueva = txtContrasenaNueva.Text;
            string contraConfNueva = txtConfirmarContrasena.Text;
            string contraAntigua = txtContrasenhaActual.Text;

            /*Validacion*/
            if (!string.IsNullOrEmpty(contraAntigua))
            {
                if (VerificarContraseña(contraAntigua, cli.salt, cli.contrasenha))
                {
                    /*Si agrega nueva contraseña*/
                    if (!string.IsNullOrEmpty(contraNueva) &&
                        !string.IsNullOrEmpty(contraConfNueva) && contraNueva.Equals(contraConfNueva))
                    {
                        string salt = GenerarSalt();
                        string hashedPassword = HashPassword(contraNueva, salt);
                        cli.contrasenha = hashedPassword;
                        cli.salt = salt;
                    }
                    else
                    {
                        lblError.Text = "Las contraseñas no coinciden";
                    }

                    bool res = daoCliente.modificarCliente(cli);
                    if (res)
                    {
                        Response.Redirect("MainCliente.aspx");
                    }
                    else lblError.Text = "No se pudo modificar los datos.";
                }
                else lblError.Text = "Ingrese correctamente su contraseña";
            }
            else lblError.Text = "Por favor ingrese su contraseña actual";
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
        private string HashPassword(string password, string salt)
        {
            string saltedPassword = password + salt;

            using (var sha256 = SHA256.Create())
            {
                byte[] hashBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(saltedPassword));
                return Convert.ToBase64String(hashBytes);
            }
        }
        private string GenerarSalt()
        {
            using (var rng = new RNGCryptoServiceProvider())
            {
                byte[] saltBytes = new byte[16];
                rng.GetBytes(saltBytes);
                return Convert.ToBase64String(saltBytes);
            }
        }
        private bool VerificarContraseña(string contraseñaIngresada, string salAlmacenada, string contraseñaHashAlmacenada)
        {
            // Combinar la contraseña ingresada con el salt almacenado
            string saltedPassword = contraseñaIngresada + salAlmacenada;

            // Recalcular el hash usando SHA256
            using (var sha256 = SHA256.Create())
            {
                byte[] hashBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(saltedPassword));
                string computedHash = Convert.ToBase64String(hashBytes);

                // Comparar el hash calculado con el hash almacenado
                return computedHash == contraseñaHashAlmacenada;
            }
        }
    }
}