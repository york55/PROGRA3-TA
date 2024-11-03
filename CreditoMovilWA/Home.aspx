
<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="Home.aspx.cs" Inherits="CreditoMovilWA.Home" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        .header .buttons {
            display: flex;
            gap: 10px;
        }

        .header .buttons button {
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
            color: #fff;
            font-weight: 700;
        }

        .header .open-account {
            background-color: #2f7a44;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 13px;
            border-radius: 5px;
            color: #fff;
            font-weight: 700;
            font-family: 'Poppins', sans-serif; 
        }

        .header .sign-in {
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

        /* Sección Principal */
        .main-banner {
            background-color: #d1e7c0;
            padding: 50px 20px;
            text-align: center;
        }

        .main-banner p {
            font-size: 24px;
            color: #265f21;
            margin: 0;
            font-weight: 400;
        }

        .main-banner h1 {
            font-size: 48px;
            color: #265f21;
            margin: 10px 0 0;
            font-weight: 700;
            line-height: 1.2;
        }

        /* Beneficios */
        .benefits {
            padding: 40px 20px;
            background-color: #f7f5fb;
            text-align: center;
        }

        .benefits h2 {
            font-size: 28px;
            color: #002e6e;
            font-weight: 700;
        }

        .benefits-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 40px;
            margin-top: 30px;
        }

        .benefit-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            max-width: 200px;
        }

        .benefit-item img {
            width: 50px;
            height: 50px;
            margin-bottom: 15px;
        }

        .benefit-item p {
            color: #265f21;
            text-align: center;
            font-size: 16px;
            font-weight: 400;
        }
    </style>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Encabezado -->
    <header class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <div class="buttons">
            <asp:Button ID="btnAbrirCuenta" runat="server" Text="Abrir una cuenta" OnClick="btnAbrirCuenta_Click" CssClass="open-account" />
            <asp:Button ID="btnIniciarSesion" runat="server" Text="Iniciar Sesión" OnClick="btnIniciarSesion_Click" CssClass="sign-in" />
        </div>
    </header>

    <!-- Sección Principal -->
    <section class="main-banner">
        <p>No te detengas</p>
        <h1>IMPULSA <br> TU NEGOCIO</h1>
    </section>

    <!-- Beneficios -->
    <section class="benefits">
        <h2>¿Por qué escoger Crédito Móvil?</h2>
        <div class="benefits-container">
            <div class="benefit-item">
                <img src="images/icono1.png" alt="Icono 1">
                <p>Créditos para comerciantes adaptados a tus necesidades</p>
            </div>
            <div class="benefit-item">
                <img src="images/icono2.png" alt="Icono 2">
                <p>Evaluaciones de crédito rápidas y confiables</p>
            </div>
            <div class="benefit-item">
                <img src="images/icono3.png" alt="Icono 3">
                <p>Flexibilidad en los montos y plazos</p>
            </div>
            <div class="benefit-item">
                <img src="images/icono4.png" alt="Icono 4">
                <p>Sin trámites engorrosos</p>
            </div>
        </div>
    </section>
</asp:Content>