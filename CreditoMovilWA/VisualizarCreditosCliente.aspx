<%@  Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="VisualizarCreditosCliente.aspx.cs" Inherits="CreditoMovilWA.VisualizarCreditos" %>
<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        label {
            display: block;
            font-size: 18px;
            color: #333;
            margin: 10px 0 5px;
        }
        .input-text {
            width: calc(100% - 20px); 
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }

        .select-dropdown {
            width: 100%; 
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #e4e4e4;
            margin-bottom: 15px;
        }

        .filter-btn, .btnBack {
            padding: 12px;
            font-size: 18px;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 40px;
            margin-bottom: 20px;
            transition: transform 0.3s ease, background-color 0.3s ease;
        }

        .filter-btn {
            background-color: #2f7a44;
            width: 48%;
        }

        .filter-btn:hover {
            background-color: #276d35; 
            transform: scale(1.05);
        }

        .btnBack {
            background-color: #273fab;
            width: 48%;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .btnBack:hover {
            background-color: #1a2b75;
            transform: scale(1.05); 
        }

        .btn-container {
            display: flex;
            justify-content: space-between;
            gap: 10px;
        }

        .table-container {
            margin-top: 20px;
            overflow-x: auto;
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

        .pay-btn {
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            text-transform: uppercase; 
            min-width: 120px; 
        }

        .pay-btn:first-child {
            background-color: #2f7a44; /* Verde */
            color: white;
        }

        /* Hover y animación para el botón de pagar */
        .pay-btn:first-child:hover {
            background-color: #276d35;
            transform: scale(1.05); /* Efecto de ampliación */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }

        /* Estilo para el botón de ver detalle */
        .pay-btn:last-child {
            background-color: #007bff; /* Azul */
            color: white;
            font-size: 18px;
            min-width: 50px; /* Ajusta el tamaño para el botón con el ícono */
            padding: 10px;
            border-radius: 50%; /* Botón redondo */
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* Hover y animación para el botón de ver detalle */
        .pay-btn:last-child:hover {
            background-color: #0056b3;
            transform: scale(1.1); /* Efecto de ampliación */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }

        .modal {
            display: none; /* Oculto por defecto */
            position: fixed;
            z-index: 10;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #faf8fc;
            margin: 20% auto;
            padding: 20px 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 600px;
            text-align: left;
            border-radius: 10px;
        }

        .close-btn {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close-btn:hover, .close-btn:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }

        .save-btn {
            width: 48%; /* Ajusta el ancho para que ambos botones ocupen el mismo espacio */
            background-color: #2f7a44;
            color: #fff;
            border: none;
            padding: 12px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .cancel-btn {
            width: 48%; /* Ajusta el ancho para que ambos botones ocupen el mismo espacio */
            background-color: #002e6e;
            color: #fff;
            border: none;
            padding: 12px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>

    <script type="text/javascript">
        // Abre el modal
        function openModal() {
            document.getElementById("PagoModal").style.display = "block";
        }

        // Cierra el modal
        function closeModal() {
            document.getElementById("PagoModal").style.display = "none";
        }

        // Muestra los campos según el método de pago seleccionado
        function mostrarCamposPago() {
            var metodo = document.getElementById("<%= metodoPago.ClientID %>").value;
            var infoBanco = document.getElementById("infoBanco");
            var infoBilletera = document.getElementById("infoBilletera");

            // Mostrar u ocultar los campos según el método seleccionado
            if (metodo === "banco") {
                infoBanco.style.display = "block";
                infoBilletera.style.display = "none";
            } else if (metodo === "billetera") {
                infoBanco.style.display = "none";
                infoBilletera.style.display = "block";
            } else {
                infoBanco.style.display = "none";
                infoBilletera.style.display = "none";
            }
        }

        // Muestra la información del banco seleccionado
        function mostrarInformacionBanco() {
            const bancoElegido = document.getElementById("<%= bancoElegido.ClientID %>").value;
            const detallesBanco = document.getElementById("detallesBanco");
            detallesBanco.style.display = "block";
        }
    </script>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <!-- Contenedor principal -->
    <div class="container">
        <h2>Listado de Créditos</h2>

        <label>Fecha de Inicio</label>
        <asp:TextBox ID="txtFechaInicio" runat="server" CssClass="input-text" TextMode="Date"></asp:TextBox>

        <label>Fecha de Fin</label>
        <asp:TextBox ID="txtFechaFin" runat="server" CssClass="input-text" TextMode="Date"></asp:TextBox>

        <label>Estado del crédito</label>
        <asp:DropDownList ID="ddlEstado" runat="server" CssClass="select-dropdown">
            <asp:ListItem Value="" Text="TODOS" />
            <asp:ListItem Value="Activo" Text="Activo" />
            <asp:ListItem Value="Inactivo" Text="Inactivo" />
            <asp:ListItem Value="Pendiente" Text="Pendiente" />
            <asp:ListItem Value="Finalizado" Text="Finalizado" />
        </asp:DropDownList>

        <div class="btn-container">
            <asp:Button ID="btnBack" runat="server" Text="Regresar" CssClass="btnBack" OnClick="btnBack_Click" />
            <asp:Button ID="btnFiltrar" runat="server" Text="Filtrar" CssClass="filter-btn" OnClick="btnFiltrar_Click" />
        </div>

        <!-- Tabla de créditos -->
        <div class="table-container">
            <asp:GridView ID="gvCreditos" runat="server" AutoGenerateColumns="false" OnRowDataBound="gvCreditos_RowDataBound">
                <Columns>
                    <asp:BoundField DataField="numCredito" HeaderText="ID_CRÉDITO" />
                    <asp:BoundField DataField="Monto" HeaderText="MONTO" />
                    <asp:BoundField DataField="NumCuotas" HeaderText="NUM. CUOTAS" />
                    <asp:BoundField DataField="TasaInteres" HeaderText="TASA INTERÉS" />
                    <asp:BoundField DataField="FechaOtorgamiento" HeaderText="FECHA SOLICITUD" DataFormatString="{0:dd/MM/yyyy}" />
                    <asp:BoundField DataField="Estado" HeaderText="ESTADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <div class="btn-container">
                                <asp:Button ID="btnPagar" runat="server" Text="Pagar" CssClass="pay-btn" CommandArgument='<%# Eval("numCredito") %>' OnClick="btnPagar_Click" />
                                <asp:Button ID="btnVerDetalle" runat="server" Text="👁️" CssClass="pay-btn" CommandArgument='<%# Eval("numCredito") %>' OnClick="btnVerDetalles_Click" />
                            </div>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <asp:Label ID="lblError" runat="server" CssClass="error-message"></asp:Label>
    </div>

    <div id="PagoModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="closeModal()">&times;</span>
            <h2>Métodos de Pago:</h2>

            <!-- Selector de método de pago -->
            <label for="metodoPago">Seleccione el método de pago:</label>
            <select id="metodoPago" runat="server" onchange="mostrarCamposPago()">
                <option value="">Seleccione</option>
                <option value="banco">Banco</option>
                <option value="billetera">Billetera Digital</option>
            </select>

            <!-- Información de banco -->
            <div id="infoBanco" style="display: none; margin-top: 20px;">
                <h3>Bancos Aceptados:</h3>
                <img src="images/bancos.png" alt="Bancos Aceptados" style="width:100%; max-width:400px;">
                <label for="bancoElegido">Seleccione el banco</label>
                <select id="bancoElegido" runat="server" onchange="mostrarInformacionBanco()">
                    <option value="">Seleccione</option>
                    <option value="bcp">BCP</option>
                    <option value="bbva">BBVA</option>
                    <option value="interbank">Interbank</option>
                    <option value="scotiabank">Scotiabank</option>
                </select>
                <div id="detallesBanco" style="margin-top: 20px; display: none;">
                    <p>CCI:</p>
                    <asp:TextBox ID="txtCCI" runat="server" CssClass="input-text" Text="" ReadOnly="False" Enabled="True" />
                    <p>Nombre del Titular:</p>
                    <asp:TextBox ID="txtTitularBanco" runat="server" CssClass="input-text" Text="" ReadOnly="False" Enabled="True" />
                    <p>Tipo de Cuenta:</p>
                    <asp:TextBox ID="txtTipoCuenta" runat="server" CssClass="input-text" Text="" ReadOnly="False" Enabled="True" />
                </div>
            </div>

            <!-- Información de billetera digital -->
            <div id="infoBilletera" style="display: none; margin-top: 20px;">
                <h3>Billeteras Digitales Aceptadas:</h3>
                <img src="images/billeteras.png" alt="Billeteras Aceptadas" style="width:100%; max-width:180px;">
                <br>
                <img src="images/QR.png" alt="Billeteras Aceptadas" style="width:100%; max-width:400px;">
                <p>Número de Billetera:</p>
                <asp:TextBox ID="txtNumeroBilletera" runat="server" CssClass="input-text" Text="" ReadOnly="False" Enabled="True" />
                <p>Nombre del Titular:</p>
                <asp:TextBox ID="txtTitularBilletera" runat="server" CssClass="input-text" Text="" ReadOnly="False" Enabled="True" />
            </div>

            <p>Inserte imagen jpeg:</p>
            <asp:FileUpload ID="fileUpload" runat="server" />
            <br /><br />
        
            <!-- Botones de acción -->
            <asp:Button ID="btnCancel" runat="server" Text="Cancelar" CssClass="cancel-btn" OnClientClick="closeModal(); return false;" />
            <asp:Button ID="btnSave" runat="server" Text="Grabar" CssClass="save-btn" OnClick="btnSave_Click"/>
        </div>
    </div>
</asp:Content>
