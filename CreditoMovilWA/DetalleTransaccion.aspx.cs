using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CreditoMovilWA
{
    public partial class DetalleTransaccion : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // datos transaccion...
            }
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (fileUploadImagen.HasFile)
            {
                string folderPath = Server.MapPath("~/Uploads/");
                if (!Directory.Exists(folderPath))
                {
                    Directory.CreateDirectory(folderPath);
                }

                string filePath = folderPath + Path.GetFileName(fileUploadImagen.FileName);
                fileUploadImagen.SaveAs(filePath);

                // Aquí puedes añadir lógica adicional para guardar la ruta de la imagen en la base de datos
                // o asociarla con la transacción específica.

                // Feedback al usuario (opcional)
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Imagen subida correctamente.');", true);
                Response.Redirect("DetalleCredito.aspx");
            }
            else
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Por favor, seleccione un archivo.');", true);
            }

        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }
    }
}