<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="DatosEvaluacionCliente.aspx.cs" Inherits="CreditoMovilWA.DatosEvaluacionCliente" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
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

        .form-group input, .form-group select {
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
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.4s ease;
        }

        .btn-save:hover {
            background-color: #265f21;
        }
 
        .watermark {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 100%;  
            height: 50%;
            background: url('images/credit2.png') no-repeat center center;
            background-size: contain;  
            z-index: -1;
            opacity: 0.1;
            pointer-events: none;
        }

        .btn-login {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.3s ease;
        }
        .btn-login:hover {
            background-color: #265f21;
        }

        .btn-back {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #273fab;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.3s ease;
        }

        .btn-back:hover {
            background-color: #1a2b75;
        }

    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Logo en la parte superior -->
    <div class="container">
        <div class="text-header">
            <h1 id="text1" runat ="server">Ingrese los siguientes datos, para la preparación de evaluación</h1>
        </div>
        
        <!-- Fila para Nombre y Apellidos -->
        <div class="form-group">
            <label for="nombre">Nombre de la empresa</label>
            <asp:TextBox ID="txtNombreNeg" runat="server" CssClass="form-control"></asp:TextBox>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="direccion-empresa">Dirección de la empresa</label>
                <asp:TextBox ID="txtDireccionNeg" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="telefono-negocio">Teléfono</label>
                <asp:TextBox ID="txtTelefonoNeg" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>

        
        <div class="form-row">
            <div class="form-group">
                <label for="ventas-diarias">Ventas diarias</label>
                <asp:TextBox ID="txtVentasDiarias" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="costo-ventas">Costo ventas promedio</label>
                <asp:TextBox ID="txtCostosVentas" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="inventario">Costo inventario neto</label>
                <asp:TextBox ID="txtInventario" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="ganancia-promedio">Utilidad promedio</label>
                <asp:TextBox ID="txtUtilidadPromedio" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>

        <!-- Campos adicionales -->
        <div class="form-group">
            <label for="observaciones">Observaciones</label>
            <asp:TextBox ID="txtObservaciones" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
        
        <!-- Campos para Contraseña y Confirmar Contraseña -->
        <div id="containerPassword" runat="server" class="form-row">
            <div class="form-group">
                <label for="contraseña">Contraseña</label>
                <asp:TextBox ID="txtContrasena" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="confirmar-contraseña">Confirmar Contraseña</label>
                <asp:TextBox ID="txtConfirmarContrasena" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
            </div>
        </div>
        <!-- Mensaje de error -->
        <asp:Label ID="lblError" runat="server" CssClass="error-message" EnableViewState="false"></asp:Label>
        <!-- Botón Guardar -->
        <div id="containerBtn" runat="server" style="display: flex; gap: 10px;">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn-back" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGuardar" runat="server" Text="Ingresar" CssClass="btn-login" OnClick="btnGuardar_Click" />
        </div>
    </div>
</asp:Content>
