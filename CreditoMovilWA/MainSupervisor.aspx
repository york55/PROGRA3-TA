<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="MainSupervisor.aspx.cs" Inherits="CreditoMovilWA.MainSupervisor" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <style>
        h2 {
            font-size: 28px;
            color: #2f7a44;
        }

        .lab-not {
            color: red;
            font-size : 18px;
            font-weight: bold;
        }

        .lab-yes {
            color: #2f7a44;
            font-size : 18px;
            font-weight: bold;
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

        /* Estilo del modal */
        .modal {
            display: none; /* Oculto por defecto */
            position: fixed; /* Fijo en la pantalla */
            z-index: 10; /* Aparece sobre otros elementos */
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: hidden; /* Evita el scroll */
            background-color: rgba(0, 0, 0, 0.4); /* Fondo oscuro semitransparente */
        }

        /* Contenido del modal */
        .modal-content {
            background-color: #faf8fc;
            margin: auto; /* Centrado horizontal */
            top: 50%; /* Centrado vertical */
            transform: translateY(-50%); /* Ajusta el centrado vertical */
            padding: 20px;
            position: relative; /* Relativo para posicionar el botón de cerrar */
            border: 1px solid #888;
            width: 80%;
            max-width: 800px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .modal-header{
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 27px;
        }

        .btn-table{
            padding: 5px 10px;
            background-color: #2f7a44;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn-table-aprobar{
            padding: 5px 10px;
            background-color: #002e6e;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Botón de cerrar estilo X */
        .btn-cerrar {
            background: none; /* Sin fondo al inicio */
            color: #333; /* Gris oscuro/negro inicial */
            border: none; /* Sin bordes */
            font-size: 20px; /* Tamaño fijo de la letra */
            font-weight: bold; /* Negrita para la X */
            cursor: pointer; /* Cambia el cursor al pasar el ratón */
            position: absolute; /* Posición fija en la parte superior derecha */
            top: 10px; /* Separación desde el borde superior */
            right: 10px; /* Separación desde el borde derecho */
            z-index: 1001; /* Asegura que esté sobre el contenido */
            padding: 0; /* Sin relleno extra */
            line-height: 1; /* Altura fija para evitar crecimiento */
            width: 25px; /* Fija el ancho */
            height: 25px; /* Fija la altura */
            text-align: center; /* Centrado de la X */
            border-radius: 0; /* Sin bordes redondeados por defecto */
            transition: background-color 0.3s ease, color 0.3s ease, border-radius 0.3s ease; /* Transición solo de color y fondo */
        }

        /* Hover: Fondo rojo, X blanca, bordes redondeados */
        .btn-cerrar:hover {
            background-color: red; /* Fondo rojo */
            color: white; /* X blanca */
        }

        /* Aseguramos que no haya cambios de tamaño ni movimiento */
        .btn-cerrar:focus, 
        .btn-cerrar:hover {
            font-size: 20px; /* Tamaño fijo */
            line-height: 1; /* Altura constante */
            padding: 0; /* Sin cambios de espacio interior */
            outline: none; /* Sin borde de enfoque */
        }


    </style>
    <script type="text/javascript">
        // Abre el modal
        function openModal() {
            document.getElementById("CredPendModal").style.display = "block";
        }
        // Cierra el modal
        function closeModal() {
            document.getElementById("CredPendModal").style.display = "none";
        }
        function confirmAprobarCredito() {
            // Mostrar la alerta de confirmación
            var respuesta = confirm("¿Estás seguro de aprobar este crédito?");

            // Si el usuario hace clic en "Aceptar", continuar con la acción
            return respuesta; // Si el usuario confirma, return true; si cancela, return false
        }
        function confirmAprobarEvaluacion() {
            // Mostrar la alerta de confirmación
            var respuesta = confirm("¿Estás seguro de aprobar este evaluacion?");

            // Si el usuario hace clic en "Aceptar", continuar con la acción
            return respuesta; // Si el usuario confirma, return true; si cancela, return false
        }
    </script>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <h2>¡Hola!</h2>
    <h2>Qué bueno volver a verte...</h2>
    <!-- Contenedor principal -->
    <div class="container">
        <h2>Clientes con créditos pendientes</h2>
        <div class="text-sup">
            <asp:Label ID="txtCliPendAsig" CssClass="lab-yes" runat="server" 
                Text="Estos son los clientes con créditos pendientes por asignar:" Visible="false"></asp:Label>
            <asp:Label ID="txtNotClientPend" CssClass="lab-not" runat="server" 
                Text="No se encontraron clientes con créditos pendientes" Visible="false"></asp:Label>
        </div>
        <div class="table-container">
            <asp:GridView ID="gvClientesCredPend" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="codigoCliente" HeaderText="Cod. Cliente" />
                    <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="apPaterno" HeaderText="Apellido Paterno" />
                    <asp:BoundField DataField="tipoDocumento" HeaderText="Tipo documento" />
                    <asp:BoundField DataField="documento" HeaderText="Nro. Documento" />
                    <asp:TemplateField>
                        <itemtemplate>
                            <asp:Button ID="btnDetallesCliente" runat="server" 
                                Text="Detalles" CssClass="btn-table" OnClick="btnDetallesCliente_Click"
                                CommandArgument='<%# Eval("codigoCliente") %>' />
                            <asp:Button ID="btnVerCreditos" runat="server" 
                                Text="Ver Creditos" CssClass="btn-table-aprobar" OnClick="btnVerCreditos_Click"
                                CommandArgument='<%# Eval("codigoCliente") %>' />
                        </itemtemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>

    <div id="CredPendModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <asp:Button ID="btnCerrarModal" CssClass="btn-cerrar" runat="server" Text="X" OnClick="btnCerrarModal_Click"/>
            </div>
            <p>Apruebe de ser necesario los creditos del cliente</p>
            <div class="modal-mid">
                <asp:GridView ID="gvCredPendXCli" runat="server" AutoGenerateColumns="false">
                    <Columns>
                        <asp:BoundField DataField="numCredito" HeaderText="NUM.CRED" />
                        <asp:BoundField DataField="monto" HeaderText="MONTO" />
                        <asp:BoundField DataField="tasaInteres" HeaderText="TASA INTERES" />
                        <asp:BoundField DataField="estado" HeaderText="ESTADO" />
                        <asp:BoundField DataField="numCuotas" HeaderText="NUM. CUOTAS" />
                        <asp:BoundField DataField="motivo" HeaderText="MOTIVO" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:Button ID="btnAprobarCredito" CssClass="btn-table" 
                                    runat="server" Text="Aprobar" OnClick="btnAprobarCredito_Click"
                                    CommandArgument='<%# Eval("numCredito") %>' OnClientClick="return confirmAprobarCredito();"/>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </div>
        </div>
    </div>

    <div class="container">
        <h2>Evaluaciones por revisar:</h2>
        <div class="text-sup">
            <asp:Label ID="txtHayPendiente" CssClass="lab-yes" runat="server" 
                Text="Estas son las evaluaciones pendientes a revisar" Visible="false"></asp:Label>
            <asp:Label ID="txtNoHayPendiente" CssClass="lab-not" runat="server" 
                Text="No se encontraron evaluaciones pendientes" Visible="false"></asp:Label>
        </div>
        <div class="table-container">
            <asp:GridView ID="gvEvaluacionesPendientes" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="numeroEvaluacion" HeaderText="ID_EVALUACION" />
                    <asp:BoundField DataField="nombreNegocio" HeaderText="NEGOCIO" />
                    <asp:BoundField DataField="ventasDiarias" HeaderText="VENTAS" />
                    <asp:BoundField DataField="margenGanancia" HeaderText="MARGEN. GANANCIA" />
                    <asp:BoundField DataField="puntaje" HeaderText="PUNTAJE" />
                    <asp:BoundField DataField="activo" HeaderText="ESTADO" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:Button ID="btnVerDetalleEv" runat="server" Text="👁️" 
                                CssClass="view-btn" CommandArgument='<%# Eval("numeroEvaluacion") %>' 
                                OnClick="btnVerDetalleEv_Click"/>
                            <asp:Button ID="btnAprobarEv" runat="server" Text="Aprobar" 
                                CssClass="view-btn" CommandArgument='<%# Eval("numeroEvaluacion") %>' 
                                OnClick="btnAprobarEv_Click" OnClientClick="return confirmAprobarEvaluacion();"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <h2>Estas son las evaluaciones que posees:</h2>
        <!-- Tabla de evaluaciones -->
        <div class="table-container">
            <div class="text-sup">
                <asp:Label ID="txtHayRealizado" CssClass="lab-yes" runat="server" 
                    Text="Estas son las evaluaciones que realizaste" Visible="false"></asp:Label>
                <asp:Label ID="txtNoHayEvRealizada" CssClass="lab-not" runat="server" 
                    Text="Aún no has realizado ninguna evaluación" Visible="false"></asp:Label>
            </div>
            <asp:GridView ID="gvEvaluacionesRealizadas" runat="server" AutoGenerateColumns="false">
                <Columns>
                    <asp:BoundField DataField="numeroEvaluacion" HeaderText="ID_EVALUACION" />
                    <asp:BoundField DataField="nombreNegocio" HeaderText="NEGOCIO" />
                    <asp:BoundField DataField="ventasDiarias" HeaderText="VENTAS" />
                    <asp:BoundField DataField="margenGanancia" HeaderText="MARGEN. GANANCIA" />
                    <asp:BoundField DataField="puntaje" HeaderText="PUNTAJE" />
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
