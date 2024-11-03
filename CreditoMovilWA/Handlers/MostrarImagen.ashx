<%@ WebHandler Language="C#" Class="MostrarImagen" %>

using System;
using System.Web;
using System.Data.SqlClient;
using System.Configuration;

public class MostrarImagen : IHttpHandler
{
    public void ProcessRequest(HttpContext context)
    {
        string idTransaccion = context.Request.QueryString["id"];
        if (!string.IsNullOrEmpty(idTransaccion))
        {
            string connectionString = ConfigurationManager.ConnectionStrings["ConexionBD"].ConnectionString;
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                string query = "SELECT Imagen, TipoImagen FROM Transacciones WHERE IdTransaccion = @IdTransaccion";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@IdTransaccion", idTransaccion);

                conn.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    byte[] imagenBytes = (byte[])reader["Imagen"];
                    string tipoImagen = reader["TipoImagen"].ToString();

                    context.Response.ContentType = tipoImagen;
                    context.Response.BinaryWrite(imagenBytes);
                }
                else
                {
                    context.Response.StatusCode = 404;
                }

                reader.Close();
            }
        }
        else
        {
            context.Response.StatusCode = 400; // Bad Request
        }
    }

    public bool IsReusable
    {
        get { return false; }
    }
}
