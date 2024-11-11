<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="ModificarDatosCliente.aspx.cs" Inherits="CreditoMovilWA.ModificarDatosCliente" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Logo en la parte superior -->
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
    </div>

    <div class="container">
        <h1>Configuración de perfil</h1>
        
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
                    <asp:ListItem Text="Carnet de Extranjeria" Value="Carnet_Extranjeria" />
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
        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn-save" OnClick="btnGuardar_Click"/>
        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click"/>
    </div>
</asp:Content>
