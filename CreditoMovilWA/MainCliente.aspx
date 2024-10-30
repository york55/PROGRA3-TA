<%@ Page Language="C#" AutoEventWireup="true" CodeFile="MainCliente.aspx.cs" Inherits="CreditoMovilWA.Main" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cuenta Iniciada - Crédito Móvil</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f7f5fb;
            text-align: center;
            margin: 0;
            padding: 0
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
        h1 {
            font-size: 40px;
            color: #265f21;
            font-weight: 700;
            margin-top: 40px;
            margin-bottom: 20px;
        }
        p {
            margin-top: 10px;
            font-size: 20px;
            color: #333;
        }
        .gauge-container {
            position: relative;
            width: 300px;
            height: 150px;
            margin: 30px auto;
            overflow: hidden;
        }
        .gauge {
            width: 100%;
            height: 100%;
            background: conic-gradient(
                red 0 25%, 
                orange 25% 50%, 
                yellow 50% 75%, 
                green 75% 100%
            );
            border-radius: 150px 150px 0 0;
            position: relative;
        }
        .needle {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 4px;
            height: 140px;
            background-color: #000;
            transform-origin: bottom center;
            transform: rotate(0deg);
            transition: transform 1s ease-out;
        }
        .btn {
            display: inline-block;
            width: 200px;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 20px;
        }
        .btn:hover {
            background-color: #265f21;
        }
        .ranking-label {
            font-size: 30px;
            color: #ffb400; /*se cambia por detras*/
            background-color: rgba(0, 0, 0,0.85);
            padding: 5px 50px;
            border-radius: 5px;
            margin-bottom: 10px;
            display: inline-block;
        }

    </style>
    <script>
        function actualizarAguja(puntaje) {
            const needle = document.querySelector('.needle');
            const rotation = (puntaje / 100) * 180; // Calcula el ángulo de rotación en función del puntaje
            needle.style.transform = `rotate(${rotation - 90}deg)`; // Ajusta para centrar en el medidor
        }
    </script>
</head>
<body onload="actualizarAguja(<%= ObtenerRankingSinPorcentaje() %>)">

<form runat="server">
    <!-- Encabezado con logo y botón de cerrar sesión -->
    <div class="header">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <!-- Contenido principal -->
    <div>
        <h1>¡Hola!</h1>
        <p>Actualmente tu ranking crediticio es:</p>
        <asp:Label ID="lblRanking" runat="server" CssClass="ranking-label" Font-Size="30px"></asp:Label>

        <!-- Medidor de ranking -->
        <div class="gauge-container">
            <div class="gauge"></div>
            <div class="needle"></div>
        </div>

        <!-- Botones de acción -->
        <asp:Button ID="btnSolicitarCredito" runat="server" Text="Solicitar un crédito" CssClass="btn" OnClick="btnSolicitarCredito_Click" />
        <asp:Button ID="btnVerCreditos" runat="server" Text="Visualizar mis créditos" CssClass="btn" OnClick="btnVerCreditos_Click" />
    </div>
</form>

</body>
</html>
