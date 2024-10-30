<%@ Page Language="C#" AutoEventWireup="true" CodeFile="MainSupervisor.aspx.cs" Inherits="CreditoMovilWA.MainSupervisor" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Supervisor - Crédito Móvil</title>
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
        h2 {
            font-size: 28px;
            color: #2f7a44;
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
    </style>
</head>
<body>

<form id="mainForm" runat="server">
    <!-- Encabezado con logo y botón de cerrar sesión -->
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <h2>¡Hola!</h2>
        <p>Estas son las evaluaciones que posees:</p>

        <!-- Tabla de evaluaciones -->
        <div class="table-container">
            <asp:GridView ID="gvEvaluaciones" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="IdEvaluacion" HeaderText="ID_EVALUACION" />
                    <asp:BoundField DataField="Negocio" HeaderText="NEGOCIO" />
                    <asp:BoundField DataField="Ventas" HeaderText="VENTAS" />
                    <asp:BoundField DataField="MargenGanancia" HeaderText="MR. GANANCIA" />
                    <asp:BoundField DataField="Puntaje" HeaderText="PUNTAJE" />
                    <asp:BoundField DataField="Estado" HeaderText="ESTADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="view-btn" CommandArgument='<%# Eval("IdEvaluacion") %>' OnClick="btnVerDetalle_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</form>

</body>
</html>
