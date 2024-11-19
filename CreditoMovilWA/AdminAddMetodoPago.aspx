<%@ Page Title="" Language="C#" MasterPageFile="~/Usuario.master" AutoEventWireup="true" CodeBehind="AdminAddMetodoPago.aspx.cs" Inherits="CreditoMovilWA.AdminAddMetodoPago" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        .container h1 {
            font-size: 32px;
            color: #265f21;
            font-weight: 700;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .form-group label {
            font-size: 16px;
            color: #333;
            margin-bottom: 5px;
        }

        .form-group input, .form-group select {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            width: 100%;
            box-sizing: border-box;
        }

        .form-row {
            display: flex;
            gap: 10px;
            margin-bottom: 15px;
        }

        .form-row .form-group {
            flex: 1;
        }

        .btn-save {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.4s ease;
        }

        .btn-save:hover {
            background-color: #265f21;
        }

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

        .btn-login {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #2f7a44;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.3s ease;
        }
        .btn-login:hover {
            background-color: #265f21;
        }

        .btn-back {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #273fab;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 30px;
            margin-bottom: 30px;
            transition: background-color 0.3s ease;
        }

        .btn-back:hover {
            background-color: #1a2b75;
        }

        .btn-container{
            display: flex;
        }

        /* Ocultar los campos adicionales por defecto */
        .campos-adicionales {
            display: none;
        }

    </style>

    <script type="text/javascript">
        // Función para mostrar los campos según el método de pago seleccionado
        function mostrarCamposPago() {
            var metodoPago = document.getElementById('metodoPago').value;
            var camposBanco = document.getElementById('camposBanco');
            var camposBilletera = document.getElementById('camposBilletera');

            // Ocultar ambos conjuntos de campos inicialmente
            camposBanco.style.display = 'none';
            camposBilletera.style.display = 'none';

            // Mostrar campos dependiendo de la opción seleccionada
            if (metodoPago === 'banco') {
                camposBanco.style.display = 'block';
            } else if (metodoPago === 'billetera') {
                camposBilletera.style.display = 'block';
            }
        }
    </script>

</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <div class="watermark"></div>
    <div class="container">
        <h1 id="text1" runat ="server">Ingresa los datos del nuevo método de pago</h1>
        <div class="form-row">
            <label for="metodoPago">Seleccione el tipo de metodo de pago:</label>
            <select id="metodoPago" runat="server" onchange="mostrarCamposPago()">
                <option value="">Seleccione</option>
                <option value="banco">Banco</option>
                <option value="billetera">Billetera Digital</option>
            </select>
        </div>

        <!-- Campos Banco (ocultos inicialmente) -->
        <div id="camposBanco" class="campos-adicionales">
            <div class="form-group">
                <label for="nombreBanco">Nombre del Banco:</label>
                <input type="text" id="nombreBanco" runat="server" placeholder="Nombre del Banco" />
            </div>
            <div class="form-group">
                <label for="cci">CCI:</label>
                <input type="text" id="cci" runat="server" placeholder="Ingrese el CCI" />
            </div>
        </div>

        <!-- Campos Billetera Digital (ocultos inicialmente) -->
        <div id="camposBilletera" class="campos-adicionales">
            <div class="form-group">
                <label for="nombreBilletera">Nombre de la Billetera:</label>
                <input type="text" id="nombreBilletera" runat="server" placeholder="Nombre de la billetera" />
            </div>
        </div>

        <!-- Botón de Guardar -->

        <div class="btn-container">
            <asp:Button ID="btnSave" runat="server" Text="Guardar" CssClass="btn-save" />
            <asp:Button ID="btnBack" runat="server" Text="Regresar" CssClass="btn-back" />
        </div>

    </div>
</asp:Content>
