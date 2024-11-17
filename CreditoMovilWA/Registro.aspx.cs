﻿using CreditoMovilWA.CreditoMovil;
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

namespace CreditoMovilWA
{
    public partial class Registro : System.Web.UI.Page
    {

        private ClienteWSClient daoCliente = new ClienteWSClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) {
                text2.Visible = false;
            }
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
            Session["TipoOperacion"] = Request.QueryString["op"];
            string cod = Request.QueryString["cod_cli"];
            if ((string)Session["TipoOperacion"] != null && cod != null)
            {
                containerPassword.Visible = false;
                btnGuardar.Visible = false;
                text1.Visible = false;
                text2.Visible = true;
                Deshabilitar_Componentes();
                ContenidoCliente(int.Parse(cod));
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

        public void ContenidoCliente(int codCliente)
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
            if((string)Session["TipoOperacion"] != null)
            {
                if (((string)Session["TipoOperacion"]).Equals("detail_cliente"))
                {
                    Response.Redirect("MainAdmin.aspx");
                }
            }
            else Response.Redirect("Home.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
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

            // Aquí puedes agregar lógica para guardar los datos en la base de datos
            // Asegúrate de hashear la contraseña antes de almacenarla
            string hashedPassword = HashPassword(contrasena);
            Cliente.contrasenha = contrasena;

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
            Cliente.ranking = 30;

            bool resultado = daoCliente.insertarCliente(Cliente);
            if (resultado)
            {
                Response.Redirect("Home.aspx");
            }

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