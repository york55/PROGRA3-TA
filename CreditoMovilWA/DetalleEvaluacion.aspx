<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DetalleEvaluacion.aspx.cs" Inherits="CreditoMovilWA.DetalleEvaluacion" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizar Evaluación - Crédito Móvil</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f7f5fb;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            border-bottom: 1px solid #ddd;
        }
        .header img {
            width: 150px;
        }
        .header .logout-btn {
            background-color: #002e6e;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 13px;
            border-radius: 5px;
            color: #fff;
            font-weight: 700;
            font-family: 'Poppins', sans-serif; 
        }
        .container {
            max-width: 1000px;
            margin: 30px auto;
            background-color: #faf8fc;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        h2 {
            font-size: 28px;
            color: #2f7a44;
            text-align: center;
        }
        .puntaje {
            font-size: 36px;
            color: #2f7a44;
            font-weight: bold;
            text-align: right;
            margin-right: 20px;
        }
        .form-group {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }
        .form-group label {
            font-size: 16px;
            color: #333;
            flex: 1;
        }
        .form-group input {
            flex: 2;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-left: 10px;
        }
        .form-group textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-top: 10px;
            resize: none;
        }
        .modify-btn {
            padding: 10px 20px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
            width: 150px;
            text-align: center;
            margin: 20px auto;
        }
        .row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }
        .label-group {
            flex: 1;
            margin-right: 15px; /* Añade espacio entre columnas */
        }
        label {
             font-size: 16px;
             color: #333;
         }
        .input-text{
            width:100%;
        }
        .back-btn{
            background-color: #002e6e;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 13px;
            border-radius: 5px;
            color: #fff;
            font-weight: 700;
            font-family: 'Poppins', sans-serif; 
            margin-right: 100px;
            margin-top:20px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<form runat="server">
    <!-- Encabezado con logo y botón de cerrar sesión -->
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <h2>Evaluación Nro <asp:Label ID="lblNumeroEvaluacion" runat="server" Text="XXXXXXXXXX"></asp:Label></h2>
        
        <div class="form-group">
            <label>Nombre del Negocio</label>
            <asp:TextBox ID="txtNombreNegocio" runat="server" CssClass="label-group" ReadOnly="true" />
            <label>Fecha de Registro</label>
            <asp:TextBox ID="txtFechaRegistro" runat="server" CssClass="input-text" ReadOnly="true" />
        </div>
        
        <div class="form-group">
            <label>Dirección del Negocio</label>
            <asp:TextBox ID="txtDireccionNegocio" runat="server" CssClass="label-group" ReadOnly="true" />
            <label>Teléfono del Negocio</label>
            <asp:TextBox ID="txtTelefonoNegocio" runat="server" CssClass="input-text" ReadOnly="true" />
        </div>

        <div class="form-group">
            <label>Nombre del Cliente Asignado</label>
            <asp:TextBox ID="txtClienteAsignado" runat="server" CssClass="label-group" ReadOnly="true" />
            <label>Margen de Ganancia</label>
            <asp:TextBox ID="txtMargenGanancia" runat="server" CssClass="input-text" ReadOnly="true" />
        </div>
        
        <div class="form-group">
            <label>Ventas Diarias</label>
            <asp:TextBox ID="txtVentasDiarias" runat="server" CssClass="label-group" ReadOnly="true" />
            <label>Inventario</label>
            <asp:TextBox ID="txtInventario" runat="server" CssClass="input-text" ReadOnly="true" />
        </div>

        <div class="form-group">
            <label>Costo de Ventas</label>
            <asp:TextBox ID="txtCostoVentas" runat="server" CssClass="label-group" ReadOnly="true" />
            <label>Estado</label>
            <asp:TextBox ID="txtEstado" runat="server" CssClass="input-text" ReadOnly="true" />
        </div>

        <label>Observaciones</label>
        <asp:TextBox ID="txtObservaciones" runat="server" CssClass="input-text" TextMode="MultiLine" Rows="3" ReadOnly="true" />

        <!-- Puntaje y botón modificar -->
        <div style="display: flex; justify-content: space-between; align-items: center; margin-top: 20px;">
            <asp:Button ID="btnModificar" runat="server" Text="MODIFICAR" CssClass="modify-btn" OnClick="btnModificar_Click" />
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="back-btn" OnClick="btnBack_Click" />
            <div class="puntaje">PUNTAJE: <asp:Label ID="lblPuntaje" runat="server" Text="98"></asp:Label></div>
        </div>
    </div>
</form>

</body>
</html>
