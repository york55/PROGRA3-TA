<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="DetalleCredito.aspx.cs" Inherits="CreditoMovilWA.DetalleCredito" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        h1 {
            font-size: 28px;
            color: #2f7a44;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }
        label {
            display: block;
            font-size: 18px;
            color: #333;
            margin: 10px 0 5px;
        }
        .input-text, .select-dropdown {
            width: 97%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
            pointer-events: none; /*read only */
        }
        .section-title {
            font-size: 18px;
            font-weight: 700;
            color: #2f7a44;
            margin: 20px 0 10px;
            text-align: left;
        }
        .table-container {
            margin-top: 20px;
            overflow-x: auto;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #2f7a44;
            color: #fff;
        }
        .view-btn {
            padding: 5px 10px;
            background-color: #2f7a44;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .back-btn {
            background-color: #002e6e;
            color: white;
            border: none;
            padding: 10px 30px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        .motivo-container {
            margin-top: 20px;
            padding: 10px;
            background-color: #f5f5f5;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .motivo-label {
            font-size: 18px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }
        .motivo-text {
            font-size: 16px;
            color: #555;
            padding: 10px;
            background-color: #e4e4e4;
            border-radius: 5px;
            width: 97%;
            border: 1px solid #ddd;
            pointer-events: none; 
        }

    </style>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <div class="container">
        <h1 id="idCredito" runat="server">Crédito Nro </h1>

        <label>Fecha de Otorgamiento</label>
        <asp:TextBox ID="txtFechaOtorgamiento" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Estado</label>
        <asp:TextBox ID="txtEstado" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Monto</label>
        <asp:TextBox ID="txtMonto" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Número de Cuotas</label>
        <asp:TextBox ID="txtNumeroCuotas" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <label>Tasa de Interés</label>
        <asp:TextBox ID="txtTasaInteres" runat="server" CssClass="input-text" ReadOnly="true"></asp:TextBox>

        <div class="motivo-container">
            <div class="motivo-label">Motivo</div>
            <asp:TextBox ID="txtMotivo" runat="server" CssClass="motivo-text" ReadOnly="true"></asp:TextBox>
        </div>

        <div class="section-title">LISTADO DE TRANSACCIONES</div>
        <div class="table-container">
            <asp:GridView ID="gvTransacciones" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="numOperacion" HeaderText="ID_TRANS." />
                    <asp:BoundField DataField="fecha" HeaderText="FECHA" />
                    <asp:BoundField DataField="concepto" HeaderText="CONCEPTO" />
                    <asp:BoundField DataField="monto" HeaderText="MONTO" />
                    <asp:BoundField DataField="anulado" HeaderText="ANULADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="view-btn" CommandArgument='<%# Eval("numOperacion") %>' OnClick="btnVerDetalleTransaccion_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>

        <div class="button-container">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="back-btn" OnClick="btnBack_Click"/>
        </div>

    </div>
</asp:Content>

