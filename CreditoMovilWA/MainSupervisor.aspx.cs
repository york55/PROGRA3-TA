using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class MainSupervisor : System.Web.UI.Page
    {

        private EvaluacionWSClient daoEvaluacion = new EvaluacionWSClient();
        private CreditoWSClient daoCredito = new CreditoWSClient();
        private ClienteWSClient daoCliente = new ClienteWSClient();

        protected void Page_Init(object sender, EventArgs e)
        {
            supervisor sup = (supervisor)Session["Supervisor"];
            if (sup == null)
            {
                Response.Redirect("Login.aspx");
            }

            // Aquí carga los datos de las evaluaciones
            if (CargarClientesCredPend()) txtCliPendAsig.Visible = true;
            else txtNotClientPend.Visible = true;
            if (CargarEvaluacionesPendientes(sup.codigoEv)) txtHayPendiente.Visible = true;
            else txtNoHayPendiente.Visible = true;
            if (CargarEvaluacionesRealizadas(sup.codigoEv)) txtHayRealizado.Visible = true;
            else txtNoHayEvRealizada.Visible = true;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            
        }
        private Boolean CargarClientesCredPend()
        {
            cliente[] listCli = null;
            gvClientesCredPend.DataSource = listCli = daoCliente.listarClientesConCredPendientes();
            gvClientesCredPend.DataBind();

            return (listCli != null);
        }
        private Boolean CargarEvaluacionesPendientes(int codSupervisor)
        {
            evaluacion[] listEv = null;
            gvEvaluacionesPendientes.DataSource = listEv = daoEvaluacion.listarPendientesPorSupervisor(codSupervisor);
            gvEvaluacionesPendientes.DataBind();

            return (listEv != null);
        }
        private Boolean CargarEvaluacionesRealizadas(int codSupervisor)
        {
            evaluacion[] listEv = null;
            gvEvaluacionesRealizadas.DataSource = listEv = daoEvaluacion.listarRealizadosPorSupervisor(codSupervisor);
            gvEvaluacionesRealizadas.DataBind();

            return (listEv != null);
        }
        protected void btnVerCreditos_Click(object sender, EventArgs e)
        {
            Button btnVerCreditos_Click = (Button)sender;
            int codigoCliente = Int32.Parse(btnVerCreditos_Click.CommandArgument);
            ViewState["ModalAbierto"] = true; // Almacena el estado del modal en ViewState
            ClientScript.RegisterStartupScript(this.GetType(), "OpenModal", "openModal();", true);
            gvCredPendXCli.DataSource = daoCredito.listarCreditosPendXCliente(codigoCliente);
            gvCredPendXCli.DataBind();
        }
        /*Modal*/
        protected void btnCerrarModal_Click(object sender, EventArgs e)
        {
            ScriptManager.RegisterStartupScript(this, this.GetType(), "closeModal", "closeModal();", true);
        }

        protected void btnAprobarCredito_Click(object sender, EventArgs e)
        {
            Button btnAprobar = (Button)sender;
            int numCredito = Int32.Parse(btnAprobar.CommandArgument);
            credito cred = daoCredito.obtenerPorIDCredito(numCredito);
            cred.estado = "Activo";
            if (daoCredito.modificarCredito(cred))
            {
                ScriptManager.RegisterStartupScript(this, this.GetType(), "closeModal", "closeModal();", true);
            }
            if (CargarClientesCredPend()) {
                txtCliPendAsig.Visible = true;
            }
            else {
                txtCliPendAsig.Visible = false;
                txtNotClientPend.Visible = true;
            }
        }

        /*EVALUACION PENDIENTE*/
        protected void btnAprobarEv_Click(object sender, EventArgs e)
        {
            Button btnAprobarEv = (Button)sender;
            int numEvaluacion = Int32.Parse(btnAprobarEv.CommandArgument);
            evaluacion ev = daoEvaluacion.obtenerPorNumEvaluacion(numEvaluacion);
            if(ev != null)
            {
                ev.clienteAsignado.tipoCliente = "Activo"; /*Pasa de pendiente a ACTIVO*/
                if (daoCliente.modificarCliente(ev.clienteAsignado))
                {
                    if (CargarEvaluacionesRealizadas(numEvaluacion))
                    {
                        txtHayRealizado.Visible = true;
                        txtNoHayEvRealizada.Visible = false;
                    }
                    else
                    {
                        txtHayRealizado.Visible = false;
                        txtNoHayEvRealizada.Visible = true;
                    }

                    if (CargarEvaluacionesPendientes(numEvaluacion))
                    {
                        txtHayPendiente.Visible = true;
                        txtNoHayPendiente.Visible = false;
                    }
                    else
                    {
                        txtHayPendiente.Visible = false;
                        txtNoHayPendiente.Visible = true;
                    }
                }
            }
        }
    }
}