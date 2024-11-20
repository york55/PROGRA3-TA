<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="MainAdmin.aspx.cs" Inherits="CreditoMovilWA.MainAdmin" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        h2 {
            font-size: 28px;
            color: #2f7a44;
            display: inline-block;
            margin: 0;
        }
        h1{
            font-size: 35px;
            color: #002e6e;
            margin: 0;
        }

        .container{
            display:flex;
            flex-direction:column;
        }
        .content-sup{
            margin: 100px 0 0 0;
            display:flex;
            flex-direction:column;
            justify-content:center;
            align-items:center;
        }
        .buscador{
            display:flex;
            justify-content:center;
            margin:0;
            background-color: rgb(198, 198, 198);
            border-radius: 6px;
        }
        .input-buscar{
            font-weight: 600;
            font-size: 15px;
            color: #2b2b2b;
            background-color: rgb(198, 198, 198);
            width:500px;
            border-radius: 6px;
            border: none;
            outline: none;
            padding: 13px;
            max-width: 450px;
            transition: .4s;
        }
        .buscador:hover{
            transition: .4s;
            box-shadow: 0 0 5px 1.5px #2f7a44;
        }
        .btn-buscar{
            border:none;
            border-radius: 6px;
            background-color: rgb(232, 232, 232);
            color:#002e6e;
            transition:.4s;
        }
        .btn-buscar:hover{
            background-color: #2f7a44;
            color:#ffffff;
        }

        .content-list{
            margin:30px 0;
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
        .btn-table{
            padding: 5px 10px;
            background-color: #2f7a44;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .content-mid {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
        }
        .button-container {
            display: flex;
            gap: 50px;
            flex-direction: row;
            align-items: flex-end;
            justify-content:space-between;
        }
        .view-btn {
            padding: 10px 20px;
            background-color: #2f7a44;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .view-btn:hover {
            background-color: #1f5a2e;
        }
    </style>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="content-sup">
            <h1>Encuentre el cliente que busca</h1>
            <div class="buscador">
                <asp:TextBox ID="texBuscar" placeholder="Ingrese el nombre del cliente..." AutoCompleteType="Disabled" runat="server" CssClass="input-buscar"></asp:TextBox>
                <asp:Button ID="btnBuscarCli"  runat="server" Text="Buscar" CssClass="btn-buscar" OnClick="btnBuscarCli_Click"/>
            </div>
            <div class="content-list">
                <asp:GridView ID="gvClientes" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" 
                    CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
                    <Columns>
                        <asp:BoundField DataField="codigoCliente" HeaderText="Cod. Cliente" />
                        <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="apPaterno" HeaderText="Apellido Paterno" />
                        <asp:BoundField DataField="tipoDocumento" HeaderText="Tipo documento" />
                        <asp:BoundField DataField="documento" HeaderText="Nro. Documento" />
                        <asp:BoundField DataField="activo" HeaderText="Activo" />
                        <asp:TemplateField>
                            <itemtemplate>
                                <asp:Button ID="btnDetalles" runat="server" 
                                    Text="Detalles" CssClass="btn-table" OnClick="btnDetalles_Click"
                                    CommandArgument='<%# Eval("codigoCliente") %>' />
                                <asp:Button ID="btnEliminar" runat="server" 
                                    Text="Eliminar" CssClass="btn-table" OnClick="btnEliminar_Click"
                                    CommandArgument='<%# Eval("codigoCliente") %>' />
                            </itemtemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
                <!-- Mensaje de error -->
                <asp:Label ID="msjError" runat="server" CssClass="error-message" EnableViewState="false"></asp:Label>
                <asp:Label ID="msjSuccess" runat="server" CssClass="success-message" EnableViewState="false"></asp:Label>
            </div>
        </div>
        <div class="content-mid">
            <div class="text">            
                <h2>Contenido general</h2>
            </div>
            <div class="button-container">
                <asp:Button ID="btnAddSupervisor" runat="server" 
                    Text="Añadir Supervisor" CssClass="view-btn" OnClick="btnAddSupervisor_Click"/>
                <asp:Button ID="btnVisualizarSupervisores" runat="server" 
                    Text="Administrar supervisores" CssClass="view-btn" OnClick="btnVisualizarSupervisores_Click" />
                <asp:Button ID="btnAddMetodoPago" runat="server" 
                    Text="Añadir metodo de pago" CssClass="view-btn" OnClick="btnAddMetodoPago_Click"/>
                <asp:Button ID="btnGenerarReportes" runat="server" 
                    Text="Generar reportes" CssClass="view-btn" OnClick="btnGenerarReportes_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
