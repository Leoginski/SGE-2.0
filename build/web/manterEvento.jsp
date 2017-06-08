<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Novo Evento</title>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta charset="UTF-8">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script>
            $(document).ready(function() {
                $('select').material_select();
            });
        </script>
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
        <h5 class="flow-text center">Manter Evento - ${operacao}</h5>
        <form action="ManterEventoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEvento" onsubmit="return validarFormulario(this)">
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" name="txtIdEvento" value="${evento.idEvento}" <c:if test="${operacao != 'incluir'}"> readonly</c:if>>
                        <label class="active" for="txtIdEvento">Id Evento</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="txtNomeEvento" value="${evento.nomeEvento}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtNomeEvento">Nome do Evento</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtDuracaoEvento" value="${evento.duracao}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDuracaoEvento">Duração do Evento</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="txtTemaEvento" value="${evento.tema}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtTemaEvento">Tema</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtDataInicioEvento" value="${evento.dataInicioEvento}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDataInicioEvento">Data Inicio</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="txtDataFimEvento" value="${evento.dataFimEvento}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDataFimEvento">Data Fim</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtDataInicioInscricao" value="${evento.dataInicioInscricao}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDataInicioInscricao">Início Inscrições</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="txtDataFimInscricao" value="${evento.dataFimInscricao}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <label class="active" for="txtDataFimInscricao">Fim Inscrições</label>
                    </div>
                </div>
                <div class="input-field center">
                    <select name="optAdministrador" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                    <option value="0" <c:if test="${administrador.codAdministrador == null}"> selected</c:if>> </option>  
                    <c:forEach items="${administradores}" var="administrador">
                        <option value="${administrador.codAdministrador}" <c:if test="${evento.administradorcodAdministrador.codAdministrador == administrador.codAdministrador}"> selected</c:if>>${administrador.nome}</option>  
                    </c:forEach>
                </select>    
                <label>Administrador</label>
            </div>        
            <div class="container center">
                <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
            </div>
        </form>        
    </main>
    <footer>
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
            if (form.txtIdEvento.value == "") {
                mensagem = mensagem + "Informe o Código do Evento\n";
            }
            if (form.txtNomeEvento.value == "") {
                mensagem = mensagem + "Informe o Nome do Evento\n";
            }
            if (form.txtDuracaoEvento.value == "") {
                mensagem = mensagem + "Informe a Duração do Evento\n";
            }
            if (form.txtTemaEvento.value == "") {
                mensagem = mensagem + "Informe o Código do Evento\n";
            }
            if (form.txtDataInicioEvento.value == "") {
                mensagem = mensagem + "Informe a Data Inicio do Evento\n";
            }
            if (form.txtDataFimEvento.value == "") {
                mensagem = mensagem + "Informe a Data de Fim do Evento\n";
            }
            if (form.txtDataInicioInscricao.value == "") {
                mensagem = mensagem + "Informe a Data de Inicio das Inscricões do Evento\n";
            }
            if (form.txtDataFimInscricao.value == "") {
                mensagem = mensagem + "Informe a Data de Fim das Inscrições do Evento\n";
            }
            if (!campoNumerico(form.txtIdEvento.value)) {
                mensagem = mensagem + "Código do Evento deve ser numérico\n";
            }
            if (form.optAdministrador.value == 0) {
                mensagem = mensagem + "Escolha um administrador\n"
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
