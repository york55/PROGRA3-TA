using System;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleEvaluacion : System.Web.UI.Page
    {
        private bool modoEdicion = false;

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

            string idEvaluacion = Request.QueryString["IdEvaluacion"];
            lblNumeroEvaluacion.Text = idEvaluacion;

            // ejemplo pa probart
            txtNombreNegocio.Text = "Nombre del Negocio Ejemplo";
            txtFechaRegistro.Text = DateTime.Now.ToShortDateString();
            txtDireccionNegocio.Text = "Dirección Ejemplo";
            txtTelefonoNegocio.Text = "123456789";
            txtClienteAsignado.Text = "Cliente Ejemplo";
            txtMargenGanancia.Text = "20%";
            txtVentasDiarias.Text = "500";
            txtInventario.Text = "Inventario Ejemplo";
            txtCostoVentas.Text = "100";
            txtEstado.Text = "Activo";
            txtObservaciones.Text = "Observaciones sobre la evaluación...";
            lblPuntaje.Text = "98";  
        }

        protected void btnModificar_Click(object sender, EventArgs e)
        {
            // alternar 
            modoEdicion = !modoEdicion;

            if (modoEdicion)
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
            // lógica va aca
            string nombreNegocio = txtNombreNegocio.Text;
            string fechaRegistro = txtFechaRegistro.Text;
            string direccionNegocio = txtDireccionNegocio.Text;
            string telefonoNegocio = txtTelefonoNegocio.Text;
            string clienteAsignado = txtClienteAsignado.Text;
            string margenGanancia = txtMargenGanancia.Text;
            string ventasDiarias = txtVentasDiarias.Text;
            string inventario = txtInventario.Text;
            string costoVentas = txtCostoVentas.Text;
            string estado = txtEstado.Text;
            string observaciones = txtObservaciones.Text;

            // aca pa actualizar base de dates
        }

        protected void btnBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("MainSupervisor.aspx");
        }
    }
}