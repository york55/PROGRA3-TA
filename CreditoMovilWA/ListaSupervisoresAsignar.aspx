<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="ListaSupervisoresAsignar.aspx.cs" Inherits="CreditoMovilWA.ListaSupervisoresAsignar" %>

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
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Contenedor principal -->
    <div class="container">
        <h2>Lista de supervisores</h2>
        <p>Estos son los supervisores activos:</p>

        <!-- Tabla de evaluaciones -->
        <div class="table-container">
            <asp:GridView ID="gvEvaluaciones" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="codigoEv" HeaderText="Codigo" />
                    <asp:BoundField DataField="codigoCargo" HeaderText="Cargo" />
                    <asp:BoundField DataField="agenciaAsignacion" HeaderText="Agencia" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="apPaterno" HeaderText="Apellido" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalle" runat="server" Text="Asignar" CssClass="view-btn"  OnClick="btnAsignar_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
