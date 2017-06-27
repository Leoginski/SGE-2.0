<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Nova Notícia</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <section>
            <h5 class="flow-text center">Manter Notícia - ${operacao}</h5>
            <form action="ManterNoticiaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterNoticia" onsubmit="return validarFormulario(this)">
                <div class="row">
                    <div class="input-field col s4">
                        <input type="text" name="txtIdNoticia" value="${noticia.idNoticia}" <c:if test="${operacao != 'incluir'}">readonly</c:if> >
                            <label class="active" for="txtIdNoticia">Id Notícia</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="text" name="txtDescricaoNoticia" value="${noticia.descricao}" <c:if test="${operacao == 'excluir'}">readonly</c:if>>
                            <label class="active" for="txtDescricaoNoticia">Descrição</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="text" name="txtDataNoticia" value="${noticia.data}" <c:if test="${operacao == 'excluir'}">readonly</c:if>>
                            <label class="active" for="txtDataNoticia">Data Notícia</label>
                        </div>
                    </div>
                    <div class="input-field center">
                        <select name="optEvento" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${evento.idEvento == null}"> selected</c:if>> </option>  
                        <c:forEach items="${eventos}" var="evento">
                            <option value="${evento.idEvento}" <c:if test="${noticia.eventoidEvento.idEvento == evento.idEvento}"> selected</c:if>>${evento.nomeEvento}</option>
                        </c:forEach>
                    </select>
                    <label>Evento</label>
                </div>
                <div class="container center">
                    <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
                </div>
            </form>
            </div>  
        </section>
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
            if (form.txtIdNoticia.value == "") {
                mensagem = mensagem + "Informe o Código da Notícia\n";
            }
            if (form.txtDataNoticia.value == "") {
                mensagem = mensagem + "Informe a Data da Notícia \n";
            }
            if (form.txtDescricaoNoticia.value == "") {
                mensagem = mensagem + "Informe a Descrição da Notícia \n";
            }
            if (!campoNumerico(form.txtIdNoticia.value)) {
                mensagem = mensagem + "Código da Notícia deve ser numérico\n";
            }
            if (form.optEvento.value == 0) {
                mensagem = mensagem + "Escolha um evento\n"
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
