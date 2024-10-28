<%@ Page Language="C#" AutoEventWireup="true" CodeFile="VisualizarCreditos.aspx.cs" Inherits="CreditoMovilWA.VisualizarCreditos" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Créditos - Crédito Móvil</title>
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
            font-family: 'Poppins', sans-serif; 
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
            width: calc(100% - 20px); /* Deja espacio adicional a los lados */
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }

        /* Para el DropDownList, ocupa el ancho completo sin modificar */
        .select-dropdown {
            width: 100%; 
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }
        .filter-btn {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 40px;
            margin-bottom: 20px;
        }
        .table-container {
            margin-top: 20px;
            overflow-x: auto;
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
        .pay-btn {
            padding: 5px 10px;
            background-color: #2f7a44;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .message {
            color: red;
            font-size: 16px;
            margin-top: 10px;
        }
                .modal {
            display: none; /* Oculto por defecto */
            position: fixed;
            z-index: 10;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }
        .modal-content {
            background-color: #faf8fc;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 500px;
            text-align: left;
            border-radius: 10px;
        }
        .close-btn {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .close-btn:hover, .close-btn:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
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
        <h2>Listado de Créditos</h2>

        <label>Fecha de Inicio</label>
        <asp:TextBox ID="txtFechaInicio" runat="server" CssClass="input-text" TextMode="Date"></asp:TextBox>

        <label>Fecha de Fin</label>
        <asp:TextBox ID="txtFechaFin" runat="server" CssClass="input-text" TextMode="Date"></asp:TextBox>

        <label>Estado del crédito</label>
        <asp:DropDownList ID="ddlEstado" runat="server" CssClass="select-dropdown">
            <asp:ListItem Value="" Text="Seleccionar Estado" />
            <asp:ListItem Value="Activo" Text="Activo" />
            <asp:ListItem Value="Inactivo" Text="Inactivo" />
            <asp:ListItem Value="Pendiente" Text="Pendiente" />
            <asp:ListItem Value="Finalizado" Text="Finalizado" />
        </asp:DropDownList>

        <asp:Button ID="btnFiltrar" runat="server" Text="Filtrar" CssClass="filter-btn" OnClick="btnFiltrar_Click" />

        <!-- Tabla de créditos -->
        <div class="table-container">
            <asp:GridView ID="gvCreditos" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="IdCredito" HeaderText="ID_CRÉDITO" />
                    <asp:BoundField DataField="Monto" HeaderText="MONTO" />
                    <asp:BoundField DataField="NumCuotas" HeaderText="NUM. CUOTAS" />
                    <asp:BoundField DataField="TasaInteres" HeaderText="TASA INTERÉS" />
                    <asp:BoundField DataField="FechaOtorgamiento" HeaderText="FECHA OTORGAMIENTO" />
                    <asp:BoundField DataField="Estado" HeaderText="ESTADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnPagar" runat="server" Text="Pagar" CssClass="pay-btn" CommandArgument='<%# Eval("IdCredito") %>' OnClick="btnPagar_Click" />
                            <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="pay-btn" CommandArgument='<%# Eval("IdCredito") %>' OnClick="btnVerDetalles_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <asp:Label ID="lblMensaje" runat="server" ForeColor="Red" />
    </div>


    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="closeModal()">&times;</span>
            <h2>Bancos Aceptados:</h2>
            <img src="bancos.png" alt="Bancos Aceptados" style="width:100%; max-width:200px;">
            <p>Inserte imagen jpeg o pdf:</p>
            <asp:FileUpload ID="fileUpload" runat="server" />
            <asp:Button ID="btnUpload" runat="server" Text="Subir Archivo" />
            <br /><br />
            <asp:Button ID="btnSave" runat="server" Text="Grabar" CssClass="filter-btn" />
            <asp:Button ID="btnCancel" runat="server" Text="Cancelar" CssClass="filter-btn" OnClientClick="closeModal(); return false;" />
        </div>
    </div>
</form>




<script>
    function openModal() {
        document.getElementById("myModal").style.display = "block";
    }
    function closeModal() {
        document.getElementById("myModal").style.display = "none";
    }
</script>

</body>
</html>
