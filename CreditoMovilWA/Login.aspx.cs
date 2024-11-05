using System;
using System.Web.UI.WebControls;
using System.Web.UI;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Cryptography;
using CreditoMovilWA.CreditoMovil;
using System.Web.Security;
using System.Web;

namespace CreditoMovilWA
{
    public partial class Login : System.Web.UI.Page
    {
        private ClienteWSClient daoCliente = new ClienteWSClient();
        private SupervisorWSClient daoSupervisor = new SupervisorWSClient();    
        protected static cliente[] todoClientes = null;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Master is Usuario masterPage)
            {
                masterPage.MostrarHeader = false; // Oculta el header en esta página
            }
        }

        protected void btnIngresar_Click(object sender, EventArgs e)
        {

            string tipoDocumento = ddlTipoDocumento.SelectedValue;
            string numDocumentoIdentidad = txtDocumento.Text.Trim();
            string password = txtPassword.Text;

            if (tipoDocumento != null && numDocumentoIdentidad != null && password != null)
            {

                cliente cli = daoCliente.obtenerPorDocIdenCliente(numDocumentoIdentidad, tipoDocumento);
                supervisor sup = daoSupervisor.obtenerPorDocIdenSup(numDocumentoIdentidad, tipoDocumento);
                administrador admin = new administrador();
                Session["Cliente"] = cli;
                Session["Supervisor"] = sup;
                if (cli != null)
                {
                    if (cli.contrasenha == password)
                    {
                        FormsAuthenticationTicket tkt;
                        string cookiestr;
                        HttpCookie ck;
                        tkt = new FormsAuthenticationTicket(1, cli.codigoCliente, DateTime.Now,
                        DateTime.Now.AddMinutes(30), true, cli.nombre+" "+cli.apPaterno+" "+cli.apMaterno);
                        cookiestr = FormsAuthentication.Encrypt(tkt);
                        ck = new HttpCookie(FormsAuthentication.FormsCookieName, cookiestr);
                        ck.Expires = tkt.Expiration; //esto genera que la cookie se quede guardada
                        ck.Path = FormsAuthentication.FormsCookiePath;
                        Response.Cookies.Add(ck);

                        string strRedirect;
                        strRedirect = Request["ReturnUrl"];
                        if (strRedirect == null)
                            strRedirect = "MainCliente.aspx";
                        Response.Redirect(strRedirect, true);
                    }
                    else
                    {
                        lblError.Text = "Usuario o contraseña incorrectos.";
                    }
                }
                if (sup != null)
                {
                    if (sup.contrasenha != password)
                    {
                        FormsAuthenticationTicket tkt;
                        string cookiestr;
                        HttpCookie ck;
                        tkt = new FormsAuthenticationTicket(1, cli.codigoCliente, DateTime.Now,
                        DateTime.Now.AddMinutes(30), true, sup.nombre + " " + sup.apPaterno + " " + sup.apMaterno);
                        cookiestr = FormsAuthentication.Encrypt(tkt);
                        ck = new HttpCookie(FormsAuthentication.FormsCookieName, cookiestr);
                        ck.Expires = tkt.Expiration; //esto genera que la cookie se quede guardada
                        ck.Path = FormsAuthentication.FormsCookiePath;
                        Response.Cookies.Add(ck);

                        string strRedirect;
                        strRedirect = Request["ReturnUrl"];
                        if (strRedirect == null)
                            strRedirect = "MainSupervisor.aspx";
                        Response.Redirect(strRedirect, true);
                    }
                    else
                    {
                        lblError.Text = "Usuario o contraseña incorrectos.";
                    }
                }
            }
            else
            {
                lblError.Text = "Por favor, ingrese sus datos.";
            }

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