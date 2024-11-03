<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="Registro.aspx.cs" Inherits="CreditoMovilWA.Registro" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
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
        }

        .btn-save:hover {
            background-color: #265f21;
        }

    </style>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Logo en la parte superior -->
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
    </div>

    <div class="container">
        <h1>Ingresa tus datos personales</h1>
        
        <!-- Fila para Nombre y Apellidos -->
        <div class="form-row">
            <div class="form-group">
                <label for="nombre">Nombre(s)</label>
                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="apellido-paterno">Apellido Paterno</label>
                <asp:TextBox ID="txtApPaterno" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="apellido-materno">Apellido Materno</label>
                <asp:TextBox ID="txtApMaterno" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        
        <!-- Fila para Tipo de Documento y Nro. Documento -->
        <div class="form-row">
            <div class="form-group">
                <label for="tipo-documento">Tipo de Documento</label>
                <asp:DropDownList ID="ddlTipoDocumento" runat="server" CssClass="form-control">
                    <asp:ListItem Text="Selecciona una opción" Value="" />
                    <asp:ListItem Text="DNI" Value="DNI" />
                    <asp:ListItem Text="Pasaporte" Value="Pasaporte" />
                </asp:DropDownList>
            </div>
            <div class="form-group">
                <label for="numero-documento">Nro. Documento</label>
                <asp:TextBox ID="txtNroDoc" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        
        <!-- Campos adicionales -->
        <div class="form-group">
            <label for="email">Email</label>
            <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div class="form-group">
            <label for="telefono">Teléfono</label>
            <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control"></asp:TextBox>
        </div>
        
        <div class="form-group">
            <label for="direccion">Dirección</label>
            <asp:TextBox ID="txtDireccion" runat="server" CssClass="form-control"></asp:TextBox>
        </div>

        <!-- Campos para Contraseña y Confirmar Contraseña -->
        <div class="form-row">
            <div class="form-group">
                <label for="contraseña">Contraseña</label>
                <asp:TextBox ID="txtContrasena" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="confirmar-contraseña">Confirmar Contraseña</label>
                <asp:TextBox ID="txtConfirmarContrasena" runat="server" CssClass="form-control" TextMode="Password"></asp:TextBox>
            </div>
        </div>

        <asp:Label ID="lblError" runat="server" CssClass="error-message" EnableViewState="false"></asp:Label>
        <!-- Botón Guardar -->
        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn-save" OnClick="btnGuardar_Click" />
    </div>
</asp:Content>
