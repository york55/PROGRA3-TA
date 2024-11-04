using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Configuration;
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

        private ClienteWSClient daoCliente = new ClienteWSClient();
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            //cliente Cliente = new cliente();

            //// Capturar los valores ingresados
            //Cliente.idUsuario = 0;
            //Cliente.nombre = txtNombre.Text.Trim();
            //Cliente.apPaterno = txtApPaterno.Text.Trim();
            //Cliente.apMaterno = txtApMaterno.Text.Trim();
            //switch (ddlTipoDocumento.SelectedValue)
            //{
            //    case "DNI":
            //        Cliente.tipoDocumento = tipoDocumento.DNI;
            //        break;
            //    case "Pasaporte":
            //        Cliente.tipoDocumento = tipoDocumento.PASAPORTE;
            //        break;
            //    case "Carnet_Extranjeria":
            //        Cliente.tipoDocumento = tipoDocumento.CARNET_EXTRANJERIA;
            //        break;
            //}
            //Cliente.documento = txtNroDoc.Text.Trim();
            //Cliente.email = txtEmail.Text.Trim();
            //Cliente.telefono = txtTelefono.Text.Trim();
            //Cliente.direccion = txtDireccion.Text.Trim();
            string contrasena = txtContrasena.Text;

            //// Validaciones básicas
            //if (string.IsNullOrEmpty(Cliente.nombre) || string.IsNullOrEmpty(Cliente.apPaterno) ||
            //    string.IsNullOrEmpty(ddlTipoDocumento.SelectedValue) || string.IsNullOrEmpty(Cliente.documento) ||
            //    string.IsNullOrEmpty(Cliente.email) || string.IsNullOrEmpty(contrasena))
            //{
            //    lblError.Text = "Por favor, complete todos los campos.";
            //    return;
            //}

            //// Aquí puedes agregar lógica para guardar los datos en la base de datos
            //// Asegúrate de hashear la contraseña antes de almacenarla
            string hashedPassword = HashPassword(contrasena);
            //Cliente.contrasenha = hashedPassword;

            //// Código para guardar en la base de datos...
            //Cliente.tipoCliente = "DE_BAJA";
            //Cliente.activo = true;
            //Cliente.fecha = DateTime.Now;
            //Cliente.fechaVencimiento = DateTime.Now; // falta ver
            ////Cliente.ultimoLogueo = DateTime.Now; // falta ver, no lo utiliza para la creacion de cliente
            //Cliente.codigoCliente = "CLI-003";

            //bool resultado = daoCliente.insertarCliente(Cliente);
            //if (resultado)
            //{
            //    Response.Redirect("Home.aspx");
            //}

            CreditoMovilWA.otroPrueba.ClienteWSClient cli = new CreditoMovilWA.otroPrueba.ClienteWSClient();
            bool val = false;
            switch (ddlTipoDocumento.SelectedValue)
            {
                case "DNI":
                    val = cli.insertarClienteParametros(0, DateTime.Now, txtNombre.Text.Trim(), txtApPaterno.Text.Trim(),
                        txtApMaterno.Text.Trim(), hashedPassword, DateTime.Now, true, CreditoMovilWA.otroPrueba.tipoDocumento.DNI,
                        txtNroDoc.Text.Trim(), "CLI-004", txtDireccion.Text.Trim(), txtTelefono.Text.Trim(), txtEmail.Text.Trim(),
                        "EXCELENTE");
                    break;
                case "Pasaporte":
                    val = cli.insertarClienteParametros(0, DateTime.Now, txtNombre.Text.Trim(), txtApPaterno.Text.Trim(),
                            txtApMaterno.Text.Trim(), hashedPassword, DateTime.Now, true, CreditoMovilWA.otroPrueba.tipoDocumento.PASAPORTE,
                            txtNroDoc.Text.Trim(), "CLI-004", txtDireccion.Text.Trim(), txtTelefono.Text.Trim(), txtEmail.Text.Trim(),
                            "EXCELENTE");
                    break;
                case "Carnet_Extranjeria":
                    val = cli.insertarClienteParametros(0, DateTime.Now, txtNombre.Text.Trim(), txtApPaterno.Text.Trim(),
                            txtApMaterno.Text.Trim(), hashedPassword, DateTime.Now, true, CreditoMovilWA.otroPrueba.tipoDocumento.CARNET_EXTRANJERIA,
                            txtNroDoc.Text.Trim(), "CLI-004", txtDireccion.Text.Trim(), txtTelefono.Text.Trim(), txtEmail.Text.Trim(),
                            "EXCELENTE");
                    break;
            }

            /*
             OBSERVACIONES, AGREGUÉ UN SERVICIO QUE ES OTRO PRUEBA EN REFERENCIA DE SERVICIO
            AGREGUÉ OTRO INSERTAR PERO CON PARÁMETROS PORQUE ME ESTABA RAYANDO CON EL OTRO NO ME DABA.
            Importante para que funcione, cambiar siempre CODIGO DE CLIENTE
             */
            if (val) Response.Redirect("Home.aspx");
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