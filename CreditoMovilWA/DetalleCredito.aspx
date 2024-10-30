<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DetalleCredito.aspx.cs" Inherits="CreditoMovilWA.DetalleCredito" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crédito Específico - Crédito Móvil</title>
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
    </style>
</head>
<body>

<form id="mainForm" runat="server">
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <div class="container">
        <h1>Crédito Nro XXXXXXXXXXXX</h1>

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

        <div class="section-title">LISTADO DE TRANSACCIONES</div>
        <div class="table-container">
            <asp:GridView ID="gvTransacciones" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="IdTransaccion" HeaderText="ID_TRANS." />
                    <asp:BoundField DataField="Fecha" HeaderText="FECHA" />
                    <asp:BoundField DataField="Concepto" HeaderText="CONCEPTO" />
                    <asp:BoundField DataField="Monto" HeaderText="MONTO" />
                    <asp:BoundField DataField="Anulado" HeaderText="ANULADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="view-btn" CommandArgument='<%# Eval("IdTransaccion") %>' OnClick="btnVerDetalleTransaccion_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>

        <div class="button-container">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="back-btn" OnClick="btnBack_Click"/>
        </div>

    </div>
</form>

</body>
</html>
