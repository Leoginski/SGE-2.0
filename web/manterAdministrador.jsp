<%-- 
    Document   : manterAdministrador
    Created on : 20/12/2016, 17:45:06
    Author     : Leo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Novo Administrador</title>
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
            <h5 class="flow-text center">Manter Administrador - ${operacao}</h5>
            <div class="row">
                <form class="col s12" action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador" onsubmit="return validarFormulario(this)">
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="CodAdministrador" type="text" name="txtCodAdministrador" value="${administrador.codAdministrador}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                <label class="active" for="CodAdministrador">Código do Administrador</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="NomeAdministrador" type="text" name="txtNomeAdministrador" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="CodAdministrador">Nome</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6"> 
                                <input id="EmailAdministrador" type="text" name="txtEmailAdministrador" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>    
                                <label class="active" for="CodAdministrador">Email</label>
                            </div>          
                            <div class="input-field col s6"> 
                                <input id="SenhaAdministrador" type="text" name="txtSenhaAdministrador" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>   
                                <label class="active" for="CodAdministrador">Senha</label>
                            </div> 
                        </div>
                        <div class="row">
                            <div class="input-field col s2"> 
                                <input id="DataNascimentoAdministrador" type="text" name="txtDataNascimentoAdministrador" value="${administrador.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label class="active" for="DataNascimentoAdministrador">Data de Nascimento</label>
                        </div>           
                    </div>                            
                    <div class="container center">
                        <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
                    </div>
                </form>
            </div>        
        </main>
        <footer class="page-footer light-green lighten-1">
            <div class="footer-copyright grey-text text-lighten-4">
                © 2016 Copyright - Modelagem e Programação: Matheus Souza Leao | Luiz Filipy Damaceno | Leonardo Smoginski Fernandes
            </div>
        </footer>
        <SCRIPT language="JavaScript">
                    <!--
            
            function campoNumerico(valor) {
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
                if (form.txtCodAdministrador.value == "") {
                    mensagem = mensagem + "Informe o Código do Administrador\n";
                }
                if (form.txtNomeAdministrador.value == "") {
                    mensagem = mensagem + "Informe o Nome do Administrador\n";
                }
                if (form.txtEmailAdministrador.value == "") {
                    mensagem = mensagem + "Informe o Email do Administrador \n";
                }
                if (form.txtDataNascimentoAdministrador.value == "") {
                    mensagem = mensagem + "Informe a sua Data de Nascimento\n";
                }
                if (!campoNumerico(form.txtCodAdministrador.value)) {
                    mensagem = mensagem + "Código do Administrador deve ser numérico\n";
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