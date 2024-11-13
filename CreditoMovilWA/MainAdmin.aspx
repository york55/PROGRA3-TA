<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="MainAdmin.aspx.cs" Inherits="CreditoMovilWA.MainAdmin" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        h2 {
            font-size: 28px;
            color: #2f7a44;
            display: inline-block;
            margin: 0;
        }
        .container {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
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
        <div class="button-container">
            <h2>¡Hola!</h2>
            <asp:Button ID="btnGenerarReportes" runat="server" Text="Generar reportes" CssClass="view-btn" />
        </div>
        <div class="button-container">
            <h2>¿Qué deseas hacer?</h2>
            <asp:Button ID="btnVisualizarSupervisores" runat="server" Text="Visualizar supervisores" CssClass="view-btn" OnClick="btnVisualizarSupervisores_Click" />
        </div>
    </div>
</asp:Content>
