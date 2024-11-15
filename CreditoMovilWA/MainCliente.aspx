<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Usuario.master" CodeFile="MainCliente.aspx.cs" Inherits="CreditoMovilWA.MainCliente" %>

<asp:Content ID="HeadContent" ContentPlaceHolderID="HeadContent" runat="server">
    <script src="https://cdn.jsdelivr.net/npm/raphael@2.2.8/raphael.min.js"></script> <!-- Dependencia de JustGage -->
    <script src="https://cdn.jsdelivr.net/npm/justgage"></script> <!-- CDN de JustGage -->
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    <style>
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
            transition: background-color 0.4s ease;
        }
        .btn:hover {
            background-color: #265f21;
        }
        .ranking-label {
            font-size: 30px;
            color: #ffb400; /*se cambia por detras*/
            background-color: rgba(0, 0, 0, 0);
            padding: 5px 50px;
            border-radius: 5px;
            margin-bottom: 10px;
            display: inline-block;
        }
        .header {
            display: flex;
            justify-content: flex-start;  /* Los elementos se alinean a la izquierda */
            align-items: center;
            width: 100%;
        }

        .header img {
            max-width: 150px;  /* Ajusta el tamaño del logo si es necesario */
        }

        .header-buttons {
            display: flex;
            gap: 10px;
            margin-left: 1080px;  /* Ajusta este valor para reducir la distancia entre el logo y los botones */
        }

        .btn-logout {
            padding: 12px 20px;
            font-size: 16px;
            font-weight: 700;
            color: white;
            background-color: #FF0000; /* Rojo claro */
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.4s ease;
        }

        .btn-logout:hover {
            background-color: #e60000; 
        }

        .btn-modificar {
            padding: 12px 20px;
            font-size: 16px;
            font-weight: 700;
            color: #fff;
            background-color: #273fab; 
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.4s ease;
        }

        .btn-modificar:hover {
            background-color: #1a2b75; 
        }
        #apexGauge {
            max-width: 380px;
            margin: auto;
        }
    </style>
    <script>
        function renderApexGauge(ranking) {
            let color;

            // Asigna un color específico basado en el valor de ranking
            if (ranking <= 20) {
                color = '#FF0000'; // Rojo para 0-20%
            } else if (ranking <= 40) {
                color = '#FFA500'; // Naranja para 20-40%
            } else if (ranking <= 60) {
                color = '#FFFF00'; // Amarillo para 40-60%
            } else if (ranking <= 80) {
                color = '#90EE90'; // Verde claro para 60-80%
            } else {
                color = '#006400'; // Verde oscuro para 80-100%
            }

            var options = {
                series: [ranking],
                chart: {
                    type: 'radialBar',
                    height: 350
                },
                plotOptions: {
                    radialBar: {
                        startAngle: -90,
                        endAngle: 90,
                        hollow: {
                            margin: 15,
                            size: '60%',
                        },
                        track: {
                            background: '#ADBAC0', // Fondo gris para mejorar el contraste
                            strokeWidth: '70%',
                            margin: 5, // Espacio entre el track y el gráfico
                            opacity: 0.7
                        },
                        dataLabels: {
                            name: {
                                show: false
                            },
                            value: {
                                fontSize: '50px',
                                color: '#78818D',
                                offsetY: -10,
                                fontFamily: 'Poppins, sans-serif', // Cambia la fuente
                                fontWeight: 'bold'
                            }
                        }
                    }
                },
                fill: {
                    colors: [color] // Color asignado según el valor del ranking
                },
                labels: ['Puntaje']
            };

            var chart = new ApexCharts(document.querySelector("#apexGauge"), options);
            chart.render();
        }

        // Llama a la función con el puntaje desde el servidor
        document.addEventListener("DOMContentLoaded", function () {
            renderApexGauge(<%= ObtenerRankingSinPorcentaje() %>);
        });
    </script>
</asp:Content>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="header" runat="server" id="headerDiv">
        <img src="images/credit2.png" alt="Logo Crédito Móvil">
        <div class="header-buttons">
            <asp:Button ID="btnModificarDatos" runat="server" Text="Modificar Datos" CssClass="btn-modificar" OnClick="btnModificarDatos_Click" />
            <asp:Button ID="btnLogout" runat="server" Text="Cerrar Sesión" CssClass="btn-logout" OnClick="btnLogout_Click" />
        </div>
    </div>
    <div>
        <h1 id="hola" runat="server">¡Hola, </h1>
        <p>Actualmente tu ranking crediticio es:</p>
        <asp:Label ID="lblRanking" runat="server" CssClass="ranking-label" Font-Size="0px"></asp:Label>

        <!-- Contenedor del medidor con ApexCharts -->
        <div id="apexGauge"></div>

        <!-- Botones de acción -->
        <asp:Button ID="btnSolicitarCredito" runat="server" Text="Solicitar un crédito" CssClass="btn" OnClick="btnSolicitarCredito_Click" />
        <asp:Button ID="btnVerCreditos" runat="server" Text="Visualizar mis créditos" CssClass="btn" OnClick="btnVerCreditos_Click" />
    </div>
</asp:Content>

