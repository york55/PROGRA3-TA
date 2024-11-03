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
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
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
</asp:Content>
