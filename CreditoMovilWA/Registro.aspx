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

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Logo en la parte superior -->
    <div id="headerProv" runat="server" class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
    </div>

    <div class="watermark"></div>

    <div class="container">
        <div class="text-header">
            <h1 id="text1" runat ="server">Ingrese sus datos personales</h1>
            <h1 id="text2" runat="server">Datos del cliente seleccionado</h1>
            <h1 id="text3" runat ="server">Ingrese los datos del personal</h1>
        </div>
        
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
        <!--Parte adicional en supervisor-->
        <div id="datosSupervisor" runat="server" class="form-row">
            <div class="form-group">
                <label for="direccion">Codigo cargo</label>
                <asp:TextBox ID="txtCodigoCargo" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="form-group">
                <label for="direccion">Agencia asignada</label>
                <asp:TextBox ID="txtAgencia" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            
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
            <asp:Button ID="btnGuardar" runat="server" Text="Ingresar" CssClass="btn-login" OnClick="btnGuardar_Click" />
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn-back" OnClick="btnRegresar_Click" />
        </div>
    </div>
</asp:Content>
