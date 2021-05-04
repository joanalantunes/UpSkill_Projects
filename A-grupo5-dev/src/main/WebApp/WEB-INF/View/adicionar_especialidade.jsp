<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
<head>
    <link rel="stylesheet" href="/css/style.css" type="text/css">

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <%--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src = "https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

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
            Responsável de unidade</div>
    </div>
    <br>
            <div class = "item">
                <img src="/Imagens/noun_Home_82867.svg" alt="logo">
                <a href="/inicio_respunidade/${user.getId()}">Início</a>
            </div>
            <div class = "item">
                <img src="/Imagens/Caminho 68.svg" alt="logo">
                <a href="/alteracao_dados_respunidade/${user.getId()}">Perfil</a>
            </div>
            <div class="item">
                <img src="/Imagens/noun_Doctor_1995245.svg" alt="logo">
                <a href="/listar_medicos/${user.getId()}">Médicos</a>
            </div>
            <div class="retanguloVerdeVer"></div>
            <div class="item">
                <img src="/Imagens/noun_heart rate_1183398.svg" alt="logo">
                <a href="/adicionar_especialidade/${user.getId()}">Adicionar Especialidade</a>
            </div>
            <p>Acessos Rápidos</p>


            <div class="item">
                <img src="/Imagens/Grupo 29.svg" alt="logo">
                <a href="/pagina_manutencao">Facturação</a>
            </div>
            <div class="item">
                <img src="/Imagens/noun Calendar 3716734.svg" alt="logo">
                <a href="/pagina_manutencao">Calendário de consultas</a>
            </div>
            <div class="item">
                <img src="/Imagens/noun_Phone_1952557.svg" alt="logo">
                <a href="/registo_admin">Registo de funcionários</a>
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

    <div class="textocalendario">
            ADICIONAR ESPECIALIDADE
        </div>

    <div class="retangulocentral">


    <form method = "post" action="">
        <div class="signup-w4ls">
        <div class="row">
        <div class="form-group col-sm-3">
             <br>
             <label>Adicionar nova Especialidade</label>
             <br>
             <br>
             <input type="text" name="novaEspecialidade" placeholder="Nova Especialidade" required>
        </div>

        </div>
        <br>
        <br>
        <div class = buttonsubmeter>
            <button type="submit" class="btn-special btn-lg">Registar</button>
        </div>
        </form>
    </div>
    <div class="noticias">
            <img src="/Imagens/Grupo 30.png" alt="logo">
    </div>
  </div>
</body>
</html>