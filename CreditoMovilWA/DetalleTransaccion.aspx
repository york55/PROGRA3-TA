<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DetalleTransaccion.aspx.cs" Inherits="CreditoMovilWA.DetalleTransaccion" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transacción Específica - Crédito Móvil</title>
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
        }
        .container {
            max-width: 800px;
            margin: 30px auto;
            background-color: #faf8fc;
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        label {
            display: block;
            font-size: 18px;
            color: #333;
            margin: 10px 0 5px;
        }
        .input-text {
            width: calc(100% - 20px);
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }
        .file-upload-section {
            margin-top: 20px;
            text-align: center;
        }
        .file-upload-section img {
            width: 100%;
            max-width: 200px;
            margin-top: 10px;
        }
        .save-btn {
            width: 100%;
            padding: 15px;
            font-size: 18px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        .select-dropdown {
            width: 100%; 
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<form id="mainForm" runat="server" enctype="multipart/form-data">
    <!-- Encabezado con logo y botón de cerrar sesión -->
    <div class="header">
        <img src="logo.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <h2>Transacción Nro XXXXXXXXXXXX</h2>

        <label>ID Transacción</label>
        <asp:TextBox ID="txtIdTransaccion" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Fecha de Transacción</label>
        <asp:TextBox ID="txtFechaTransaccion" runat="server" CssClass="input-text" TextMode="Date"></asp:TextBox>

        <label>Agencia</label>
        <asp:DropDownList ID="ddlEstado" runat="server" CssClass="select-dropdown">
            <asp:ListItem Value="" Text="Seleccionar Agencia" />
            <asp:ListItem Value="BCP" Text="BCP" />
            <asp:ListItem Value="Visa" Text="Visa" />
            <asp:ListItem Value="American Express" Text="American Express" />
            <asp:ListItem Value="MasterCard" Text="MasterCard" />
        </asp:DropDownList>

        <label>Monto</label>
        <asp:TextBox ID="txtMonto" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <h3>FOTOS DE LA TRANSACCIÓN</h3>
        <div class="file-upload-section">
            <asp:FileUpload ID="fileUploadImagen" runat="server" Accept="image/jpeg, image/png" />
            <img id="uploadedImage" src="#" alt="Imagen de la transacción" style="display: none;" />
        </div>

        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="save-btn" OnClick="btnGuardar_Click" />
    </div>
</form>

<script>
    // Preview image before upload
    document.getElementById("fileUploadImagen").onchange = function (event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                const uploadedImage = document.getElementById("uploadedImage");
                uploadedImage.src = e.target.result;
                uploadedImage.style.display = "block";
            };
            reader.readAsDataURL(file);
        }
    };
</script>

</body>
</html>
