
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt" xmlns:href="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css"> <!-- [PROBLEMA COM A REF DOS ÍCONES DE FONT AWESOME] -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
--
</head>
<body>

<div class="login">
<div class="textotituloregisto">
    <div class="registo">
    	<form method="post" action="/registo">
    		<br>
            <br>
            <br>
            <br>
    			<label for="nome_id" class="labelsregisto">Nome: </label>
    			<input type="text" name="nome" placeholder="Nome" id="nome_id" value="${user.getNome()}" required maxlength="100">
                <br>
                <span style="color: red; font-size: small" >${errorMessageNome}</span>
    		<br>
            <br>
            <br>
                <label for="username_id" class="labelsregisto">Username: </label>
                <input type="text" name="username" placeholder="Username" id="username_id" value="${user.getUsername()}" required maxlength="100">
                <br>
                <span style="color: red; font-size: small" >${errorMessageUsername}</span><br>
                <span style="color: red; font-size: small" >${errorMessageUserSame}</span>
    		<br>
    		<br>
    			<label for="email_id" class="labelsregisto">E-mail: </label>
    			<input type="email" name="email" placeholder="E-mail" id="email_id" value="${user.getEmail()}" required maxlength="100">

                <br>
                <span style="color: red; font-size: small" >${errorMessageEmail}</span><br>
                <span style="color: red; font-size: small" >${errorMessageEmailSame}</span>
    		<br>
    		<br>
    			<label for="password_id" class="labelsregisto">Password: </label>
    			<input type="password" name="password" placeholder="Password" id="password_id" value="${user.getPassword()}" required maxlength="100">

                <br>
                <span style="color: red; font-size: small" >${errorMessagePass01}</span><br>
                <span style="color: red; font-size: small" >${errorMessagePass02}</span>
    		<br>
    		<br>
    			<label for="password2_id" class="labelsregisto">Confirmação de Password: </label>
    			<input type="password" name="password2" placeholder="Password" id="password2_id" value="${user.getPassword()}" required />

                <br>
                <span style="color: red; font-size: small" >${errorMessagePass2}</span>
            <br>
    		<br>
            <br>
            <br>
            <div class="registo">
                <input type = "checkbox" id = "aceptTerms" nome = "aceptTerms" value = "aceptTerms" required >
                    <label for = "aceptTerms"> Aceito os <a href=https://www.centrosdesaude.pt/termos-e-condicoes/"> Termos e Condições</a> em vigor</label>

            <br>
            <br>
    		</div>
    		<div class="botaoregisto">
                        <button type="reset" class="btn-special1">Limpar</button>
                        <button type="submit" class="btn-special">Confirmar</button>


            </div>

            <br>
        </form>
    </div>

    </fieldset>
    <br>
    </div>
    </div>
    <div class ="imagemlogin">
        <img src="/Imagens/logo_proposta.svg" alt="logo" width="500" height="300">
    </div>
    </div>
    </div>
</form>
</body>
</html>