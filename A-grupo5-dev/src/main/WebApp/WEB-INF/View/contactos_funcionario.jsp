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
                Funcionário</div>
        </div>
        <br>
        <div class = "item">
            <img src="/Imagens/noun_Home_82867.svg" alt="logo">
            <a href="/inicio_funcionario/${user.getId()}">Início</a>
        </div>
        <div class = "item">
            <img src="/Imagens/Caminho 68.svg" alt="logo">
            <a href="/alteracao_dados_funcionario/${user.getId()}">Perfil</a>
        </div>
        <div class="item">
            <img src="/Imagens/noun_Doctor_1995245.svg" alt="logo">
            <a href="/listar_medicos_func/${user.getId()}">Médicos</a>
        </div>
        <div class="item">
            <img src="/Imagens/noun_heart rate_1183398.svg" alt="logo">
            <a href="/pagina_manutencao">Utentes</a>
        </div>
        <p>Acessos Rápidos</p>


        <div class="item">
            <img src="/Imagens/Grupo 29.svg" alt="logo">
            <a href="/pagina_manutencao">Facturação</a>
        </div>
        <div class="item">
            <img src="/Imagens/noun Calendar 3716734.svg" alt="logo">
            <a href="/calendario_utente_func/${user.getId()}">Calendário de consultas</a>
        </div>
        <div class="retanguloVerdeVer"></div>
        <div class="item">
            <img src="/Imagens/noun_Phone_1952557.svg" alt="logo">
            <a href="/contactos_funcionario/${user.getId()}">Contactos</a>
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
               CONTACTOS
           <br>
           <br>
           <br>
               <div class="retangulocentralcontacto">
           <div class="contacto">
               <h3> Centro Hospitalar Upskill </h3>
                   <h5><span style="text-decoration: underline;">Telefone geral</span>: 211 234 567 </h5>
                   <h5><span style="text-decoration: underline;">E-mail</span>: centro.hospitalar@upskill.pt </h5>
                   <h5><span style="text-decoration: underline;">Morada</span>: Avenida ABC, 100, 1500-650 Lisboa </h5>
           </div>
           <br>
           <br>
           <div class="imagemHospital">
               <img src="/Imagens/imagemhospital.jpg" alt="imagemhospital" width="500" height="300">
           </div>
           </div>
   </div>
           <br>
           <br>
        <div class="noticias">
            <img src="/Imagens/Grupo 30.png" alt="logo">
        </div>


    </div>
</div>
</body>
</html>