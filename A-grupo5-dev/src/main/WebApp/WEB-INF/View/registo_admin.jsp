<!DOCTYPE html>
<html lang="pt" xmlns:href="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<style>
.inv {
    display: none;
}

</style>
<body>
<form method = "post" action="/registo_admin">
    <div class="login">
    <div class="textotitulologin">
    <fieldset>
        <br>
        <br>
        <label for="nome_id"> Nome: </label>
        <input type="text" name="nome" id="nome_id" placeholder="Nome" required maxlength="100">
        <br>
        <br>
        <label for="username_id"> Username: </label>
        <input type="text" name="username" id="username_id" placeholder="Username" required maxlength="100">
        <br>
        <br>
        <label for="email_id"> Email: </label>
        <input type="text" name="email" id="email_id" placeholder="E-mail" required maxlength="100">
        <br>
        <br>
        <label>Cargo do Funcionário: </label>

        <select name="role" id="input_medico" class="form-control">
            <option value="None">--Cargo do Funcionário--</option>
            <option value="Médico">Médico</option>
            <option value="Responsável de Unidade">Responsável de Unidade</option>
            <option value="Funcionário">Funcionário</option>
        </select>

        <div id="Médico" class="inv">
            <select name="especialidade" id="inputEspecialidade" class="form-control">
                <option value="Geral">Geral</option>
                <option value="Pediatria">Pediatria</option>
                <option value="Ortorrino">Ortorrino</option>
                <option value="Cardiologia">Cardiologia</option>
            </select>

        </div>

        <script>
                    document
                        .getElementById('input_medico')
                        .addEventListener('change', function () {
                            'use strict';
                            var vis = document.querySelector('.vis');
                            var target = document.getElementById(this.value);
                            if (vis !== null) {
                                vis.className = 'inv';
                            }

                            if (target !== null ) {
                                target.className = 'vis';
                            }
                    });
                </script>

        <br>
        <label for="password_id"> Password: </label>
        <input type="password" name="password" id="password_id" placeholder="Palavra-passe" required maxlength="100">
        <br>
        <br>
        <label for="password1_id">Confirme a sua password</label>
        <input type="password" name="password1" id="password1_id" placeholder="Confirme palavra-passe "></input>
        <br>
        <br>
        <br>
        <div class="registo">
            <input type = "checkbox" id = "aceptTerms" nome = "aceptTerms" value = "aceptTerms">
                <label for = "aceptTerms"> Aceito os <a href=https://www.centrosdesaude.pt/termos-e-condicoes/"> Termos e Condições</a> em vigor</label>
            <br>
            </div>
            <br>
            <div class="botaoregisto">
            <button type="reset" class="btn btn-light btn-lg">Limpar</button>
            <button type="submit" class="btn btn-light btn-lg">Confirmar</button>


    </div>
    </fieldset>
    <br>
    </div>
    </div>
    <div class ="imagemlogin">
        <img src="/Imagens/logo_proposta.svg" alt="logo" width="500" height="300">
    </div>
</form>
</body>
</html>