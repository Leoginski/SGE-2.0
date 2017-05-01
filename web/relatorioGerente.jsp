<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Relatorio Gerentes</title>
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
        <div class="input-field row">
            <select name="optGerente" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                <option value="0" <c:if test="${gerente.codGerente == null}"> selected</c:if>></option>
                <c:forEach items="${gerentes}" var="gerente">
                    <option value="${gerente.codGerente}" <c:if test="${proposta.gerente.codGerente == gerente.codGerente}"> selected</c:if>>${gerente.nome}</option>
                </c:forEach>
            </select>
            <label>Gerentes</label>
        </div>  
        <div class="input-field row">
            <input type="text" name="txtDataNascimento">
            <label class="active" for="txtDataNascimento">Data Nascimento</label>
        </div>
        <div class="container center">
            <a href="RelatorioGerenteController?acao=confirmarImprimir" method="post"> <button class="btn waves-effect waves-light center" > Relatório </button></a>
        </div>
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