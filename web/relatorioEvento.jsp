<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <title>Relatorio Eventos</title>
        <!--jQuery-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script>
            $(document).ready(function() {
                $('select').material_select();
            });
        </script>
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <nav class="nav-extended light-green lighten-1">
                <div class="nav-wrapper">
                    <img class="responsive" src="img/if_icon.png">
                    <a href="#" class="brand-logo">Sistema de Gerenciamento de Eventos</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="sass.html">Sass</a></li>
                        <li><a href="badges.html">Components</a></li>
                        <li><a href="collapsible.html">JavaScript</a></li>
                    </ul>
                    <ul class="side-nav" id="mobile-demo">
                        <li><a href="sass.html">Sass</a></li>
                        <li><a href="badges.html">Components</a></li>
                        <li><a href="collapsible.html">JavaScript</a></li>
                    </ul>
                    <ul class="tabs tabs-transparent">
                        <li class="tab"><a href="VoltarInicioController">Início</a></li>
                        <li class="tab"><a href="PesquisaNoticiaController">Noticias</a></li>
                        <li class="tab"><a href="PesquisaPropostaController">Propostas</a></li>
                        <li class="tab"><a href="PesquisaAlunoController">Alunos</a></li>
                        <li class="tab"><a href="PesquisaAdministradorController">Administrador</a></li>
                        <li class="tab"><a href="PesquisaEventoController">Evento</a></li>
                        <li class="tab"><a href="PesquisaExternoController">Externo</a></li>
                        <li class="tab"><a href="PesquisaGerenteController">Gerente</a></li>
                        <li class="tab"><a href="PesquisaLocalController">Local</a></li>
                    </ul>
                </div>
            </nav>
            <div>
                Esse sistema foi desenvolvido para gerenciar Eventos Institucionais de forma a facilitar os eventos.
            </div>
        </header>
    <main>
        <form action="RelatorioEventoController?acao=exibirRelatorio" method="post" name="frmRelatorioEvento">
        <div class="input-field row">
            <select name="temaEvento" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                <option value="" <c:if test="${externo.conhecimento == null}"> selected</c:if>></option>
                <c:forEach items="${eventos}" var="evento">
                    <option value="${evento.tema}">
                    ${evento.tema}
                    </option>  
                </c:forEach>
                        </select>
                        <label>Tema</label>
                    </div>   
        <div class="container center">
            <div class="container center">
               <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
            </div>
        </div>
        </form>       
    </main>
    <footer class="page-footer light-green lighten-1">
        <div class="footer-copyright grey-text text-lighten-4">
            © 2016 Copyright - Modelagem e Programação: Leonardo Smoginski Fernandes | Luiz Filipy Damaceno | Matheus Souza Leao
        </div>
    </footer>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
    <!-- JavaScript SGE-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <!-- JQuery-->
    <!--        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>-->
</body>
</html>

