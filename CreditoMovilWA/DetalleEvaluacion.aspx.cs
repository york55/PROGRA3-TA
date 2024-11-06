using CreditoMovilWA.CreditoMovil;
using System;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleEvaluacion : System.Web.UI.Page
    {
        private EvaluacionWSClient daoEvaluacion = new EvaluacionWSClient();
        private bool modoEdicion;

        protected void Page_Init(object sender, EventArgs e)
        {
            modoEdicion = false;
            btnModificar.Text = "MODIFICAR";
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatosEvaluacion();
                DeshabilitarCampos(); //inicialmente inhabilitad
            }
        }

        private void CargarDatosEvaluacion()
        {

            string idEvaluacion = (string)Session["idEvaluacion"];
            lblNumeroEvaluacion.Text = idEvaluacion;
            evaluacion ev = daoEvaluacion.obtenerPorIDEvaluacion(Int32.Parse(idEvaluacion));

            // ejemplo pa probart
            txtNombreNegocio.Text = ev.nombreNegocio;
            txtFechaRegistro.Text = ev.fechaRegistro.ToString();
            txtDireccionNegocio.Text = ev.direccionNegocio;
            txtTelefonoNegocio.Text = ev.telefonoNegocio;
            txtClienteAsignado.Text = ev.clienteAsignado.nombre + " " + ev.clienteAsignado.apPaterno + " " + ev.clienteAsignado.apMaterno;
            txtMargenGanancia.Text = ev.margenGanancia.ToString();
            txtVentasDiarias.Text = ev.ventasDiarias.ToString();
            txtInventario.Text = ev.inventario.ToString();
            txtCostoVentas.Text = ev.costoVentas.ToString();
            txtEstado.Text = ev.activo ? "Activo" : "Inactivo";
            txtObservaciones.Text = ev.observaciones.ToString();
            lblPuntaje.Text = ev.puntaje.ToString();

            Session["evaluacion"] = ev;
        }

        protected void btnModificar_Click(object sender, EventArgs e)
        {
            // alternar 
            modoEdicion = ! modoEdicion;

            if (btnModificar.Text == "MODIFICAR")
            {
                HabilitarCampos();
                btnModificar.Text = "GUARDAR"; 
            }
            else
            {
                GuardarDatosEvaluacion();
                DeshabilitarCampos();
                btnModificar.Text = "MODIFICAR"; 
            }
        }

        private void HabilitarCampos()
        {
            txtNombreNegocio.ReadOnly = false;
            txtFechaRegistro.ReadOnly = false;
            txtDireccionNegocio.ReadOnly = false;
            txtTelefonoNegocio.ReadOnly = false;
            txtClienteAsignado.ReadOnly = false;
            txtMargenGanancia.ReadOnly = false;
            txtVentasDiarias.ReadOnly = false;
            txtInventario.ReadOnly = false;
            txtCostoVentas.ReadOnly = false;
            txtEstado.ReadOnly = false;
            txtObservaciones.ReadOnly = false;
        }

        private void DeshabilitarCampos()
        {
            txtNombreNegocio.ReadOnly = true;
            txtFechaRegistro.ReadOnly = true;
            txtDireccionNegocio.ReadOnly = true;
            txtTelefonoNegocio.ReadOnly = true;
            txtClienteAsignado.ReadOnly = true;
            txtMargenGanancia.ReadOnly = true;
            txtVentasDiarias.ReadOnly = true;
            txtInventario.ReadOnly = true;
            txtCostoVentas.ReadOnly = true;
            txtEstado.ReadOnly = true;
            txtObservaciones.ReadOnly = true;
        }

        private void GuardarDatosEvaluacion()
        {
            evaluacion ev = (evaluacion)Session["evaluacion"];
            ev.nombreNegocio = txtNombreNegocio.Text;
            ev.fechaRegistro = DateTime.Parse(txtFechaRegistro.Text);
            ev.direccionNegocio = txtDireccionNegocio.Text;
            ev.telefonoNegocio = txtTelefonoNegocio.Text;
            //logica para el cliente asignado
            string clienteAsignado = txtClienteAsignado.Text;
            //logica para el cliente asignado
            ev.margenGanancia = Double.Parse(txtMargenGanancia.Text);
            ev.ventasDiarias = Double.Parse(txtVentasDiarias.Text);
            ev.inventario = Double.Parse(txtInventario.Text);
            ev.costoVentas = Double.Parse(txtCostoVentas.Text);
            ev.activo = txtEstado.Text=="Activo" ? true : false;
            ev.observaciones = txtObservaciones.Text;

            // aca pa actualizar base de dates
            daoEvaluacion.modificarEvaluacion(ev);
        }

        protected void btnBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainSupervisor.aspx");
        }
    }
}