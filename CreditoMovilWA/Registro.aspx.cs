using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml.Linq;
using static System.Net.Mime.MediaTypeNames;
using System.Security.Cryptography;
using System.Text;

namespace CreditoMovilWA
{
    public partial class Registro : System.Web.UI.Page
    {

        private ClienteWSClient daoCliente = new ClienteWSClient();
        private SupervisorWSClient daoSupervisor = new SupervisorWSClient();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                text3.Visible = false;
                text1.Visible = false;
                text2.Visible = false;
                containerPassword.Visible = false;
                btnGuardar.Visible = false;
                datosSupervisor.Visible = false;
            }
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
            Session["TipoOperacion"] = Request.QueryString["op"];
            Session["CodigoPersona"] = Request.QueryString["cod_person"];
            if ((string)Session["TipoOperacion"] != null && (string)Session["CodigoPersona"] != null)
            {
                switch ((string)Session["TipoOperacion"])
                {
                    case ("detail_cliente"):
                        text2.Visible = true;
                        Deshabilitar_Componentes();
                        verContenidoCliente(int.Parse((string)Session["CodigoPersona"]));
                        break;
                    case ("add_cliente"):
                        text1.Visible = true;
                        containerPassword.Visible = true;
                        btnGuardar.Visible = true;
                        break;
                    case ("add_supervisor"):
                        text3.Visible = true;
                        datosSupervisor.Visible = true;
                        containerPassword.Visible = true;
                        btnGuardar.Visible = true;
                        break;
                }
            }
        }
        
        public void Deshabilitar_Componentes()
        {
            txtNombre.Enabled = false;
            txtApPaterno.Enabled = false;
            txtApMaterno.Enabled = false;
            ddlTipoDocumento.Enabled = false;
            txtNroDoc.Enabled = false;
            txtEmail.Enabled = false;
            txtTelefono.Enabled = false;
            txtDireccion.Enabled = false;
        }

        public void verContenidoCliente(int codCliente)
        {
            cliente cli = daoCliente.obtenerPorCodCliente(codCliente);
            txtNombre.Text = cli.nombre;
            txtApPaterno.Text = cli.apPaterno;
            txtApMaterno.Text = cli.apMaterno;
            ddlTipoDocumento.Text = cli.tipoDocumento.ToString();
            txtNroDoc.Text = cli.documento;
            txtEmail.Text = cli.email;
            txtTelefono.Text = cli.telefono;
            txtDireccion.Text = cli.direccion;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            /*CAMBIO*/
            if ((string)Session["TipoOperacion"] != null)
            {
                switch ((string)Session["TipoOperacion"])
                {
                    case ("detail_cliente"):
                        Response.Redirect("MainAdmin.aspx");
                        break;
                    case("add_cliente"):
                        Response.Redirect("Home.aspx");
                        break;
                    case("add_supervisor"):
                        Response.Redirect("MainAdmin.aspx");
                        break;
                }
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            int codPersona = int.Parse((string)Session["CodigoPersona"]);
            string tipOperacion = (string)Session["TipoOperacion"];

            switch (tipOperacion)
            {
                case ("add_cliente"):
                    insertarCliente();
                    break;
                case ("add_supervisor"):
                    insertarSupervisor();
                    break;
            }
        }

        private void insertarCliente()
        {
            cliente Cliente = new cliente();
            // Capturar los valores ingresados
            Cliente.idUsuario = 0;
            Cliente.nombre = txtNombre.Text.Trim();
            Cliente.apPaterno = txtApPaterno.Text.Trim();
            Cliente.apMaterno = txtApMaterno.Text.Trim();
            switch (ddlTipoDocumento.SelectedValue)
            {
                case "DNI":
                    Cliente.tipoDocumento = tipoDocumento.DNI;
                    break;
                case "Pasaporte":
                    Cliente.tipoDocumento = tipoDocumento.PASAPORTE;
                    break;
                case "Carnet_Extranjeria":
                    Cliente.tipoDocumento = tipoDocumento.CARNET_EXTRANJERIA;
                    break;
            }
            Cliente.tipoDocumentoSpecified = true;
            Cliente.documento = txtNroDoc.Text.Trim();
            Cliente.email = txtEmail.Text.Trim();
            Cliente.telefono = txtTelefono.Text.Trim();
            Cliente.direccion = txtDireccion.Text.Trim();
            string contrasena = txtContrasena.Text;

            // Validaciones básicas
            if (string.IsNullOrEmpty(Cliente.nombre) || string.IsNullOrEmpty(Cliente.apPaterno) ||
                string.IsNullOrEmpty(ddlTipoDocumento.SelectedValue) || string.IsNullOrEmpty(Cliente.documento) ||
                string.IsNullOrEmpty(Cliente.email) || string.IsNullOrEmpty(contrasena))
            {
                lblError.Text = "Por favor, complete todos los campos.";
                return;
            }


            string salt = GenerarSalt();
            // Aquí puedes agregar lógica para guardar los datos en la base de datos
            // Asegúrate de hashear la contraseña antes de almacenarla
            string hashedPassword = HashPassword(contrasena, salt);
            Cliente.contrasenha = hashedPassword;

            // Código para guardar en la base de datos...
            Cliente.tipoCliente = "Nuevo";
            Cliente.activo = true;
            Cliente.fecha = DateTime.Now;
            Cliente.fechaSpecified = true;
            Cliente.fechaVencimiento = DateTime.Now; // falta ver
            Cliente.fechaVencimientoSpecified = true;
            Cliente.ultimoLogueo = DateTime.Now; // falta ver, no lo utiliza para la creacion de cliente
            Cliente.ultimoLogueoSpecified = true;
            Cliente.codigoCliente = 0;
            Cliente.salt = salt;
            Cliente.ranking = 30;

            bool resultado = daoCliente.insertarCliente(Cliente);
            if (resultado)
            {
                Response.Redirect("Home.aspx");
            }
        }

        private void insertarSupervisor()
        {
            supervisor sup = new supervisor();
            sup.idUsuario = 0;
            sup.nombre = txtNombre.Text.Trim();
            sup.apPaterno = txtApPaterno.Text.Trim();
            sup.apMaterno = txtApMaterno.Text.Trim();
            switch (ddlTipoDocumento.SelectedValue)
            {
                case "DNI":
                    sup.tipoDocumento = tipoDocumento.DNI;
                    break;
                case "Pasaporte":
                    sup.tipoDocumento = tipoDocumento.PASAPORTE;
                    break;
                case "Carnet_Extranjeria":
                    sup.tipoDocumento = tipoDocumento.CARNET_EXTRANJERIA;
                    break;
            }
            sup.tipoDocumentoSpecified = true;
            sup.documento = txtNroDoc.Text.Trim();
            // Validaciones básicas
            string contrasena = txtContrasena.Text;
            if (string.IsNullOrEmpty(sup.nombre) || string.IsNullOrEmpty(sup.apPaterno) ||
                            string.IsNullOrEmpty(ddlTipoDocumento.SelectedValue) || string.IsNullOrEmpty(sup.documento)
                            || string.IsNullOrEmpty(contrasena))
            {
                lblError.Text = "Por favor, complete todos los campos.";
                return;
            }
            string saltSup = GenerarSalt();
            sup.activo = true;
            sup.contrasenha = HashPassword(contrasena, saltSup);
            sup.codigoCargo = int.Parse(txtCodigoCargo.Text.Trim());
            sup.agenciaAsignacion = txtAgencia.Text.Trim();
            sup.fecha = DateTime.Now;
            sup.fechaSpecified = true;
            sup.fechaVencimiento = DateTime.Now; // falta ver
            sup.fechaVencimientoSpecified = true;
            sup.ultimoLogueo = DateTime.Now; // falta ver, no lo utiliza para la creacion de cliente
            sup.ultimoLogueoSpecified = true;
            sup.salt = saltSup;
            sup.codigoEv = 11;

            bool res = daoSupervisor.insertarSupervisor(sup);
            if (res) Response.Redirect("Home.aspx");
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
    }
}