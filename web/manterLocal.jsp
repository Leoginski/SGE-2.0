<%-- 
    Document   : manterLocal
    Created on : 11/10/2016, 10:18:51
    Author     : Math
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Novo Local</title>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header>
            <nav class="nav-wraper light-green lighten-1">
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Sistema de Gerenciamento de Eventos</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <ul id="nav-mobile" class="left hide-on-med-and-down">
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
        </header>
        <main>
            <h5 class="flow-text center">Manter Local - ${operacao}</h5>
            <form action="ManterLocalController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterLocal" onsubmit="return validarFormulario(this)">
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtIdLocal" value="${local.idLocal}" <c:if test="${operacao != 'incluir'}"> readonly</c:if>>
                        <label class="active" for="txtIdLocal">Id do Local</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="txtDescricaoLocal" value="${local.descricao}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDescricaoLocal">Descriçao</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s2">
                        <input type="text" name="txtCapacidadeLocal" value="${local.capacidade}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtCapacidadeLocal">Capacidade</label>               
                </div>
                </div>
                <div class="row">
                <div class="container center">
                    <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
                </div>
                </div>    
        </form>
</main>
<footer class="page-footer light-green lighten-1">
    <div class="footer-copyright grey-text text-lighten-4">
        © 2016 Copyright - Modelagem e Programação: Matheus Souza Leao | Luiz Filipy Damaceno | Leonardo Smoginski Fernandes
    </div>
</footer>  
<SCRIPT language="JavaScript">
            <!--
            
    function campoNumerico(valor)
    {
        var caracteresValidos = "0123456789";
        var ehNumero = true;
        var umCaracter;
        for (i = 0; i < valor.length && ehNumero == true; i++)
        {
            umCaracter = valor.charAt(i);
            if (caracteresValidos.indexOf(umCaracter) == -1)
            {
                ehNumero = false;
            }
        }
        return ehNumero;
    }

    function validarFormulario(form) {
        var mensagem;
        mensagem = "";
        if (form.txtIdLocal.value == "") {
            mensagem = mensagem + "Informe o Código do Local\n";
        }
        if (form.txtDescricaoLocal.value == "") {
            mensagem = mensagem + "Informe a Descrição do Local\n";
        }
        if (form.txtCapacidadeLocal.value == "") {
            mensagem = mensagem + "Informe a capacidade do Local \n";
        }
        if (!campoNumerico(form.txtIdLocal.value)) {
            mensagem = mensagem + "Código do Local deve ser numérico\n";
        }
        if (!campoNumerico(form.txtCapacidadeLocal.value)) {
            mensagem = mensagem + "Capacidade do Local deve ser numérico\n";
        }
        if (mensagem == "") {
            return true;
        } else {
            alert(mensagem);
            return false;
        }
    }
    //-->
</SCRIPT>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
<!-- JavaScript SGE-->
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
