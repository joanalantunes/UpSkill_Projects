<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt" charset="UTF-8">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>

<body>
<div class="login">
    <div class="textotitulologin">
        <br>
        <br>
        <span style="color: red; font-size: medium" >${errorMessage}</span>
        <form method="post" action="login">
        <label for="username">Username: </label>
        <input type="text" name="username" placeholder="Username">
        <br>
        <br>
        <br>
        <label for="password">Password: </label>
        <input type="password" name="password" placeholder="Password">
        <br>
        <br>
        <br>
        <div class="posicaobotoes">
            <div class ="sessao">
                <button class="btn-special" type="submit">Iniciar sessão</button>
                <br>
                <br>
            </div>
            <div class ="form-check">
                <div class="criarconta">
                Não tem uma conta? <a href="registo">Criar conta</a>
                </div>
            </div>
        </div>
    </form>

    </div>

</div>

    <div class ="imagemlogin">
            <img src="/Imagens/logo_proposta.svg" alt="logo" width="500" height="300">
    </div>
</body>

</html>