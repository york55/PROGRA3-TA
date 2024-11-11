using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Data.SqlTypes;
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
                var resultados = daoCredito.listarCreditosFiltro(cli.codigoCliente, fechaInicio, fechaFin, estado);

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
                // Guarda el archivo en Session para uso posterior
                Session["ImagenPago"] = fileUpload.FileBytes;

                string metodoP = metodoPago.Value;
                if(metodoP == "banco")
                {
                    banco bank = new banco();
                    bank.foto = (Byte[])Session["ImagenPago"];
                    bank.nombreTitular = txtTitularBanco.Text;
                    bank.CCI = txtCCI.Text;
                    bank.tipoCuenta = txtTipoCuenta.Text;
                    bank.nombreBanco = bancoElegido.Value;

                    daoBanco.insertarBanco(bank);
                }
                else if(metodoP == "billetera")
                {
                    billetera bill = new billetera();
                    bill.nombreTitular = txtTitularBilletera.Text;
                    bill.foto = (Byte[])Session["ImagenPago"];
                    bill.numeroTelefono = txtNumeroBilletera.Text;
                    //daoBilletera.insertarBilletera(bill);

                    trans.agencia = metodoP;
                }

                trans.fecha = DateTime.Now;
                trans.foto = (Byte[])Session["ImagenPago"];
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

            // Cierra el modal después de grabar
            ViewState["ModalAbierto"] = false;
            ScriptManager.RegisterStartupScript(this, this.GetType(), "CloseModal", "closeModal();", true);
        }

        protected void btnVerDetalles_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            string idCredito = btn.CommandArgument;
            Session["idCredito"] = idCredito;
            Response.Redirect("DetalleCredito.aspx");
        }

    }
}
