<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="DetalleTransaccion.aspx.cs" Inherits="CreditoMovilWA.DetalleTransaccion" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
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
        .transaccion-imagen {
            width: 100%;
            max-width: 400px;
            margin-top: 10px;
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
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <!-- Contenedor principal -->
    <div class="container">
        <h2>Transacción Nro <asp:Label ID="lblNumeroTransaccion" runat="server"></asp:Label></h2>

        <label>ID Transacción</label>
        <asp:TextBox ID="txtIdTransaccion" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Fecha de Transacción</label>
        <asp:TextBox ID="txtFechaTransaccion" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Agencia</label>
        <asp:TextBox ID="txtAgencia" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Monto</label>
        <asp:TextBox ID="txtMonto" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <h3>IMAGEN DE LA TRANSACCIÓN</h3>
        <div>
            <asp:Image ID="imgTransaccion" runat="server" CssClass="transaccion-imagen" />
        </div>


    </div>
</asp:Content>
