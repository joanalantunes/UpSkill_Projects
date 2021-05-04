<!DOCTYPE html>
<html lang="pt">
<html>
<head>
           <link rel="stylesheet" href="/css/style.css" type="text/css">
           <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
           <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
           integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
           crossorigin="anonymous">
</head>
<body>

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
            Responsável de Unidade</div>
    </div>
    <br>
    <div class = "item">
        <img src="/Imagens/noun_Home_82867.svg" alt="logo">
        <a href="/inicio_respunidade/${user.getId()}">Início</a>
    </div>
    <div class="retanguloVerdeVer"></div>
    <div class = "item">
        <img src="/Imagens/Caminho 68.svg" alt="logo">
        <a href="/alteracao_dados_respunidade/${user.getId()}">Perfil</a>
    </div>
    <div class="item">
        <img src="/Imagens/noun_Doctor_1995245.svg" alt="logo">
        <a href="/listar_medicos/${user.getId()}">Médicos</a>
    </div>
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

    <br>
    <div class="retangulodados">
         <form method="POST" action="/alteracao_dados_respunidade/${user.getId()}" enctype="multipart/form-data">
                    <br>
                    <div class="wrapper">
                            <img src="${user.getPhotosImagePath()}" width="200px" height="200px"/>
                            </div>
                                <input type="file" class="my_file" name="image" accept="image/png, image/jpeg"/>
                                <br>
                                <br>
                    <div class="row">
                        <div class="form-group">
                            <label for="inputNome">Nome Completo</label>
                            <input type="nome" name="nome" class="form-control" id="inputNome" placeholder="${user.getNome()}"value="${user.getNome()}">
                        </div>
                    </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputMorada">Morada</label>
                    <input type="morada" name="morada" class="form-control" id="inputMorada" placeholder="Morada" value="${user.getMorada()}">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPostal">Código-Postal</label>
                    <input type="codigoPostal" name="codigoPostal" class="form-control" id="inputPostal" placeholder="Código-Postal" value="${user.getCodigoPostal()}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputLocalidade">Localidade</label>
                    <input type="localidade" name="localidade" class="form-control" id="inputLocalidade" placeholder="Localidade" value="${user.getLocalidade()}"/>
                </div>
                <div class="form-group col-md-6">
                    <label class="control-label" for="date"> Data de nascimento</label>
                    <input class="form-control" id="date" name="dataNascimento" placeholder="MM/DD/YY" type = "text" value="${user.getDataNascimento()}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputDocumentoID">Documento de Identificação</label>
                    <select id="inputDocId" class="form-control" id="inputDocumentoId">
                        <option selected>Selecione...</option>
                        <option>Bilhete de Identidade</option>
                        <option>Cartão de Cidadão</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="inputNumeroDoc">Nº do documento </label>
                    <input type="numeroDoc" name="numeroDocumento" class="form-control" id="inputNumeroDoc" placeholder="Nº do documento selecionado" value="${user.getNumeroDocumento()}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="inputContacto">Contacto telefónico</label>
                    <input type="contacto" name="contacto" class="form-control" id="inputContacto" placeholder="Contacto telefónico" value="${user.getContacto()}">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputNIF">NIF</label>
                    <input type="nif" name="nif" class="form-control" id="inputNIF" placeholder="NIF" value="${user.getNif()}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="email" name="email" class="form-control" id="inputEmail" placeholder="${user.getEmail()}" value="${user.getEmail()}" readonly>
                </div>
            </div>
            <br>
            <div class = buttonsubmeter>
                <button type="submit" class="btn-special btn-lg">Submeter</button>
            </div>
        </form>
    </div>
</body>
</html>