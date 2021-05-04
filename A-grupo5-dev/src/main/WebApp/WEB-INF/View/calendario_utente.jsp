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

            <div class="retanguloVerdeVer"></div>
            <div class="item">
                <img src="/Imagens/noun Calendar 3716734.svg" alt="logo">
                <a href="/calendario_utente/${user.getId()}">Calendário de vagas</a>
            </div>
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

    <div class="textocalendario">
            Marcação de Consulta
    </div>

    <div class="retangulocentral">

    <div class="container" style="margin-left: 4%">
        <table class="table">
            <thead>
            <tr>
                <th>Especialidades</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="especialidade" items="${especialidadeList}">
                    <tr>
                        <td>${especialidade.getNome()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br>

        <div class="signup-w4ls">
        <form method = "post" action="">
        <div class="row">

        <div class="form-group col-sm-3" style="margin-left: 2%">

             <label>Selecionar Especialidade</label>
                <select class="form-control" name="especialidadeOption">
                    <option value=0>Escolha a especialidade</option>
                    <c:forEach var="especialidade" items="${especialidadeList}">
                        <option value="${especialidade.getId_especialidade()}">
                            ${especialidade.getNome()}
                        </option>
                    </c:forEach>
                </select>

        </div>

        </div>
        <br>
        <div class = buttonsubmeter>
            <button type="submit" class="btn-special btn-lg">Escolher médico</button>
        </div>
        </form>
    </div>
    <div class="noticias">
            <img src="/Imagens/Grupo 30.png" alt="logo">
    </div>
    </div>
    </div>
    </div>
</body>
</html>