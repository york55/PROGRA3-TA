﻿
<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Home.aspx.cs" Inherits="CreditoMovilWA.Home" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crédito Móvil</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Encabezado */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: #f7f5fb;
            border-bottom: 1px solid #ddd;
        }

        .header img {
            width: 150px;
        }

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
</head>
<body>

<form runat="server">
    <!-- Encabezado -->
    <header class="header">
        <img src="logo.png" alt="Logo Crédito Móvil">
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
                <img src="icon1.png" alt="Icono 1">
                <p>Créditos para comerciantes adaptados a tus necesidades</p>
            </div>
            <div class="benefit-item">
                <img src="icon2.png" alt="Icono 2">
                <p>Evaluaciones de crédito rápidas y confiables</p>
            </div>
            <div class="benefit-item">
                <img src="icon3.png" alt="Icono 3">
                <p>Flexibilidad en los montos y plazos</p>
            </div>
            <div class="benefit-item">
                <img src="icon4.png" alt="Icono 4">
                <p>Sin trámites engorrosos</p>
            </div>
        </div>
    </section>
</form>

</body>
</html>