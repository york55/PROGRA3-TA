using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Data.SqlTypes;
using System.IO;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class VisualizarCreditos : System.Web.UI.Page
    {

        private CreditoWSClient daoCredito = new CreditoWSClient();
        private TransaccionWSClient daoTransaccion = new TransaccionWSClient();
        private BancoWSClient daoBanco = new BancoWSClient();
        private BilleteraWSClient daoBilletera = new BilleteraWSClient();


        protected void Page_Init(object sender, EventArgs e)
        {
            cliente cli = (cliente)Session["Cliente"];
            if (cli == null)
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                lblError.Text = "";
            }
            else if (ViewState["ModalAbierto"] != null && (bool)ViewState["ModalAbierto"])
            {
                ScriptManager.RegisterStartupScript(this, GetType(), "AbrirModal", "openModal();", true);
            }
        }
        protected void gvCreditos_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow) // Asegúrate de que sea una fila de datos
            {
                var dataItem = e.Row.DataItem as credito; // Reemplaza 'Credito' con tu tipo de datos
                if (dataItem != null) // Valida que dataItem no sea null
                {
                    var btnPagar = (Button)e.Row.FindControl("btnPagar");
                    if (btnPagar != null) // Valida que btnPagar no sea null
                    {
                        if (dataItem.estado?.ToLower() == "pendiente" || dataItem.numCuotas == 0)
                        {
                            btnPagar.Visible = false; // Oculta el botón
                        }
                    }
                }
            }
        }
        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            cliente cli = (cliente) Session["Cliente"];
            
            DateTime fechaInicio, fechaFin;
            bool isFechaInicio = DateTime.TryParse(txtFechaInicio.Text, out fechaInicio);
            bool isFechaFin = DateTime.TryParse(txtFechaFin.Text, out fechaFin);
            string estado;
            estado = ddlEstado.SelectedValue;
            if (estado == "") estado = null;

            if (isFechaInicio && isFechaFin)
            {
                //var resultados = ObtenerCreditosPorFecha(fechaInicio, fechaFin);
                var resultados = daoCredito.listarCreditosClientePorFecha(cli.codigoCliente, fechaInicio, fechaFin, estado);

                if (resultados != null)
                {
                    gvCreditos.DataSource = resultados;
                    gvCreditos.DataBind();
                    lblError.Text = "";
                }
                else
                {
                    gvCreditos.DataSource = null;
                    gvCreditos.DataBind();
                    lblError.Text = "No se encontraron créditos en el rango de fechas especificado.";
                }
            }
            else
            {
                lblError.Text = "Por favor, seleccione ambas fechas.";
            }
        }

        protected void btnPagar_Click(object sender, EventArgs e)
        {
            string idCredito = (sender as Button).CommandArgument;
            ViewState["ModalAbierto"] = true; // Almacena el estado del modal en ViewState
            ClientScript.RegisterStartupScript(this.GetType(), "OpenModal", "openModal();", true);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            transaccion trans = new transaccion();
            if (fileUpload.HasFile)
            {
                string metodoP = metodoPago.Value;
                if(metodoP == "banco")
                {
                    agregarFoto();
                    banco bank = new banco();
                    bank.idMetodoPago = 0;
                    bank.foto = (byte[])Session["ImagenPago"];
                    bank.nombreTitular = txtTitularBanco.Text;
                    bank.CCI = txtCCI.Text;
                    bank.tipoCuenta = txtTipoCuenta.Text;
                    bank.nombreBanco = bancoElegido.Value;

                    trans.agencia = metodoP;
                    if (daoBanco.insertarBanco(bank))
                    {
                        // Cierra el modal después de grabar
                        ViewState["ModalAbierto"] = false;
                        ScriptManager.RegisterStartupScript(this, this.GetType(), "CloseModal", "closeModal();", true);
                    }
                }
                else if(metodoP == "billetera")
                {
                    agregarFoto();
                    billetera bill = new billetera();
                    bill.idMetodoPago = 0;
                    bill.foto = (byte[])Session["ImagenPago"];
                    bill.nombreBilletera = "FALTA AGREGAR";
                    bill.numeroTelefono = txtNumeroBilletera.Text;
                    bill.nombreTitular = txtTitularBilletera.Text;

                    if (daoBilletera.insertarBilletera(bill))
                    {
                        // Cierra el modal después de grabar
                        ViewState["ModalAbierto"] = false;
                        ScriptManager.RegisterStartupScript(this, this.GetType(), "CloseModal", "closeModal();", true);
                    }
                    trans.agencia = metodoP;
                }

                trans.fecha = DateTime.Now;
                trans.foto = (byte[])Session["ImagenPago"];
                trans.concepto = "Pago de Crédito";
                trans.monto = 123; // FALTA EL MONTO
                trans.anulado = false;
                trans.credito = (credito)Session["Credito"];
                


                lblError.Text = "Archivo subido correctamente y pago registrado.";
                lblError.ForeColor = System.Drawing.Color.Green;
            }
            else
            {
                lblError.Text = "Por favor, selecciona un archivo para subir.";
                lblError.ForeColor = System.Drawing.Color.Red;
            }

            //// Cierra el modal después de grabar
            //ViewState["ModalAbierto"] = false;
            //ScriptManager.RegisterStartupScript(this, this.GetType(), "CloseModal", "closeModal();", true);
        }

        protected void btnVerDetalles_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string idCredito = btn.CommandArgument;
            Session["idCredito"] = idCredito;
            Response.Redirect("DetalleCredito.aspx");
        }

        protected void btnBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainCliente.aspx");
        }

        private void agregarFoto()
        {
            if (fileUpload.HasFile && fileUpload.PostedFile != null)
            {
                string extension = Path.GetExtension(fileUpload.FileName);
                if (extension.ToLower() == ".jpg" || extension.ToLower() == ".jpeg" 
                        || extension.ToLower() == ".png" || extension.ToLower() == ".pdf")
                {
                    string clienteCodigo = ((cliente)Session["Cliente"]).documento.ToString();
                    string fechaActual = DateTime.Now.ToString("yyyy/MM/dd"); // Ejemplo: "2024/11/14"

                    string directorioCliente = Server.MapPath("~/Uploads/" + clienteCodigo + "/" + fechaActual);

                    //Verificar si la carpeta existe, y si no, crearla
                    if (!Directory.Exists(directorioCliente))
                    {
                        Directory.CreateDirectory(directorioCliente);
                    }
                    string filename = Guid.NewGuid().ToString() + extension;

                    //Ruta completa para guardar el archivo
                    string filePath = Path.Combine(directorioCliente, filename);
                    fileUpload.SaveAs(filePath);

                    FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    Session["ImagenPago"] = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
            }
        }
    }
}
