<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="SolicitudCredito.aspx.cs" Inherits="CreditoMovilWA.SolicitudCredito" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        .watermark {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 100%;  
            height: 50%;
            background: url('images/credit2.png') no-repeat center center;
            background-size: contain;  
            z-index: -1;
            opacity: 0.1;
            pointer-events: none;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 32px;
            color: #265f21;
            font-weight: 700;
            text-align: center;
            margin-bottom: 20px;
            transition: color 0.3s ease;
        }
        h1:hover {
            color: #2f7a44;
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
            margin: 10px 0;
        }
        .slider {
            width: 100%;
            margin: 0 10px;
            cursor: pointer;
            accent-color: #2f7a44;
        }
        .slider:hover {
            filter: brightness(1.2);
        }
        .amount-display {
            font-size: 24px;
            font-weight: 700;
            color: #2f7a44;
            text-align: center;
            margin-top: 10px;
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
            transition: all 0.3s ease;
            background: #fff;
        }
        .btn-option:hover {
            background: #f1f1f1;
            border-color: #bbb;
        }
        .btn-option.selected {
            background-color: #2f7a44;
            color: #fff;
            border-color: #2f7a44;
            transform: scale(1.05);
        }
        .submit-btn {
            width: 275px;
            padding: 10px;
            font-size: 18px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 15px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .submit-btn:hover {
            background-color: #265f21;
            transform: translateY(-2px);
        }
        .submit-btn:active {
            background-color: #1d4b1a;
        }
        .back-btn {
            width: 275px;
            padding: 10px;
            font-size: 18px;
            font-weight: 700;
            color: #fff;
            background-color: #273fab;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 15px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .back-btn:hover {
            background-color: #1a2b75;
            transform: translateY(-2px);    
        }
        .back-btn:active {
            background-color: #1d4b1a;
        }
        .button-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .interest-display {
            font-size: 16px;
            color: #333;
            margin-top: 20px;
            text-align: left;
            animation: fadeIn 0.5s ease-in-out;
        }
        .text-area-container {
            margin-top: 20px;
        }
        .text-area {
            width: 95%;
            height: 150px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            resize: none;
            outline: none;
        }
        .char-counter {
            text-align: right;
            font-size: 14px;
            color: #888;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>
    <script>
        function updateAmount(value) {
            document.getElementById("amountDisplay").innerText = "S/. " + value;
            document.getElementById("<%= hfMonto.ClientID %>").value = value;
            updateInterest(value); // Actualizar el interés cuando se cambie el monto
        }

        function selectOption(button, group) {
            let options = document.querySelectorAll(`.btn-option[data-group="${group}"]`);
            options.forEach(btn => btn.classList.remove("selected"));
            button.classList.add("selected");

            document.getElementById("selectedCuotas").value = button.textContent;
        }

        function selectOption2(button, group) {
            let options = document.querySelectorAll(`.btn-option[data-group="${group}"]`);
            options.forEach(btn => btn.classList.remove("selected"));
            button.classList.add("selected");

            document.getElementById("selectedPrimerPago").value = button.textContent;
        }

        function updateInterest(amount) {
            const minInterest = (amount * 0.10).toFixed(2); // 5% mínimo
            const maxInterest = (amount * 0.15).toFixed(2); // 15% máximo
            document.getElementById("interestDisplay").innerText = `Interés aproximado: S/. ${minInterest} - S/. ${maxInterest}   (10% - 15%)`;
        }

        function updateCharCount() {
            var textArea = document.getElementById("<%= motivoSolicitud.ClientID %>");
            var charCount = textArea.value.length;
            document.getElementById("charCounter").innerText = charCount + "/1000";
        }
    </script>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Contenedor principal -->

    <div class="watermark"></div>

    <div class="container">
        <h1>Registro de Créditos</h1>
        
        <label>¿Cuánto dinero desea solicitar?</label>
        <div class="slider-container">
            <span>1000</span>
            <input type="range" min="1000" max="5000" value="3500" class="slider" oninput="updateAmount(this.value)" />
            <span>5000</span>
        </div>
        <div id="amountDisplay" class="amount-display">S/. 3500</div>

        <asp:HiddenField ID="hfMonto" runat="server" Value="3500" />

        <label>¿En cuántas cuotas lo desea?</label>
        <div>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">1</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">2</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">3</button>
            <button type="button" class="btn-option" data-group="cuotas" onclick="selectOption(this, 'cuotas')">4</button>

            <asp:HiddenField ID="selectedCuotas" runat="server" ClientIDMode="Static" />
        </div>

        <label>¿Cuándo desea realizar el primer pago?</label>
        <div>
            <button type="button" class="btn-option" data-group="primerPago" onclick="selectOption2(this, 'primerPago')">Quincena de mes</button>
            <button type="button" class="btn-option" data-group="primerPago" onclick="selectOption2(this, 'primerPago')">Inicio de mes</button>
            <asp:HiddenField ID="selectedPrimerPago" runat="server" ClientIDMode="Static" />
        </div>

        <div class="interest-display" id="interestDisplay">Interés aproximado: S/. 350.00 - S/. 525.00   (10% - 15%)</div>

        <div class="text-area-container">
            <textarea id="motivoSolicitud" runat="server" class="text-area" maxlength="1000" oninput="updateCharCount()" placeholder="Escriba aquí el motivo de su solicitud..."></textarea>
            <div id="charCounter" class="char-counter">0/1000</div>
        </div>

        <asp:Label ID="lblErrorMotivo" runat="server" ForeColor="Red" Visible="false" Text="Por favor, ingrese un motivo para su solicitud." />

        <div style="display: flex; gap: 10px;">
            <asp:Button ID="backBtn" runat="server" Text="Regresar" CssClass="back-btn" OnClick="btnBack_Click" />
            <asp:Button ID="saveBtn" runat="server" Text="Solicitar" CssClass="submit-btn" OnClick="btnSubmit_Click" />
        </div>
    </div>
</asp:Content>
