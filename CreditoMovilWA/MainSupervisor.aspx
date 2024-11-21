<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="MainSupervisor.aspx.cs" Inherits="CreditoMovilWA.MainSupervisor" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
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
    <script>
        // Abre el modal
        function openModal() {
            document.getElementById("CredPendModal").style.display = "block";
        }
        // Cierra el modal
        function closeModal() {
            document.getElementById("CredPendModal").style.display = "none";
        }
</script>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Contenedor principal -->
    <div class="container">
        <h2>¡Hola!</h2>
        <p>Estos son los clientes con créditos pendientes por asignar:</p>
        <div class="table-container">
            <asp:GridView ID="gvClientesCredPend" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="codigoCliente" HeaderText="Cod. Cliente" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="apPaterno" HeaderText="Apellido Paterno" />
                    <asp:BoundField DataField="tipoDocumento" HeaderText="Tipo documento" />
                    <asp:BoundField DataField="documento" HeaderText="Nro. Documento" />
                    <asp:TemplateField>
                        <itemtemplate>
                            <asp:Button ID="btnDetalles" runat="server" 
                                Text="Detalles" CssClass="btn-table" OnClick="btnDetalles_Click"
                                CommandArgument='<%# Eval("codigoCliente") %>' />
                            <asp:Button ID="btnVerCreditos" runat="server" 
                                Text="Ver Creditos" CssClass="btn-table" OnClick="btnVerCreditos_Click"
                                CommandArgument='<%# Eval("codigoCliente") %>' />
                        </itemtemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>

    <div id="CredPendModal">
        <asp:GridView ID="gvCredPendXCli" runat="server" AutoGenerateColumns="false">
            <Columns>
                <asp:BoundField DataField="numCredito" HeaderText="NUM.CRED" />
                <asp:BoundField DataField="monto" HeaderText="MONTO" />
                <asp:BoundField DataField="tasaInteres" HeaderText="TASA INTERES" />
                <asp:BoundField DataField="estado" HeaderText="ESTADO" />
                <asp:BoundField DataField="numCuotas" HeaderText="NUM. CUOTAS" />
                <asp:BoundField DataField="motivo" HeaderText="MOTIVO" />
            </Columns>
        </asp:GridView>
    </div>

    <div class="container">
        <h2>Estas son las evaluaciones que posees:</h2>
        <!-- Tabla de evaluaciones -->
        <div class="table-container">
            <asp:GridView ID="gvEvaluaciones" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="numeroEvaluacion" HeaderText="ID_EVALUACION" />
                    <asp:BoundField DataField="nombreNegocio" HeaderText="NEGOCIO" />
                    <asp:BoundField DataField="ventasDiarias" HeaderText="VENTAS" />
                    <asp:BoundField DataField="margenGanancia" HeaderText="MARGEN. GANANCIA" />
                    <asp:BoundField DataField="puntaje" HeaderText="PUNTAJE" />
                    <asp:BoundField DataField="activo" HeaderText="ESTADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="view-btn" CommandArgument='<%# Eval("numeroEvaluacion") %>' OnClick="btnVerDetalle_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
