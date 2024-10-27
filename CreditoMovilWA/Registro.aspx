<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Registro.aspx.cs" Inherits="CreditoMovilWA.Registro" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crédito Móvil - Registro</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f5fb;
        }

        .header {
            text-align: left;
            padding: 23px;
            border-bottom: 1px solid #ddd;
        }

        .header img {
            width: 150px; 
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background-color: #faf8fc;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        .container h1 {
            font-size: 32px;
            color: #265f21;
            font-weight: 700;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .form-group label {
            font-size: 16px;
            color: #333;
            margin-bottom: 5px;
        }

        .form-group input {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            width: 100%;
            box-sizing: border-box;
        }

        .form-row {
            display: flex;
            gap: 10px;
            margin-bottom: 15px;
        }

        .form-row .form-group {
            flex: 1;
        }

        /* Estilos para el botón de guardar */
        .btn-save {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px; /* Agrega espacio adicional arriba y abajo botón */
            margin-bottom: 30px;
        }

        .btn-save:hover {
            background-color: #265f21;
        }
    </style>
</head>
<body>

<form runat="server">
    <!-- Logo en la parte superior -->
    <div class="header">
        <img src="logo.png" alt="Logo Crédito Móvil">
    </div>

    <div class="container">
        <h1>Ingresa tus datos personales</h1>
        
        <!-- Fila para Nombre y Apellidos -->
        <div class="form-row">
            <div class="form-group">
                <label for="nombre">Nombre(s)</label>
                <input type="text" id="nombre" name="nombre">
            </div>
            <div class="form-group">
                <label for="apellido-paterno">Apellido Paterno</label>
                <input type="text" id="apellido-paterno" name="apellido-paterno">
            </div>
            <div class="form-group">
                <label for="apellido-materno">Apellido Materno</label>
                <input type="text" id="apellido-materno" name="apellido-materno">
            </div>
        </div>
        
        <!-- Resto de los campos -->
        <div class="form-row">
            <div class="form-group">
                <label for="tipo-documento">Tipo de Documento</label>
                <input type="text" id="tipo-documento" name="tipo-documento">
            </div>
            <div class="form-group">
                <label for="numero-documento">Nro. Documento</label>
                <input type="text" id="numero-documento" name="numero-documento">
            </div>
        </div>
        
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email">
        </div>
        
        <div class="form-group">
            <label for="telefono">Teléfono</label>
            <input type="tel" id="telefono" name="telefono">
        </div>
        
        <div class="form-group">
            <label for="direccion">Dirección</label>
            <input type="text" id="direccion" name="direccion">
        </div>

        <!-- Botón Guardar -->
        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn-save" OnClick="btnGuardar_Click" />
    </div>
</form>

</body>
</html>
