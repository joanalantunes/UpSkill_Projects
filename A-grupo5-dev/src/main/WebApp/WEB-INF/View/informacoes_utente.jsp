<!DOCTYPE html>
<html lang="pt">
<head>
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <%--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous"--%>

    <style>

    </style>
</head>
<body>
<div class="container-fluid">
<div class="sidenav">
    <figure>
        <img src="/Imagens/centro_hospitalar_upskill_logo.svg" alt="logo">
    </figure>
    <div class="texto">
        <div class="textoOla">
            Olá de novo,<br></div>
        <div class="textonome">
         ${user.getUsername()}<br></div>
        <div class="textotipo">
            Utente</div>
    </div>
    <br>
    <div class = "item">
        <img src="/Imagens/noun_Home_82867.svg" alt="logo">
        <a href="/inicio_utente/${user.getId()}">Início</a>
    </div>
    <div class = "item">
        <img src="/Imagens/Caminho 68.svg" alt="logo">
        <a href="/alteracao_dados_utente/${user.getId()}">Perfil</a>
    </div>
    <div class="item">
            <img src= "/Imagens/noun_Doctor_1995245.svg" alt="logo">
            <a href="/pagina_manutencao">Consultas</a>
        </div>
    <div class="item">
        <img src="/Imagens/noun_heart rate_1183398.svg" alt="logo">
        <a href="/pagina_manutencao">Pagamentos</a>
    </div>
    <p>Acessos Rápidos</p>

    <div class="item">
        <img src="/Imagens/noun Calendar 3716734.svg" alt="logo">
        <a href="/calendario_utente/${user.getId()}">Calendário de vagas</a>
    </div>
    <div class="retanguloVerdeVer"></div>
    <div class="item">
        <img src="/Imagens/Grupo 29.svg" alt="logo">
        <a href="/informacoes_utente/${user.getId()}">Informações gerais</a>
    </div>
    <div class="item">
        <img src="/Imagens/noun_Phone_1952557.svg" alt="logo">
        <a href="/contactos_utente/${user.getId()}">Contactos</a>
    </div>

    <div class="bottom">
        <div class="logo">
            <img src="/Imagens/Captura de ecrã 2021-02-06, às 16.10.52.png" alt="logo">
        </div>
        <hr>
        <div class="item">
            <img src="/Imagens/noun_logout_541763.svg" alt="logo">
            <a href="/logout">Terminar Sessão</a>
        </div>
    </div>


</div>


<div class="main">

    <div class="figura">
        <img src="/Imagens/Grupo 7.svg" alt="logo">
    </div>
    <div class="textomain">
        <div class="textotitulo">
            CUIDE DE SI E DOS SEUS.<br><br></div>
        <div class="textoinfo">
            O Centro Hospitalar UPskill inspira-se nos seus clientes para estar na vanguarda
            na proteção das famílias. Estamos mais inovadores na prestação de cuidados de saúde, mais próximos e mais ágeis.<br></div>
    </div>

        <div class="textogeral">
                INFORMAÇÕES GERAIS
                <br>
                <br>
                    <div class="informacaogeral">
                        <h3> Missão e valores do Centro Hospitalar Upskill </h3>
                        <h5>Consciente do papel que desempenha no país, como empresa 100% portuguesa e como referência na prestação de cuidados de saúde,</h5>
                        <h5>o Centro Hospitalar Upskill assume, desde a sua origem, um compromisso sério e responsável com os seus clientes,</h5>
                        <h5>parceiros, fornecedores, com o Estado e com a sociedade em geral.</h5>
                        <br>
                        <br>
                        <h5>Promover a prestação de serviços de saúde com os mais elevados níveis de qualidade e conhecimento, respeitando o primado da vida e o ambiente,</h5>
                        <h5>através do desenvolvimento do capital intelectual das organizações, numa busca permanente do melhor é a missão do Centro Hospitalar Upskill</h5>
                        <br>
                        <br>
                        <h5>Para concretizar a sua missão, o Centro Hospitalar Upskill desenvolve a sua atividade com base em três plataformas de excelência,</h5>
                        <h5>nomeadamente a excelência em talento humano, a excelência no serviço e a excelência em operações e sistemas.</h5>
                        <br>
                        <br>
                        <h5><span style="text-decoration: underline;">Horários</span></h5>
                        <h5><b>Dias úteis:</b> 8h - 22h </h5>
                        <h5><b>Sábados:</b> 8h - 21h </h5>
                        <h5><b>Domingos e Feriados:</b> 8h - 21h </h5>
                        <br>
                        <br>
                        <h5><span style="text-decoration: underline;">Urgências</span></h5>
                        <h5><b>Serviço urgência:</b> 24h/dia </h5>
                    </div>
                </div>
            <div class="noticias1">
                <img src="/Imagens/Grupo 30.png" alt="logo">
            </div>
        </div>
                </div>
            </div>
            <br>
            <br>
        </div>
    </div>
    </body>
    </html>