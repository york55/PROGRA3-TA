<%@ Page Language="C#" AutoEventWireup="true" CodeFile="SolicitudCredito.aspx.cs" Inherits="CreditoMovilWA.SolicitudCredito" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Créditos - Crédito Móvil</title>
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
            max-width: 600px;
            margin: 30px auto;
            padding: 20px 40px;
            background-color: #faf8fc;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        h1 {
            font-size: 32px;
            color: #265f21;
            font-weight: 700;
        }
        label {
            font-size: 18px;
            margin-top: 20px;
            color: #333;
            display: block;
        }
        .slider-container {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .slider {
            width: 100%;
            margin: 0 10px;
        }
        .amount-display {
            font-size: 24px;
            font-weight: 700;
            color: #2f7a44;
        }
        .btn-option {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #333;
            border: 1px solid #ddd;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }
        .btn-option.selected {
            background-color: #2f7a44;
            color: #fff;
        }
        .submit-btn {
            width: 100%;
            padding: 15px;
            font-size: 18px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 50px;
            margin-bottom: 25px;
        }
        .interest-display {
            font-size: 16px;
            color: #333;
            margin-top: 20px;
            text-align: left;
        }

    </style>
    <script>
        function updateAmount(value) {
            document.getElementById("amountDisplay").innerText = "S/. " + value;
            updateInterest(value); // Actualizar el interés cuando se cambie el monto
        }

        function selectOption(button, group) {
            let options = document.querySelectorAll(`.btn-option[data-group="${group}"]`);
            options.forEach(btn => btn.classList.remove("selected"));
            button.classList.add("selected");
        }

        function updateInterest(amount) {
            const minInterest = (amount * 0.05).toFixed(2); // 5% mínimo
            const maxInterest = (amount * 0.15).toFixed(2); // 15% máximo
            document.getElementById("interestDisplay").innerText = `Interés aproximado: S/. ${minInterest} - S/. ${maxInterest}`;
        }
    </script>
</head>
<body>

<form runat="server">
    <!-- Encabezado con logo y botón de cerrar sesión -->
    <div class="header">
        <img src="logo.png" alt="Logo Crédito Móvil">
        <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="logout-btn" OnClick="btnLogout_Click" />
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <h1>Registro de Créditos</h1>
        
        <label>¿Cuánto dinero desea solicitar?</label>
        <div class="slider-container">
            <span>0</span>
            <input type="range" min="0" max="5000" value="3500" class="slider" oninput="updateAmount(this.value)" />
            <span>5000</span>
        </div>
        <div id="amountDisplay" class="amount-display">S/. 3500</div>

        <!-- HiddenField para almacenar el monto seleccionado -->
        <asp:HiddenField ID="hfMonto" runat="server" Value="3500" />

        <label>¿En cuántas cuotas lo desea?</label>
        <div>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">0</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">1</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">2</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">3</button>
        </div>

        <label>¿Cuándo desea realizar el primer pago?</label>
        <div>
            <button type="button" class="btn-option" data-group="primerPago" onclick="selectOption(this, 'primerPago')">Quincena más</button>
            <button type="button" class="btn-option" data-group="primerPago" onclick="selectOption(this, 'primerPago')">Inicio de mes más</button>
        </div>

        <!-- Interés aproximado -->
        <div id="interestDisplay" class="interest-display">Interés aproximado: S/. 175 - S/. 525</div>

        <asp:Button ID="btnSubmit" runat="server" Text="Solicitar Crédito" CssClass="submit-btn" OnClick="btnSubmit_Click" />
    </div>
</form>

<script>
    function selectOption(button) {
        let options = document.querySelectorAll(".btn-option");
        options.forEach(btn => btn.classList.remove("selected"));
        button.classList.add("selected");
    }
</script>

</body>
</html>
